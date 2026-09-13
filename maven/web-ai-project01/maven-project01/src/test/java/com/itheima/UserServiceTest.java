package com.itheima;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author N1357
 * @since 2026/9/12
 */
@DisplayName("用户信息的测试类")
public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    // ==================== getAge 测试 ====================

    @Test
    @DisplayName("测试getAge - 正常身份证号")
    public void testGetAge_normal() {
        // 使用一个固定的身份证号: 出生日期 2001-10-01
        Integer age = userService.getAge("100000200110011011");
        int expected = Period.between(LocalDate.of(2001, 10, 1), LocalDate.now()).getYears();
        Assertions.assertEquals(expected, age);
    }

    @Test
    @DisplayName("测试getAge - 身份证号null")
    public void testGetAge_null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getAge(null));
    }

    @Test
    @DisplayName("测试getAge - 身份证号长度不足18位")
    public void testGetAge_tooShort() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getAge("1234567890"));
    }

    @Test
    @DisplayName("测试getAge - 身份证号长度超过18位")
    public void testGetAge_tooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getAge("10000020011001101100"));
    }

    // ==================== getGender 测试 ====================

    @Test
    @DisplayName("测试getGender - 男性(第17位为奇数)")
    public void testGetGender_male() {
        // 第17位是1(奇数) -> 男
        String gender = userService.getGender("100000200110011011");
        Assertions.assertEquals("男", gender);
    }

    @Test
    @DisplayName("测试getGender - 女性(第17位为偶数)")
    public void testGetGender_female() {
        // 第17位是2(偶数) -> 女
        String gender = userService.getGender("100000200110011021");
        Assertions.assertEquals("女", gender);
    }

    @Test
    @DisplayName("测试getGender - 身份证号null")
    public void testGetGender_null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender(null));
    }

    @Test
    @DisplayName("测试getGender - 身份证号长度不足18位")
    public void testGetGender_tooShort() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender("12345"));
    }

    /**
     * 参数化测试 - 性别判断
     * 第17位为奇数返回"男", 为偶数返回"女"
     */
    @DisplayName("测试getGender - 参数化测试")
    @ParameterizedTest
    @CsvSource({
            "100000200110011011, 男",  // 第17位=1, 奇数
            "100000200110011031, 男",  // 第17位=3, 奇数
            "100000200110011051, 男",  // 第17位=5, 奇数
            "100000200110011071, 男",  // 第17位=7, 奇数
            "100000200110011091, 男",  // 第17位=9, 奇数
            "100000200110011021, 女",  // 第17位=2, 偶数
            "100000200110011041, 女",  // 第17位=4, 偶数
            "100000200110011061, 女",  // 第17位=6, 偶数
            "100000200110011081, 女",  // 第17位=8, 偶数
            "100000200110011001, 女"   // 第17位=0, 偶数
    })
    public void testGetGender_parameterized(String idCard, String expectedGender) {
        String gender = userService.getGender(idCard);
        Assertions.assertEquals(expectedGender, gender);
    }

    /**
     * 参数化测试 - 无效身份证号
     */
    @DisplayName("测试getGender - 无效身份证号")
    @ParameterizedTest
    @NullSource
    public void testGetGender_invalid(String idCard) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender(idCard));
    }
}
