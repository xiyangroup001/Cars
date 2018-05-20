package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.CarMasterDao;
import com.xiyan.dao.master.OrderMasterDao;
import com.xiyan.dao.master.UserMasterDao;
import com.xiyan.dao.slave.CarSlaveDao;
import com.xiyan.dao.slave.OrderSlaveDao;
import com.xiyan.dao.slave.UserSlaveDao;
import com.xiyan.model.entity.Admin;
import com.xiyan.model.entity.Car;
import com.xiyan.model.entity.Order;
import com.xiyan.model.entity.User;
import com.xiyan.model.entity.twolevel.ReserveDate;
import com.xiyan.model.exception.BizException;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.model.utils.ApiTemplate;
import com.xiyan.service.OrderService;
import com.xiyan.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMasterDao orderMasterDao;
    @Resource
    private OrderSlaveDao orderSlaveDao;
    @Resource
    private CarMasterDao carMasterDao;
    @Resource
    private CarSlaveDao carSlaveDao;

    @Override
    public APIResponse<Integer> deleteOrder(Admin currentAdmin, Integer orderId) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(orderId != 0, "订单号出错！");
            }

            @Override
            protected APIResponse process() throws BizException {
                Order order = orderSlaveDao.selectById(orderId);
                if (order == null) return APIResponse.returnFail("不存在该订单！");
                Car car = carSlaveDao.selectById(order.getCarId());
                List<ReserveDate> list = car.getReserveDateList();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getOrderId() == (orderId)) {
                        list.remove(i);
                        break;
                    }
                }
                if (list.isEmpty()) {
                    car.setCarState(Car.SYATE_INSTORE);

                }
                carMasterDao.update(car);
                return APIResponse.returnSuccess(orderMasterDao.delete(orderId));
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> insertOrder(User currentUser, Order order) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(order, "");
                Preconditions.checkNotNull(currentUser);
                Preconditions.checkArgument(order.getTakeCarShop() != 0, "取车门店出错！");
            }

            @Override
            protected APIResponse process() throws BizException {

                order.setOrderGenerationTime(new Date());
                order.setUserId(currentUser.getUserId());
                order.setPayType(Order.UNPAID_DEPOSIT);
                orderMasterDao.insert(order);
                Car car = carSlaveDao.selectById(order.getCarId());
                car.setCarState(Car.SYATE_BOOKED);

                ReserveDate reserveDate = new ReserveDate();
                reserveDate.setOrderId(order.getOrderId());
                reserveDate.setStartDate(order.getStartTime());
                reserveDate.setEndDate(order.getEndTime());
                car.getReserveDateList().add(reserveDate);
                carMasterDao.update(car);

                return APIResponse.returnSuccess();
            }
        }.execute();

    }

    @Override
    public APIResponse<Integer> payDeposit(int userId, Integer orderId) {
        return new ApiTemplate<Integer>() {
            @Override
            protected APIResponse<Integer> process() throws BizException {
                Order order = orderSlaveDao.selectById(orderId);
                if (order.getUserId() != userId) return APIResponse.returnFail("该订单不是该用户！");
                else if (order.getPayType() != Order.UNPAID_DEPOSIT) return APIResponse.returnFail("订单状态不对！");
                else {
                    order.setPayType(Order.UNPAID_RENT);
                    return APIResponse.returnSuccess(orderMasterDao.update(order));
                }
            }
        }.execute();
    }

    @Override
    public APIResponse<Integer> payAll(int userId, Integer orderId) {
        return new ApiTemplate<Integer>() {
            @Override
            protected APIResponse<Integer> process() throws BizException {
                Order order = orderSlaveDao.selectById(orderId);
                if (order.getUserId() != userId) return APIResponse.returnFail("该订单不是该用户！");
                else if (order.getPayType() != Order.UNPAID_RENT) return APIResponse.returnFail("订单状态不对！付定金后进行此操作！");
                else {
                    order.setPayType(Order.PAID_RENT);
                    return APIResponse.returnSuccess(orderMasterDao.update(order));
                }
            }
        }.execute();
    }

    @Override
    public APIResponse<Boolean> getCar(Admin currentAdmin, int orderId) {
        return new ApiTemplate<Boolean>() {
            @Override
            protected APIResponse<Boolean> process() throws BizException {
                Order order = orderSlaveDao.selectById(orderId);
                if (order.getPayType() != Order.UNPAID_RENT) return APIResponse.returnFail("请先付定金，即押金！");
                order.setPayType(Order.CAR_OUT);
                orderMasterDao.update(order);

                Car car = carSlaveDao.selectById(order.getCarId());
                List<ReserveDate> list = car.getReserveDateList();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getOrderId() == (orderId)) {
                        list.remove(i);
                        break;
                    }
                }
                car.setCarState(Car.SYATE_RENTEND_OUT);
                carMasterDao.update(car);

                return APIResponse.returnSuccess(true);
            }
        }.execute();
    }

    @Override
    public APIResponse<Boolean> returnCar(Admin currentAdmin, int orderId) {
        return new ApiTemplate<Boolean>() {
            @Override
            protected APIResponse<Boolean> process() throws BizException {
                Order order = orderSlaveDao.selectById(orderId);
                if (order.getPayType() != Order.CAR_OUT) return APIResponse.returnFail("请先付定金，即押金！");
                order.setPayType(Order.REFUNDED_DEPOSIT);
                orderMasterDao.update(order);

                Car car = carSlaveDao.selectById(order.getCarId());
                car.setCarState(Car.SYATE_INSTORE);
                carMasterDao.update(car);

                return APIResponse.returnSuccess(true);
            }
        }.execute();
    }


    @Override
    public APIResponse<List<Order>> listOrderByUserId(int userId) {
        return new ApiTemplate<List<Order>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(userId != 0, "用户id出错！");
            }

            @Override
            protected APIResponse<List<Order>> process() throws BizException {
                Order o1 = new Order();
                o1.setUserId(userId);
                List<Order> orders = orderSlaveDao.select(o1);
                return APIResponse.returnSuccess(orders);
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Order>> getByCarId(Admin currentAdmin, int carId) {
        return new ApiTemplate<List<Order>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(carId != 0, "用户id出错！");
            }

            @Override
            protected APIResponse<List<Order>> process() throws BizException {
                Order o1 = new Order();
                o1.setCarId(carId);
                List<Order> orders = orderSlaveDao.select(o1);
                return APIResponse.returnSuccess(orders);
            }
        }.execute();
    }

    @Override
    public APIResponse<Order> getByIdInAdmin(Admin currentAdmin, int orderId) {
        return new ApiTemplate<Order>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(orderId > 0, "用户id出错！");
            }
            @Override
            protected APIResponse<Order> process() throws BizException {
                Order o1 = new Order();
                o1.setOrderId(orderId);
                List<Order> orders = orderSlaveDao.select(o1);
                if (orders != null && !orders.isEmpty()) return APIResponse.returnSuccess(orders.get(0));
                else return APIResponse.returnFail("订单号错误，不存在该订单！");
            }
        }.execute();
    }

    @Override
    public APIResponse<List<Order>> getOrderByStore(Admin currentAdmin) {
        return new ApiTemplate<List<Order>>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(currentAdmin);
            }
            @Override
            protected APIResponse<List<Order>> process() throws BizException {
                Order o1 = new Order();
                o1.setTakeCarShop(currentAdmin.getStore());
                List<Order> orders = orderSlaveDao.select(o1);
                return APIResponse.returnSuccess(orders);
            }
        }.execute();
    }

    @Override
    public APIResponse<Order> getByIdInUser(User currentuser, int orderId) {
        return new ApiTemplate<Order>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkArgument(orderId > 0, "用户id出错！");
            }
            @Override
            protected APIResponse<Order> process() throws BizException {
                Order o1 = new Order();
                o1.setOrderId(orderId);
                o1.setUserId(currentuser.getUserId());
                List<Order> orders = orderSlaveDao.select(o1);
                if (orders != null && !orders.isEmpty()) return APIResponse.returnSuccess(orders.get(0));
                else return APIResponse.returnFail("订单号错误，不存在该订单！");
            }
        }.execute();
    }


}
