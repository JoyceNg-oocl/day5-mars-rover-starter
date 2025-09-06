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

    @Test
    void should_return_x_minus_when_M_given_S() {
        MarsRover marsRover = new MarsRover(0, 0, "S");

        marsRover.executeCommand("M");

        String expectedResult = "(" + 0 + "," + -1 + "," + "S" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }

    @Test
    void should_return_x_plus_when_M_given_W() {
        MarsRover marsRover = new MarsRover(0, 0, "W");

        marsRover.executeCommand("M");

        String expectedResult = "(" + -1 + "," + 0 + "," + "W" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }

    @Test
    void should_return_direction_W_when_L_given_N() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommand("L");

        String expectedResult = "(" + 0 + "," + 0 + "," + "W" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }

    @Test
    void should_return_direction_S_when_L_given_W() {
        MarsRover marsRover = new MarsRover(0, 0, "W");

        marsRover.executeCommand("L");

        String expectedResult = "(" + 0 + "," + 0 + "," + "S" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }

    @Test
    void should_return_direction_E_when_L_given_S() {
        MarsRover marsRover = new MarsRover(0, 0, "S");

        marsRover.executeCommand("L");

        String expectedResult = "(" + 0 + "," + 0 + "," + "E" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }

    @Test
    void should_return_direction_N_when_L_given_E() {
        MarsRover marsRover = new MarsRover(0, 0, "E");

        marsRover.executeCommand("L");

        String expectedResult = "(" + 0 + "," + 0 + "," + "N" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }

    @Test
    void should_return_direction_E_when_R_given_N() {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.executeCommand("R");

        String expectedResult = "(" + 0 + "," + 0 + "," + "E" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }

    @Test
    void should_return_direction_S_when_R_given_E() {
        MarsRover marsRover = new MarsRover(0, 0, "E");

        marsRover.executeCommand("R");

        String expectedResult = "(" + 0 + "," + 0 + "," + "S" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }

    @Test
    void should_return_direction_W_when_R_given_S() {
        MarsRover marsRover = new MarsRover(0, 0, "S");

        marsRover.executeCommand("R");

        String expectedResult = "(" + 0 + "," + 0 + "," + "W" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }

    @Test
    void should_return_direction_N_when_R_given_W() {
        MarsRover marsRover = new MarsRover(0, 0, "W");

        marsRover.executeCommand("R");

        String expectedResult = "(" + 0 + "," + 0 + "," + "N" + ")";
        assertEquals(expectedResult, marsRover.getLocation());
    }
}
