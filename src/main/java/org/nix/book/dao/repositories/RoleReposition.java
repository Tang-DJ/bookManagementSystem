package org.nix.book.dao.repositories;

import org.nix.book.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleReposition extends JpaRepository<RoleModel,Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM role_model")
    List<RoleModel> findRoleList();

    @Query(nativeQuery = true,
            value = "SELECT * FROM role_model WHERE id=?1")
    RoleModel findRoleById(String id);

}
