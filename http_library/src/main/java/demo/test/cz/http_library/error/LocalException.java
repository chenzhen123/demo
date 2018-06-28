package demo.test.cz.http_library.error;

/**
 * @description:
 * @FileName: LocalException.java
 * @author: chenzhen
 * @date: 2018-06-11
 * @E-mail:zhenchen@excar.com.cn
 */

public class LocalException extends RuntimeException {
    private ErrorEntity errorEntity;

    public LocalException(Throwable e, ErrorEntity errorEntity) {
        super(e);
        this.errorEntity = errorEntity;
    }

    public static LocalException networkException(Throwable e, ErrorEntity errorEntity) {
        return new LocalException(e, errorEntity);
    }

    public static LocalException conversionException(Throwable e, ErrorEntity errorEntity) {
        return new LocalException(e, errorEntity);
    }

    public static LocalException httpException(Throwable e, ErrorEntity errorEntity) {
        return new LocalException(e, errorEntity);
    }

    public static LocalException unexpectedException(Throwable e, ErrorEntity errorEntity) {
        return new LocalException(e, errorEntity);
    }


    public ErrorEntity getErrorEntity() {
        return errorEntity;
    }

    public void setErrorEntity(ErrorEntity errorEntity) {
        this.errorEntity = errorEntity;
    }
}
