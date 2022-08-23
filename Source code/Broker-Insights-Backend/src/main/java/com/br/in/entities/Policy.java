package com.br.in.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "policies_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

	@Getter
	@Setter
	@Id
	private int idpolicies_tb;
	
	@Getter
	@Setter
	private int idclient_tb;
	
	@Getter
	@Setter
	private int idcustomer_tb;
	
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
