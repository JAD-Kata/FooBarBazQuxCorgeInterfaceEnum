package com.jad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BazTest {
    @Test
    void interfaceTest() {
        assertDoesNotThrow(() -> (IBaz) new Baz(), "Baz should implement IBar");
    }
}