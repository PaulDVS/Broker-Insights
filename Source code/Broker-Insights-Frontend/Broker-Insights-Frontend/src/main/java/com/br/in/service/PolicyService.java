package com.br.in.service;

import com.br.in.entities.ClientList;
import com.br.in.entities.CustomerPolicy;
import com.br.in.entities.CustomerPolicyList;

public interface PolicyService {
	public ClientList getClientList();
	
	public CustomerPolicyList getClientPolicies(String name);
	
	public CustomerPolicy uploadNewPolicy(CustomerPolicy customerPolicy);
	
	public CustomerPolicy modifyPolicy(CustomerPolicy customerPolicy);
}
