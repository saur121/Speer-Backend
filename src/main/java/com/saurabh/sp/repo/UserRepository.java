package com.saurabh.sp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.sp.model.UserDtls;


public interface UserRepository extends JpaRepository<UserDtls, Integer> {
    
	public boolean existsByEmailId(String emailId);
	
	public UserDtls findByEmailId(String emailId);
	
	//Optional<UserDtls> findByEmailId(String emailId);
}
