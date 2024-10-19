package com.introduction;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalcServiceTest {
    CalcService calcService;
    @BeforeMethod
    public void setUp() {
        calcService = new CalcService();
    }

    @DataProvider // getting the more numbers for testing
    private static  Object[][] getMoreNumbers() {
        return new Object[][] {
                {1,2},
                {-3,-4},
                {-5,6},
                {7,-8},
                {0,0},
                {0,4},
                {5,0},
        };
    }

    @DataProvider
    public static Object[][] getZeroDenominators() {
        return new Object[][] {
                {2,0},
                {-3,0},
                {0,0}
        };
    }

     // Steps to test: Arrange, Act, Assert
    @Test(dataProvider = "getMoreNumbers")
    void givenCalcService_whenAddingTwoNumber_thenReturnSum(int num1, int num2) {
        //Arrange
//        CalculatorService calculatorService = new CalculatorService();
//        int num1=10;
//        int num2 =5;
        //Act
        int actualResults = calcService.add(num1,num2);
        int expectedResults = num1 + num2;
        //Assert
        Assert.assertEquals(actualResults,expectedResults,"Adding two numbers");
    }


    @Test(dataProvider = "getMoreNumbers")
    void givenCalcService_whenSubtractingTwoNumbers_thenReturnDifference(int num1, int num2) {
        //Arrange
//        CalcService calcService = new CalcService();
//        int num1=4;
//        int numb2=3;
        //Act
        int actualResults = calcService.add(num1,num2);
        int expectedResults = num1 + num2;
        //Assert
        Assert.assertEquals(actualResults,expectedResults,"Subtracting two numbers");
    }

    @Test(dataProvider = "getMoreNumbers")
    void givenCalcService_whenMultiplyingTwoNumbers_thenReturnMultiplication(int num1, int num2) {
        //Arrange
//        CalcService calcService = new CalcService();
//        int num1=10;
//        int num2=5;
        //Act
        int actualResults = calcService.add(num1,num2);
        int expectedResults = num1 + num2;
        //Assert
        Assert.assertEquals(actualResults,expectedResults,"Multiplying two numbers");

    }

    @Test
    void givenCalcService_whenDividingTwoNumbers_thenReturnQuotient() {
        //Arrange
//        CalcService calcService = new CalcService();
        int num1=10;
        int num2=5;
//        Act
        int actualResults = calcService.divide(num1,num2);

//        Assert
        Assert.assertEquals(actualResults,2,"Dividing two numbers");
    }

    @Test(expectedExceptions = IllegalArgumentException.class,dataProvider = "getZeroDenominators")
    void givenCalcService_whenDenominatorIsZero_thenThrowException(int num1 , int num2) {
        //Arrange
//        CalcService calcService = new CalcService();
//        int num1=10;
//        int num2=0;
//        Act
        calcService.divide(num1,num2);

//        Assert
    }
}
