package demo.test.cz.http_library.convertfactory;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import javax.annotation.Nullable;

import demo.test.cz.http_library.base.BaseEntivy;
import demo.test.cz.http_library.utils.LogUtils;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @description: 本地转换类
 * @FileName: JavaBeanConvertFactory.java
 * @author: chenzhen
 * @date: 2018-06-14
 * @E-mail:zhenchen@excar.com.cn
 */

public class JavaBeanConvertFactory extends Converter.Factory {
    private static final String TAG = JavaBeanConvertFactory.class.getSimpleName();
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static JavaBeanConvertFactory javaBeanConvertFactory = null;

    private JavaBeanConvertFactory() {
    }

    public static JavaBeanConvertFactory create() {
        if (javaBeanConvertFactory == null) {
            synchronized (JavaBeanConvertFactory.class) {
                javaBeanConvertFactory = new JavaBeanConvertFactory();
            }
        }
        return javaBeanConvertFactory;
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new ResponseToJavaBeanConvert<BaseEntivy>(new Gson(), type);
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
//        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
        return new RequestJavaBeanToJson<Object>(new Gson(), type);
    }

    /**
     * 转换responsebody到对应的javabean的内部类
     *
     * @param <T>
     */
    public static class ResponseToJavaBeanConvert<T extends BaseEntivy> implements Converter<ResponseBody, T> {
        private final Gson gson;
        private final Type type;

        public ResponseToJavaBeanConvert(Gson gson, Type type) {

            this.type = type;
            this.gson = gson;
        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            String response = value.string();
            BaseEntivy baseEntivy = gson.fromJson(response, type);
            return (T) baseEntivy;
        }
    }

    /**
     * 转换javabean到requestbody
     *
     * @param <T>
     */
    public static class RequestJavaBeanToJson<T> implements Converter<T, RequestBody> {
        private final Gson gson;
        private final Type type;

        public RequestJavaBeanToJson(Gson gson, Type type) {
            this.gson = gson;
            this.type = type;
        }

        @Override
        public RequestBody convert(T value) throws IOException {
//            String json = gson.toJson(value);
//            LogUtils.i(TAG,"======json:"+json);
//            LogUtils.i(TAG,"======type:"+type.toString());
//            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),json);
//            return reqestBody;
            TypeAdapter<T> adapter = (TypeAdapter<T>) gson.getAdapter(TypeToken.get(type));
            Buffer buffer = new Buffer();
            Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
            JsonWriter jsonWriter = gson.newJsonWriter(writer);
            adapter.write(jsonWriter, value);
            jsonWriter.close();
            return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
        }
    }
}
