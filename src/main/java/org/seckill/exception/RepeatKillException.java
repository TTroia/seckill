package org.seckill.exception;

/**
 * 重复秒杀异常{运行时异常}
 * @author changhongyuan
 * @date 2016年8月28日20:51:41
 */
public class RepeatKillException extends SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
