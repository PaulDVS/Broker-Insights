package com.br.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.in.entities.Client;
import com.br.in.entities.Customer;
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
	public Client test1() {
		System.out.println(clientDoa.findById(1).get());
		return null;
	}

	@Override
	public Policy test2() {
		System.out.println(customerDoa.findById(1).get());
		return null;
	}

	@Override
	public Customer test3() {
		System.out.println(policyDoa.findById(1).get());
		return null;
	}

}
