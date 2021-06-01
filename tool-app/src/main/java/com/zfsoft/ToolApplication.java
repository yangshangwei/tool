package com.zfsoft;

import com.zfsoft.common.intf.ZFExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/6/1 10:18
 * @mark: show me the code , change the world
 */

@SpringBootApplication
@Slf4j
public class ToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolApplication.class, args);


        log.info("参数{}" ,args);
        // 解析args 选择Executor
        ZFExecutor executor = null;
        ServiceLoader serviceLoader = ServiceLoader.load(ZFExecutor.class);

        Iterator<ZFExecutor> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            executor = iterator.next();
            executor.execute();
        }


    }
}
    