package com.introduction;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcServiceTest {
    CalcService calcService;

    @BeforeMethod
    public void setUp() {
        calcService = new CalcService();
    }

    @DataProvider // getting the more numbers for testing
    private static Object[][] getMoreNumbers() {
        return new Object[][] {
                {1, 2},
                {-3, -4},
                {-5, 6},
                {7, -8},
                {0, 0},
                {0, 4},
                {5, 0},
        };
    }

    @DataProvider  // dataProvider for division operation
    public static Object[][] getZeroDenominators() {
        return new Object[][] {
                {2, 0},
                {-3, 0},
                {0, 0}
        };
    }
    // Steps for testing: Arrange, Act, Assert
    @Test(dataProvider = "getMoreNumbers")
    void givenCalcService_whenAddingTwoNumbers_thenReturnSum(int num1, int num2) {
        int actualResult = calcService.add(num1, num2);
        int expectedResult = num1 + num2;
        Assert.assertEquals(actualResult, expectedResult, "Adding two numbers");
    }

    @Test(dataProvider = "getMoreNumbers")
    void givenCalcService_whenSubtractingTwoNumbers_thenReturnDifference(int num1, int num2) {
        int actualResult = calcService.subtract(num1, num2);
        int expectedResult = num1 - num2;
        Assert.assertEquals(actualResult, expectedResult, "Subtracting two numbers");
    }

    @Test(dataProvider = "getMoreNumbers")
    void givenCalcService_whenMultiplyingTwoNumbers_thenReturnProduct(int num1, int num2) {
        int actualResult = calcService.multiply(num1, num2);
        int expectedResult = num1 * num2;
        Assert.assertEquals(actualResult, expectedResult, "Multiplying two numbers");
    }

    @Test
    void givenCalcService_whenDividingTwoNumbers_thenReturnQuotient() {
        int num1 = 10;
        int num2 = 5;
        int actualResult = calcService.divide(num1, num2);
        Assert.assertEquals(actualResult, 2, "Dividing two numbers");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "getZeroDenominators")
    void givenCalcService_whenDenominatorIsZero_thenThrowException(int num1, int num2) {
        calcService.divide(num1, num2);
    }
}
