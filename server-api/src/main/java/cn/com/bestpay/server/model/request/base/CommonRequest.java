package cn.com.bestpay.server.model.request.base;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/1.
 */
@Data
@ToString
public class CommonRequest implements Serializable {

    private String keep;

}
