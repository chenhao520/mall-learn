package com.example.malllearning.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBaits配置类
 * Created by chenhao on 2021/7/15
 */
@Configuration
@MapperScan({"com.example.malllearning.mbg.mapper","com.example.malllearning.dao"})
public class MyBaitsConfig {
}
