package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    private static final int INITIAL_ID_VALUE = 1;
    private static final String INITIAL_NAME_VALUE = "Gosho";

    @Test
    public void personGetIdShouldReturnId() {

        Person person = new Person(INITIAL_ID_VALUE, INITIAL_NAME_VALUE);

        Assert.assertEquals(INITIAL_ID_VALUE, person.getId());
    }

    @Test
    public void personGetUsernameShouldReturnUsername() {
        Person person = new Person(INITIAL_ID_VALUE, INITIAL_NAME_VALUE);

        Assert.assertEquals(INITIAL_NAME_VALUE, person.getUsername());
    }
}
