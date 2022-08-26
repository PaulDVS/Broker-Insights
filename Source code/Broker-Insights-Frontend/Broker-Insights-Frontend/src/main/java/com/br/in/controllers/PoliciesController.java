package com.br.in.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.in.entities.Client;
import com.br.in.entities.ClientList;
import com.br.in.entities.CustomerPolicy;
import com.br.in.entities.CustomerPolicyList;
import com.br.in.entities.Policy;
import com.br.in.service.PolicyService;

@Controller
public class PoliciesController {

	@Autowired
	PolicyService policyService;
	
	@RequestMapping("/")
	public ModelAndView loadInHomePage() {
		ModelAndView modelAndView = new ModelAndView();
				
		ClientList clientList = policyService.getClientList();
		Client client = new Client();
		modelAndView.addObject("Client", client);
		
		modelAndView.addObject("ClientList", clientList.getClients());
		modelAndView.setViewName("index");
		
		ArrayList<CustomerPolicy> temp = new ArrayList<CustomerPolicy>();
		modelAndView.addObject("customerPolicies", temp);
		
		return modelAndView;
	}
	
	@RequestMapping("/searchClientsPolicies")
	public ModelAndView addPolicy(Client currentClient) {
		ModelAndView modelAndView = new ModelAndView();
		
		ClientList clientList = policyService.getClientList();
		Client client = new Client();
		modelAndView.addObject("Client", client);
		modelAndView.addObject("ClientList", clientList.getClients());
		modelAndView.setViewName("index");
		
		
		CustomerPolicyList customerPolicyList = policyService.getClientPolicies(currentClient.getClient_name());
		modelAndView.addObject("customerPolicies", customerPolicyList.getCustomerPolicy());
		
		modelAndView.addObject("client_name", currentClient.getClient_name());
		
		
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
	
	@RequestMapping("/addPolicy/{client_name}")
	public ModelAndView addPolicy(@PathVariable String client_name) {
		ModelAndView modelAndView = new ModelAndView();
		
		CustomerPolicy customerPolicy = new CustomerPolicy();
		customerPolicy.setClient_name(client_name);
		modelAndView.addObject("Policy", customerPolicy);
		
		modelAndView.setViewName("createPolicyPage");
		return modelAndView;
	}
	
	@RequestMapping("/createPolicy")
	public ModelAndView createPolicy(CustomerPolicy customerPolicy) {
		ModelAndView modelAndView = new ModelAndView();
		
		policyService.uploadNewPolicy(customerPolicy);
		
		ClientList clientList = policyService.getClientList();
		Client client = new Client();
		modelAndView.addObject("Client", client);
		modelAndView.addObject("ClientList", clientList.getClients());
		modelAndView.setViewName("index");
		
		
		CustomerPolicyList customerPolicyList = policyService.getClientPolicies(customerPolicy.getClient_name());
		modelAndView.addObject("customerPolicies", customerPolicyList.getCustomerPolicy());
		
		modelAndView.addObject("client_name", customerPolicy.getClient_name());
		
		
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
	
	@RequestMapping("/modifyPolicy/{id}")
	public ModelAndView modifyPolicy(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		
		CustomerPolicy customerPolicy = policyService.getPolicy(id);
		
		modelAndView.addObject("Policy", customerPolicy);
		
		modelAndView.setViewName("modifyPolicyPage");
				
		return modelAndView;
	}
	
	
	@RequestMapping("/submitModifiedPolicy")
	public ModelAndView submitModifiedPolicy(CustomerPolicy customerPolicy) {
		ModelAndView modelAndView = new ModelAndView();
		
		policyService.modifyPolicy(customerPolicy);
		
		ClientList clientList = policyService.getClientList();
		Client client = new Client();
		modelAndView.addObject("Client", client);
		modelAndView.addObject("ClientList", clientList.getClients());
		modelAndView.setViewName("index");
		
		
		CustomerPolicyList customerPolicyList = policyService.getClientPolicies(customerPolicy.getClient_name());
		modelAndView.addObject("customerPolicies", customerPolicyList.getCustomerPolicy());
		
		modelAndView.addObject("client_name", customerPolicy.getClient_name());
		
		
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
}
