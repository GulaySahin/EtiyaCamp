package com.etiya.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.reCapProject.entities.concrates.ApplicationUser;

public interface ApplicationUserDao extends JpaRepository<ApplicationUser, Integer>{

}
