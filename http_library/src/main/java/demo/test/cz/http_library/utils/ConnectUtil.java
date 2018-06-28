package demo.test.cz.http_library.utils;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.IntDef;
import android.telephony.TelephonyManager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static demo.test.cz.http_library.utils.ConnectUtil.NetworkType.FORE_G;
import static demo.test.cz.http_library.utils.ConnectUtil.NetworkType.THREE_G;
import static demo.test.cz.http_library.utils.ConnectUtil.NetworkType.TWO_G;
import static demo.test.cz.http_library.utils.ConnectUtil.NetworkType.UNKNOW;
import static demo.test.cz.http_library.utils.ConnectUtil.NetworkType.WIFI;

/**
 * @description:
 * @FileName: ConnectUtil.java
 * @author: chenzhen
 * @date: 2018-06-08
 * @E-mail: zhenchen@excar.com.cn
 */

public class ConnectUtil {
    private static final String TAG = ConnectUtil.class.getSimpleName();
    private Context context;
    private static ConnectUtil connectUtil;
    private WifiManager wifiManager;
    private BluetoothManager bluetoothManager;
    private ConnectivityManager connectivityManager;
    private TelephonyManager telephonyManager;

    private ConnectUtil(Context context) {
        this.context = context;
        wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        bluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    public static ConnectUtil getInstance(Context context) {
        if (context == null) {
            synchronized (ConnectUtil.class) {
                connectUtil = new ConnectUtil(context);
            }
        }
        return connectUtil;
    }

    /**
     * 打开网络设置中心
     */
    public void openNetworkSetting() {
        if (android.os.Build.VERSION.SDK_INT > 10) {
            context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
        } else {
            context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
        }
    }

    /**
     * 获取活动网络信息
     *
     * @return NetworkInfo
     */
    public NetworkInfo getActiveNetworkInfo() {
        return connectivityManager.getActiveNetworkInfo();
    }

    /**
     * 判断当前网络是否可用
     *
     * @return true/false
     */
    public boolean isAvailable() {
        NetworkInfo networkInfo = getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable();
    }

    /**
     * 判断网络是否连接
     *
     * @return true/false
     */
    public boolean isConnected() {
        NetworkInfo networkInfo = getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    /**
     * 判断当前网络是否是4G
     *
     * @return true/false
     */
    public boolean is4G() {
        NetworkInfo networkInfo = getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.getSubtype() == TelephonyManager.NETWORK_TYPE_LTE;
    }

    /**
     * 判断是否是wifi,(注意只能判断wifi是否链接，不能判断wifi的网络状态)
     *
     * @return true/false
     */
    public boolean getIsWifi() {
        NetworkInfo networkInfo = getActiveNetworkInfo();
        return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 获取移动网络运营商的名字
     *
     * @return 移动、联通、电信
     */
    public String getOperatorName() {
        return telephonyManager.getNetworkOperatorName();
    }

    /**
     * 获取当前网络类型（4G,3G,2G,Wifi）
     *
     * @return int 返回值参考此注解{@link NetworkType}
     */
    public @NetworkType int getNetworkType() {
        int type = -1;
        NetworkInfo networkInfo = getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                type = NetworkType.WIFI;
            } else {
                if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    switch (networkInfo.getSubtype()) {
                        //电信2G
                        case TelephonyManager.NETWORK_TYPE_GPRS:
                        case TelephonyManager.NETWORK_TYPE_CDMA:
                        case TelephonyManager.NETWORK_TYPE_EDGE:
                        case TelephonyManager.NETWORK_TYPE_1xRTT:
                        case TelephonyManager.NETWORK_TYPE_IDEN:
                        case TelephonyManager.NETWORK_TYPE_GSM:
                            type = NetworkType.TWO_G;
                            break;
                        case TelephonyManager.NETWORK_TYPE_EVDO_A:
                        case TelephonyManager.NETWORK_TYPE_UMTS:
                        case TelephonyManager.NETWORK_TYPE_EVDO_0:
                        case TelephonyManager.NETWORK_TYPE_HSDPA:
                        case TelephonyManager.NETWORK_TYPE_HSUPA:
                        case TelephonyManager.NETWORK_TYPE_HSPA:
                        case TelephonyManager.NETWORK_TYPE_EVDO_B:
                        case TelephonyManager.NETWORK_TYPE_EHRPD:
                        case TelephonyManager.NETWORK_TYPE_HSPAP:
                            type = NetworkType.THREE_G;
                            break;
                        case TelephonyManager.NETWORK_TYPE_LTE:
                            type = NetworkType.FORE_G;
                            break;
                        default :
                            String subtypeName = networkInfo.getSubtypeName();
                            if (subtypeName.equalsIgnoreCase("TD-SCDMA")
                                    || subtypeName.equalsIgnoreCase("WCDMA")
                                    || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                type = NetworkType.THREE_G;
                            } else {
                                type = NetworkType.UNKNOW;
                            }
                            break;
                    }
                }
            }
        } else {
            type = NetworkType.UNKNOW;
        }
        return type;
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({WIFI, FORE_G, THREE_G, TWO_G,UNKNOW})
    public @interface NetworkType {
        /**
         * wifi
         */
        int WIFI = 0;
        /**
         * 4G
         */
        int FORE_G = 1;
        /**
         * 3G
         */
        int THREE_G = 2;
        /**
         * 2G
         */
        int TWO_G = 3;
        /**
         * 未知
         */
        int UNKNOW = 4;

    }

}
