package org.nix.book.service;

import org.nix.book.dao.repositories.UserReposition;
import org.nix.book.dto.UserDto;
import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bookmanage
 * @description: user
 * @author: Tang
 * @create: 2018-06-06 11:03
 **/

@Service
public class UserService {

    @Autowired
    private UserReposition userReposition;

    public BaseResultDto findUserListByUserName(String userName) throws CloneNotSupportedException{

        List<UserModel> userList = userReposition.findUserModelsByUserName(userName);

        System.out.println(userList);
        if (userList.size()>0){
            return new UserDto(userList).result();
        }
        return null;
    }

    public BaseResultDto login(String userId,String password) throws CloneNotSupportedException{

        List<UserModel> userList = userReposition.login(userId,password);
        if (userList.size()>0){
            return new UserDto(userList).result();
        }
        return null;
    }


}
