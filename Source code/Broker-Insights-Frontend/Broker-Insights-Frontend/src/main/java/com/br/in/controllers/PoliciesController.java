package com.br.in.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
import com.br.in.entities.PolicyFilter;
import com.br.in.service.PolicyService;

@Controller
public class PoliciesController {

	@Autowired
	PolicyService policyService;
	
	//Function for when users access the Homepage.
	@RequestMapping("/")
	public ModelAndView loadInHomePage() {
		ModelAndView modelAndView = new ModelAndView();
				
		//Loads in the list of clients into the drop down menu
		ClientList clientList = policyService.getClientList();
		modelAndView.addObject("ClientList", clientList.getClients());
		
		//Sets up the client object for when users press the search Button to select a client.
		Client client = new Client();
		modelAndView.addObject("Client", client);
		
		modelAndView.setViewName("index");
		
		//Creates a blank CustomerPolicy, required so that the Div that would contain all the loaded policies doesnt throw errors
		ArrayList<CustomerPolicy> temp = new ArrayList<CustomerPolicy>();
		modelAndView.addObject("customerPolicies", temp);
		
		//Sets up the filter on page
		PolicyFilter newFilter = new PolicyFilter();
		newFilter.setPremiumMax(9999999.99f);
		modelAndView.addObject("PolicyFilter", newFilter);
		
		return modelAndView;
	}
	
	//Function for when the user searches for a specific clients policies.
	@RequestMapping("/searchClientsPolicies")
	public ModelAndView addPolicy(Client currentClient) {
		ModelAndView modelAndView = new ModelAndView();
		
		
		//Loads in the list of clients into the drop down menu
		ClientList clientList = policyService.getClientList();
		modelAndView.addObject("ClientList", clientList.getClients());
				
		//Sets up the client object for when users press the search Button to select a client.
		Client client = new Client();
		modelAndView.addObject("Client", client);
				
		modelAndView.setViewName("index");
		
		//Adds the clients name to specific parts of the page to pass it further along.
		modelAndView.addObject("client_name", currentClient.getClient_name());
				
		//Sets up the filter on page
		PolicyFilter newFilter = new PolicyFilter();
		newFilter.setPremiumMax(9999999.99f);
		modelAndView.addObject("PolicyFilter", newFilter);
		
		//If client name is blank return
		if(currentClient.getClient_name() == "") {
			//Creates a blank CustomerPolicy, required so that the Div that would contain all the loaded policies doesnt throw errors
			ArrayList<CustomerPolicy> temp = new ArrayList<CustomerPolicy>();
			modelAndView.addObject("customerPolicies", temp);
			return modelAndView;
		}

		
		//Uses the name of the current client to get a list of policies
		CustomerPolicyList customerPolicyList = policyService.getClientPolicies(currentClient.getClient_name());
		modelAndView.addObject("customerPolicies", customerPolicyList.getCustomerPolicy());
		
		return modelAndView;
	}
	
	//Function for when users select the add policy button. Takes users to another page where they can fill out data to create
	//a new policy.
	@RequestMapping("/addPolicy/{client_name}")
	public ModelAndView addPolicy(@PathVariable String client_name) {
		ModelAndView modelAndView = new ModelAndView();
		
		//Creates an empty CustomerPolicy object but only saves the client name as that is the only current variable.
		CustomerPolicy customerPolicy = new CustomerPolicy();
		customerPolicy.setClient_name(client_name);
		modelAndView.addObject("Policy", customerPolicy);
		
		modelAndView.setViewName("createPolicyPage");
		return modelAndView;
	}
	
	//Function for when users have filled out the policy creation form and pressed the submit button.
	@RequestMapping("/createPolicy")
	public ModelAndView createPolicy(CustomerPolicy customerPolicy) {
		ModelAndView modelAndView = new ModelAndView();
		
		//Saves the newly created Policy
		policyService.uploadNewPolicy(customerPolicy);
		
		//Loads in the list of clients into the drop down menu
		ClientList clientList = policyService.getClientList();
		modelAndView.addObject("ClientList", clientList.getClients());
				
		//Sets up the client object for when users press the search Button to select a client.
		Client client = new Client();
		modelAndView.addObject("Client", client);
				
		//Takes users back to the main page
		modelAndView.setViewName("index");
		
		
		//Uses the name of the current client to get a list of policies
		CustomerPolicyList customerPolicyList = policyService.getClientPolicies(customerPolicy.getClient_name());
		modelAndView.addObject("customerPolicies", customerPolicyList.getCustomerPolicy());
				
		//Adds the clients name to specific parts of the page to pass it further along.
		modelAndView.addObject("client_name", customerPolicy.getClient_name());
		
		//Sets up the filter on page
		PolicyFilter newFilter = new PolicyFilter();
		newFilter.setPremiumMax(9999999.99f);
		modelAndView.addObject("PolicyFilter", newFilter);
		
		return modelAndView;
	}
	
