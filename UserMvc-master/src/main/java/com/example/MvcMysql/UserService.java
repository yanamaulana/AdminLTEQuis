package com.example.MvcMysql;

import java.util.List;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scala.Int;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public List<Tbluser> listAll() {
		return repo.findAll();
	}
	
	public void save(Tbluser tbl_user) {
		repo.save(tbl_user);
	}
	
	public Tbluser get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}