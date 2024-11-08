package com.jad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class QuxTest {
    @Test
    void interfaceTest() {
        assertDoesNotThrow(() -> (IQux) new Qux(), "Qux should implement IBaz");
    }

}