package demo.test.cz.http_library.response.item;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @description:
 * @FileName: FlowUsage.java
 * @author: lvlei
 * @date: 2018-05-17
 */
public class FlowUsage {
    /**
     * 当前用户短信使用量
     */
    @SerializedName("usedSMSNumber")
    private String usedSMSNumber;
    /**
     * 激活时间
     */
    @SerializedName("authTime")
    private String authTime;
    /**
     * 失效时间
     */
    @SerializedName("expireTime")
    private String expireTime;
    /**
     * 当前用户初始数据流量（不限量为-1）
     */
    @SerializedName("dataVolume_init")
    private String dataVolume_init;
    /**
     * 当前用户总数据余量
     */
    @SerializedName("dataVolume")
    private String dataVolume;
    /**
     * 当前用户总数据用量
     */
    @SerializedName("usedDataVolume")
    private String usedDataVolume;
    /**
     * 用户
     */
    @SerializedName("account")
    private String account;
    /**
     * 当前用户总语音使用分钟数（无服务为-1）
     */
    @SerializedName("usedVoiceMinute")
    private String usedVoiceMinute;
    /**
     * 套餐包详情列表
     */
    @SerializedName("packageDetails")
    private List<PackageDetail> packageDetails;

    public String getUsedSMSNumber() {
        return usedSMSNumber;
    }

    public void setUsedSMSNumber(String usedSMSNumber) {
        this.usedSMSNumber = usedSMSNumber;
    }

    public String getAuthTime() {
        return authTime;
    }

    public void setAuthTime(String authTime) {
        this.authTime = authTime;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getDataVolume_init() {
        return dataVolume_init;
    }

    public void setDataVolume_init(String dataVolume_init) {
        this.dataVolume_init = dataVolume_init;
    }

    public String getDataVolume() {
        return dataVolume;
    }

    public void setDataVolume(String dataVolume) {
        this.dataVolume = dataVolume;
    }

    public String getUsedDataVolume() {
        return usedDataVolume;
    }

    public void setUsedDataVolume(String usedDataVolume) {
        this.usedDataVolume = usedDataVolume;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsedVoiceMinute() {
        return usedVoiceMinute;
    }

    public void setUsedVoiceMinute(String usedVoiceMinute) {
        this.usedVoiceMinute = usedVoiceMinute;
    }

    public List<PackageDetail> getPackageDetails() {
        return packageDetails;
    }

    public void setPackageDetails(List<PackageDetail> packageDetails) {
        this.packageDetails = packageDetails;
    }

    @Override
    public String toString() {
        return "FlowUsageModel{" +
                "usedSMSNumber='" + usedSMSNumber + '\'' +
                ", authTime='" + authTime + '\'' +
                ", expireTime='" + expireTime + '\'' +
                ", dataVolume_init='" + dataVolume_init + '\'' +
                ", dataVolume='" + dataVolume + '\'' +
                ", usedDataVolume='" + usedDataVolume + '\'' +
                ", account='" + account + '\'' +
                ", usedVoiceMinute='" + usedVoiceMinute + '\'' +
                ", packageDetails=" + packageDetails +
                '}';
    }
}
