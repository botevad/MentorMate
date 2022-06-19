package com.calculatorwithdataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorWithDataProvider {
    @DataProvider(name = "data-provider")
    public Object [][] dpMethod () {
        return new Object[][] {{2,3,5}, {5,7,12}};
    }

    @Test(dataProvider = "data-provider", groups = "group1")
    public void testAddition (int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(result, sum);
    }

    @Test (dataProvider = "data-provider", groups = "group2")
    public void testSubtraction (int a, int b, int result) {
        int sum = a - b;
        Assert.assertEquals(result, sum);
    }

    @Test (dataProvider = "data-provider", groups = "group3")
    public void testMultiplication (int a, int b, int result) {
        int sum = a * b;
        Assert.assertEquals(result, sum);
    }

    @Test (dataProvider = "data-provider", groups = "group4")
    public void testDivision (int a, int b, int result) {
        int sum = a / b;
        Assert.assertEquals(result, sum);
    }

    @Test (dataProvider = "data-provider", groups = "group5")
    public void testModul (int a, int b, int result) {
        int sum = a % b;
        Assert.assertEquals(result, sum);
    }

}
