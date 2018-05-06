package com.xiyan.dao.slave;

import com.xiyan.model.entity.Evaluation;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface EvaluationSlaveDao extends GeneralSlaveDao<Evaluation> {
}
