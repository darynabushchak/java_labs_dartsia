package src.test.java.ua.lviv.iot.algo.part1.lab3;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ChairManagerTest {
    ChairManager chairManager = new ChairManager();

    @BeforeEach
    public void setUp() {
        chairManager.addChair(new OfficeChair(3, "plastic", 200, "Sashko", "cotton", 78));
        chairManager.addChair(new FeedingTable(7, "plastic", 150, "Lesyk", 100, 50, 78, 2));
        chairManager.addChair(new RockingChair(2, "wood", 183, "Darynka", 84));
        chairManager.addChair(new DentalChair(12, "vinyl upholstery", 160, "Andriy", 120, 70, 71));
    }

    @Test
    public void testAddChair() {
        assertEquals(4, chairManager.getChairs().size());
    }

    @Test
    public void testFindAllByMaterial() {
        List<Chair> plasticChairsFromManager = chairManager.findAllByMaterial("plastic");
        List<Chair> expected = new LinkedList<>();
        expected.add(new OfficeChair(3, "plastic", 200, "Sashko", "cotton", 78));
        expected.add(new FeedingTable(7, "plastic", 150, "Lesyk", 100, 50, 78, 2));
        assertFalse(plasticChairsFromManager.isEmpty());
        assertEquals(expected.toString(), plasticChairsFromManager.toString());

    }

    @Test
    public void testFindAllWithMaxWeightHeavierThan() {
        List<Chair> maxWeightChairsFromManager = chairManager.findAllWithMaxWeightHeavierThan(170);
        List<Chair> expected = new LinkedList<>();
        expected.add(new OfficeChair(3, "plastic", 200, "Sashko", "cotton", 78));
        expected.add(new RockingChair(2, "wood", 183, "Darynka", 84));
        assertFalse(maxWeightChairsFromManager.isEmpty());
        assertEquals(expected.toString(), maxWeightChairsFromManager.toString());
    }

}