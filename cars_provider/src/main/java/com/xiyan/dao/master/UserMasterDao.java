package com.xiyan.dao.master;

import com.xiyan.model.entity.User;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/1/24  16:12
 */
@MapperScan
public interface UserMasterDao extends GeneralMasterDao<User>  {

}
