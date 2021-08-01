package com.myworld.user.mgmt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myworld.user.mgmt.model.entity.UserAddress;
import com.myworld.user.mgmt.model.entity.UserDetails;

@Repository
public interface UserAdressRepository extends JpaRepository<UserAddress, Long> {

	List<UserAddress> findByUserDetailsRef(UserDetails user);
	
}
