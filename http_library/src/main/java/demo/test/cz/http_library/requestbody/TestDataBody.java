package demo.test.cz.http_library.requestbody;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * @description:
 * @FileName: TestDataBody.java
 * @author: chenzhen
 * @date: 2018-06-12
 * @E-mail:zhenchen@excar.com.cn
 */

public class TestDataBody{
    /**
     * 设备码
     */
    @SerializedName("code")
    String code;

    public TestDataBody() {
    }

    public TestDataBody(String code) {
        this.code = code;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TestDataBody{" +
                "code='" + code + '\'' +
                '}';
    }
}

