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
@Table(name = "customer_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Getter
	@Setter
	@Id
	private int idcustomer_tb;
	
	@Getter
	@Setter
	@Column(unique=true)
	private String customer_name;
	
	@Getter
	@Setter
	private String customer_address;
}
