package com.tpp.threat_perception_platform.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User Data Transfer Object
 * Includes User details and Role Name
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends User {

    /**
     * 用户角色名称
     */
    private String roleName;
}