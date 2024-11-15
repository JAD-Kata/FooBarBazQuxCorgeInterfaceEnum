package com.jad;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;


class EBazTest {
    private static final int NB_OF_FIELDS = 1;
    private static final int NB_OF_NON_CONSTRUCTOR_METHOD = 1;
    private static Class<?> eBazClass;

    @BeforeAll
    static void beforeAll() {
        EBazTest.eBazClass = Utils.testIfClassExists("com.jad.EBaz");
    }

    @Test
    void enumTest() {
        Utils.testIfIsAnEnumClass(EBazTest.eBazClass);
    }

    @Test
    void countAttributesTest() {
        Utils.testCountAttributes(EBazTest.eBazClass, EBazTest.NB_OF_FIELDS);
    }

    @Test
    void countMethodsTest() {
        Utils.testCountNonConstructorMethods(EBazTest.eBazClass, EBazTest.NB_OF_NON_CONSTRUCTOR_METHOD);
    }

    @Test
    void implementsTest() {
        Utils.testImplementsInterface(EBazTest.eBazClass, "com.jad.IBaz");
    }

    @Test
    void hasDoSomethingLikeABazMethodTest() {
        Utils.testIfMethodExists(EBazTest.eBazClass, "doSomethingLikeABaz");
    }

    @Test
    void hasGetNameMethodTest() {
        Utils.testIfMethodExists(EBazTest.eBazClass, "getName");
    }

    @Test
    void getNameReturnsNameAttributeTest() {
        Constructor<?> constructor = assertDoesNotThrow(() -> EBazTest.eBazClass.getDeclaredConstructor(String.class));
        constructor.setAccessible(true);
        Object eBazInstance = assertDoesNotThrow(() -> constructor.newInstance("testName"));

        java.lang.reflect.Method getNameMethod = assertDoesNotThrow(
                () -> EBazTest.eBazClass.getDeclaredMethod("getName"));
        getNameMethod.setAccessible(true);
        String nameValue = assertDoesNotThrow(() -> (String) getNameMethod.invoke(eBazInstance));

        assertEquals("testName", nameValue, "The getName method should return the value of the name attribute.");
    }

    @Test
    void hasSingleStringConstructorTest() {
        Constructor<?>[] constructors = EBazTest.eBazClass.getDeclaredConstructors();
        assertEquals(1, constructors.length, "EBaz should have only one constructor.");
        Constructor<?> constructor = constructors[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        assertEquals(1, parameterTypes.length, "EBaz constructor should have one parameter.");
        assertEquals(String.class, parameterTypes[0], "EBaz constructor parameter should be of type String.");
    }

    @Test
    void enumValuesTest() {
        Object[] enumConstants = assertDoesNotThrow(() -> EBazTest.eBazClass.getEnumConstants());
        assertEquals(3, enumConstants.length, "EBaz should have three enum values.");

        java.lang.reflect.Method getNameMethod = assertDoesNotThrow(
                () -> EBazTest.eBazClass.getDeclaredMethod("getName"));
        getNameMethod.setAccessible(true);

        String[] expectedNames = {"EBaz1", "EBaz2", "EBaz3"};
        String[] expectedValues = {"Baz1", "Baz2", "Baz3"};

        for (int i = 0; i < enumConstants.length; i++) {
            assertEquals(expectedNames[i], enumConstants[i].toString(),
                         "Enum name should be " + expectedNames[i] + ".");
            final int finalI = i;
            assertEquals(expectedValues[i],
                         assertDoesNotThrow(() -> (String) getNameMethod.invoke(enumConstants[finalI])),
                         expectedNames[i] + " name should be " + expectedValues[i] + ".");
        }
    }
}