package org.nix.book.service;

import org.nix.book.dao.repositories.UserReposition;
import org.nix.book.dto.UserDto;
import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.model.UserInfoModel;
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
     * @param
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findUserModelList() throws CloneNotSupportedException{

        List<UserModel> userList = userReposition.findUserModelList();

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

    /**
     * 注册
     * @param userModel
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean register(UserModel userModel) throws CloneNotSupportedException{
        userReposition.save(userModel);
        return true;
    }


    /**
     * 用户详情
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findUserById(String id) throws CloneNotSupportedException{

        List<UserModel> userList = userReposition.findUserById(id);
        if (userList.size()>0){
            return new UserDto(userList).result();
        }
        return null;
    }


    /**
     * 重写用户详情
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findUserById1(String id) throws CloneNotSupportedException{

        UserModel userModel = userReposition.findUserById1(id);
        if (userModel!=null){
            return new UserDto(userModel).result();
        }
        return null;
    }

    /**
     * 借还书状态修改
     * @param id
     * @param num
     * @return
     * @throws CloneNotSupportedException
     */
    public UserModel changeUserLendedNum(String id,Integer num) throws CloneNotSupportedException{

        UserModel userModel = userReposition.findUserById1(id);
        UserInfoModel userInfoModel = userModel.getUserInfoModel();
        Integer lendNum = userInfoModel.getLendedNum();
        userInfoModel.setLendedNum(lendNum+num);

        userReposition.saveAndFlush(userModel);
        return userModel;
    }


}
