package ua.lviv.iot.algo.part1.lab3;

import lombok.*;

@Getter
@Setter
public class OfficeChair extends Chair{
    private String chairUpholstery;
    private int currentSlopeInDegrees;
    public OfficeChair(
            int id,
            String material,
            int maxWeight,
            String owner,
            String chairUpholstery,
            int currentSlopeInDegrees) {

        super(id, material, maxWeight, owner);
        this.chairUpholstery = chairUpholstery;
        this.currentSlopeInDegrees = currentSlopeInDegrees;
    }

    @Override
    public void adjustPosition(int value) {
        this.currentSlopeInDegrees += value;
    }
}
