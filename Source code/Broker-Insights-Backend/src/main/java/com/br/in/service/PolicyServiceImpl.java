package com.br.in.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.in.entities.Client;
import com.br.in.entities.ClientList;
import com.br.in.entities.Customer;
import com.br.in.entities.CustomerPolicy;
import com.br.in.entities.CustomerPolicyList;
import com.br.in.entities.Policy;

import com.br.in.persistence.ClientDoa;
import com.br.in.persistence.CustomerDoa;
import com.br.in.persistence.PolicyDoa;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	ClientDoa clientDoa;
	
	@Autowired
	CustomerDoa customerDoa;
	
	@Autowired
	PolicyDoa policyDoa;

	@Override
	public ClientList getAllClients() {
		ClientList tempClientList = new ClientList(clientDoa.findAll());
		return tempClientList;
	}

	@Override
	public CustomerPolicyList getClientPolicies(String name) {

		
		ArrayList<Policy> policyList = policyDoa.getAllPoliciesForClient(name);
		ArrayList<CustomerPolicy> templist = new ArrayList();
		
		for(Policy current : policyList) {
			Customer tempCustomer = customerDoa.findCustomerByName(current.getCustomer_name());
			
			CustomerPolicy tempCustomerPolicy = new CustomerPolicy(current.getIdpolicies_tb(), current.getClient_name(), tempCustomer.getCustomer_name(), tempCustomer.getCustomer_address(), current.getPremium(), current.getPolicy_type(), current.getInsurer_name());
			
			templist.add(tempCustomerPolicy);
			
		}
		
		CustomerPolicyList tempCustomerPolicyList = new CustomerPolicyList(templist);
		
		return tempCustomerPolicyList;
	}

	@Override
	public CustomerPolicy savePolicy(CustomerPolicy customerPolicy) {
		Customer testCustomer = customerDoa.findCustomerByName(customerPolicy.getCustomer_name());
		if(testCustomer == null) {
			Customer tempCustomer = new Customer(customerPolicy.getCustomer_name(), customerPolicy.getCustomer_address());
			customerDoa.save(tempCustomer);
		} else {		
			customerPolicy.setCustomer_address(testCustomer.getCustomer_address());
		}
		
		Policy tempPolicy = new Policy(customerPolicy.getClient_name(), customerPolicy.getCustomer_name(), customerPolicy.getPremium(), customerPolicy.getPolicy_type(), customerPolicy.getInsurer_name());
		Policy savedPolicy = policyDoa.save(tempPolicy);
		
		customerPolicy.setIdpolicies_tb(savedPolicy.getIdpolicies_tb());
		
		return customerPolicy;
	}

	@Override
	public CustomerPolicy modifyPolicy(CustomerPolicy customerPolicy) {
		Customer testCustomer = customerDoa.findCustomerByName(customerPolicy.getCustomer_name());
		if(testCustomer == null) {
			Customer tempCustomer = new Customer(customerPolicy.getCustomer_name(), customerPolicy.getCustomer_address());
			customerDoa.save(tempCustomer);
		} else {		
			customerPolicy.setCustomer_address(testCustomer.getCustomer_address());
		}
		
		Policy tempPolicy = new Policy(customerPolicy.getIdpolicies_tb(), customerPolicy.getClient_name(), customerPolicy.getCustomer_name(), customerPolicy.getPremium(), customerPolicy.getPolicy_type(), customerPolicy.getInsurer_name());
		Policy savedPolicy = policyDoa.save(tempPolicy);

		return customerPolicy;
	}

}
