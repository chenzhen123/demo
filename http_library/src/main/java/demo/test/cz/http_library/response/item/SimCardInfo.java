package demo.test.cz.http_library.response.item;

import com.google.gson.annotations.SerializedName;

import demo.test.cz.http_library.annotation.OperatorId;
import demo.test.cz.http_library.annotation.SimCardStatus;

/**
 * @description:
 * @FileName: SimCardInfo.java
 * @author: lvlei
 * @date: 2018-05-17
 */
public class SimCardInfo {
    /**
     * iccid
     */
    @SerializedName("iccid")
    private String iccid;
    /**
     * imsi
     */
    @SerializedName("imsi")
    private String imsi;
    /**
     * msisdn
     */
    @SerializedName("msisdn")
    private String msisdn;
    /**
     * vin
     */
    @SerializedName("vin")
    private String vin;
    /**
     * xdsn
     */
    @SerializedName("xdsn")
    private String xdsn;
    /**
     * temId
     */
    @SerializedName("temId")
    private String temId;
    /**
     * ihuId
     */
    @SerializedName("ihuId")
    private String ihuId;
    /**
     * 实名状态
     *
     * @see SimCardStatus
     */
    @SerializedName("statusFlag")
    private int statusFlag;
    /**
     * 实名认证时间
     */
    @SerializedName("authDate")
    private String authDate;
    /**
     * 运营商id
     *
     * @see OperatorId
     */
    @SerializedName("operatorId")
    private int operatorId;

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getXdsn() {
        return xdsn;
    }

    public void setXdsn(String xdsn) {
        this.xdsn = xdsn;
    }

    public String getTemId() {
        return temId;
    }

    public void setTemId(String temId) {
        this.temId = temId;
    }

    public String getIhuId() {
        return ihuId;
    }

    public void setIhuId(String ihuId) {
        this.ihuId = ihuId;
    }

    public int getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(int statusFlag) {
        this.statusFlag = statusFlag;
    }

    public String getAuthDate() {
        return authDate;
    }

    public void setAuthDate(String authDate) {
        this.authDate = authDate;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public String toString() {
        return "SimCard{" +
                "iccid='" + iccid + '\'' +
                ", imsi='" + imsi + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", vin='" + vin + '\'' +
                ", xdsn='" + xdsn + '\'' +
                ", temId='" + temId + '\'' +
                ", ihuId='" + ihuId + '\'' +
                ", statusFlag=" + statusFlag +
                ", authDate='" + authDate + '\'' +
                ", operatorId=" + operatorId +
                '}';
    }
}
