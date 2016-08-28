package org.seckill.exception;

/**
 * 秒杀相关业务异常
 * @author changhongyuan
 * @date 2016年8月28日20:55:36
 */
public class SeckillException extends  RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
