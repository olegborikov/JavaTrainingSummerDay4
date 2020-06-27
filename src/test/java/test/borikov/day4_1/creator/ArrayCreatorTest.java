package test.borikov.day4_1.creator;

import com.borikov.day4_1.creator.ArrayCreator;
import com.borikov.day4_1.entity.IntegerArray;
import com.borikov.day4_1.exception.IncorrectDataException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorTest {
    ArrayCreator arrayCreator;

    @BeforeClass
    public void setUp() {
        arrayCreator = new ArrayCreator();
    }

    @AfterClass
    public void tearDown() {
        arrayCreator = null;
    }

    @DataProvider(name = "createAndFillArrayRandomPositiveData")
    public Object[][] createCreateAndFillArrayRandomPositiveData() throws IncorrectDataException {
        return new Object[][]{
                {10},
                {5},
                {3},
        };
    }

    @Test(dataProvider = "createAndFillArrayRandomPositiveData")
    public void createAndFillArrayRandomPositiveTest(int size) {
        try {
            IntegerArray integerArray = arrayCreator.createAndFillArrayRandom(size);
            assertEquals(size, integerArray.size());
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "createAndFillArrayRandomExceptionData")
    public Object[][] createCreateAndFillArrayRandomNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {0},
                {-1},
                {-10},
        };
    }

    @Test(dataProvider = "createAndFillArrayRandomExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void createAndFillArrayRandomExceptionTest(int size) throws IncorrectDataException {
        IntegerArray integerArray = arrayCreator.createAndFillArrayRandom(size);
    }

    @Test
    public void createAndFillArrayConsolePositiveTest() {
        try {
            IntegerArray expected = new IntegerArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
            IntegerArray actual = arrayCreator.createAndFillArrayConsole();
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "createAndFillArrayFilePositiveData")
    public Object[][] createCreateAndFillArrayFilePositiveData() throws IncorrectDataException {
        return new Object[][]{
                {"input/validData.txt", new IntegerArray(new int[]{1, 2, 3, 10, 123, 45})},
                {null, new IntegerArray(new int[]{3, 2, 1, 5, 4})},
                {"input/qwerty.txt", new IntegerArray(new int[]{3, 2, 1, 5, 4})},
        };
    }

    @Test(dataProvider = "createAndFillArrayFilePositiveData")
    public void createAndFillArrayFilePositiveTest(String file, IntegerArray expected) {
        try {
            IntegerArray actual = arrayCreator.createAndFillArrayFile(file);
            assertEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "createAndFillArrayFileNegativeData")
    public Object[][] createCreateAndFillArrayFileNegativeData() throws IncorrectDataException {
        return new Object[][]{
                {"input/validData.txt", new IntegerArray(new int[]{1, 2})},
                {null, new IntegerArray(new int[]{3, 2, 1, 4})},
                {"input/qwerty.txt", new IntegerArray(new int[]{3, 1, 5, 4})},
        };
    }

    @Test(dataProvider = "createAndFillArrayFileNegativeData")
    public void createAndFillArrayFileNegativeTest(String file, IntegerArray expected) {
        try {
            IntegerArray actual = arrayCreator.createAndFillArrayFile(file);
            assertNotEquals(actual, expected);
        } catch (IncorrectDataException e) {
            fail("input exception");
        }
    }

    @DataProvider(name = "createAndFillArrayFileExceptionData")
    public Object[][] createCreateAndFillArrayFileExceptionData() {
        return new Object[][]{
                {"input/invalidData.txt"}
        };
    }

    @Test(dataProvider = "createAndFillArrayFileExceptionData",
            expectedExceptions = IncorrectDataException.class)
    public void createAndFillArrayFileExceptionTest(String file) throws IncorrectDataException {
        arrayCreator.createAndFillArrayFile(file);
    }
}
