package com.dars.backend.repository;

import com.dars.backend.entity.DisasterEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisasterEventRepository extends JpaRepository<DisasterEvent, Long> {
}