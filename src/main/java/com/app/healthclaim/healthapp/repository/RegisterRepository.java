package com.app.healthclaim.healthapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.healthclaim.healthapp.model.User;

public interface RegisterRepository extends JpaRepository<User, Integer> {

	public User findAllByEmail(String email);

	public User findAllByEmailAndPassword(String email, String password);

}
