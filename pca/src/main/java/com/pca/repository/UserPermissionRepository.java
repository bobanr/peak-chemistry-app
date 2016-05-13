package com.pca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pca.domain.UserPermission;

public interface UserPermissionRepository  extends JpaRepository <UserPermission, Long> {

}
