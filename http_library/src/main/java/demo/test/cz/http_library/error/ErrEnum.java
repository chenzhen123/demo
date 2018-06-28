package demo.test.cz.http_library.error;

import demo.test.cz.http_library.HttpApplication;
import demo.test.cz.http_library.R;
import demo.test.cz.http_library.annotation.Kind;

/**
 * File: ErrEnum.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/26 15:23
 * E-mail:zhenchen@ecarx.com.cn
 **/
public enum ErrEnum {
    /**
     * 返回非200错误
     */
    ERR_HTTP(Kind.HTTP, getString(R.string.error_message_http)),
    /**
     * 系统错误
     */
    ERR_SYSTEMERR(Kind.SYSTEMERR, getString(R.string.error_message_system)),
    /**
     * 链接错误
     */
    ERR_NETWORK(Kind.NETWORK, getString(R.string.error_message_network)),
    /**
     * 转换错误
     */
    ERR_CONVERSION(Kind.CONVERSION, getString(R.string.error_message_conversion)),
    /**
     * 为止错误
     */
    ERR_UNEXPECTED(Kind.UNEXPECTED, getString(R.string.error_message_unexpected)),
    /**
     * 必要字段缺失
     */
    ERR_5000(Kind.E_5000, getString(R.string.error_message_5000)),
    /**
     * 无查询结果
     */
    ERR_5001(Kind.E_5001, getString(R.string.error_message_5001)),
    /**
     * 系统异常
     */
    ERR_5002(Kind.E_5002, getString(R.string.error_message_5002)),
    /**
     * 依赖系统异常
     */
    ERR_5003(Kind.E_5003, getString(R.string.error_message_5003)),
    /**
     * 密钥不匹配
     */
    ERR_5004(Kind.E_5004, getString(R.string.error_message_5004)),;
    private int code;
    private String errMessage;

    private ErrEnum(@Kind int code, String errMessage) {
        this.code = code;
        this.errMessage = errMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public static String getString(int id) {
        if(id<0){
            return "";
        }
        return HttpApplication.context.getResources().getString(id);
    }
}
