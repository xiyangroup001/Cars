package com.xiyan.dao.slave;

import com.xiyan.model.entrty.Car;
import com.xiyan.model.entrty.Platform;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @antuor binwang
 * @date 2018/2/7  11:28
 */
@MapperScan

public interface PlatformSlaveDao {
    List<Platform> listAllPlatform();
}
