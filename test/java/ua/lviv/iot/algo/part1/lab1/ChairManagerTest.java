package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChairManagerTest {
    ChairManager chairManager;
    @BeforeEach
    public void setUp() {
        chairManager = new ChairManager();
    }

    @Test
    void testChairManager() {
        ChairManager chairs = new ChairManager();

        chairs.addChair(new OfficeChair(3, "plastic", 200, "Sashko", "cotton", 78));
        chairs.addChair(new OfficeChair(5,"wood", 180,"Oskar", "batting", 74));
        chairs.addChair(new FeedingTable(7,"plastic", 150, "Lesyk", 100, 50, 78, 2));
        chairs.addChair(new FeedingTable(8, "cotton",154, "Victor", 110, 60, 109,1));
        chairs.addChair(new RockingChair(2, "wood", 183,"Darynka", 84));
        chairs.addChair(new RockingChair(10,"cloth", 150, "Maks", 67));
        chairs.addChair(new DentalChair(12,"vinyl upholstery",160,"Andriy", 120, 70,71));
        chairs.addChair(new DentalChair(4, "leather upholstery",175,"Oleksiy", 125, 80, 110));
    }

    @Test
    void testAddChair() {
        chairManager.addChair(new OfficeChair(3, "plastic", 200, "Sashko", "cotton", 78));
        chairManager.addChair(new FeedingTable(7,"plastic", 150, "Lesyk", 100, 50, 78, 2));
        chairManager.addChair(new RockingChair(2, "wood", 183,"Darynka", 84));
        chairManager.addChair(new DentalChair(12,"vinyl upholstery",160,"Andriy", 120, 70,71));
        assertEquals(4, chairManager.getChairs().size());
    }

    @Test
    void testFindAllByMaterial() {
        chairManager.addChair(new OfficeChair(3, "plastic", 200, "Sashko", "cotton", 78));
        chairManager.addChair(new FeedingTable(7,"plastic", 150, "Lesyk", 100, 50, 78, 2));
        chairManager.addChair(new RockingChair(2, "wood", 183,"Darynka", 84));
        chairManager.addChair(new DentalChair(12,"vinyl upholstery",160,"Andriy", 120, 70,71));
        List<Chair> plasticChairsFromManager = chairManager.findAllByMaterial("plastic");
        List<Chair> plasticChairs = new LinkedList<>();
        plasticChairs.add(new OfficeChair(3, "plastic", 200, "Sashko", "cotton", 78));
        plasticChairs.add(new FeedingTable(7,"plastic", 150, "Lesyk", 100, 50, 78, 2));
        assertFalse(plasticChairsFromManager.isEmpty());
        assertEquals(plasticChairs.toString(), plasticChairsFromManager.toString());

    }

    @Test
    void testFindAllWithMaxWeightHeavierThan() {
        chairManager.addChair(new OfficeChair(3, "plastic", 200, "Sashko", "cotton", 78));
        chairManager.addChair(new FeedingTable(7,"plastic", 150, "Lesyk", 100, 50, 78, 2));
        chairManager.addChair(new RockingChair(2, "wood", 183,"Darynka", 84));
        chairManager.addChair(new DentalChair(12,"vinyl upholstery",160,"Andriy", 120, 70,71));
        List<Chair> maxWeightChairsFromManager = chairManager.findAllWithMaxWeightHeavierThan(170);
        List<Chair> maxWeightChairs = new LinkedList<>();
        maxWeightChairs.add(new OfficeChair(3, "plastic", 200, "Sashko", "cotton", 78));
        maxWeightChairs.add(new RockingChair(2, "wood", 183,"Darynka", 84));
        assertFalse(maxWeightChairsFromManager.isEmpty());
        assertEquals(maxWeightChairs.toString(), maxWeightChairsFromManager.toString());
    }

}