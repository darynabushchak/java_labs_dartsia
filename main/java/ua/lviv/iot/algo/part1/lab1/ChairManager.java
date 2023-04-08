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

}

