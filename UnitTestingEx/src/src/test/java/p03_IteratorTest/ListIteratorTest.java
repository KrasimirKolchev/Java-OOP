package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private static final String[] INITIAL_ELEMENTS = {"qwe", "rty", "asd", "zxc"};
    private static final String TEST_VALUE = "rty";


    @Test(expected = OperationNotSupportedException.class)
    public void ifListiteratorIsCreatedWithNULLShouldThrowException() throws OperationNotSupportedException {
        ListIterator list = new ListIterator(null);

    }

    @Test
    public void moveShouldReturnTrueIfOperationIsSuccessful() throws OperationNotSupportedException {
        ListIterator list = new ListIterator(INITIAL_ELEMENTS);

        Assert.assertTrue(list.move());
    }

    @Test
    public void moveShouldReturnFalseIfOperationIsNotSuccessful() throws OperationNotSupportedException {
        ListIterator list = new ListIterator(INITIAL_ELEMENTS);
        list.move();
        list.move();
        list.move();

        Assert.assertFalse(list.move());
    }

    @Test
    public void hasNextShouldReturnTrueIfThereIsNextElement() throws OperationNotSupportedException {
        ListIterator list = new ListIterator(INITIAL_ELEMENTS);

        Assert.assertTrue(list.hasNext());
    }

    @Test
    public void hasNextShouldReturnFalseIfThereIsNotNextElements() throws OperationNotSupportedException {
        ListIterator list = new ListIterator(INITIAL_ELEMENTS);
        list.move();
        list.move();
        list.move();

        Assert.assertFalse(list.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void printShouldReturnExceptionIfListiteratorIsEmpty() throws OperationNotSupportedException {
        ListIterator list = new ListIterator();
        list.print();
    }

    @Test
    public void printShouldReturnTheValueFromTheCollection() throws OperationNotSupportedException {
        ListIterator list = new ListIterator(INITIAL_ELEMENTS);
        list.move();

        Assert.assertEquals(TEST_VALUE, list.print());
    }

}