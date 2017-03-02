package cn.com.bestpay.server.filter;


import cn.com.bestpay.server.model.request.base.CommonRequest;
import com.alibaba.dubbo.rpc.*;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Howell on 1/3/17.
 *
 * 生产者过滤器配置
 *
 * e-mail:th15817161961@gmail.com
 */
public class ProviderFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String methodName = invocation.getMethodName();
        String className = invoker.getInterface().getSimpleName();
        Object[] args = invocation.getArguments();
        String keep = null;
        if (args.length > 0) {
            Object req = args[0];
            try {
                if (req instanceof CommonRequest) {
                    keep = ((CommonRequest) req).getKeep();
                }
            } catch (Exception e) {
                LOGGER.error("日志打印设置线程异常", e);
            }
        }
        if (StringUtils.isBlank(keep)) {
            Thread.currentThread().setName(System.currentTimeMillis() + RandomStringUtils.randomNumeric(6));
        } else {
            Thread.currentThread().setName(keep);
        }
        LOGGER.info("[{}.{}] Start to handle request .[{}] ", className, methodName, args);
        Result result = null;
        Long startTime = System.currentTimeMillis();
        try {
            result = invoker.invoke(invocation);
        } finally {
            Long endTime = System.currentTimeMillis();
            Long elapsed = endTime - startTime;
            if (result != null && result.getValue() != null) {
                LOGGER.info("[{}.{}]  Finish handling request . [{}]. ", className, methodName, result.getValue());
            } else {
                LOGGER.info("[{}.{}]  Finish handling request .", className, methodName);
            }
            LOGGER.info("[{}.{}]  Elapsed:{} ms.",className, methodName,elapsed);
        }
        return result;
    }
}
