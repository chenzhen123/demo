package demo.test.cz.http_library.error;

import android.net.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;

import demo.test.cz.http_library.annotation.Kind;
import demo.test.cz.http_library.base.BaseEntivy;
import demo.test.cz.http_library.utils.LogUtils;
import retrofit2.HttpException;

/**
 * @description:
 * @FileName: LocalExceptionHandle.java
 * @author: chenzhen
 * @date: 2018-06-11
 * @E-mail:zhenchen@excar.com.cn
 */

public class LocalExceptionHandle {
    private static String TAG = LocalException.class.getSimpleName();

    public static LocalException handleException(Throwable e) {
        if (e instanceof ConnectException) {
            return LocalException.networkException(e, makeErrorEntity(Kind.NETWORK));
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            return LocalException.conversionException(e, makeErrorEntity(Kind.CONVERSION));
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            BaseEntivy baseEntivy ;
            ErrorEntity errorEntity = null;
            try {
                baseEntivy = new Gson().fromJson(httpException.response().errorBody().string(), BaseEntivy.class);
                errorEntity = makeErrorEntity(baseEntivy.getResultCode());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return LocalException.httpException(e, errorEntity);
        } else {
            return LocalException.unexpectedException(e,makeErrorEntity(Kind.UNEXPECTED));
        }
    }

    public static ErrorEntity resolve(Throwable e) {
        if (e instanceof LocalException) {
            LocalException localException = (LocalException) e;
            return localException.getErrorEntity();
        } else if (e instanceof ConnectException) {
            return makeErrorEntity(Kind.NETWORK);
        } else if (e instanceof JSONException || e instanceof JsonParseException || e instanceof ParseException) {
            return makeErrorEntity(Kind.CONVERSION);
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            BaseEntivy baseEntivy ;
            ErrorEntity errorEntity = null;
            try {
                baseEntivy = new Gson().fromJson(httpException.response().errorBody().string(), BaseEntivy.class);
                errorEntity = makeErrorEntity(baseEntivy.getResultCode());
            } catch (IOException e1) {
                e1.printStackTrace();
                LogUtils.e(TAG, e1.toString());
                return makeErrorEntity(Kind.HTTP);
            }
            return errorEntity;
        } else {
            return makeErrorEntity(Kind.UNEXPECTED);
        }
    }

    public static ErrorEntity systemError() {
        return makeErrorEntity(Kind.SYSTEMERR);
    }

    public static ErrorEntity makeErrorEntity(int kind) {
        switch (kind) {
            case Kind.NETWORK:
                return new ErrorEntity(ErrEnum.ERR_NETWORK.getCode(), ErrEnum.ERR_NETWORK.getErrMessage());
            case Kind.CONVERSION:
                return new ErrorEntity(ErrEnum.ERR_CONVERSION.getCode(), ErrEnum.ERR_CONVERSION.getErrMessage());
            case Kind.HTTP:
                return new ErrorEntity(ErrEnum.ERR_HTTP.getCode(), ErrEnum.ERR_HTTP.getErrMessage());
            case Kind.SYSTEMERR:
                return new ErrorEntity(ErrEnum.ERR_SYSTEMERR.getCode(), ErrEnum.ERR_SYSTEMERR.getErrMessage());
            case Kind.E_5000:
                return new ErrorEntity(ErrEnum.ERR_5000.getCode(),ErrEnum.ERR_5000.getErrMessage());
            case Kind.E_5001:
                return new ErrorEntity(ErrEnum.ERR_5001.getCode(),ErrEnum.ERR_5001.getErrMessage());
            case Kind.E_5002:
                return new ErrorEntity(ErrEnum.ERR_5002.getCode(),ErrEnum.ERR_5002.getErrMessage());
            case Kind.E_5003:
                return new ErrorEntity(ErrEnum.ERR_5003.getCode(),ErrEnum.ERR_5003.getErrMessage());
            case Kind.E_5004:
                return new ErrorEntity(ErrEnum.ERR_5004.getCode(),ErrEnum.ERR_5004.getErrMessage());
            default:
                return new ErrorEntity(ErrEnum.ERR_UNEXPECTED.getCode(), ErrEnum.ERR_UNEXPECTED.getErrMessage());

        }
    }
}
