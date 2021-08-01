package com.example.pruebatecnica.app.dao.repositories;

import com.example.pruebatecnica.app.dao.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
