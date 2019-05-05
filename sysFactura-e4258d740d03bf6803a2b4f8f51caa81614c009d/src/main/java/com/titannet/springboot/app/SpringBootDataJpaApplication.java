package com.titannet.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.titannet.springboot.app.service.IUploadService;



@SpringBootApplication
public class SpringBootDataJpaApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}
	@Autowired
	IUploadService uploadService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
				uploadService.deleteAll();
				uploadService.init();
		
	}

}
