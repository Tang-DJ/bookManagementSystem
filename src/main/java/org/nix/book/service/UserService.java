package org.nix.book.service;

import org.nix.book.dao.repositories.RecordsReposition;
import org.nix.book.dao.repositories.UserReposition;
import org.nix.book.dto.UserDto;
import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.model.BookInfo;
import org.nix.book.model.BorrowRecords;
import org.nix.book.model.UserInfoModel;
import org.nix.book.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.io.IOException;
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

    @Autowired
    private RecordsReposition recordsReposition;

    /**
     * 获得user列表
     * @param
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findUserModelList() throws CloneNotSupportedException, IOException, ClassNotFoundException {

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
    public BaseResultDto login(String userName,String password) throws CloneNotSupportedException, IOException, ClassNotFoundException {

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
    public BaseResultDto findUserById(String id) throws CloneNotSupportedException, IOException, ClassNotFoundException {

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
    public BaseResultDto findUserById1(String id) throws CloneNotSupportedException, IOException, ClassNotFoundException {

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

    /**
     * 删除单个用户
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean delUserById(Integer id) throws CloneNotSupportedException{
        UserModel userModel = userReposition.findUserById1(id.toString());

        userModel.setRoleModel(null);

        userReposition.delete(userModel);

        List<BorrowRecords> borrowRecordsList = recordsReposition.findBorrowRecordsByUserId(id.toString());

        for(BorrowRecords model : borrowRecordsList){
            model.setBookInfo(null);
            model.setUserModel(null);
        }

        recordsReposition.deleteAll(borrowRecordsList);

        return true;

    }

    /**
     * 删除多个用户
     * @param ids
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean delUserByIds(Integer[] ids) throws CloneNotSupportedException{

        for(int i =0;i<ids.length;i++){
            UserModel userModel = userReposition.findUserById1(ids[i].toString());

            userModel.setRoleModel(null);

            userReposition.delete(userModel);

            List<BorrowRecords> borrowRecordsList = recordsReposition.findBorrowRecordsByUserId(ids[i].toString());

            for(BorrowRecords model : borrowRecordsList){
                model.setBookInfo(null);
                model.setUserModel(null);
            }
            recordsReposition.deleteAll(borrowRecordsList);
        }
        return true;
    }

    /**
     * 更新用户
     * @param id
     * @param userModel
     * @return
     */
    public boolean updateUserById(String id,UserModel userModel) throws CloneNotSupportedException{
        UserModel userModel1 = userReposition.findUserById1(id);
        userModel1.setUserName(userModel.getUserName());

        UserInfoModel userInfoModel = userModel.getUserInfoModel();
        UserInfoModel userInfoModel1 = userModel1.getUserInfoModel();

        userInfoModel1.setPhone(userInfoModel.getPhone());
        userInfoModel1.setEmail(userInfoModel.getEmail());
        userInfoModel1.setMajor(userInfoModel.getMajor());
        userInfoModel1.setDepartments(userInfoModel.getDepartments());
        userReposition.saveAndFlush(userModel1);

        return  true;
    }






}
