package com.ibrahim.istidata.repository;

import com.ibrahim.istidata.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // all crud databases methods
}
