package com.example.lab4_20171198.repository;

import com.example.lab4_20171198.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
