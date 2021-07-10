package day3.spring;

import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.annotation.ApplicationScope;
import sun.rmi.runtime.Log;

@SpringBootApplication
@MapperScan("day3.spring.mapper")
public class LoginApp {
    public static void main(String[] args) {
        SpringApplication.run(LoginApp.class);
    }
}
