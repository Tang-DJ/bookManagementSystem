package org.nix.book.dao.repositories;

import org.nix.book.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserReposition extends JpaRepository<UserModel,Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM user_model,user_info_model WHERE user_model.user_info_model_id = user_info_model.id")
    List<UserModel> findUserModelsByUserName(String userName);

    @Query(nativeQuery = true,
            value = "SELECT * FROM user_model WHERE id = ?1 AND `password` = ?2")
    List<UserModel> login(String userId,String password);

}
