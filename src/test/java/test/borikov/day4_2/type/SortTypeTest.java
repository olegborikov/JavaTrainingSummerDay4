package test.borikov.day4_2.type;

import com.borikov.day4_2.exception.InvalidDataException;
import com.borikov.day4_2.type.SortType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortTypeTest {
    @DataProvider(name = "sortMethodPositiveData")
    public Object[][] createSortMethodPositiveData() {
        return new Object[][]{
                {SortType.SUM_LINE, new int[]{1, 2, 3}, 6},
                {SortType.SUM_LINE, new int[]{-1, 2, 3}, 4},
                {SortType.SUM_LINE, new int[]{0, -5, 5}, 0},
                {SortType.MAX_ELEMENT_LINE, new int[]{1, 2, 3}, 3},
                {SortType.MAX_ELEMENT_LINE, new int[]{-1, 2, 123}, 123},
                {SortType.MAX_ELEMENT_LINE, new int[]{0, -5, 5}, 5},
                {SortType.MIN_ELEMENT_LINE, new int[]{1, 2, 3}, 1},
                {SortType.MIN_ELEMENT_LINE, new int[]{-1, 2, 123}, -1},
                {SortType.MIN_ELEMENT_LINE, new int[]{0, -5, 5}, -5},
        };
    }

    @Test(dataProvider = "sortMethodPositiveData")
    public void sortMethodPositiveTest(SortType sortType, int[] numbers, int expected) {
        try {
            int actual = sortType.sortMethod(numbers);
            assertEquals(actual, expected);
        } catch (InvalidDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "sortMethodNegativeData")
    public Object[][] createSortMethodNegativeData() {
        return new Object[][]{
                {SortType.SUM_LINE, new int[]{1, 2, 3}, 3},
                {SortType.SUM_LINE, new int[]{-1, 2, 3}, 2},
                {SortType.SUM_LINE, new int[]{0, -5, 5}, 1},
                {SortType.MAX_ELEMENT_LINE, new int[]{1, 2, 3}, 1},
                {SortType.MAX_ELEMENT_LINE, new int[]{-1, 2, 123}, -1},
                {SortType.MAX_ELEMENT_LINE, new int[]{0, -5, 5}, 0},
                {SortType.MIN_ELEMENT_LINE, new int[]{1, 2, 3}, -10},
                {SortType.MIN_ELEMENT_LINE, new int[]{-1, 2, 123}, 123},
                {SortType.MIN_ELEMENT_LINE, new int[]{0, -5, 5}, 5},
        };
    }

    @Test(dataProvider = "sortMethodNegativeData")
    public void sortMethodNegativeTest(SortType sortType, int[] numbers, int expected) {
        try {
            int actual = sortType.sortMethod(numbers);
            assertNotEquals(actual, expected);
        } catch (InvalidDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "sortMethodExceptionData")
    public Object[][] createSortMethodExceptionData() {
        return new Object[][]{
                {SortType.SUM_LINE, null},
                {SortType.MAX_ELEMENT_LINE, null},
                {SortType.MIN_ELEMENT_LINE, null},
        };
    }

    @Test(dataProvider = "sortMethodExceptionData",
            expectedExceptions = InvalidDataException.class)
    public void sortMethodExceptionTest(SortType sortType, int[] numbers) throws InvalidDataException {
        int actual = sortType.sortMethod(numbers);
    }
}
