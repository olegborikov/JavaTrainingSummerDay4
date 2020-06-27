package test.borikov.day4_1.service;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.service.ArrayArithmeticService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayArithmeticServiceTest {
    ArrayArithmeticService arrayArithmeticService;

    @BeforeTest
    public void setUp() {
        arrayArithmeticService = new ArrayArithmeticService();
    }

    @AfterTest
    public void tearDown() {
        arrayArithmeticService = null;
    }

    @DataProvider(name = "maxValuePositiveData")
    public Object[][] createMaxValuePositiveData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 5, 4}), 5},
                {new IntegerArray(new int[]{1, 5, 10, 15}), 15},
                {new IntegerArray(new int[]{5, 4, 3, 2}), 5}
        };
    }

    @Test(dataProvider = "maxValuePositiveData")
    public void maxValuePositiveTest(IntegerArray integerArray, int expected) {
        try {
            int actual = arrayArithmeticService.maxValue(integerArray);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "maxValueNegativeData")
    public Object[][] createMaxValueNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 5, 4}), 1},
                {new IntegerArray(new int[]{1, 5, 10, 15}), 2},
                {new IntegerArray(new int[]{5, 4, 3, 2}), 3}
        };
    }

    @Test(dataProvider = "maxValueNegativeData")
    public void maxValueNegativeTest(IntegerArray integerArray, int expected) {
        try {
            int actual = arrayArithmeticService.maxValue(integerArray);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void maxValueExceptionTest() throws IncorrectDataException {
        IntegerArray integerArray = null;
        arrayArithmeticService.maxValue(integerArray);
    }

    @DataProvider(name = "minValuePositiveData")
    public Object[][] createMinValuePositiveData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 5, 4}), 1},
                {new IntegerArray(new int[]{2, 5, 10, 15}), 2},
                {new IntegerArray(new int[]{5, 4, 3, -5}), -5}
        };
    }

    @Test(dataProvider = "minValuePositiveData")
    public void minValuePositiveTest(IntegerArray integerArray, int expected) {
        try {
            int actual = arrayArithmeticService.minValue(integerArray);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "minValueNegativeData")
    public Object[][] createMinValueNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 5, 4}), 6},
                {new IntegerArray(new int[]{1, 5, 10, 15}), 2},
                {new IntegerArray(new int[]{5, 4, 3, 2}), 1}
        };
    }

    @Test(dataProvider = "minValueNegativeData")
    public void minValueNegativeTest(IntegerArray integerArray, int expected) {
        try {
            int actual = arrayArithmeticService.minValue(integerArray);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void minValueExceptionTest() throws IncorrectDataException {
        IntegerArray integerArray = null;
        arrayArithmeticService.minValue(integerArray);
    }

    @DataProvider(name = "getPrimeNumbersPositiveData")
    public Object[][] createGetPrimeNumbersPositiveData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 5, 4}), new int[]{1, 2, 5}},
                {new IntegerArray(new int[]{10, 15}), new int[]{}},
                {new IntegerArray(new int[]{-1, 0, 2, 3, 7}), new int[]{2, 3, 7}}
        };
    }

    @Test(dataProvider = "getPrimeNumbersPositiveData")
    public void getPrimeNumbersPositiveTest(IntegerArray integerArray, int[] expected) {
        try {
            int[] actual = arrayArithmeticService.getPrimeNumbers(integerArray);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "getPrimeNumbersNegativeData")
    public Object[][] createGetPrimeNumbersNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 5, 4}), new int[]{}},
                {new IntegerArray(new int[]{10, 15}), new int[]{1}},
                {new IntegerArray(new int[]{-1, 0, 2, 3, 7}), new int[]{2, 7}}
        };
    }

    @Test(dataProvider = "getPrimeNumbersNegativeData")
    public void getPrimeNumbersNegativeTest(IntegerArray integerArray, int[] expected) {
        try {
            int[] actual = arrayArithmeticService.getPrimeNumbers(integerArray);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void getPrimeNumbersExceptionTest() throws IncorrectDataException {
        IntegerArray integerArray = null;
        arrayArithmeticService.getPrimeNumbers(integerArray);
    }

    @DataProvider(name = "getFibonacciNumbersPositiveData")
    public Object[][] createGetFibonacciNumbersPositiveData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 5, 4}), new int[]{1, 2, 5}},
                {new IntegerArray(new int[]{10, 15}), new int[]{}},
                {new IntegerArray(new int[]{-1, 0, 2, 3, 7}), new int[]{-1, 0, 2, 3}}
        };
    }

    @Test(dataProvider = "getFibonacciNumbersPositiveData")
    public void getFibonacciNumbersPositiveTest(IntegerArray integerArray, int[] expected) {
        try {
            int[] actual = arrayArithmeticService.getFibonacciNumbers(integerArray);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "getFibonacciNumbersNegativeData")
    public Object[][] createGetFibonacciNumbersNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 5, 4}), new int[]{1, 2}},
                {new IntegerArray(new int[]{10, 15}), new int[]{20, 30, -1}},
                {new IntegerArray(new int[]{-1, 0, 2, 3, 7}), new int[]{4, 7}}
        };
    }

    @Test(dataProvider = "getFibonacciNumbersNegativeData")
    public void getFibonacciNumbersNegativeTest(IntegerArray integerArray, int[] expected) {
        try {
            int[] actual = arrayArithmeticService.getFibonacciNumbers(integerArray);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void getFibonacciNumbersExceptionTest() throws IncorrectDataException {
        IntegerArray integerArray = null;
        arrayArithmeticService.getFibonacciNumbers(integerArray);
    }

    @DataProvider(name = "getThreeDigitUniqueNumbersPositiveData")
    public Object[][] createGetThreeDigitUniqueNumbersPositiveData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{222, 123, -321}), new int[]{123, -321}},
                {new IntegerArray(new int[]{103, 99, 3}), new int[]{103}},
                {new IntegerArray(new int[]{101, 99, 109, -109}), new int[]{109, -109}}
        };
    }

    @Test(dataProvider = "getThreeDigitUniqueNumbersPositiveData")
    public void getThreeDigitUniqueNumbersPositiveTest(IntegerArray integerArray, int[] expected) {
        try {
            int[] actual = arrayArithmeticService.getThreeDigitUniqueNumbers(integerArray);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "getThreeDigitUniqueNumbersNegativeData")
    public Object[][] createGetThreeDigitUniqueNumbersNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{222, 123, -321}), new int[]{222}},
                {new IntegerArray(new int[]{103, 99, 3}), new int[]{}},
                {new IntegerArray(new int[]{1}), new int[]{321}}
        };
    }

    @Test(dataProvider = "getThreeDigitUniqueNumbersNegativeData")
    public void getThreeDigitUniqueNumbersNegativeTest(IntegerArray integerArray, int[] expected) {
        try {
            int[] actual = arrayArithmeticService.getThreeDigitUniqueNumbers(integerArray);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void getThreeDigitUniqueNumbersExceptionTest() throws IncorrectDataException {
        IntegerArray integerArray = null;
        arrayArithmeticService.getThreeDigitUniqueNumbers(integerArray);
    }
}
