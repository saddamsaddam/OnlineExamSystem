package com.nvn;

import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainPage {
	public static void main(String[] args) throws SQLException {
		System.out.print("hellow programmer");
		SpringApplication.run(MainPage.class, args);
	
		
	}

}
