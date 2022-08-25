package com.br.in.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

	@Getter
	@Setter
	private int idpolicies_tb;
	
	@Getter
	@Setter
	private String client_name;
	
	@Getter
	@Setter
	private String customer_name;
	
	@Getter
	@Setter
	private float premium;
	
	@Getter
	@Setter
	private String policy_type;
	
	@Getter
	@Setter
	private String insurer_name;

	public Policy(String client_name, String customer_name, float premium, String policy_type, String insurer_name) {
		super();
		this.client_name = client_name;
		this.customer_name = customer_name;
		this.premium = premium;
		this.policy_type = policy_type;
		this.insurer_name = insurer_name;
	}
	
	
}