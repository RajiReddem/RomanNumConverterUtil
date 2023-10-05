package com.ford.us.roman.util;

import com.ford.us.roman.exception.InvalidInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void convertRomanToInteger_Success()
    {
        String input="XI";
        assertEquals(Roman.toInteger(input),11);
    }


    @Test
    void convertRomanToInteger_failure()
    {
        String input="MMMM";
        InvalidInputException invalidInputException = assertThrowsExactly(InvalidInputException.class, () -> Roman.toInteger(input));

        String message = invalidInputException.getMessage();

        assertEquals("{} Invalid Input ".formatted(input),message);
    }
}