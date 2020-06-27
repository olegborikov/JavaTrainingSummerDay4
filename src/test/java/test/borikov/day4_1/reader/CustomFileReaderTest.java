package test.borikov.day4_1.reader;

import com.borikov.day4_1.exception.IncorrectDataException;
import com.borikov.day4_1.reader.CustomFileReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomFileReaderTest {
    CustomFileReader customFileReader;

    @BeforeClass
    public void setUp() {
        customFileReader = new CustomFileReader();
    }

    @AfterClass
    public void tearDown() {
        customFileReader = null;
    }

    @DataProvider(name = "readArrayPositiveData")
    public Object[][] createReadArrayPositiveData() {
        return new Object[][]{
                {"input/validData.txt", "1 2 3 10 123 45"},
                {null, "3 2 1 5 4"},
                {"input/qwerty.txt", "3 2 1 5 4"},
        };
    }

    @Test(dataProvider = "readArrayPositiveData")
    public void readArrayPositiveTest(String file, String expected) {
        try {
            String actual = customFileReader.readArray(file);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "readArrayNegativeData")
    public Object[][] createReadArrayNegativeData() {
        return new Object[][]{
                {"input/validData.txt", "1 2 "},
                {null, "3 2 1 4"},
                {"input/qwerty.txt", "3 1 5 4"},
        };
    }

    @Test(dataProvider = "readArrayNegativeData")
    public void readArrayNegativeTest(String file, String expected) {
        try {
            String actual = customFileReader.readArray(file);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "readArrayExceptionData")
    public Object[][] createReadArrayExceptionData() {
        return new Object[][]{
                {"input/invalidData.txt"}
        };
    }

    @Test(dataProvider = "readArrayExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void readArrayExceptionTest(String file) throws IncorrectDataException {
        customFileReader.readArray(file);
    }
}
