package com.pca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pca.domain.UserPermission;

/**
 * Spring Data JPA repository for the UserPermission entity.
 */
public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {

}
