package com.xiyan.service.impl;

import com.xiyan.dao.master.CodeMasterDao;
import com.xiyan.dao.slave.CodeSlaveDao;
import com.xiyan.model.entrty.Code;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.CodeService;
import com.xiyan.utils.CodeSendUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

public class CodeServiceImpl implements CodeService {
    @Resource
    private CodeMasterDao codeMasterDao;
    @Resource
    private CodeSlaveDao codeSlaveDao;
    private static Random r=new Random();
    @Override
    public APIResponse<Integer> insertCodr(Code code) {
        return null;
    }

    @Override
    public APIResponse<Integer> updateCode(Code code) {
        return null;
    }

    @Override
    public void sendCode(String phone) {
        if(codeSlaveDao.selectByPhone(phone)!=null){//数据库没有该记录
            Code code = new Code();
            String val = getCodeVal();
            code.setCodeVal(val);
            code.setSendTime(new Date());
            code.setUserPhone(phone);
            codeMasterDao.insert(code);
            CodeSendUtil.send(phone,val);
        }else {
            Code code = new Code();
            String val = getCodeVal();
            code.setCodeVal(val);
            code.setSendTime(new Date());
            code.setUserPhone(phone);
            codeMasterDao.update(code);
            CodeSendUtil.send(phone,val);
        }
    }
    private static String getCodeVal(){
        String codeVal = "";
        for (int i = 0; i <4; i++) {
            codeVal+=r.nextInt(10);
        }
        return codeVal;
    }
}
