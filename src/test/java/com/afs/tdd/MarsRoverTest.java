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
}
