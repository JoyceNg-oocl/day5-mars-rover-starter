package com.afs.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {
    @Test
    void should_return_y_plus_when_M_given_N() {

        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommand("M");

        String expectedResult = "(" + 0 + "," + 1 + "," + "N" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }

    @Test
    void should_return_y_minus_when_M_given_E() {

        MarsRover marsRover = new MarsRover(0, 0, "E");

        marsRover.executeCommand("M");

        String expectedResult = "(" + 1 + "," + 0 + "," + "E" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }
}
