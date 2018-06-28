package demo.test.cz.http_library.service;

import demo.test.cz.http_library.base.BaseEntivy;
import demo.test.cz.http_library.requestbody.TestDataBody;
import demo.test.cz.http_library.response.TestResponseBody;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @description: 请求列表
 * @FileName: ApiService.java
 * @author: chenzhen
 * @date: 2018-06-08
 * @E-mail:zhenchen@excar.com.cn
 */

public interface ApiService {
    @POST("/mno/restful/resource/orderPackageTest")
    Observable<BaseEntivy<String>> getString(@Body RequestBody object);

    /**
     *请求sim卡详情
     * @param testDataBody {@link TestDataBody}
     * @return
     */
    @POST("/mno/restful/simcard/getSimcardDetail")
    Observable<BaseEntivy<TestResponseBody>> getSimCardDetail(@Body RequestBody testDataBody);

}
