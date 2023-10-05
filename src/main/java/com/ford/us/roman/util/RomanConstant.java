package com.ford.us.roman.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class RomanConstant {

    private RomanConstant()
    {

    }

    public static final String INVALID_INPUT="{} Invalid Input ";


    public static final Map<Integer, String> ROMAN_INT_VALUES = getRomanMap();
    public static Map<Integer, String> getRomanMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        return map;
    }

    public static final Map<Character, Integer>
            ROMAN_LETTER_MAP = Map.of(
            'I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500,
            'M', 1000);

    public static final Set<Character> ALLOWED_ROMAN_CHARS = ROMAN_LETTER_MAP.keySet();
}
