package com.jad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CorgeTest {
    static final IFoo FAKE_FOO = new IFoo() {
        private ICorge corge;

        @Override
        public ICorge getCorge() {
            return this.corge;
        }

        @Override
        public void setCorge(final ICorge corge) {
            this.corge = corge;
        }
    };

    @Test
    void interfaceTest() {
        assertDoesNotThrow(() -> (ICorge) new Corge(CorgeTest.FAKE_FOO), "Corge should implement IBaz");
    }

    @Test
    void fooTest() {
        Corge corge = new Corge(CorgeTest.FAKE_FOO);
        assertDoesNotThrow(() -> (ICorge) new Corge(CorgeTest.FAKE_FOO), "Corge should implement IBaz");
        ICorge iCorge = (ICorge) corge;
        assertEquals(CorgeTest.FAKE_FOO, corge.getFoo(), "Foo should be the same as the one passed to the constructor");
        assertEquals(CorgeTest.FAKE_FOO.getCorge(), iCorge,
                     "Corge should be the same as the one set in the constructor");
    }
}