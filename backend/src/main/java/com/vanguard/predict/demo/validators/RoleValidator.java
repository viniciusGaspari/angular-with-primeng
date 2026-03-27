package com.vanguard.predict.demo.validators;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import com.vanguard.predict.demo.models.roles.Role;
import com.vanguard.predict.demo.repositories.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleValidator {

    private final BaseRepository<Role, Integer> baseRepository;

    public Role getRoleById(Integer roleId){
        return this.baseRepository.findById(roleId)
                .orElseThrow(() -> new MyRuntimeException("Role ID inserido não existe", 403));
    }

}
