package com.vanguard.predict.demo.models.permissions;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "can_delete", nullable = false)
    private boolean canDelete = false;

    @Column(name = "can_create", nullable = false)
    private boolean canCreate = false;

    @Column(name = "can_read", nullable = false)
    private boolean canRead = true;

    @Column(name = "can_update", nullable = false)
    private boolean canUpdate = false;
}
