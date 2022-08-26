package com.br.in.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PolicyFilter {

	@Getter
	@Setter
	String sortField;
	
	@Getter
	@Setter
	String customerFilter;
	
	@Getter
	@Setter
	String addressFilter;
	
	@Getter
	@Setter
	float premiumMin;
	
	@Getter
	@Setter
	float premiumMax;
}
