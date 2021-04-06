package cn.xiaolimoon.blog.master.service.ex;

/**
 *  验证码错误
 * @author Zcj
 */
public class InviteCodeException extends ServiceException {
    public InviteCodeException() {
    }

    public InviteCodeException(String message) {
        super(message);
    }

    public InviteCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InviteCodeException(Throwable cause) {
        super(cause);
    }

    public InviteCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
