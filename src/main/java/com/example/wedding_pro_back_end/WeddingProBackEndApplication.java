package com.example.wedding_pro_back_end;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.wedding_pro_back_end.mapper")
public class WeddingProBackEndApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeddingProBackEndApplication.class, args);
	}

}
