package com.br.in.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPolicyList {
	@Getter
	@Setter
	private List<CustomerPolicy> CustomerPolicy;
}
