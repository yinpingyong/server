package cn.com.bestpay.server.model.request;

import cn.com.bestpay.server.model.request.base.CommonRequest;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Administrator on 2017/3/1.
 */
@Data
@ToString
public class LoginRequest extends CommonRequest{

    /**
     * 用户名称
     */
    @NotBlank(
            message = "用户名称不能为空"
    )
    private String name;

    /**
     * 用户密码
     */
    @NotBlank(
            message = "用户密码不能为空"
    )
    private String password;
}
