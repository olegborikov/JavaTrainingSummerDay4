package test.borikov.day4_1.entity;

import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IntegerArrayTest {

    @DataProvider(name = "getPositiveData")
    public Object[][] createGetPositiveData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 3, 4, 5}), 0, 1},
                {new IntegerArray(new int[]{10, 11, 32}), 2, 32},
                {new IntegerArray(new int[]{3, 2, 1, -3}), 3, -3},
        };
    }

    @Test(dataProvider = "getPositiveData")
    public void getPositiveTest(IntegerArray integerArray, int index, int expected) {
        try {
            int actual = integerArray.get(index);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "getNegativeData")
    public Object[][] createGetNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{6, 2, 3, 4, 5}), 0, 1},
                {new IntegerArray(new int[]{10, 11, 32}), 2, 30},
                {new IntegerArray(new int[]{3, 2}), 1, 3},
        };
    }

    @Test(dataProvider = "getNegativeData")
    public void getNegativeTest(IntegerArray integerArray, int index, int expected) {
        try {
            int actual = integerArray.get(index);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "getExceptionData")
    public Object[][] createGetExceptionData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{6, 2, 3, 4, 5}), -1},
                {new IntegerArray(new int[]{10, 11, 32}), 5},
                {new IntegerArray(new int[]{3, 2}), 3},
        };
    }

    @Test(dataProvider = "getExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void getExceptionTest(IntegerArray integerArray, int index) throws IncorrectDataException {
        integerArray.get(index);
    }

    @DataProvider(name = "setPositiveData")
    public Object[][] creatSetPositiveData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 3, 4, 5}),
                        1, 1, new IntegerArray(new int[]{1, 1, 3, 4, 5})},
                {new IntegerArray(new int[]{3, 2, 1, 5}),
                        0, 2, new IntegerArray(new int[]{2, 2, 1, 5})},
                {new IntegerArray(new int[]{20, 30, 40}),
                        2, 10, new IntegerArray(new int[]{20, 30, 10})},
        };
    }

    @Test(dataProvider = "setPositiveData")
    public void setPositiveTest(IntegerArray actual, int index, int value, IntegerArray expected) {
        try {
            actual.set(index, value);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "setNegativeData")
    public Object[][] creatSetNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{1, 2, 3, 4, 5}),
                        1, 1, new IntegerArray(new int[]{5})},
                {new IntegerArray(new int[]{3, 2, 1, 5}),
                        0, 2, new IntegerArray(new int[]{2, 2})},
                {new IntegerArray(new int[]{20, 30, 40}),
                        2, 10, new IntegerArray(new int[]{20, 30, 20})},
        };
    }

    @Test(dataProvider = "setNegativeData")
    public void setNegativeTest(IntegerArray actual, int index, int value, IntegerArray expected) {
        try {
            actual.set(index, value);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "setExceptionData")
    public Object[][] creatSetExceptionData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{6, 2, 3, 4, 5}), -1, 10},
                {new IntegerArray(new int[]{10, 11, 32}), 5, 2},
                {new IntegerArray(new int[]{3, 2}), 3, 3},
        };
    }


    @Test(dataProvider = "setExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void setExceptionTest(IntegerArray actual, int index, int value) throws IncorrectDataException {
        actual.set(index, value);
    }

    @DataProvider(name = "equalsToArrayPositiveData")
    public Object[][] creatEqualsToArrayPositiveData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{6, 2, 3, 4, 5}), new int[]{6, 2, 3, 4, 5}},
                {new IntegerArray(new int[]{10, 11, 32}), new int[]{10, 11, 32}},
                {new IntegerArray(new int[]{3, 2}), new int[]{3, 2}},
        };
    }

    @Test(dataProvider = "equalsToArrayPositiveData")
    public void equalsToArrayPositiveTest(IntegerArray integerArray, int[] numbers) {
        boolean actual = integerArray.equalsToArray(numbers);
        assertTrue(actual);
    }

    @DataProvider(name = "equalsToArrayNegativeData")
    public Object[][] creatEqualsToArrayNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {new IntegerArray(new int[]{6, 2, 3, 4, 5}), new int[]{6}},
                {new IntegerArray(new int[]{10, 11, 32}), new int[]{10, 11}},
                {new IntegerArray(new int[]{3, 2, 1}), new int[]{3, 2}},
        };
    }

    @Test(dataProvider = "equalsToArrayNegativeData")
    public void equalsToArrayNegativeTest(IntegerArray integerArray, int[] numbers) {
        boolean actual = integerArray.equalsToArray(numbers);
        assertFalse(actual);
    }
}
