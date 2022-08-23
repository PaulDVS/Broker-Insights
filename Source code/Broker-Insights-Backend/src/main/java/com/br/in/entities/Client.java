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
@Table(name = "client_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Client {

	@Getter
	@Setter
	@Id
	private int idclient_tb;
	
	@Getter
	@Setter
	@Column(unique=true)
	private String client_name;
}
