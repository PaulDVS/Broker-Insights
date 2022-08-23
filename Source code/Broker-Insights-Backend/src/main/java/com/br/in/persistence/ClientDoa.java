package com.br.in.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.in.entities.Client;

@Repository
public interface ClientDoa extends JpaRepository<Client, Integer> {

}
