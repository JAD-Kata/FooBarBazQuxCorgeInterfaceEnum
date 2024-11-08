package com.jad;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {
    static final IBar FAKE_BAR = new IBar() {
        @Override
        public String getName() {
            return "FAKE";
        }
    };

    @Test
    void interfaceTest() {
        Foo foo = new Foo(FooTest.FAKE_BAR);
        assertDoesNotThrow(() -> {
            IFoo iFoo = (IFoo) foo;
        }, "Foo should implement IFoo");
    }

    @Test
    void barTest() {
        Foo foo = new Foo(FooTest.FAKE_BAR);
        assertEquals(FooTest.FAKE_BAR, foo.getBar(), "Bar should be the same as the one passed to the constructor");
    }

    @Test
    void bazTest() {
        final int bazCount = 10;
        ArrayList<IBaz> bazs = new ArrayList<>();
        for (int i = 0; i < bazCount; i++) {
            bazs.add(new IBaz() {
            });
        }
        Foo foo = new Foo(FooTest.FAKE_BAR);
        assertEquals(0, foo.getBazs().size(), "Bazs should be empty by default");
        for (IBaz baz : bazs) {
            foo.addBaz(baz);
        }
        assertEquals(bazCount, foo.getBazs().size(), "Bazs should have " + bazCount + " elements");
        assertTrue(foo.getBazs().containsAll(bazs), "Bazs should contain all the Bazs that were added");
    }

    @Test
    void quxTest() {
        Foo foo = new Foo(FooTest.FAKE_BAR);
        assertNotNull(foo.getQux(), "Qux should not be null");
    }

    @Test
    void corgeTest() {
        Foo foo = new Foo(FooTest.FAKE_BAR);
        assertDoesNotThrow(() -> {
            IFoo iFoo = (IFoo) foo;
        }, "Foo should implement IFoo");
        ICorge firstCorge = new ICorge() {
            private IFoo foo = null;

            @Override
            public IFoo getFoo() {
                return this.foo;
            }

            @Override
            public void setFoo(final IFoo foo) {
                this.foo = foo;
            }
        };
        IFoo iFoo = (IFoo) foo;
        foo.setCorge(firstCorge);
        assertEquals(firstCorge, foo.getCorge(), "Corge should be the same as the one passed to the setter");
        assertEquals(iFoo, firstCorge.getFoo(), "Foo should be the same as the one passed to the setter");
        ICorge secondCorge = new ICorge() {
            private IFoo foo = null;

            @Override
            public IFoo getFoo() {
                return this.foo;
            }

            @Override
            public void setFoo(final IFoo foo) {
                this.foo = foo;
            }
        };
        foo.setCorge(secondCorge);
        assertEquals(iFoo, secondCorge.getFoo(), "Foo should be the same as the one passed to the setter");
        assertEquals(secondCorge, foo.getCorge(), "Corge should be the same as the one passed to the setter");
        assertNull(firstCorge.getFoo(), "Foo should be null after the second Corge is created");
    }
}
