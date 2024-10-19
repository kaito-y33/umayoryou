package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring Bootアプリケーションのエントリーポイントクラス
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.example", "com.umayoryou"})
@EnableJpaRepositories(basePackages = "com.example.repository.dao")
@EntityScan(basePackages = "com.example.repository.entity")
public class WebApplication {

    /**
     * メインメソッド。Spring Bootアプリケーションを起動します。
     * 
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        // Spring Bootアプリケーションを起動
        SpringApplication.run(WebApplication.class, args);
    }
}
