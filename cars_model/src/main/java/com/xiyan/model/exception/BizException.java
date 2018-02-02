package com.xiyan.model.exception;

/**
 * @antuor binwang
 * @date 2018/2/2  13:10
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 业务异常封装类
 * <p>如果classpath下包含business-exception-message.properties（key=errorCode，value=具体错误信息），
 * 则自动读取里面内容，初始化错误类型</p>
 * <p>否则只抛出未知系统异常</p>
 */
public class BizException extends Exception {

    private static final long serialVersionUID = -504955880063536901L;

    private static final Logger log = LoggerFactory.getLogger(BizException.class);

    private static final Map<Integer,String> CODE_MAP =new HashMap<>();
    private static final String ERROR_CODE_0_MESSAGE = "未知系统错误";
    private static final String EXCEPTION_MESSAGE_PROPERTIES = "business-exception-message.properties";
    private static final String ENCODING_CODE = "UTF-8";


    static {
        initCodeMap();
    }

    /**
     * 从properties配置文件中初始化CodeMap
     */
    private synchronized static void initCodeMap() {
        if (CODE_MAP.isEmpty()) {
            // 初始化CODE_MAP
            CODE_MAP.put(0, ERROR_CODE_0_MESSAGE);

            log.info("---------------开始初始化异常信息---------------");

            Properties pro = new Properties();
            try {
                //read property
                ClassLoader cl = BizException.class.getClassLoader();
                pro.load(new InputStreamReader(cl.getResourceAsStream(EXCEPTION_MESSAGE_PROPERTIES),
                        ENCODING_CODE));

                pro.forEach((k,v)->{
                    String key = String.valueOf(k);

                    if (isNumber(key)){
                        CODE_MAP.put(Integer.valueOf(key),String.valueOf(v));
                        log.info("添加code={},message={}",key,v);
                    } else {
                        log.warn("跳过添加code={},message={}",key,v);
                    }
                });
            }catch (Exception e){
                log.error("load business-exception-message.properties fail",e);
            }

            log.info("---------------初始化异常信息完毕---------------");
        }
    }

    /**
     * 附加描述信息
     */
    private String additionMessage = null;

    /**
     * 本异常错误代码
     */
    private Integer bizErrorCode = 0;

    public BizException(int errCode, String additionMessage) {
        super(additionMessage);
        this.additionMessage = additionMessage;
        this.bizErrorCode = errCode;
    }

    public BizException(Integer erroCode) {
        super();
        bizErrorCode = erroCode;
    }

    public BizException(Integer erroCode, String additionMessage, Throwable cause) {
        super(cause);
        bizErrorCode = erroCode;
        this.additionMessage = additionMessage;
    }

    public BizException(Integer erroCode, Throwable cause) {
        super(cause);
        bizErrorCode = erroCode;
    }

    /**
     * 获取异常错误代码
     *
     * @return
     */
    public Integer getBizErrorCode() {
        return bizErrorCode;
    }

    @Override
    public String getMessage() {
        return getLocalizedMessage();
    }

    @Override
    public String getLocalizedMessage() {
        String localMessage = null;
        if (null != this.additionMessage) {
            localMessage = this.additionMessage;
        } else {
            localMessage = CODE_MAP.get(this.bizErrorCode);
        }
        if (null == this.additionMessage && (localMessage == null || localMessage.length()==0)) {
            localMessage = "未知业务错误";
        }
        return localMessage;
    }

    private static boolean isNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] chars = str.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false;
        // deal with any possible sign up front
        int start = (chars[0] == '-') ? 1 : 0;
        if (sz > start + 1) {
            if (chars[start] == '0' && chars[start + 1] == 'x') {
                int i = start + 2;
                if (i == sz) {
                    return false; // str == "0x"
                }
                // checking hex (it can't be anything else)
                for (; i < chars.length; i++) {
                    if ((chars[i] < '0' || chars[i] > '9')
                            && (chars[i] < 'a' || chars[i] > 'f')
                            && (chars[i] < 'A' || chars[i] > 'F')) {
                        return false;
                    }
                }
                return true;
            }
        }
        sz--; // don't want to loop to the last char, check it afterwords
        // for type qualifiers
        int i = start;
        // loop to the next to last char or to the last char if we need another digit to
        // make a valid number (e.g. chars[0..5] = "1234E")
        while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                foundDigit = true;
                allowSigns = false;

            } else if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                hasDecPoint = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // we've already taken care of hex.
                if (hasExp) {
                    // two E's
                    return false;
                }
                if (!foundDigit) {
                    return false;
                }
                hasExp = true;
                allowSigns = true;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (!allowSigns) {
                    return false;
                }
                allowSigns = false;
                foundDigit = false; // we need a digit after the E
            } else {
                return false;
            }
            i++;
        }
        if (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                // no type qualifier, OK
                return true;
            }
            if (chars[i] == 'e' || chars[i] == 'E') {
                // can't have an E at the last byte
                return false;
            }
            if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                // single trailing decimal point after non-exponent is ok
                return foundDigit;
            }
            if (!allowSigns
                    && (chars[i] == 'd'
                    || chars[i] == 'D'
                    || chars[i] == 'f'
                    || chars[i] == 'F')) {
                return foundDigit;
            }
            if (chars[i] == 'l'
                    || chars[i] == 'L') {
                // not allowing L with an exponent
                return foundDigit && !hasExp;
            }
            // last character is illegal
            return false;
        }
        // allowSigns is true iff the val ends in 'E'
        // found digit it to make sure weird stuff like '.' and '1E-' doesn't pass
        return !allowSigns && foundDigit;
    }



    public Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }


    /*********************************************/
    @Deprecated
    private ErrorCode errorCode;

    public BizException() {
    }

    @Deprecated
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Deprecated
    public BizException(ErrorCode code) {
        super(code.getMessage());
        this.errorCode = code;
    }

    @Deprecated
    public BizException(Throwable cause) {
        super(cause);
    }

    @Deprecated
    public BizException(Throwable cause, ErrorCode code) {
        super(code.getMessage(), cause);
        this.errorCode = code;
    }

    @Deprecated
    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    /*********************************************/

}

