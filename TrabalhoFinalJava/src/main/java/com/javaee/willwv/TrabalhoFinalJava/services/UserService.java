package com.javaee.willwv.TrabalhoFinalJava.services;

import java.util.List;

import com.javaee.willwv.TrabalhoFinalJava.domain.User;

public interface UserService {
	User getById(Long id);
	List<User> getAllUsers();
	User createNew(User user);
	User save(Long id, User user);
	User patcg(Long id, User user);
	void deleteById(Long id);
}
