package p01_DatabaseTests;

import org.junit.Assert;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private static final Integer[] INITIAL_ELEMENTS = {1, 2, 3, 4};
    private static final int INVALID_ELEMENTS_MAX_COUNT = 17;

    @Test
    public void creatingDatabaseShouldSetElementsCorrectly() throws OperationNotSupportedException {
        Database database = new Database(INITIAL_ELEMENTS);

        Assert.assertArrayEquals(database.getElements(), INITIAL_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createDatabaseWithZeroElementsShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createDatabaseWithSeventeenElementsShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database(new Integer[INVALID_ELEMENTS_MAX_COUNT]);
    }

    @Test
    public void addShouldAddAnElementAtTheNextCell() throws OperationNotSupportedException {
        Database database = new Database(INITIAL_ELEMENTS);
        int initCapacity = database.getElements().length;
        database.add(22);

        Assert.assertEquals(database.getElements().length, initCapacity + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExceptionIfPassedElementIsNULL() throws OperationNotSupportedException {
        Database database = new Database(INITIAL_ELEMENTS);

        database.add(null);
    }

    @Test
    public void removeShouldRemoveAnElement() throws OperationNotSupportedException {
        Database database = new Database(INITIAL_ELEMENTS);
        int initCapacity = database.getElements().length;
        database.remove();

        Assert.assertEquals(database.getElements().length, initCapacity - 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowExceptionIfDatabaseIsEmpty() throws OperationNotSupportedException {
        Database database = new Database(INITIAL_ELEMENTS);
        for (int i = 0; i < 5; i++) {
            database.remove();
        }
    }

}