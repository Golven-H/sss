package springbootTest;

import java.io.UnsupportedEncodingException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootTest.controller.Test;
import springbootTest.service.CxService;

@SpringBootApplication
@MapperScan("springbootTest.dao")
@EnableTransactionManagement
@RestController
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class,args);
		System.out.println("app runing...");
	}
	
	@RequestMapping("/")
	public String helloWord(Model model) {
		return "Hello World!";
	}

}
