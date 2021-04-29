package com.shangpin.common;


public class Result<T> {
    private String result;
    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result() {
    }

    public Result(String result, Integer code, String msg, T data) {
        this.result = result;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                ", code=" + code +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 访问成功时调用 包含data
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    /**
     * 访问失败时调用 包含错误信息
     */
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }
}
