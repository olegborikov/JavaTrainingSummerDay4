package test.borikov.day4_1.reader;

import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.reader.ConsoleReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.*;

public class ConsoleReaderTest {
    ConsoleReader consoleReader;

    @BeforeClass
    public void setUp() {
        consoleReader = new ConsoleReader();
    }

    @AfterClass
    public void tearDown() {
        consoleReader = null;
    }

    @DataProvider(name = "readArraySizePositiveData")
    public Object[][] createReadArraySizePositiveData() {
        return new Object[][]{
                {"1", new int[]{0}},
                {"2", new int[]{0, 0}},
                {"5", new int[]{0, 0, 0, 0, 0}}
        };
    }

    @Test(dataProvider = "readArraySizePositiveData")
    public void readArraySizePositiveTest(String data, int[] expected) {
        InputStream actualData = new ByteArrayInputStream(data.getBytes());
        try {
            int[] actual = consoleReader.readArraySize(actualData);
            boolean result = equalsOneDimensionalArray(actual, expected);
            assertTrue(result);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "readArraySizeNegativeData")
    public Object[][] createReadArraySizeNegativeData() {
        return new Object[][]{
                {"5", new int[]{0}},
                {"3", new int[]{0, 0}},
                {"1", new int[]{}}
        };
    }

    @Test(dataProvider = "readArraySizeNegativeData")
    public void readArraySizeNegativeTest(String data, int[] expected) {
        InputStream actualData = new ByteArrayInputStream(data.getBytes());
        try {
            int[] actual = consoleReader.readArraySize(actualData);
            boolean result = equalsOneDimensionalArray(actual, expected);
            assertFalse(result);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "readArraySizeExceptionData")
    public Object[][] createReadArraySizeExceptionData() {
        return new Object[][]{
                {"eq23"},
                {"0"},
                {"-20"}
        };
    }

    @Test(dataProvider = "readArraySizeExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void readArraySizeExceptionTest(String data) throws IncorrectDataException {
        InputStream actual = new ByteArrayInputStream(data.getBytes());
        consoleReader.readArraySize(actual);
    }


    @DataProvider(name = "readArrayElementPositiveData")
    public Object[][] createReadArrayElementPositiveData() {
        return new Object[][]{
                {1, "100", 100},
                {2, "-100", -100},
                {3, "1", 1}
        };
    }

    @Test(dataProvider = "readArrayElementPositiveData")
    public void readArrayElementPositiveTest(int index, String data, int expected) {
        InputStream actualData = new ByteArrayInputStream(data.getBytes());
        try {
            int actual = consoleReader.readArrayElement(index, actualData);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "readArrayElementNegativeTest")
    public Object[][] createReadArrayElementNegativeTest() {
        return new Object[][]{
                {1, "100", 10},
                {2, "-100", 3},
                {3, "1", 123}
        };
    }

    @Test(dataProvider = "readArrayElementNegativeTest")
    public void readArrayElementNegativeTest(int index, String data, int expected) {
        InputStream actualData = new ByteArrayInputStream(data.getBytes());
        try {
            int actual = consoleReader.readArrayElement(index, actualData);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "readArrayElementExceptionData")
    public Object[][] createReadArrayElementExceptionData() {
        return new Object[][]{
                {0, "eq23"},
                {1, "dhb "},
                {2, "20fg"}
        };
    }

    @Test(dataProvider = "readArrayElementExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void readArrayElementExceptionTest(int index, String data) throws IncorrectDataException {
        InputStream actual = new ByteArrayInputStream(data.getBytes());
        consoleReader.readArrayElement(index, actual);
    }

    private boolean equalsOneDimensionalArray(int[] firstArray, int[] secondArray) {
        boolean result = true;
        if (firstArray.length != secondArray.length) {
            result = false;
        } else {
            for (int i = 0; i < firstArray.length; i++) {
                if (firstArray[i] != secondArray[i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
