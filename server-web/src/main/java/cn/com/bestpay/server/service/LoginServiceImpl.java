package cn.com.bestpay.server.service;

import cn.com.bestpay.server.enums.LoginEnum;
import cn.com.bestpay.server.model.request.LoginRequest;
import cn.com.bestpay.server.model.response.LoginResponse;
import cn.com.bestpay.server.model.response.base.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/1.
 */
@Slf4j
@Service("loginService")
public class LoginServiceImpl implements  LoginService{

    @Override
    public CommonResponse<LoginResponse> LoginService(LoginRequest loginRequest) {

        String name = loginRequest.getName();

        String password = loginRequest.getPassword();

        log.info(name + password);

        CommonResponse<LoginResponse> commonResponse = new CommonResponse<LoginResponse>();

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setResult("welocome to : " + name );

        commonResponse.setResult(loginResponse);

        commonResponse.setResultCode(LoginEnum.SUCCESS.getResultCode());

        commonResponse.setResultDesc(LoginEnum.SUCCESS.getResultDesc());

        return commonResponse;
    }
}
