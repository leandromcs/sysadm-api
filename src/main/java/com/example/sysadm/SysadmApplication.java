package com.example.sysadm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.sysadm")
public class SysadmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysadmApplication.class, args);
	}

}
