package com.br.in.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.in.entities.Policy;

@Repository
public interface PolicyDoa extends JpaRepository<Policy, Integer> {

}
