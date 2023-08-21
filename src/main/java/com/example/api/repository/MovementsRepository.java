package com.example.api.repository;

import com.example.api.model.Movements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementsRepository extends JpaRepository<Movements, Integer> {
}
