package com.ibrahim.istidata.repository;

import com.ibrahim.istidata.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
    //all crud methods
}
