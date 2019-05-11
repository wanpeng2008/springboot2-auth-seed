package com.pwan.authorizationserver.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "t_role")
@Data
@Slf4j
public class Role {
    @NotEmpty(message = "roleCode不能为空") // hibernate validator校验
    @Id
    @Column(name="role_code", nullable = false, unique = true)
    private String roleCode;

    @NotEmpty(message = "roleName不能为空")
    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_role_permission", joinColumns = @JoinColumn(name = "role_code"), inverseJoinColumns = @JoinColumn(name = "permission_code"))
    private List<Permission> permissionList;

}
