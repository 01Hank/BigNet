package com.bignet.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(SpringUtil.class);

    private static ApplicationContext applicationContext;

    public static void isInit() {
        if (applicationContext != null) {
            System.out.println("初始成功");
        } else {
            System.out.println("初始失败");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (this.applicationContext == null) {
            this.applicationContext = applicationContext;
        }
    }


    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(clazz);
    }

    //通过路径获取Bean.
    public static <T> T getBean(String className) {
        if (applicationContext == null) {
            return null;
        }

        return (T) applicationContext.getBean(className);
    }


    //定义一个静态枚举类
    enum SingletonEnum {
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private SpringUtil instance;

        //私有化枚举的构造函数
        SingletonEnum() {
            instance = new SpringUtil();
        }

        public SpringUtil getInstnce() {
            return instance;
        }
    }

    //对外暴露一个获取User对象的静态方法
    public static SpringUtil getInstance() {
        return SingletonEnum.INSTANCE.getInstnce();
    }
}
