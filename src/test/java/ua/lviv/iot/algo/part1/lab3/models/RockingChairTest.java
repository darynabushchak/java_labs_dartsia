package ua.lviv.iot.algo.part1.lab3.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class RockingChairTest {
    RockingChair rockingChair;
    RockingChair empty = new RockingChair();

    @BeforeEach
    public void setup() {
        rockingChair = new RockingChair(17, "wood",
                100, "Sashko", 89);
    }

    @Test
    public void testAdjustPosition() {
        int finalTiltAngle = rockingChair.getCurrentSlopeInDegrees() + 30;
        rockingChair.adjustPosition(30);
        assertEquals(finalTiltAngle, rockingChair.getCurrentSlopeInDegrees());
    }

    @Test
    public void testRelease() {
        rockingChair.occupy("Daryna");
        assertEquals("Daryna", rockingChair.getOwner());
        rockingChair.release();
        assertNull(rockingChair.getOwner());
    }
}