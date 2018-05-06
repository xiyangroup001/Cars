package com.xiyan.service.impl;

import com.xiyan.dao.master.CodeMasterDao;
import com.xiyan.dao.slave.CodeSlaveDao;
import com.xiyan.model.entity.Code;
import com.xiyan.model.utils.APIResponse;
import com.xiyan.service.CodeService;
import com.xiyan.utils.CodeSendUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@Service("codeService")
public class CodeServiceImpl implements CodeService {
    @Resource
    private CodeMasterDao codeMasterDao;
    @Resource
    private CodeSlaveDao codeSlaveDao;
    private static Random r = new Random();

    @Override
    public APIResponse<Integer> insertCodr(Code code) {
        return null;
    }

    @Override
    public APIResponse<Integer> updateCode(Code code) {
        return null;
    }

    @Override
    public APIResponse<String> sendCode(String phone) {
        if (codeSlaveDao.selectByPhone(phone) == null) {//数据库没有该记录
            Code code = new Code();
            String val = getCodeVal();
            code.setCodeVal(val);
            code.setSendTime(new Date());
            code.setUserPhone(phone);
            codeMasterDao.insert(code);
            CodeSendUtil.send(phone, val);
            return APIResponse.returnSuccess(val);
        } else {
            Code code = new Code();
            String val = getCodeVal();
            code.setCodeVal(val);
            code.setSendTime(new Date());
            code.setUserPhone(phone);
            codeMasterDao.update(code);
            CodeSendUtil.send(phone, val);
            return APIResponse.returnSuccess(val);
        }
    }

    @Override
    public APIResponse<Boolean> checkCode(String phone, String val) {
        Code c1 = codeSlaveDao.selectByPhone(phone);
        if (c1 == null) {
            return APIResponse.returnFail("不存在该手机！");
        }
        if (c1.getCodeVal().equals(val) && (new Date().getTime()) - (c1.getSendTime().getTime()) < 1000 * 60 * 15)
        {
            return APIResponse.returnSuccess();
        } else
            return APIResponse.returnFail("验证码错误或超出了时间限制，请重新验证。");
    }

    private static String getCodeVal() {
        String codeVal = "";
        for (int i = 0; i < 4; i++) {
            codeVal += r.nextInt(10);
        }
        return codeVal;
    }
}
