package com.tonpe.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface URepo extends JpaRepository<Employee, Long> {
	Employee findByUsername(String username);

}
