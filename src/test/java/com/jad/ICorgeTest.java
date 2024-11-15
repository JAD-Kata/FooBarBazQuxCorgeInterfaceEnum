package com.jad;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ICorgeTest {
    private static final int NB_OF_FIELDS = 0;
    private static final int NB_OF_NON_CONSTRUCTOR_METHOD = 3;
    private static Class<?> iCorgeClass;

    @BeforeAll
    static void beforeAll() {
        ICorgeTest.iCorgeClass = Utils.testIfClassExists("com.jad.ICorge");
    }

    @Test
    void topLevelClassTest() {
        Utils.testIfIsATopLevelClass(ICorgeTest.iCorgeClass);
    }

    @Test
    void interfaceTest() {
        Utils.testIfIsAnInterface(ICorgeTest.iCorgeClass);
    }

    @Test
    void countMethodsTest() {
        Utils.testCountNonConstructorMethods(ICorgeTest.iCorgeClass, ICorgeTest.NB_OF_NON_CONSTRUCTOR_METHOD);
    }

    @Test
    void hasDoSomethingLikeACorgeMethodTest() {
        Utils.testIfMethodExists(ICorgeTest.iCorgeClass, "doSomethingLikeACorge");
    }

    @Test
    void hasGetFooMethodTest() {
        Utils.testIfMethodExists(ICorgeTest.iCorgeClass, "getFoo");
    }

    @Test
    void hasSetFooMethodTest() {
        Utils.testIfMethodExists(ICorgeTest.iCorgeClass, "setFoo");
    }
}