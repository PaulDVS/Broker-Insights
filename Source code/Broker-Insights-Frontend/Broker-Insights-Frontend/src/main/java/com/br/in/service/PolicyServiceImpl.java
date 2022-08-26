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

	//Gets a list of all clients from the backend.
	@Override
	public ClientList getClientList() {
		return restTemplate.getForObject("http://localhost:8090/clientList", ClientList.class);
	}

	//Using the clients name gets all of the policies associated with that client.
	@Override
	public CustomerPolicyList getClientPolicies(String name) {
		return restTemplate.getForObject("http://localhost:8090/clientPolicies/" +name, CustomerPolicyList.class);
	}

	//Uploads a CustomerPolicy object to the backend.
	@Override
	public CustomerPolicy uploadNewPolicy(CustomerPolicy customerPolicy) {
		return restTemplate.postForObject("http://localhost:8090/createPolicy", customerPolicy, CustomerPolicy.class);
	}

	//Uploads a modified CustomerPolicy object to update and existing policy in the database.
	@Override
	public CustomerPolicy modifyPolicy(CustomerPolicy customerPolicy) {
		//Manually uses the PUT method to upload the data as typically put requests do not receive any response.
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<CustomerPolicy> entity = new HttpEntity<CustomerPolicy>(customerPolicy, headers);
		return restTemplate.exchange("http://localhost:8090/modifyPolicy", HttpMethod.PUT, entity, CustomerPolicy.class).getBody();
	}

	//Gets the data of a specific policy using the id of the policy.
	@Override
	public CustomerPolicy getPolicy(int id) {
		return restTemplate.getForObject("http://localhost:8090/getPolicy/" +id, CustomerPolicy.class);
	}
	
}
