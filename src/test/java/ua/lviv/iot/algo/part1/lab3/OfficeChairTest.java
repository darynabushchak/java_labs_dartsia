package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficeChairTest {
    OfficeChair officeChair;
    @BeforeEach
    public void setUp() {
        officeChair = new OfficeChair(19, "plastic",
                250, "Daryna", "bavovna", 80);
    }

    @Test
    void testAdjustPosition() {
        int finalTiltAngle = officeChair.getCurrentSlopeInDegrees() + 20;
        officeChair.adjustPosition(20);
        assertEquals(finalTiltAngle, officeChair.getCurrentSlopeInDegrees());
    }
    @Test
    void testChairUpholstery(){
        assertEquals("bavovna", officeChair.getChairUpholstery());
    }
    @Test
    void testRelease() {
        officeChair.occupy("Daryna");
        assertEquals("Daryna", officeChair.getOwner());
        officeChair.release();
        assertNull(officeChair.getOwner());
    }
}