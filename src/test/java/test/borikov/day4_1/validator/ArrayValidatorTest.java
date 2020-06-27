package test.borikov.day4_1.validator;

import com.borikov.day4_1.validator.ArrayValidator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayValidatorTest {
    ArrayValidator arrayValidator;

    @BeforeTest
    public void setUp() {
        arrayValidator = new ArrayValidator();
    }

    @AfterTest
    public void tearDown() {
        arrayValidator = null;
    }

    @DataProvider(name = "isIndexCorrectPositiveData")
    public Object[][] createIsIndexCorrectPositiveData() {
        return new Object[][]{
                {0, 10},
                {9, 10},
                {5, 10}
        };
    }

    @Test(dataProvider = "isIndexCorrectPositiveData")
    public void isIndexCorrectPositiveTest(int index, int arrayLength) {
        boolean actual = arrayValidator.isIndexCorrect(index, arrayLength);
        assertTrue(actual);
    }

    @DataProvider(name = "isIndexCorrectNegativeData")
    public Object[][] createIsIndexCorrectNegativeData() {
        return new Object[][]{
                {-1, 10},
                {4, -5},
                {-5, 10}
        };
    }

    @Test(dataProvider = "isIndexCorrectNegativeData")
    public void isIndexCorrectNegativeTest(int index, int arrayLength) {
        boolean actual = arrayValidator.isIndexCorrect(index, arrayLength);
        assertFalse(actual);
    }
}
