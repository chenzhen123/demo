package demo.test.cz.http_library.base;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import demo.test.cz.http_library.error.ErrorEntity;

/**
 * @description: 接收消息的基类
 * @FileName: BaseEntivy.java
 * @author: chenzhen
 * @date: 2018-06-08
 * @E-mail:zhenchen@excar.com.cn
 */

public class BaseEntivy<T> implements Serializable {
    private static final long serialVersionUID = 6392589406028182931L;
    /**
     * 结果，成功/失败
     */
    @SerializedName("success")
    private boolean isSucc;
    /**
     * 返回信息
     */
    @SerializedName("message")
    private String message;
    /**
     * 返回码
     */
    @SerializedName("errCode")
    private int resultCode;
    /**
     * 消息实体
     */
    @SerializedName("data")
    private T t;

    public BaseEntivy() {
    }

    public boolean isSucc() {
        return isSucc;
    }

    public void setSucc(boolean succ) {
        isSucc = succ;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "BaseEntivy{" +
                "isSucc=" + isSucc +
                ", message='" + message + '\'' +
                ", resultCode=" + resultCode +
                ", t=" + t +
                '}';
    }
}
