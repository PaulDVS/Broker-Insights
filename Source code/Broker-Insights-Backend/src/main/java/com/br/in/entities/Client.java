package com.br.in.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	private String client_name;
}
