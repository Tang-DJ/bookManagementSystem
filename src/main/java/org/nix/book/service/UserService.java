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

    /**
     * 获得user列表
     * @param userName
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findUserListByUserName(String userName) throws CloneNotSupportedException{

        List<UserModel> userList = userReposition.findUserModelsByUserName(userName);

        System.out.println(userList);
        if (userList.size()>0){
            return new UserDto(userList).result();
        }
        return null;
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto login(String userName,String password) throws CloneNotSupportedException{

        List<UserModel> userList = userReposition.login(userName,password);
        if (userList.size()>0){
            return new UserDto(userList).result();
        }
        return null;
    }

    /**
     * 账号是否已经被注册
     * @param userName
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean hasRegister(String userName) throws CloneNotSupportedException{

        List<UserModel> userList = userReposition.hasRegister(userName);
        if (userList.size()>0){
            return true;
        }
        return false;
    }

    public boolean register(UserModel userModel) throws CloneNotSupportedException{
        userReposition.save(userModel);
        return true;
    }



}
