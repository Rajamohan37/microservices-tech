package com.myworld.user.mgmt.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rj.user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "first_nm")
	private String fName;

	@Column(name = "last_nm")
	private String lName;

	@Column(name = "user_nm")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile_nbr")
	private Long mobileNbr;
	
	@Column(name = "active_usr")
	private boolean isActiveUser;
	
	@OneToMany(mappedBy = "userDetailsRef")
	private List<UserAddress> userAddresses;

}
