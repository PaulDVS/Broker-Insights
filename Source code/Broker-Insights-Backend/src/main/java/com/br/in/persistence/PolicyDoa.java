package com.br.in.persistence;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.in.entities.Policy;

@Repository
public interface PolicyDoa extends JpaRepository<Policy, Integer> {

	
	@Query("from Policy where client_name=?1")
	public ArrayList<Policy> getAllPoliciesForClient(String client_name);
}
