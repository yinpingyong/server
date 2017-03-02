package cn.com.bestpay.server.enums;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Administrator on 2017/3/1.
 */
public enum  LoginEnum {

    SUCCESS("000000","登陆成功");

    private String resultCode;

    private String resultDesc;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    LoginEnum(String resultCode, String resultDesc) {
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }
}
