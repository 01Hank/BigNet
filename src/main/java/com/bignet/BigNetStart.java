package com.bignet;


import com.bignet.db.TableEnum;
import com.bignet.db.mapper.BaseMapper;
import com.bignet.db.mapper.UserMapper;
import com.bignet.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
@MapperScan("com.bignet.db.mapper")
public class BigNetStart {
    private static final Logger log = LoggerFactory.getLogger(BigNetStart.class);


    public static void main(String[] args) {
        SpringApplication.run(BigNetStart.class, args);
        startPre();
        log.info("server is start suc!");
    }


    /**
     * 启动后初始化一部分数据
     */
    public static void startPre() {
        //初始化表
        initTables();
        //初始配置
        initConfig();
    }


    /**
     * 初始表
     */
    private static void initTables() {
        try {
            TableEnum[] values = TableEnum.values();
            for (TableEnum table : values) {
                Object bean = SpringUtil.getBean(table.getTablePath());
                if (bean != null) {
                    BaseMapper baseMapper = (BaseMapper) bean;
                    baseMapper.initTable();
                }
            }

            log.info("initTables is suc,tableCount = " + values.length);
        } catch (Exception e) {
            log.error("initTables is error", e);
        }
    }


    /**
     * 初始配置
     */
    private static void initConfig() {
        try {
            log.info("initConfig is suc,configCount = " + 0);
        } catch (Exception e) {
            log.error("initConfig is error", e);
        }
    }
}
