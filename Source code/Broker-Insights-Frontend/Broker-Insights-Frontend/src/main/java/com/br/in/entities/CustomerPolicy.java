package com.br.in.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPolicy {

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
	private String customer_address;
	
	@Getter
	@Setter
	private float premium;
	
	@Getter
	@Setter
	private String policy_type;
	
	@Getter
	@Setter
	private String insurer_name;
}
