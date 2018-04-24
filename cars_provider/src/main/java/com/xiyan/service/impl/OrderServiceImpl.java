package com.xiyan.service.impl;

import com.google.common.base.Preconditions;
import com.xiyan.dao.master.CarMasterDao;
import com.xiyan.dao.master.OrderMasterDao;
import com.xiyan.dao.master.UserMasterDao;
import com.xiyan.dao.slave.CarSlaveDao;
import com.xiyan.dao.slave.OrderSlaveDao;
import com.xiyan.dao.slave.UserSlaveDao;
import com.xiyan.model.entity.Car;
import com.xiyan.model.entity.Order;
import com.xiyan.model.entity.User;
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
    public APIResponse<Integer> deleteOrder(Integer orderId) {
        return null;
    }

    @Override
    public APIResponse<Integer> insertOrder(User currentUser, Order order) {
        return new ApiTemplate<Integer>() {
            @Override
            protected void checkParams() throws BizException {
                Preconditions.checkNotNull(order);
                Preconditions.checkNotNull(currentUser);
                Preconditions.checkArgument(order.getTakeCarShop() != 0, "驱车门店出错！");
            }

            @Override
            protected APIResponse process() throws BizException {
                Car car= carSlaveDao.selectById(order.getCarId());
                car.setCarState(Car.SYATE_BOOKED);
                carMasterDao.update(car);
                order.setOrderGenerationTime(new Date());
                order.setUserId(currentUser.getUserId());
                order.setPayType(Order.UNPAID_DEPOSIT);
                return APIResponse.returnSuccess(orderMasterDao.insert(order));
            }
        }.execute();

    }

    @Override
    public APIResponse<List<Order>> listAllOrder() {
        return null;
    }

    @Override
    public APIResponse<Integer> updateOrder(Order order) {
        return null;
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
    public APIResponse<Boolean> getCar(int userId, int orderId) {
        return new ApiTemplate<Boolean>() {
            @Override
            protected APIResponse<Boolean> process() throws BizException {

                Order order = orderSlaveDao.selectById(orderId);

                if (order.getUserId() != userId) return APIResponse.returnFail("该订单不是该用户！");
                else if (order.getPayType() != Order.UNPAID_RENT) return APIResponse.returnFail("请先付定金，即押金！");
                order.setPayType(Order.PAID_RENT);
                orderMasterDao.update(order);

                Car car= carSlaveDao.selectById(order.getCarId());
                car.setCarState(Car.SYATE_RENTEND_OUT);
                carMasterDao.update(car);

                return APIResponse.returnSuccess(true);
            }
        }.execute();
    }

    @Override
    public APIResponse<Boolean> returnCar(int userId, int orderId) {
        return new ApiTemplate<Boolean>() {
            @Override
            protected APIResponse<Boolean> process() throws BizException {
                Order order = orderSlaveDao.selectById(orderId);
                if (order.getUserId() != userId) return APIResponse.returnFail("该订单不是该用户！");
                else if (order.getPayType() != Order.UNPAID_RENT) return APIResponse.returnFail("请先付定金，即押金！");
                order.setPayType(Order.PAID_RENT);
                orderMasterDao.update(order);

                Car car= carSlaveDao.selectById(order.getCarId());
                car.setCarState(Car.SYATE_INSTORE);
                carMasterDao.update(car);

                return APIResponse.returnSuccess(true);
            }
        }.execute();
    }
}
