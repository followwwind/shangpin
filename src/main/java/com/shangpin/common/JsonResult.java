package com.shangpin.common;

import java.util.List;

/**
 * @package com.shangpin.common
 * @className JsonResult
 * @note json结果
 * @author wind
 * @date 2021/4/29 22:37
 */
public class JsonResult<T> {

    public final static String SUCCESS = "success";
    public final static String FAIL = "fail";
    /**
     * success/fail
     */
    private String returnCode;
    /**
     * 通讯错误信息
     */
    private String returnMsg;
    /**
     * 集合
     */
    private List<T> items;

    public static <T> JsonResult<T> success(List<T> items){
        JsonResult<T> result = new JsonResult<>();
        result.setReturnCode(SUCCESS);
        result.setReturnMsg("");
        result.setItems(items);
        return result;
    }

    public static  <T> JsonResult<T> error(String msg){
        JsonResult<T> result = new JsonResult<>();
        result.setReturnCode(FAIL);
        result.setReturnMsg(msg);
        return result;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
