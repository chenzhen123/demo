package demo.test.cz.http_library.error;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * @description:
 * @FileName: ErrorEntity.java
 * @author: chenzhen
 * @date: 2018-06-11
 * @E-mail:zhenchen@excar.com.cn
 */

public class ErrorEntity implements Parcelable {
    @SerializedName("errCode")
    private int errCode;
    @SerializedName("errMessage")
    private String errMessage;

    public ErrorEntity(int errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    protected ErrorEntity(Parcel in) {
        errCode = in.readInt();
        errMessage = in.readString();
    }

    public static final Creator<ErrorEntity> CREATOR = new Creator<ErrorEntity>() {
        @Override
        public ErrorEntity createFromParcel(Parcel in) {
            return new ErrorEntity(in);
        }

        @Override
        public ErrorEntity[] newArray(int size) {
            return new ErrorEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(errCode);
        dest.writeString(errMessage);
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    @Override
    public String toString() {
        return "ErrorEntity{" +
                "errCode=" + errCode +
                ", errMessage='" + errMessage + '\'' +
                '}';
    }
}
