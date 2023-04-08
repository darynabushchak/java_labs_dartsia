package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DentalChairTest {
    DentalChair dentalChair;
    @BeforeEach
    public void setUp() {
        dentalChair = new DentalChair(17, "wood", 167, "Sasha", 120, 80, 100);
    }
    @Test
    void testAdjustPosition() {
        int expectedHeight = dentalChair.getCurrentHeight() + 15;
        dentalChair.adjustPosition(15);
        assertEquals(expectedHeight, dentalChair.getCurrentHeight());
    }
    @Test
    void testMaxAllowedValues() {
        dentalChair.adjustPosition(130);
        assertEquals(dentalChair.getCurrentHeight(), dentalChair.getMaxHeight());
    }

    @Test
    void testRelease() {
        dentalChair.occupy("Daryna");
        assertEquals("Daryna", dentalChair.getOwner());
        dentalChair.release();
        assertNull(dentalChair.getOwner());
    }
}