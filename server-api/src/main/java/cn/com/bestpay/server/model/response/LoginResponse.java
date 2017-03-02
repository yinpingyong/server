package cn.com.bestpay.server.model.response;

import cn.com.bestpay.server.model.response.base.CommonResponse;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/1.
 */
@Data
@ToString
public class LoginResponse implements Serializable{

    /**
     * 响应结果：返回登陆响应结果
     */
    private String result;

}
