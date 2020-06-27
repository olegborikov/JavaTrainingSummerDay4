package test.borikov.day4_1.service;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.service.ArraySortService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySortServiceTest {
    ArraySortService arraySortService;

    @BeforeClass
    public void setUp() {
        arraySortService = new ArraySortService();
    }

    @AfterClass
    public void tearDown() {
        arraySortService = null;
    }

    @DataProvider(name = "sortPositiveData")
    public Object[][] createSortPositiveData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 10, 4, 5, 1}),
                        false, new IntegerArray(new int[]{1, 1, 4, 5, 10})},
                {new IntegerArray(new int[]{5, -4, 3, -2, 1}),
                        false, new IntegerArray(new int[]{-4, -2, 1, 3, 5})},
                {new IntegerArray(new int[]{1, 0, -5, 5}),
                        true, new IntegerArray(new int[]{5, 1, 0, -5})},
        };
    }

    @DataProvider(name = "sortNegativeData")
    public Object[][] createBubbleSortNegativeTest() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 10, 4, 5, 1}),
                        false, new IntegerArray(new int[]{10})},
                {new IntegerArray(new int[]{5, -4, 3, -2, 1}),
                        false, new IntegerArray(new int[]{-4, -2, 1, 3, 10, 1, 5})},
                {new IntegerArray(new int[]{1, 0, -5, 5}),
                        true, new IntegerArray(new int[]{-5, 0, 1, 5})},
        };
    }

    @Test(dataProvider = "sortPositiveData")
    public void bubbleSortPositiveTest(IntegerArray actual, boolean isReverse, IntegerArray expected) {
        try {
            arraySortService.bubbleSort(actual, isReverse);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(dataProvider = "sortNegativeData")
    public void bubbleSortNegativeTest(IntegerArray actual, boolean isReverse, IntegerArray expected) {
        try {
            arraySortService.bubbleSort(actual, isReverse);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void bubbleSortExceptionTest() throws IncorrectDataException {
        IntegerArray integerArray = null;
        boolean isReverse = true;
        arraySortService.bubbleSort(integerArray, isReverse);
    }

    @Test(dataProvider = "sortPositiveData")
    public void selectionSortPositiveTest(IntegerArray actual, boolean isReverse, IntegerArray expected) {
        try {
            arraySortService.selectionSort(actual, isReverse);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(dataProvider = "sortNegativeData")
    public void selectionSortNegativeTest(IntegerArray actual, boolean isReverse, IntegerArray expected) {
        try {
            arraySortService.selectionSort(actual, isReverse);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void selectionSortExceptionTest() throws IncorrectDataException {
        IntegerArray integerArray = null;
        boolean isReverse = true;
        arraySortService.selectionSort(integerArray, isReverse);
    }

    @Test(dataProvider = "sortPositiveData")
    public void insertionSortPositiveTest(IntegerArray actual, boolean isReverse, IntegerArray expected) {
        try {
            arraySortService.insertionSort(actual, isReverse);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(dataProvider = "sortNegativeData")
    public void insertionSortNegativeTest(IntegerArray actual, boolean isReverse, IntegerArray expected) {
        try {
            arraySortService.insertionSort(actual, isReverse);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void insertionSortExceptionTest() throws IncorrectDataException {
        IntegerArray integerArray = null;
        boolean isReverse = true;
        arraySortService.insertionSort(integerArray, isReverse);
    }
}
