import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.book.Application;
import org.nix.book.dao.repositories.UserReposition;
import org.nix.book.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
