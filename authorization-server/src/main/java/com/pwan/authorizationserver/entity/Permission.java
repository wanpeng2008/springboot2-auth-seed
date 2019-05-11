package com.pwan.authorizationserver.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Table(name = "t_permission")
@Data
@Slf4j
public class Permission {
    @Id
    @Column(name = "permission_code", nullable = false, unique = true)
    private String permissionCode;

    @Column(name = "permission_name", nullable = false, unique = true)
    private String permissionName;


}
