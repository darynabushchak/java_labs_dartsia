package ua.lviv.iot.algo.part1.lab3.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab3.models.FeedingTable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FeedingTableTest {
    FeedingTable feedingTable;
    FeedingTable empty = new FeedingTable();

    @BeforeEach
    public void setUp() {
        feedingTable = new FeedingTable(20, "wood",
                150, "Andriy", 150,
                80, 105, 4);
    }

    @Test
    public void testAdjustPosition() {
        int finalTiltAngle = feedingTable.getCurrentHeight() + 20;
        feedingTable.adjustPosition(20);
        assertEquals(finalTiltAngle, feedingTable.getCurrentHeight());
    }

    @Test
    public void testMaxAllowedValues() {
        feedingTable.adjustPosition(245);
        assertEquals(feedingTable.getCurrentHeight(), feedingTable.getMaxHeight());
    }

    @Test
    public void testRelease() {
        feedingTable.occupy("Daryna");
        assertEquals("Daryna", feedingTable.getOwner());
        feedingTable.release();
        assertNull(feedingTable.getOwner());
    }
}