	//Function for when users selects the modify policy button. Takes user to another page where they can modify the policy data.
	@RequestMapping("/modifyPolicy/{id}")
	public ModelAndView modifyPolicy(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		
		//Using the Policy id, load in the policy data and pre-fill the form data.
		CustomerPolicy customerPolicy = policyService.getPolicy(id);
		
		modelAndView.addObject("Policy", customerPolicy);
		
		modelAndView.setViewName("modifyPolicyPage");
				
		return modelAndView;
	}
	
	//Function for when users have finished modifying the policy data and press the submit button.
	@RequestMapping("/submitModifiedPolicy")
	public ModelAndView submitModifiedPolicy(CustomerPolicy customerPolicy) {
		ModelAndView modelAndView = new ModelAndView();
		
		//Saves the newly modified Policy
		policyService.modifyPolicy(customerPolicy);
		
		//Loads in the list of clients into the drop down menu
		ClientList clientList = policyService.getClientList();
		modelAndView.addObject("ClientList", clientList.getClients());
				
		//Sets up the client object for when users press the search Button to select a client.
		Client client = new Client();
		modelAndView.addObject("Client", client);
				
		//Takes users back to the main page
		modelAndView.setViewName("index");
				
				
		//Uses the name of the current client to get a list of policies
		CustomerPolicyList customerPolicyList = policyService.getClientPolicies(customerPolicy.getClient_name());
		modelAndView.addObject("customerPolicies", customerPolicyList.getCustomerPolicy());
						
		//Adds the clients name to specific parts of the page to pass it further along.
		modelAndView.addObject("client_name", customerPolicy.getClient_name());
		
		//Sets up the filter on page
		PolicyFilter newFilter = new PolicyFilter();
		newFilter.setPremiumMax(9999999.99f);
		modelAndView.addObject("PolicyFilter", newFilter);
		
		return modelAndView;
	}
	
	
	//Function for when the user searches for a specific clients policies.
	@RequestMapping("/filterPolicy/{client_name}")
	public ModelAndView f(@PathVariable String client_name, PolicyFilter filter) {
		ModelAndView modelAndView = new ModelAndView();
		
		
		//Loads in the list of clients into the drop down menu
		ClientList clientList = policyService.getClientList();
		modelAndView.addObject("ClientList", clientList.getClients());
				
		//Sets up the client object for when users press the search Button to select a client.
		Client client = new Client();
		modelAndView.addObject("Client", client);
				
		modelAndView.setViewName("index");
		
		//Uses the name of the current client to get a list of policies
		CustomerPolicyList customerPolicyList = policyService.getClientPolicies(client_name);
		
		//Filters and sorts the list of client policies
		List<CustomerPolicy> tempList = customerPolicyList.getCustomerPolicy().stream()
				.filter(p -> p.getCustomer_name().contains(filter.getCustomerFilter()))
				.filter(p -> p.getCustomer_address().contains(filter.getAddressFilter()))
				.filter(p -> p.getPremium() >= filter.getPremiumMin())
				.filter(p -> p.getPremium() <= filter.getPremiumMax())
				.collect(Collectors.toList());

		
		switch(filter.getSortField()){
			case "customer_name":
				tempList.sort(Comparator.comparing(CustomerPolicy::getCustomer_name));
				break;
				
			case "customer_address":
				tempList.sort(Comparator.comparing(CustomerPolicy::getCustomer_address));
				break;
				
			case "premium":
				tempList.sort(Comparator.comparing(CustomerPolicy::getPremium));
				break;
				
			case "policy_type":
				tempList.sort(Comparator.comparing(CustomerPolicy::getPolicy_type));
				break;
				
			case "insurer_name":
				tempList.sort(Comparator.comparing(CustomerPolicy::getInsurer_name));
				break;
		}
		
		CustomerPolicyList filterPolicyList = new CustomerPolicyList(tempList);
		
		
		modelAndView.addObject("customerPolicies", filterPolicyList.getCustomerPolicy());
		
		//Adds the clients name to specific parts of the page to pass it further along.
		modelAndView.addObject("client_name", client_name);
		
		//Sets up the filter on page
		PolicyFilter newFilter = new PolicyFilter();
		newFilter.setPremiumMax(9999999.99f);
		modelAndView.addObject("PolicyFilter", newFilter);
		
		return modelAndView;
	}
	
}
