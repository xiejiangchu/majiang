package majiang.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration
@ComponentScan(basePackages = {"majiang.client.controller"})
@Configuration
public class StartWarp {
    public static void start(String[] args) throws Exception {
        SpringApplication.run(StartWarp.class, args);
    }
}
