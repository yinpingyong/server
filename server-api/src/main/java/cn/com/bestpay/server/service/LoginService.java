package cn.com.bestpay.server.service;

import cn.com.bestpay.server.model.request.LoginRequest;
import cn.com.bestpay.server.model.response.LoginResponse;
import cn.com.bestpay.server.model.response.base.CommonResponse;

/**
 * Created by Administrator on 2017/3/1.
 */
public interface LoginService {

    /**
     * 用户登陆
     * @param testRequest
     * @return
     */
    CommonResponse<LoginResponse> LoginService(LoginRequest testRequest);

}
