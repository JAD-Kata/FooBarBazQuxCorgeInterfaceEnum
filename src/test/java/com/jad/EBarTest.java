package com.jad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EBarTest {

    static final int EBAR_COUNT = 3;

    @Test
    void interfaceTest() {
        assertDoesNotThrow(() -> {
            IBar eBar = EBar.valueOf("BAR1");
        }, "EBar should implement IBar");
    }

    @Test
    void valuesTest() {
        assertEquals(EBarTest.EBAR_COUNT, EBar.values().length, "EBar should have " + EBarTest.EBAR_COUNT + " values");
    }

    @Test
    void valueOfTest() {
        assertDoesNotThrow(() -> EBar.valueOf("BAR1"), "EBar should have a value named BAR1");
        assertDoesNotThrow(() -> EBar.valueOf("BAR2"), "EBar should have a value named BAR2");
        assertDoesNotThrow(() -> EBar.valueOf("BAR3"), "EBar should have a value named BAR3");
        assertEquals("BAR1", EBar.valueOf("BAR1").name(), "BAR1 should have the name BAR1");
        assertEquals("BAR2", EBar.valueOf("BAR2").name(), "BAR2 should have the name BAR2");
        assertEquals("BAR3", EBar.valueOf("BAR3").name(), "BAR3 should have the name BAR3");
    }
}