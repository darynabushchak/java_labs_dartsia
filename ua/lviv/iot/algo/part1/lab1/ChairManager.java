package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ChairManager {
    private final List<Chair> chairs = new LinkedList<>();
    public void addChair(final Chair chair) {
        this.chairs.add(chair);
    }
    public List<Chair> findAllByMaterial(String material) {
        return chairs.stream().filter(chair -> chair.getMaterial().equals(material)).collect(Collectors.toList());
    }
    public List<Chair> findAllWithMaxWeightHeavierThan(int maxWeight){
        return chairs.stream().filter(chair -> chair.getMaxWeight() > maxWeight).collect(Collectors.toList());
    }
    public static void main(String[] args) {

        var chairs = new ChairManager();
        chairs.addChair(new OfficeChair(3, "plastic", 200, "Sashko", "cotton", 78));
        chairs.addChair(new OfficeChair(5,"wood", 180,"Oskar", "batting", 74));
        chairs.addChair(new FeedingTable(7,"plastic", 150, "Lesyk", 100, 50, 78, 2));
        chairs.addChair(new FeedingTable(8, "cotton",154, "Victor", 110, 60, 109,1));
        chairs.addChair(new RockingChair(2, "wood", 183,"Darynka", 84));
        chairs.addChair(new RockingChair(10,"cloth", 150, "Maks", 67));
        chairs.addChair(new DentalChair(12,"vinyl upholstery",160,"Andriy", 120, 70,71));
        chairs.addChair(new DentalChair(4, "leather upholstery",175,"Oleksiy", 125, 80, 110));


        for (Chair chair : chairs.getChairs()) {
            System.out.println(chair);
        }
        var allByMaterial = chairs.findAllByMaterial("plastic");
        System.out.println("\nPlastic chairs");
        for (Chair chair: allByMaterial){
            System.out.println(chair);
        }

        var allWithMaxWeightHeavierThan = chairs.findAllWithMaxWeightHeavierThan(180);
        System.out.println("\nChairs heavier than 180");
        for (Chair chair: allWithMaxWeightHeavierThan){
            System.out.println(chair);
        }
    }
}
