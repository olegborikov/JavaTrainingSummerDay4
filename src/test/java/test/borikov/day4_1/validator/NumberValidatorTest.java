package test.borikov.day4_1.validator;

import com.borikov.day4_1.validator.NumberValidator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberValidatorTest {
    NumberValidator numberValidator;

    @BeforeTest
    public void setUp() {
        numberValidator = new NumberValidator();
    }

    @AfterTest
    public void tearDown() {
        numberValidator = null;
    }

    @DataProvider(name = "isNumberPrimePositiveData")
    public Object[][] createIsNumberPrimePositiveData() {
        return new Object[][]{
                {1},
                {7},
                {13}
        };
    }

    @Test(dataProvider = "isNumberPrimePositiveData")
    public void isNumberPrimePositiveTest(int number) {
        boolean actual = numberValidator.isNumberPrime(number);
        assertTrue(actual);
    }

    @DataProvider(name = "isNumberPrimeNegativeData")
    public Object[][] createIsNumberPrimeNegativeData() {
        return new Object[][]{
                {0},
                {6},
                {-10}
        };
    }

    @Test(dataProvider = "isNumberPrimeNegativeData")
    public void isNumberPrimeNegativeTest(int number) {
        boolean actual = numberValidator.isNumberPrime(number);
        assertFalse(actual);
    }

    @DataProvider(name = "isNumberFibonacciPositiveData")
    public Object[][] createIsNumberFibonacciPositiveData() {
        return new Object[][]{
                {0},
                {-8},
                {1}
        };
    }

    @Test(dataProvider = "isNumberFibonacciPositiveData")
    public void isNumberFibonacciPositiveTest(int number) {
        boolean actual = numberValidator.isNumberFibonacci(number);
        assertTrue(actual);
    }

    @DataProvider(name = "isNumberFibonacciNegativeData")
    public Object[][] createIsNumberFibonacciNegativeData() {
        return new Object[][]{
                {-2},
                {-34},
                {123}
        };
    }

    @Test(dataProvider = "isNumberFibonacciNegativeData")
    public void isNumberFibonacciNegativeTest(int number) {
        boolean actual = numberValidator.isNumberFibonacci(number);
        assertFalse(actual);
    }

    @DataProvider(name = "isNumberThreeDigitPositiveData")
    public Object[][] createIsNumberThreeDigitPositiveData() {
        return new Object[][]{
                {100},
                {999},
                {-123}
        };
    }

    @Test(dataProvider = "isNumberThreeDigitPositiveData")
    public void isNumberThreeDigitPositiveTest(int number) {
        boolean actual = numberValidator.isNumberThreeDigit(number);
        assertTrue(actual);
    }

    @DataProvider(name = "isNumberThreeDigitNegativeData")
    public Object[][] createIsNumberThreeDigitNegativeData() {
        return new Object[][]{
                {99},
                {1000},
                {0}
        };
    }

    @Test(dataProvider = "isNumberThreeDigitNegativeData")
    public void isNumberThreeDigitNegativeTest(int number) {
        boolean actual = numberValidator.isNumberThreeDigit(number);
        assertFalse(actual);
    }

    @DataProvider(name = "isNumberUniquePositiveData")
    public Object[][] createIsNumberUniquePositiveData() {
        return new Object[][]{
                {19},
                {-321},
                {0}
        };
    }


    @Test(dataProvider = "isNumberUniquePositiveData")
    public void isNumberUniquePositiveTest(int number) {
        boolean actual = numberValidator.isNumberUnique(number);
        assertTrue(actual);
    }

    @DataProvider(name = "isNumberUniqueNegativeData")
    public Object[][] createIsNumberUniqueNegativeData() {
        return new Object[][]{
                {99},
                {13455},
                {-122}
        };
    }

    @Test(dataProvider = "isNumberUniqueNegativeData")
    public void isNumberUniqueNegativeTest(int number) {
        boolean actual = numberValidator.isNumberUnique(number);
        assertFalse(actual);
    }
}
