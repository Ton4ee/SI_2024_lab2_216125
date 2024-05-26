package com.example.myapp;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testCheckCart() {
        List<Item> items = new ArrayList<>();

        // Test  1
        RuntimeException ex1;
        ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));

        // Test  2
        items.add(new Item("item1", "012345", 350, 0.1f));
        assertTrue(SILab2.checkCart(items, 320));

        // Test  3
        items.clear();
        items.add(new Item("item1", "112345", 350, 0.1f));
        assertTrue(SILab2.checkCart(items, 35));

        // Test  4
        items.clear();
        items.add(new Item("item1", "012345", 350, 0.0f));
        assertFalse(SILab2.checkCart(items, 320));

        // Test  5
        items.clear();
        items.add(new Item("item1", "112345", 350, 0.0f));
        assertTrue(SILab2.checkCart(items, 350));

        // Test  6
        items.clear();
        items.add(new Item("item1", "012345", 250, 0.1f));
        assertTrue(SILab2.checkCart(items, 25));

        // Test  7
        items.clear();
        items.add(new Item("item1", "112345", 250, 0.1f));
        assertTrue(SILab2.checkCart(items, 25));

        // Test  8
        items.clear();
        items.add(new Item("item1", "012345", 250, 0.0f));
        assertTrue(SILab2.checkCart(items, 250));

        // Test  9
        items.clear();
        items.add(new Item("item1", "112345", 250, 0.0f));
        assertTrue(SILab2.checkCart(items, 250));

        // Test  10
        items.clear();
        items.add(new Item("item1", "01a345", 250, 0.0f));
        RuntimeException ex2;
        ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 250));
        assertTrue(ex2.getMessage().contains("Invalid character in item barcode!"));

        // Test  11
        items.clear();
        items.add(new Item("item1", null, 250, 0.0f));
        RuntimeException ex3;
        ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 250));
        assertTrue(ex3.getMessage().contains("No barcode!"));

        // Test  12
        items.clear();
        items.add(new Item(null, "012345", 250, 0.0f));
        SILab2.checkCart(items, 250);
        assertEquals("unknown", items.get(0).getName());

        // Test  13
        items.clear();
        items.add(new Item("", "012345", 250, 0.0f));
        SILab2.checkCart(items, 250);
        assertEquals("unknown", items.get(0).getName());
    }
}
