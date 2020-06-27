package test.borikov.day4_1.service;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.service.ArraySearchService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySearchServiceTest {

    ArraySearchService arraySearchService;

    @BeforeTest
    public void setUp() {
        arraySearchService = new ArraySearchService();
    }

    @AfterTest
    public void tearDown() {
        arraySearchService = null;
    }

    @DataProvider(name = "binarySearchPositiveData")
    public Object[][] createBinarySearchPositiveData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 5, 4}), 4, 2},
                {new IntegerArray(new int[]{1, 5, 10, 15}), 15, 3},
                {new IntegerArray(new int[]{5,4,3,2}), 1, -1}
        };
    }

    @Test(dataProvider = "binarySearchPositiveData")
    public void binarySearchPositiveTest(IntegerArray integerArray, int number, int expected) {
        try {
            int actual = arraySearchService.binarySearch(integerArray, number);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "binarySearchNegativeData")
    public Object[][] createBinarySearchNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 5, 4}), 4, 5},
                {new IntegerArray(new int[]{1, 5, 10, 15}), 15, -2},
                {new IntegerArray(new int[]{5,4,3,2}), 1, 0}
        };
    }

    @Test(dataProvider = "binarySearchNegativeData")
    public void binarySearchNegativeTest(IntegerArray integerArray, int number, int expected) {
        try {
            int actual = arraySearchService.binarySearch(integerArray, number);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void binarySearchExceptionTest() throws IncorrectDataException {
        IntegerArray integerArray = null;
        int number = 10;
        arraySearchService.binarySearch(integerArray, number);
    }
}
