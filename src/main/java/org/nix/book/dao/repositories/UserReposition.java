package org.nix.book.dao.repositories;

import org.nix.book.model.UserInfoModel;
import org.nix.book.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserReposition extends JpaRepository<UserModel,Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM user_model")
    List<UserModel> findUserModelList();

    @Query(nativeQuery = true,
            value = "SELECT * FROM user_model WHERE user_name = ?1 AND `password` = ?2")
    List<UserModel> login(String userName,String password);

    @Query(nativeQuery = true,
            value = "SELECT * FROM user_model WHERE user_name = ?1")
    List<UserModel> hasRegister(String userName);

    @Query(nativeQuery = true,
            value = "SELECT")
    List<UserModel> Register(String userName);

    @Query(nativeQuery = true,
            value = "SELECT * FROM user_model WHERE id= ?1")
    List<UserModel> findUserById(String id);

    @Query(nativeQuery = true,
            value = "SELECT * FROM user_model WHERE id= ?1")
    UserModel findUserById1(String id);


}
