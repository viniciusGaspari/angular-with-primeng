package com.vanguard.predict.demo.helpers;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import com.vanguard.predict.demo.models.roles.Role;
import com.vanguard.predict.demo.repositories.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleHelper {

    private final RoleRepository roleRepository;

    public Role getRoleById(Integer roleId){
        return this.roleRepository.findById(roleId)
                .orElseThrow(() -> new MyRuntimeException("Role ID inserido não existe", 403));
    }

}
