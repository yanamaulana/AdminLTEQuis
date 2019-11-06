package com.example.MvcMysql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MvcMysql.Tbluser;


public interface UserRepository extends JpaRepository<Tbluser, Integer> {

}