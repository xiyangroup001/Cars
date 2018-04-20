package com.xiyan.model.utils;

import com.xiyan.model.exception.BizException;
import com.xiyan.model.monitor.MonitorConstants;
import com.xiyan.model.monitor.TMonitor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Api逻辑模板， 所有的对外暴露的服务的方法实现均需要使用这个模板来编写 模板已经处理了 未知异常，监控
 *
 * @antuor binwang
 * @date 2018/2/2  13:06
 */
public abstract class ApiTemplate<T> {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected String monitorKey;

    protected ApiTemplate(String monitorKey) {
        this.monitorKey = monitorKey;
    }
    protected ApiTemplate() {

    }

    protected void checkParams() throws BizException {
    }

    ;

    protected abstract APIResponse<T> process() throws BizException;

    protected void afterProcess() {
        //UserContext.release();// 删除缓存
    }

    protected void onSuccess() {
    }

    protected String getCustomMessage() {
        return StringUtils.EMPTY;
    }

    private APIResponse<T> buildFailAPIResponse(Throwable t) {
        logger.error("ApiTemplate execute fail，error msg:{}", t.getMessage(), t);

        if (t instanceof BizException) {
            BizException biz = (BizException) t;
            TMonitor.recordOne(monitorKey + MonitorConstants.BIZ_ERROR);
            return APIResponse.returnFail(biz.getBizErrorCode(), biz.getMessage());
        } else if (t instanceof NullPointerException || t instanceof IllegalArgumentException) {
            TMonitor.recordOne(monitorKey + MonitorConstants.RUNTIME_EXCEPTION);
            return APIResponse.returnFail(109998, t.getMessage());
        } else {
            TMonitor.recordOne(monitorKey + MonitorConstants.RUNTIME_EXCEPTION);
            String errorMes = t.getMessage();
            if (StringUtils.isNotBlank(getCustomMessage())) {
                errorMes = getCustomMessage();
            }
            return APIResponse.returnFail(109997, errorMes);
        }
    }

    public APIResponse<T> execute() {
        long start = System.currentTimeMillis();
        try {
            //1.check
            checkParams();

            //2.handler
            APIResponse<T> result = process();

            //3.after doing
            onSuccess();

            return result;
        } catch (Throwable e) {

            return buildFailAPIResponse(e);
        } finally {
            try {
                afterProcess();
            } catch (Exception e) {
                logger.error("execute afterProcess fail", e);
            }

            TMonitor.recordOne(monitorKey + MonitorConstants.INVOKE, System.currentTimeMillis() - start);
        }
    }
}

