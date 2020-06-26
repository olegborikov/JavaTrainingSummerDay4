package test.borikov.day4_1.parser;

import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.parser.ArrayParser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class ArrayParserTest {
    ArrayParser arrayParser;

    @BeforeTest
    public void setUp() {
        arrayParser = new ArrayParser();
    }

    @AfterTest
    public void tearDown() {
        arrayParser = null;
    }

    @DataProvider(name = "parseLineToArrayPositiveData")
    public Object[][] createParseLineToArrayPositiveData() {
        return new Object[][]{
                {"2  3 ", new int[]{2, 3}},
                {"     -1         2 3    ", new int[]{-1, 2, 3}},
                {"1 2 3 4  5 -6", new int[]{1, 2, 3, 4, 5, -6}}
        };
    }

    @Test(dataProvider = "parseLineToArrayPositiveData")
    public void parseLineToArrayPositiveTest(String data, int[] expected) {
        try {
            int[] actual = arrayParser.parseLineToArray(data);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "parseLineToArrayNegativeData")
    public Object[][] createParseLineToArrayNegativeData() {
        return new Object[][]{
                {"1", new int[]{}},
                {"321", new int[]{1, 2, 3}},
                {"1 2 -6", new int[]{1, 2, 3, 4, 5, -6}}
        };
    }

    @Test(dataProvider = "parseLineToArrayNegativeData")
    public void parseLineToArrayNegativeTest(String data, int[] expected) {
        try {
            int[] actual = arrayParser.parseLineToArray(data);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "parseLineToArrayExceptionData")
    public Object[][] createParseLineToArrayExceptionData() {
        return new Object[][]{
                {"qwerty"},
                {null},
                {""}
        };
    }

    @Test(dataProvider = "parseLineToArrayExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void parseLineToArrayExceptionTest(String data) throws IncorrectDataException {
        arrayParser.parseLineToArray(data);
    }

    @DataProvider(name = "breakUpNumberToArrayPositiveData")
    public Object[][] createBreakUpNumberToArrayPositiveData() {
        return new Object[][]{
                {103, new int[]{1, 0, 3}},
                {-123, new int[]{1, 2, 3}},
                {0, new int[]{0}}
        };
    }

    @Test(dataProvider = "breakUpNumberToArrayPositiveData")
    public void breakUpNumberToArrayPositiveTest(int number, int[] expected) {
        int[] actual = arrayParser.breakUpNumberToArray(number);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "breakUpNumberToArrayNegativeData")
    public Object[][] createBreakUpNumberToArrayNegativeData() {
        return new Object[][]{
                {1034, new int[]{1, 0, 3}},
                {-123, new int[]{1}},
                {0, new int[]{}}
        };
    }

    @Test(dataProvider = "breakUpNumberToArrayNegativeData")
    public void breakUpNumberToArrayNegativeTest(int number, int[] expected) {
        int[] actual = arrayParser.breakUpNumberToArray(number);
        assertNotEquals(actual, expected);
    }
}
