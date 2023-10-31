
package com.example.demo.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

@Entity

public class User {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long user_id;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;

    private String address;

    private String phone;

    private String email_id;

    private String user_type;

    // Constructors

    public User() {

    }


    public User(Long user_id, String name, String address, String phone, String email_id, String user_type) {

		super();

		this.user_id = user_id;

		this.name = name;

		this.address = address;

		this.phone = phone;

		this.email_id = email_id;

		this.user_type = user_type;

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

