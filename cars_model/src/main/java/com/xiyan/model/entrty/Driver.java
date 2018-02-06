package com.xiyan.model.entrty;

import com.xiyan.model.entrty.twolevel.DriverPictureUrl;

import java.util.Date;

/**
 * @antuor binwang
 * @date 2018/2/6  20:10
 */
public class Driver {
    /*
    * `driver_name` VARCHAR(8) NOT NULL DEFAULT '' COMMENT '姓名',
  `id_number` CHAR(18) NOT NULL DEFAULT '00000000000000000x' COMMENT '身份证号',
  `user_id` bigint(20) NOT NULL DEFAULT '0'  COMMENT '用户Id',
  `expiration_date` DATE NOT NULL DEFAULT '1900-01-01'  COMMENT '到期日期',
  `file_number` VARCHAR(22) NOT NULL DEFAULT ' ' COMMENT '驾照档案号',
  `end_time` VARCHAR(300) NOT NULL DEFAULT ' ' COMMENT '相关照片路径',
  `aduit_type` TINYINT NOT NULL DEFAULT '0' COMMENT '驾驶人审核状态',
  `aduit_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '驾驶人审核号',*/

    private String driverName;
    private String IdNumber;
    private int userId;
    private Date expirateDate;
    private String fileNumber;
    private DriverPictureUrl driverPicUrl;
    private short aduitType;
    private int aduitId;


}
