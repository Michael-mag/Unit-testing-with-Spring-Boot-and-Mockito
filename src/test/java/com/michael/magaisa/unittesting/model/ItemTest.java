package com.michael.magaisa.unittesting.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ItemTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Item#Item(int, String, int, int)}
     *   <li>{@link Item#setId(int)}
     *   <li>{@link Item#setName(String)}
     *   <li>{@link Item#setPrice(int)}
     *   <li>{@link Item#setQuantity(int)}
     *   <li>{@link Item#setValue(int)}
     *   <li>{@link Item#toString()}
     *   <li>{@link Item#getId()}
     *   <li>{@link Item#getName()}
     *   <li>{@link Item#getPrice()}
     *   <li>{@link Item#getQuantity()}
     *   <li>{@link Item#getValue()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Item actualItem = new Item(1, "Name", 1, 1);
        actualItem.setId(1);
        actualItem.setName("Name");
        actualItem.setPrice(1);
        actualItem.setQuantity(1);
        actualItem.setValue(42);
        String actualToStringResult = actualItem.toString();
        assertEquals(1, actualItem.getId());
        assertEquals("Name", actualItem.getName());
        assertEquals(1, actualItem.getPrice());
        assertEquals(1, actualItem.getQuantity());
        assertEquals(42, actualItem.getValue());
        assertEquals("Item[1 , Name, 1, 1]", actualToStringResult);
    }
}

