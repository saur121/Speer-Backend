package com.saurabh.sp.model;

import javax.persistence.*;
import lombok.*;


@Getter
@Setter
@Data
@Entity
public class UserDtls {
     
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 private String emailId;
	 
	 private String password;
	 
	 private String role;
	 
	   public UserDtls() {
	        this.role = "ROLE_USER";
	    }
}
