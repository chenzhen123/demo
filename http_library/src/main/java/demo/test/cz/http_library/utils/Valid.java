package demo.test.cz.http_library.utils;

import android.os.Build;
import android.text.TextUtils;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @description:
 * @FileName: Valid.java
 * @author: chenzhen
 * @date: 2018-06-08
 * @E-mail:zhenchen@excar.com.cn
 */

public class Valid {
    /**
     * 判断身份证号码是否有效
     *
     * @param idNo 身份证号码
     * @return
     */
    public static boolean isIdNoValid(String idNo) {
        return !TextUtils.isEmpty(idNo) && Pattern.matches("^\\d{15}$|^\\d{17}[0-9Xx]$", idNo);
    }

    /**
     * 判断手机号码是否有效
     * 移动：http://shop.10086.cn/list/134_571_571_1_0_0_0_0_0.html
     * 134 135 136 137 138 139 147 150 151 152 157 158 159 178 182 183 184 187 188
     * 联通：http://num.10010.com/NumApp/chseNumList/init
     * 130 131 132 155 156 176 185 186
     * 电信：http://www.189.cn/haoma/numList.html
     * 133 153 173 177 180 181 189 199
     *
     * @param mobileNum 手机号码
     * @return
     */
    public static boolean isMobileNumValid(String mobileNum) {
        return !TextUtils.isEmpty(mobileNum) && Pattern.matches("^1(3[0-9]|47|5[012356789]|7[3678]|8[0-9]|199)\\d{8}$", mobileNum);
    }
}
