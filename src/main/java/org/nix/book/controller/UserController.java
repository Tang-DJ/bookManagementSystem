package org.nix.book.controller;

import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.model.RoleModel;
import org.nix.book.model.UserInfoModel;
import org.nix.book.model.UserModel;
import org.nix.book.service.RoleService;
import org.nix.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     *  用户列表接口
     */
    @GetMapping(value = "/userList")
    public Map<String,Object> findUserListByUserName() throws CloneNotSupportedException, IOException, ClassNotFoundException {

        BaseResultDto userList = userService.findUserModelList();

        return new ResultMap()
                .success("data",userList)
                .send();
    }

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public Map<String,Object> login(HttpServletRequest request,
                                    @RequestParam("userName")String userName,
                                    @RequestParam("password")String password) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        BaseResultDto userList = userService.login(userName,password);

        if (userList!=null){

            HttpSession session = request.getSession();
            session.setAttribute("currentUser", userList);

            return new ResultMap()
                    .success("data",userList)
                    .send();
        }

        return new ResultMap()
                .fail("用户名或密码错误")
                .send();
    }

    /**
     * 注册接口
     * **/
    @PostMapping(value = "/register")
    public Map<String,Object> register(@ModelAttribute("UserModel")UserModel userModel,
                                       @ModelAttribute("UserInfoModel")UserInfoModel userInfoModel) throws Exception{
        if (userModel == null) {
            return new ResultMap()
                    .fail("缺少必要参数")
                    .send();
        }

        if (userService.hasRegister(userModel.getUserName())){
            return new ResultMap()
                    .fail("账号已注册！")
                    .send();
        }
        RoleModel roleModel = roleService.findRoleById("3");
        userInfoModel.setMax(10);
        userInfoModel.setLendedNum(0);
        userInfoModel.setTime(new Date());
        userModel.setRoleModel(roleModel);
        userModel.setUserInfoModel(userInfoModel);

        if (!userService.register(userModel)) {
            return new ResultMap()
                    .fail("注册失败")
                    .send();
        }

        return new ResultMap().success("注册成功").send();
    }


    /**
     * 获得用户详情
     * @return
     * @throws CloneNotSupportedException
     */
    @GetMapping(value = "/userDetail")
    public Map<String,Object> findUserById(@RequestParam String id) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        BaseResultDto userList = userService.findUserById(id);

        return new ResultMap()
                .success("data",userList)
                .send();
    }

    /**
     * 删除用户
     * @param ids
     * @return
     * @throws CloneNotSupportedException
     */
    @DeleteMapping(value = "/delUsers")
    public Map<String,Object> delUser(@RequestParam Integer[] ids) throws CloneNotSupportedException {

        userService.delUserByIds(ids);

        return new ResultMap().success("删除成功").send();
    }

    /**
     * 更新用户
     * @param userModel
     * @param userInfoModel
     * @return
     * @throws CloneNotSupportedException
     */
    @PostMapping(value = "/updateUser")
    public Map<String,Object> updateUser(@RequestParam String userId,
                                         @ModelAttribute("UserModel")UserModel userModel,
                                         @ModelAttribute("UserInfoModel")UserInfoModel userInfoModel) throws CloneNotSupportedException {

        userModel.setUserInfoModel(userInfoModel);
        userService.updateUserById(userId,userModel);

        return new ResultMap().success("更新成功").send();
    }


}
