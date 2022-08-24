package com.br.in.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.br.in.entities.CustomerPolicy;
import com.br.in.service.PolicyService;

@SpringBootApplication(scanBasePackages ="com.br.in")
@EntityScan(basePackages = "com.br.in.entities")
@EnableJpaRepositories(basePackages = "com.br.in.persistence")
public class BrokerInsightsBackendApplication implements CommandLineRunner {

	@Autowired
	PolicyService policyService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BrokerInsightsBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
