package com.br.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.in.entities.ClientList;
import com.br.in.entities.CustomerPolicy;
import com.br.in.entities.CustomerPolicyList;

@Service
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ClientList getClientList() {
		return restTemplate.getForObject("http://localhost:8090/clientList", ClientList.class);
	}

	@Override
	public CustomerPolicyList getClientPolicies(String name) {
		return restTemplate.getForObject("http://localhost:8090/clientPolicies/" +name, CustomerPolicyList.class);
	}

	@Override
	public CustomerPolicy uploadNewPolicy(CustomerPolicy customerPolicy) {
		return restTemplate.postForObject("http://localhost:8090/createPolicy", customerPolicy, CustomerPolicy.class);
	}

	@Override
	public CustomerPolicy modifyPolicy(CustomerPolicy customerPolicy) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<CustomerPolicy> entity = new HttpEntity<CustomerPolicy>(customerPolicy, headers);
		return restTemplate.exchange("http://localhost:8090/modifyPolicy", HttpMethod.PUT, entity, CustomerPolicy.class).getBody();
	}

	@Override
	public CustomerPolicy getPolicy(int id) {
		return restTemplate.getForObject("http://localhost:8090/getPolicy/" +id, CustomerPolicy.class);
	}
	
}
