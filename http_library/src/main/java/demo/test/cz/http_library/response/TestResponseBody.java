package demo.test.cz.http_library.response;

import com.google.gson.annotations.SerializedName;

import demo.test.cz.http_library.response.item.CarMachineInfo;
import demo.test.cz.http_library.response.item.FlowUsage;
import demo.test.cz.http_library.response.item.RealNameInfo;
import demo.test.cz.http_library.response.item.SimCardInfo;

/**
 * @description:
 * @FileName: TestResponseBody.java
 * @author: chenzhen
 * @date: 2018-06-12
 * @E-mail:zhenchen@excar.com.cn
 */

public class TestResponseBody {
    @SerializedName("simCardInfo")
    private SimCardInfo simCardInfo;
    @SerializedName("infotainment")
    private CarMachineInfo carMachineInfo;
    @SerializedName("userInfoDto")
    private RealNameInfo realNameInfo;
    @SerializedName("respoolInfo")
    private FlowUsage flowUsage;

    public TestResponseBody() {
    }

    public TestResponseBody(SimCardInfo simCardInfo, CarMachineInfo carMachineInfo, RealNameInfo realNameInfo, FlowUsage flowUsage) {
        this.simCardInfo = simCardInfo;
        this.carMachineInfo = carMachineInfo;
        this.flowUsage = flowUsage;
        this.realNameInfo = realNameInfo;
    }

    public SimCardInfo getSimCardInfo() {
        return simCardInfo;
    }

    public void setSimCardInfo(SimCardInfo simCardInfo) {
        this.simCardInfo = simCardInfo;
    }

    public CarMachineInfo getCarMachineInfo() {
        return carMachineInfo;
    }

    public void setCarMachineInfo(CarMachineInfo carMachineInfo) {
        this.carMachineInfo = carMachineInfo;
    }

    public RealNameInfo getRealNameInfo() {
        return realNameInfo;
    }

    public void setRealNameInfo(RealNameInfo realNameInfo) {
        this.realNameInfo = realNameInfo;
    }

    public FlowUsage getFlowUsage() {
        return flowUsage;
    }

    public void setFlowUsage(FlowUsage flowUsage) {
        this.flowUsage = flowUsage;
    }

    @Override
    public String toString() {
        return "TestResponseBody{" +
                "simCardInfo=" + simCardInfo +
                ", carMachineInfo=" + carMachineInfo +
                ", realNameInfo=" + realNameInfo +
                ", flowUsage=" + flowUsage +
                '}';
    }
}
