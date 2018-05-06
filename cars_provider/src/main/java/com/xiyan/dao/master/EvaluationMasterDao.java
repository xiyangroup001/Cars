package com.xiyan.dao.master;

import com.xiyan.model.entity.Evaluation;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface EvaluationMasterDao extends GeneralMasterDao<Evaluation> {
}
