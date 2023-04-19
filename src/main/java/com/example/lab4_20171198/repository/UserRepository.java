package com.example.lab4_20171198.repository;

import com.example.lab4_20171198.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from users where email=?1 and password=?2")
    List<User> compararUsers(String name, String contrasena);
}
