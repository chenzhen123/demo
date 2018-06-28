package demo.test.cz.http_library.response.item;

import com.google.gson.annotations.SerializedName;

/**
 * @description:
 * @FileName: SimCardInfo.java
 * @author: lvlei
 * @date: 2018-05-17
 */
public class CarMachineInfo {
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
     * 车型
     */
    @SerializedName("carModel")
    private String carModel;
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
     * ihuId
     */
    @SerializedName("ihuId")
    private String ihuId;
    /**
     * 配置
     *
     * @see Pcode
     */
    @SerializedName("pcode")
    private String pcode;
    /**
     * 生产时间
     */
    @SerializedName("productTime")
    private String productTime;
    /**
     * 车联序列号
     */
    @SerializedName("chelianSn")
    private String chelianSn;
    /**
     *
     */
    @SerializedName("tboxId")
    private String tboxId;

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

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
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

    public String getIhuId() {
        return ihuId;
    }

    public void setIhuId(String ihuId) {
        this.ihuId = ihuId;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getProductTime() {
        return productTime;
    }

    public void setProductTime(String productTime) {
        this.productTime = productTime;
    }

    public String getChelianSn() {
        return chelianSn;
    }

    public void setChelianSn(String chelianSn) {
        this.chelianSn = chelianSn;
    }

    public String getTboxId() {
        return tboxId;
    }

    public void setTboxId(String tboxId) {
        this.tboxId = tboxId;
    }

    @Override
    public String toString() {
        return "CarMachineInfo{" +
                "iccid='" + iccid + '\'' +
                ", imsi='" + imsi + '\'' +
                ", carModel='" + carModel + '\'' +
                ", vin='" + vin + '\'' +
                ", xdsn='" + xdsn + '\'' +
                ", ihuId='" + ihuId + '\'' +
                ", pcode=" + pcode +
                ", productTime='" + productTime + '\'' +
                ", chelianSn='" + chelianSn + '\'' +
                ", tboxId='" + tboxId + '\'' +
                '}';
    }
}
