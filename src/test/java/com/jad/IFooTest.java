package com.jad;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IFooTest {
    private static final int NB_OF_FIELDS = 0;
    private static final int NB_OF_NON_CONSTRUCTOR_METHOD = 3;
    private static Class<?> iFooClass;

    @BeforeAll
    static void beforeAll() {
        IFooTest.iFooClass = Utils.testIfClassExists("com.jad.ICorge");
    }

    @Test
    void topLevelClassTest() {
        Utils.testIfIsATopLevelClass(IFooTest.iFooClass);
    }

    @Test
    void interfaceTest() {
        Utils.testIfIsAnInterface(IFooTest.iFooClass);
    }

    @Test
    void countMethodsTest() {
        Utils.testCountNonConstructorMethods(IFooTest.iFooClass, IFooTest.NB_OF_NON_CONSTRUCTOR_METHOD);
    }

    @Test
    void hasDoSomethingLikeAFooMethodTest() {
        Utils.testIfMethodExists(IFooTest.iFooClass, "doSomethingLikeAFoo");
    }

    @Test
    void hasGetCorgeMethodTest() {
        Utils.testIfMethodExists(IFooTest.iFooClass, "getCorge");
    }

    @Test
    void hasSetCorgeMethodTest() {
        Utils.testIfMethodExists(IFooTest.iFooClass, "setCorge");
    }
}