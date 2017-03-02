package cn.com.bestpay.server.filter;

import com.alibaba.dubbo.rpc.*;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Howell on 1/3/17.
 *
 * 消费者的过滤器配置
 *
 * e-mail:th15817161961@gmail.com
 */
public class ConsumerFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFilter.class);


    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String methodName = invocation.getMethodName();
        String className = invoker.getInterface().getSimpleName();
        String serverAddress = invoker.getUrl().getAddress();
        Object[] args = invocation.getArguments();
        Gson gson = new Gson();
        if (args.length > 0) {
        	try {
        		LOGGER.info("[{}.{}] Start to handle request [{}] . [{}] ", className, methodName, serverAddress, gson.toJson(args));
			} catch (IllegalArgumentException e) {
				LOGGER.info("[{}.{}] Start to handle request [{}] . [{}] ", className, methodName, serverAddress, args.toString());
			}
        } else {
            LOGGER.info("[{}.{}] Start to handle request .",className, methodName);
        }
        Result result = null;
        Long startTime = System.currentTimeMillis();
        try {
            result = invoker.invoke(invocation);
        } finally {
            Long endTime = System.currentTimeMillis();
            Long elapsed = endTime - startTime;
            if (result != null && result.getValue() != null) {
                LOGGER.info("[{}.{}]  Finish handling request . [{}].", className, methodName, gson.toJson(result.getValue()));
            } else {
                LOGGER.info("[{}.{}]  Finish handling request .", className, methodName);
            }
            LOGGER.info("[{}.{}]  Elapsed:{} ms.",className, methodName,elapsed);
        }
        return result;
    }

}
