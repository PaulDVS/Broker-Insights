package com.br.in.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.br.in.entities.ClientList;
import com.br.in.entities.CustomerPolicy;
import com.br.in.entities.CustomerPolicyList;
import com.br.in.service.PolicyService;

@SpringBootApplication(scanBasePackages = "com.br.in")
public class BrokerInsightsFrontendApplication implements CommandLineRunner  {
	
	public static void main(String[] args) {
		SpringApplication.run(BrokerInsightsFrontendApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
	}
}
