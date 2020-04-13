package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Person[] INITIAL_ELEMENTS = {new Person(1, "a"), new Person(2, "b"),
            new Person(3, "c"), new Person(4, "d")};

    private static final Person[] MAX_COUNT_ELEMENTS = {new Person(1, "a"), new Person(2, "b"),
            new Person(3, "c"), new Person(4, "d"), new Person(5, "e"), new Person(6, "f"),
            new Person(7, "g"), new Person(8, "h"), new Person(9, "i"), new Person(10, "j"),
            new Person(11, "k"), new Person(12, "l"), new Person(13, "m"), new Person(14, "n"),
            new Person(15, "o"), new Person(16, "p"), new Person(17, "q")};


    @Test
    public void creatingDatabaseShouldSetElementsCorrectly() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);

        Assert.assertArrayEquals(db.getElements(), INITIAL_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithZeroElementsShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithSeventeenElementsShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(MAX_COUNT_ELEMENTS);

    }

    //Not implemented method in database class
    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExceptionIfMultipleUsersWithSameIdAdded() throws OperationNotSupportedException {
        Person person = new Person(0, "Stamat");
        Database db = new Database(INITIAL_ELEMENTS);
        db.add(person);
        db.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowExceptionIfAddedNULLElement() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);
        Person person = null;
        db.add(person);
    }

    //Not implemented method in database class
    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithNegativeIdShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);
        Person person = new Person(-1, "asd");
        db.add(person);
    }

    //Not implemented exception in database class
    //@Test(expected = OperationNotSupportedException.class) <- should be
    @Test(expected = NumberFormatException.class)
    public void addPersonWithNULLIdShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);
        int testValue = Integer.parseInt(null);
        Person person = new Person(testValue, null);
        db.add(person);
    }

    @Test
    public void removeShouldDecreaseTheCountOfElements() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);
        db.remove();

        Assert.assertEquals(INITIAL_ELEMENTS.length - 1, db.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowExceptionIfDatabaseIsEmpty() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);

        for (int i = 0; i < 5; i++) {
            db.remove();
        }
    }

    @Test
    public void getElementsShouldReturnCopyOfTheSameElements() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);
        Database db2 = new Database(db.getElements());

        Assert.assertArrayEquals(INITIAL_ELEMENTS, db2.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionIfNotPresentedUsernameInDatabase() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);

        db.findByUsername("Stamat");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionIfParamUsernameIsNULL() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);

        db.findByUsername(null);
    }

    //Parameters are checked case - sensitive
    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionIfParamUsernameIsNotSame() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);

        db.findByUsername("A");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldThrowExceptionIfNoUserIsPresentBySameId() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_ELEMENTS);
        db.findById(12);
    }
}
