package com.br.in.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Getter
	@Setter
	private String customer_name;
	
	@Getter
	@Setter
	private String customer_address;
	
	
}
