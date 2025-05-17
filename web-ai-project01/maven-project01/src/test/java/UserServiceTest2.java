import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("用户测试信息类")
public class UserServiceTest2 {

    private UserService userService;
    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }
    @Test
    @DisplayName("获取性别null值")
    public void tsetGetGender1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        });
    }

    @Test
    @DisplayName("获取性别-空串")
    public void tsetGetGender2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("");
        });
    }

    @Test
    @DisplayName("获取性别-长度不足")
    public void tsetGetGender3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("110");
        });
    }

    @Test
    @DisplayName("获取性别-长度超出")
    public void tsetGetGender4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("110000000002333333331111111");
        });
    }

    @Test
    @DisplayName("获取性别-正常男性身份证")
    public void tsetGetGender5() {
        String gender = userService.getGender("100000200010011011");
        Assertions.assertEquals("男", gender);
    }

    @Test
    @DisplayName("获取性别-正常女性身份证")
    public void tsetGetGender6() {
        String gender = userService.getGender("100000200010011021");
        Assertions.assertEquals("女", gender);
    }

    //测试获取年龄
    @Test
    @DisplayName("获取年龄-正常身份证")
    public void tsetGetAge1() {
        Integer age = userService.getAge("100000200010011011");
        Assertions.assertEquals(24, age);
    }

    @Test
    @DisplayName("获取年龄-null值")
    public void tsetGetAge2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge(null);
        });

    }

    @Test
    @DisplayName("获取年龄-长度超长")
    public void tsetGetAge3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge("11111111111111100000021303333");
        });
    }

    @Test
    @DisplayName("获取年龄-长度不足")
    public void tsetGetAge4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge("1000");
        });
    }
}

