package com.br.in.service;

import com.br.in.entities.Client;
import com.br.in.entities.ClientList;
import com.br.in.entities.Customer;
import com.br.in.entities.CustomerPolicy;
import com.br.in.entities.CustomerPolicyList;
import com.br.in.entities.Policy;

public interface PolicyService {
	
	ClientList getAllClients();
	
	CustomerPolicyList getClientPolicies(String name);
	
	CustomerPolicy savePolicy(CustomerPolicy customerPolicy);
	
	CustomerPolicy modifyPolicy(CustomerPolicy customerPolicy);
}
