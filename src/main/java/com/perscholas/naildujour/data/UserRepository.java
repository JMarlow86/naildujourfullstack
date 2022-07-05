package com.perscholas.naildujour.data;

import com.perscholas.naildujour.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<User, String> {

    User findUserByEmail(String email);

    List<User> findUserByPhone(String phone);

    List<User> findAll();

    void deleteUserByEmail(String email);

    User findUserByRole(String role);
}