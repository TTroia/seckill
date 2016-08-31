package org.seckill.dto;

/**
 * @author changhongyuan
 * @date 2016年8月31日17:54:56
 */
//所有ajax请求返回类型，封装json结果
public class SeckillResult<T> {
    private boolean seccuss;
    private T data;
    private String error;

    public SeckillResult(boolean seccuss, T data) {
        this.seccuss = seccuss;
        this.data = data;
    }

    public SeckillResult(boolean seccuss, String error) {
        this.seccuss = seccuss;
        this.error = error;
    }

    public boolean isSeccuss() {
        return seccuss;
    }

    public void setSeccuss(boolean seccuss) {
        this.seccuss = seccuss;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
