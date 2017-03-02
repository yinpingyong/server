package cn.com.bestpay.server.model.response.base;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/1.
 */
@Data
@ToString
public class CommonResponse<T> implements Serializable{

    /**
     * 响应结果
     */
    private T result;

    /**
     * 响应码
     */
    private String resultCode;

    /**
     * 响应描述
     */
    private String resultDesc;

}
