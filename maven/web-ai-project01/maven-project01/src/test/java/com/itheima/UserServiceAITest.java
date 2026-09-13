package com.itheima;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.Period;

/**
AI 生成的单元测试 - 针对 getAge 方法的补充测试
@author N1357
@since 2026/9/13
*/
@DisplayName("AI生成 - getAge 补充测试")
public class UserServiceAITest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    @DisplayName("测试getAge - 身份证号为空字符串")
    public void testGetAge_empty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getAge(""));
    }

    /**
     * 参数化测试 - 不同出生日期的年龄计算
     */
    @DisplayName("测试getAge - 参数化测试不同出生日期")
    @ParameterizedTest
    @CsvSource({
            "100000199001011011, 1990, 1, 1",   // 1990-01-01
            "100000200006151012, 2000, 6, 15",   // 2000-06-15
            "100000198512311013, 1985, 12, 31",  // 1985-12-31
            "100000201002281014, 2010, 2, 28",   // 2010-02-28
            "100000200002291015, 2000, 2, 29"    // 2000-02-29 (闰年)
    })
    public void testGetAge_parameterized(String idCard, int year, int month, int day) {
        Integer age = userService.getAge(idCard);
        int expected = Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears();
        Assertions.assertEquals(expected, age);
    }

    @Test
    @DisplayName("测试getAge - 今年生日还没到")
    public void testGetAge_birthdayNotYetThisYear() {
        // 构造一个出生日期: 取明天的日期(确保今年生日还没过)
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        // 用该日期构造身份证号, 出生月日在第7~14位
        String birthdayStr = tomorrow.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd"));
        String idCard = "100000" + birthdayStr + "1011";
        Integer age = userService.getAge(idCard);
        int expected = Period.between(tomorrow, LocalDate.now()).getYears();
        Assertions.assertEquals(expected, age);
    }

    @Test
    @DisplayName("测试getAge - 今年生日已经过了")
    public void testGetAge_birthdayAlreadyPassed() {
        // 构造一个出生日期: 取昨天的日期(确保今年生日已经过了)
        LocalDate yesterday = LocalDate.now().minusDays(1);
        String birthdayStr = yesterday.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd"));
        String idCard = "100000" + birthdayStr + "1011";
        Integer age = userService.getAge(idCard);
        int expected = Period.between(yesterday, LocalDate.now()).getYears();
        Assertions.assertEquals(expected, age);
    }
}
