package com.xiyan.dao.slave;

import com.xiyan.model.entity.Platform;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @antuor binwang
 * @date 2018/2/7  11:28
 */
@MapperScan

public interface PlatformSlaveDao  extends GeneralSlaveDao<Platform> {
    Platform selectById(int platformId);
}
