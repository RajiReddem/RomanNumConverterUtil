package com.ford.us.roman.util;

import com.ford.us.roman.exception.InvalidInputException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RomanTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }




    @Test
    void convertIntegerToRoman_success()
    {
        Integer input=102;
        assertEquals("CII",Roman.toRoman(input));
    }
    @Test
    void convertRomanToInteger_success()
    {
        String input="XI";
        assertEquals(11,Roman.toInteger(input));
    }

    @ParameterizedTest
    @MethodSource("getRomanLetterAndValueMap")
    void convertRomanToInteger_success_map(Map<String,Integer> inputMap)
    {
        inputMap.forEach((k,v)-> assertEquals(Roman.toInteger(k),v));
    }



    @ParameterizedTest()
    @ValueSource(strings = { "","abc"})
    @NullSource
    void convertRomanToInteger_failure(String paramInput)
    {

        InvalidInputException invalidInputException = assertThrowsExactly(InvalidInputException.class, () -> Roman.toInteger(paramInput));

        String message = invalidInputException.getMessage();

        assertEquals("{} Invalid Input ".formatted(paramInput),message);
    }


    static Stream<Map<String, Integer>> getRomanLetterAndValueMap ()
    {
        return Stream.of(Map.of("X",10,
                "MMM",3000,
                "L", 50,
                "LI", 51,
                "IL", 49));
    }


}