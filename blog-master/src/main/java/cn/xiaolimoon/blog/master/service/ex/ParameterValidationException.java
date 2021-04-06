package cn.xiaolimoon.blog.master.service.ex;

/**
 * 参数验证异常
 *
 * @author Zcj
 */
public class ParameterValidationException extends ServiceException {
    public ParameterValidationException() {
    }

    public ParameterValidationException(String message) {
        super(message);
    }

    public ParameterValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterValidationException(Throwable cause) {
        super(cause);
    }

    public ParameterValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
