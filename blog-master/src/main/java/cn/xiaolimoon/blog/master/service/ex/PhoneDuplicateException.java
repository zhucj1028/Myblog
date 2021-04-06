package cn.xiaolimoon.blog.master.service.ex;

/**
 * 手机号码冲突异常
 * @author Zcj
 */
public class PhoneDuplicateException extends ServiceException {
    public PhoneDuplicateException() {
    }

    public PhoneDuplicateException(String message) {
        super(message);
    }

    public PhoneDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneDuplicateException(Throwable cause) {
        super(cause);
    }

    public PhoneDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
