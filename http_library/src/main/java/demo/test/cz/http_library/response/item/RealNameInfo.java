package demo.test.cz.http_library.response.item;

import com.google.gson.annotations.SerializedName;

/**
 * @description:
 * @FileName: RealNameInfo.java
 * @author: lvlei
 * @date: 2018-05-17
 */
public class RealNameInfo {
    /**
     * 用户姓名
     */
    @SerializedName("userName")
    private String userName;
    /**
     * 身份证号
     */
    @SerializedName("identityId")
    private String identityId;
    /**
     * 用户地址
     */
    @SerializedName("userAddress")
    private String userAddress;
    /**
     * 激活时间
     */
    @SerializedName("authDate")
    private String authDate;
    /**
     * 4s店名
     */
    @SerializedName("dealerName")
    private String dealerName;
    /**
     * 热线电话
     */
    @SerializedName("hotLine")
    private String hotLine;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getAuthDate() {
        return authDate;
    }

    public void setAuthDate(String authDate) {
        this.authDate = authDate;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getHotLine() {
        return hotLine;
    }

    public void setHotLine(String hotLine) {
        this.hotLine = hotLine;
    }

    @Override
    public String toString() {
        return "RealNameInfo{" +
                "userName='" + userName + '\'' +
                ", identityId='" + identityId + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", authDate='" + authDate + '\'' +
                ", dealerName='" + dealerName + '\'' +
                ", hotLine='" + hotLine + '\'' +
                '}';
    }
}
