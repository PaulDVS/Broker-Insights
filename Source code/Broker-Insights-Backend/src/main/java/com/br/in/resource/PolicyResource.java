package com.br.in.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.in.entities.ClientList;
import com.br.in.entities.CustomerPolicy;
import com.br.in.entities.CustomerPolicyList;
import com.br.in.service.PolicyService;

@RestController
public class PolicyResource {

	@Autowired
	PolicyService policyService;
	
	//Api to return a list of all clients.
	@GetMapping(path = "/clientList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientList listAllClients() {
		return policyService.getAllClients();
	}
	
	//Api to return a list of all policies associated to a specific client
	@GetMapping(path = "/clientPolicies/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerPolicyList clientPolicies(@PathVariable String name) {
		return policyService.getClientPolicies(name);
	}
	
	//Api to save the uploaded policy
	@PostMapping(path = "/createPolicy", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerPolicy clientPolicies(@RequestBody CustomerPolicy customerPolicy) {
		return policyService.savePolicy(customerPolicy);
	}
	
	//Api to modify an existing policy using the uploaded policy data.
	@PutMapping(value="/modifyPolicy",produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerPolicy confirmOrder(@RequestBody CustomerPolicy customerPolicy) {
		return policyService.modifyPolicy(customerPolicy);
	}
}
