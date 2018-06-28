package demo.test.cz.http_library.response.item;

import com.google.gson.annotations.SerializedName;

/**
 * @description:
 * @FileName: PackageDetail.java
 * @author: lvlei
 * @date: 2018-05-17
 */
public class PackageDetail {
    /**
     * 订购套餐id
     */
    @SerializedName("productId")
    private String productId;
    /**
     * 套餐初始流量
     */
    @SerializedName("dataVolume_init")
    private int dataVolume_init;
    /**
     * 订单号
     */
    @SerializedName("orderId")
    private String orderId;
    /**
     * 套餐数据总余量
     */
    @SerializedName("dataVolume")
    private int dataVolume;
    /**
     * 套餐数据总用量
     */
    @SerializedName("usedDataVolume")
    private int usedDataVolume;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getDataVolume_init() {
        return dataVolume_init;
    }

    public void setDataVolume_init(int dataVolume_init) {
        this.dataVolume_init = dataVolume_init;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getDataVolume() {
        return dataVolume;
    }

    public void setDataVolume(int dataVolume) {
        this.dataVolume = dataVolume;
    }

    public int getUsedDataVolume() {
        return usedDataVolume;
    }

    public void setUsedDataVolume(int usedDataVolume) {
        this.usedDataVolume = usedDataVolume;
    }

    @Override
    public String toString() {
        return "PackageDetail{" +
                "productId='" + productId + '\'' +
                ", dataVolume_init=" + dataVolume_init +
                ", orderId='" + orderId + '\'' +
                ", dataVolume=" + dataVolume +
                ", usedDataVolume=" + usedDataVolume +
                '}';
    }
}
