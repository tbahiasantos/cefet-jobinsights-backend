package br.com.taugs.jobinsights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CefetJobInsightsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CefetJobInsightsApiApplication.class, args);
	}

}
