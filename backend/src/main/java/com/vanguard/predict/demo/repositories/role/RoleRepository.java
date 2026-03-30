package com.vanguard.predict.demo.repositories.role;

import com.vanguard.predict.demo.models.roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
