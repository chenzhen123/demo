package demo.test.cz.http_library.wrapper;

import android.content.Context;

import com.google.gson.Gson;

import demo.test.cz.http_library.itip.Itip;
import demo.test.cz.http_library.annotation.MediaTypes;
import demo.test.cz.http_library.base.BaseEntivy;
import demo.test.cz.http_library.base.BaseWrapper;
import demo.test.cz.http_library.error.CustomObserver;
import demo.test.cz.http_library.requestbody.TestDataBody;
import demo.test.cz.http_library.response.TestResponseBody;
import demo.test.cz.http_library.utils.HttpUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @description:测试请求逻辑类，可参照此类编写自己的请求逻辑
 * @FileName: TestWrapper.java
 * @author: chenzhen
 * @date: 2018-06-12
 * @E-mail:zhenchen@excar.com.cn
 */

public class TestWrapper extends BaseWrapper {
    private static final String TAG = TestWrapper.class.getSimpleName();
    private static TestWrapper testWrapper;
    private HttpUtils httpUtils;
    private TestWrapper() {
        httpUtils = HttpUtils.getInstance();
    }

    public static TestWrapper getInstance() {
        if (testWrapper == null) {
            synchronized (TestWrapper.class) {
                testWrapper = new TestWrapper();
            }
        }
        return testWrapper;
    }

    public void getSimCardDetail(Context context, Itip tip, String code, CustomObserver<BaseEntivy<TestResponseBody>> customObserver) {
        TestDataBody body = new TestDataBody();
        body.setCode(code);
        RequestBody requestBody = RequestBody.create(MediaType.parse(MediaTypes.JSON), new Gson().toJson(body));
        doTranceOnActivity(httpUtils.create().getSimCardDetail(requestBody), tip, customObserver);
    }
}
