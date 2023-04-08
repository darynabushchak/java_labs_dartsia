package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@ToString(callSuper = true)
@Getter
@Setter
public class OfficeChair extends Chair{
    private String chairUpholstery;
    public OfficeChair(int id, String material, int maxWeight, String owner, String chairUpholstery, int currentSlopeInDegrees) {
        super(id, material, maxWeight, owner);
        this.chairUpholstery = chairUpholstery;
        this.currentSlopeInDegrees = currentSlopeInDegrees;
    }

    private int currentSlopeInDegrees;

    @Override
    public void adjustPosition(int value) {
        this.currentSlopeInDegrees += value;
    }
}
