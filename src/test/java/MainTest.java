import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.book.Application;
import org.nix.book.controller.ResultMap;
import org.nix.book.dao.repositories.UserReposition;
import org.nix.book.model.RoleModel;
import org.nix.book.model.UserInfoModel;
import org.nix.book.model.UserModel;
import org.nix.book.service.RoleService;
import org.nix.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MainTest {

    @Autowired
    private UserReposition userRepositories;

    public static void main(String[] args) {

    }

    @Test
    public void userTest(){
        UserModel userModel = new UserModel();
        userModel.setUserName("faskfjkasj");
        userModel.setPassword("4564654654");
        userRepositories.save(userModel);
    }

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
//    @Test
//    public void userInfoTest() throws CloneNotSupportedException {
//        UserInfoModel userInfoModel = new UserInfoModel();
//        UserModel userModel =new UserModel();
//        userModel.setUserName("333");
//        userModel.setPassword("123");
//
//        userInfoModel.setDepartments("计算机");
//        userInfoModel.setMajor("软件工程");
//        userInfoModel.setEmail("3@qq.com");
//        userInfoModel.setPhone("123333");
//
//        RoleModel roleModel = roleService.findRoleById("3");
//        userInfoModel.setMax(10);
//        userInfoModel.setLendedNum(0);
//        userInfoModel.setTime(new Date());
//        userModel.setRoleModel(roleModel);
//        userModel.setUserInfoModel(userInfoModel);
//
//        userRepositories.save(userModel);
//    }

}
