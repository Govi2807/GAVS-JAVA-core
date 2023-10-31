package com.example.demo.model;
 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
 
@Entity
public class User {
    @Id
    @NotNull
    @DecimalMin("6")
    private Long user_id;
    @NotNull
    @Size(min = 4, max = 20)
    private String name;

    @NotNull
    @Size(min = 4, max = 20)
    private String address;

    @NotNull
    @Size(min = 4, max = 20)
    private String phone;

    @NotNull
    @Size(min = 4, max = 20)
    private String email_id;

    @NotNull
    @Size(min = 4, max = 20)
    private String password;

    private String user_type;
 
    public User() {
    }
 
	public User(Long user_id, String name, String address, String phone, String email_id, String password,
			String user_type) {
		
		this.user_id = user_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email_id = email_id;
		this.password = password;
		this.user_type = user_type;
	}



	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getUser_type() {
		return user_type;
	}
 
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
 
}
 
 