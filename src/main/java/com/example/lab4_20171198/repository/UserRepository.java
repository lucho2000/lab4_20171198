package com.example.lab4_20171198.repository;

import com.example.lab4_20171198.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * from user where email=?1 and password=?2", nativeQuery = true)
    User compararUsers(String correo, String contrasena);

    //User findUserByEmailAndPassword(String correo, String contrasena);



}
