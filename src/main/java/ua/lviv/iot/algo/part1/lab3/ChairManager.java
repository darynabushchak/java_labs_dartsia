package src.main.java.ua.lviv.iot.algo.part1.lab3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChairManager {
    private final List<Chair> chairs = new LinkedList<>();

    public void addChair(final Chair chair) {
        this.chairs.add(chair);
    }

    public List<Chair> findAllByMaterial(String material) {
        return chairs.stream().filter(chair -> chair.getMaterial().equals(material)).collect(Collectors.toList());
    }

    public List<Chair> findAllWithMaxWeightHeavierThan(int maxWeight) {
        return chairs.stream().filter(chair -> chair.getMaxWeight() > maxWeight).collect(Collectors.toList());
    }
}

