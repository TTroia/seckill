package org.seckill.exception;

/**
 * 秒杀关闭异常
 * @author changhongyuan
 * @date 2016年8月28日20:54:10
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
