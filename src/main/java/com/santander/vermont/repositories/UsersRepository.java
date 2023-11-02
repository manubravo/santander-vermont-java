package com.santander.vermont.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santander.vermont.entities.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer>{
    
}
