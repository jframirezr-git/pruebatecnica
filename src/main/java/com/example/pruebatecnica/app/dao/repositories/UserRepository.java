package com.example.pruebatecnica.app.dao.repositories;

import com.example.pruebatecnica.app.dao.models.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Integer> {
}
