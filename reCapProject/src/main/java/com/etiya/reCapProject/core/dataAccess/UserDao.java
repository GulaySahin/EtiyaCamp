package com.etiya.reCapProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.reCapProject.core.entities.concrates.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
