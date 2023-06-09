package com.example.helloworld.repository;

import com.example.helloworld.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.password = ?1")
    public User findById(String id);
}
