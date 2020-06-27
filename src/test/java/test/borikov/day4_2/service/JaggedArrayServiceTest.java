package test.borikov.day4_2.service;

import com.borikov.day4_2.exception.InvalidDataException;
import com.borikov.day4_2.service.JaggedArrayService;
import com.borikov.day4_2.type.SortType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JaggedArrayServiceTest {
    JaggedArrayService jaggedArrayService;

    @BeforeClass
    public void setUp() {
        jaggedArrayService = new JaggedArrayService();
    }

    @AfterClass
    public void tearDown() {
        jaggedArrayService = null;
    }

    @DataProvider(name = "bubbleSortPositiveData")
    public Object[][] createBubbleSortPositiveData() {
        return new Object[][]{
                {new int[][]{
                        {7, 8, 9},
                        {1, 2, 3},
                        {4, 5, 6}},
                        SortType.SUM_LINE, false,
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}}},
                {new int[][]{
                        {7, 8, 9},
                        {1, 2},
                        {6}},
                        SortType.SUM_LINE, true,
                        new int[][]{
                                {7, 8, 9},
                                {6},
                                {1, 2}}},
                {new int[][]{
                        {10, 11, 20},
                        {-1, 0, 1, 10, 15},
                        {-20}},
                        SortType.MIN_ELEMENT_LINE, false,
                        new int[][]{
                                {-20},
                                {-1, 0, 1, 10, 15},
                                {10, 11, 20}}},
                {new int[][]{
                        {-29, -120},
                        {0},
                        {1, 2, 3, 4}},
                        SortType.MIN_ELEMENT_LINE, true,
                        new int[][]{
                                {1, 2, 3, 4},
                                {0},
                                {-29, -120}}},
                {new int[][]{
                        {10, 11, 20},
                        {-1, 0, 1, 10, 15},
                        {-20}},
                        SortType.MAX_ELEMENT_LINE, false,
                        new int[][]{
                                {-20},
                                {-1, 0, 1, 10, 15},
                                {10, 11, 20}}},
                {new int[][]{
                        {1, 2, 4},
                        {-20, -30, 5}},
                        SortType.MAX_ELEMENT_LINE, true,
                        new int[][]{
                                {-20, -30, 5},
                                {1, 2, 4}}},
        };
    }

    @Test(dataProvider = "bubbleSortPositiveData")
    public void bubbleSortPositiveTest(int[][] actual, SortType sortType,
                                       boolean isReverse, int[][] expected) {
        try {
            jaggedArrayService.bubbleSort(actual, sortType, isReverse);
            boolean result = equalsTwoDimensionalArray(actual, expected);
            assertTrue(result);
        } catch (InvalidDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "bubbleSortNegativeData")
    public Object[][] createBubbleSortNegativeData() {
        return new Object[][]{
                {new int[][]{
                        {7, 8, 9},
                        {4, 5, 6}},
                        SortType.SUM_LINE, false,
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6}}},
                {new int[][]{
                        {10, 11, 20},
                        {-1, 0, 1, 10, 15},
                        {-20}},
                        SortType.MIN_ELEMENT_LINE, false,
                        new int[][]{
                                {-21},
                                {-1, 0, 1, 10, 15},
                                {10, 11, 20}}},
                {new int[][]{
                        {10, 11, 20},
                        {-1, 0, 1, 10, 15},},
                        SortType.MAX_ELEMENT_LINE, false,
                        new int[][]{}},
        };
    }

    @Test(dataProvider = "bubbleSortNegativeData")
    public void bubbleSortNegativeTest(int[][] actual, SortType sortType,
                                       boolean isReverse, int[][] expected) {
        try {
            jaggedArrayService.bubbleSort(actual, sortType, isReverse);
            boolean result = equalsTwoDimensionalArray(actual, expected);
            assertFalse(result);
        } catch (InvalidDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "bubbleSorExceptionData")
    public Object[][] createBubbleSortExceptionData() {
        return new Object[][]{
                {null,
                        SortType.SUM_LINE, false,},
                {new int[][]{
                        {10, 11, 20},
                        {-1, 0, 1, 10, 15},
                        {-20}},
                        null, false},
                {new int[][]{
                        null,
                        {-1, 0, 1, 10, 15},},
                        SortType.MAX_ELEMENT_LINE, false,},
        };
    }

    @Test(dataProvider = "bubbleSorExceptionData",
            expectedExceptions = InvalidDataException.class)
    public void bubbleSortExceptionTest(int[][] actual, SortType sortType,
                                        boolean isReverse) throws InvalidDataException {
        jaggedArrayService.bubbleSort(actual, sortType, isReverse);
    }

    private boolean equalsTwoDimensionalArray(int[][] firstArray, int[][] secondArray) {
        boolean result = true;
        if (firstArray.length != secondArray.length) {
            result = false;
        } else {
            for (int i = 0; i < firstArray.length; i++) {
                if (firstArray[i].length != secondArray[i].length) {
                    result = false;
                } else {
                    for (int j = 0; j < firstArray[i].length; j++) {
                        if (firstArray[i][j] != secondArray[i][j]) {
                            result = false;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
