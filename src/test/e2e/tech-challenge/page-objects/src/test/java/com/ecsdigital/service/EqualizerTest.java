package com.ecsdigital.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualizerTest {

    private final static String ERROR_MSG = "Incorrect index returned or null";

    private Equalizable equalizable;

    @BeforeEach
    public void init() {
        equalizable = new Equalizer();
    }


    @Nested
    @DisplayName("Suite of cases for when an index is found")
    class IndexFound {
        @Test
        @DisplayName("Verify that a middle index is returned")
        public void indexFoundTest() {
            String[] numbers = {"10", "15", "5", "7", "1", "24", "36", "2"};
            assertEquals(5, equalizable.checkLeftAndRightEquality(numbers), ERROR_MSG);
        }

        @Test
        @DisplayName("Verify that a middle index is returned")
        public void indexFoundTestVariance() {
            String[] numbers = {"23", "50", "63", "90", "10", "30", "155", "23", "18"};
            assertEquals(4, equalizable.checkLeftAndRightEquality(numbers), ERROR_MSG);
        }

        @Test
        @DisplayName("Verify that a middle index is returned")
        public void indexFoundTestVariance2() {
            String[] numbers = {"133", "60", "23", "92", "6", "7", "168", "16", "19"};
            assertEquals(3, equalizable.checkLeftAndRightEquality(numbers), ERROR_MSG);
        }

        @Test
        @DisplayName("Verify that a middle index is returned")
        public void indexFoundTestVariance3() {
            String[] numbers = {"30", "43", "29", "10", "50", "40", "99", "51", "12"};
            assertEquals(5, equalizable.checkLeftAndRightEquality(numbers), ERROR_MSG);
        }
    }


    @Test
    @DisplayName("Verify that null is returned, no index is returned")
    public void indexNotFoundTest() {
        String[]  numbers = {"10","15","5","7","1","24","100","2"};
        assertNull(equalizable.checkLeftAndRightEquality(numbers));
    }



}