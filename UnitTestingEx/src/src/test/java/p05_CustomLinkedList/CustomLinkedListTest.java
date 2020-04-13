package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Test;

public class CustomLinkedListTest {
    private String TEST_VALUE = "Gosho";

    @Test(expected = IllegalArgumentException.class)
    public void gettingElementByIndexFromEmptyListShouldThrowException() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.get(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void gettingElementByInvalidIndexFromListShouldThrowException() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.get(2);
    }

    @Test
    public void gettingElementByIndexShouldReturnTheElement() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add(TEST_VALUE);
        list.add("Stamat");
        String value = list.get(1);
        Assert.assertEquals(TEST_VALUE, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setElementByIndexLessThanZeroShouldThrowException() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Ivan");
        list.add("Stamat");
        list.set(-1, TEST_VALUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setElementByIndexOutOfRangeShouldThrowException() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Ivan");
        list.add("Stamat");
        list.set(4, TEST_VALUE);
    }

    @Test
    public void checkIfSetElementByIndexSetsTheElement() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Ivan");
        list.add("Stamat");
        list.set(1, TEST_VALUE);
        String value = list.get(1);
        Assert.assertEquals(TEST_VALUE, value);
    }

    @Test
    public void addShouldAddElementToTheLastIndex() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Ivan");
        list.add(TEST_VALUE);
        String value = list.get(2);
        Assert.assertEquals(TEST_VALUE, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtElementByIndexLessThanZeroShouldThrowException() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Ivan");
        list.add("Stamat");
        list.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtElementByIndexOutOfRangeShouldThrowException() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Ivan");
        list.add("Stamat");
        list.removeAt(4);
    }

    @Test
    public void checkIfRemoveAtElementByIndexRemovesTheElement() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add(TEST_VALUE);
        list.add("Stamat");
        String value = list.removeAt(1);
        Assert.assertEquals(TEST_VALUE, value);
    }

    @Test
    public void removeElementShouldReturnMinusOneIfElementIsNotFound() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Ivan");
        list.add("Stamat");
        int value = list.remove(TEST_VALUE);
        Assert.assertEquals(-1, value);
    }

    @Test
    public void removeElementShouldReturnOneIfElementIsNotFound() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add(TEST_VALUE);
        list.add("Stamat");
        int value = list.remove(TEST_VALUE);
        Assert.assertEquals(1, value);
    }

    @Test
    public void indexOfElementShouldReturnMinusOneIfNoSuchElementPresented() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Ivan");
        list.add("Stamat");
        int value = list.indexOf(TEST_VALUE);
        Assert.assertEquals(-1, value);
    }

    @Test
    public void indexOfElementShouldReturnTheIndexOfElementIfPresented() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add(TEST_VALUE);
        list.add("Stamat");
        int value = list.indexOf(TEST_VALUE);
        Assert.assertEquals(1, value);
    }

    @Test
    public void containsElementShouldReturnFalseIfNoSuchElementPresented() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Ivan");
        list.add("Stamat");
        Assert.assertFalse(list.contains(TEST_VALUE));
    }

    @Test
    public void containsElementShouldReturnTrueIfElementPresented() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add(TEST_VALUE);
        list.add("Stamat");
        Assert.assertTrue(list.contains(TEST_VALUE));
    }

}