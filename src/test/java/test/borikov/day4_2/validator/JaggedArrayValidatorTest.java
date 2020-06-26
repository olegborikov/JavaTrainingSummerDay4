package test.borikov.day4_2.validator;

import com.borikov.day4_2.validator.JaggedArrayValidator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JaggedArrayValidatorTest {
    JaggedArrayValidator jaggedArrayValidator;

    @BeforeTest
    public void setUp() {
        jaggedArrayValidator = new JaggedArrayValidator();
    }

    @AfterTest
    public void tearDown() {
        jaggedArrayValidator = null;
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
        boolean actual = jaggedArrayValidator.isIndexCorrect(index, arrayLength);
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
        boolean actual = jaggedArrayValidator.isIndexCorrect(index, arrayLength);
        assertFalse(actual);
    }
}
