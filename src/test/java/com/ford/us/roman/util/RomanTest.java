package com.ford.us.roman.util;

import com.ford.us.roman.exception.InvalidInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

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



    @ParameterizedTest()
    @ValueSource(strings = { ""})
    @NullSource
    void convertRomanToInteger_failure(String paramInput)
    {

        InvalidInputException invalidInputException = assertThrowsExactly(InvalidInputException.class, () -> Roman.toInteger(paramInput));

        String message = invalidInputException.getMessage();

        assertEquals("{} Invalid Input ".formatted(paramInput),message);
    }
}