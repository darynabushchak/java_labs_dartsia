package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;

@ToString(callSuper = true)
public class RockingChair extends Chair{
    private int currentSlopeInDegrees;

    public RockingChair(int id, String material, int maxWeight, String owner, int currentSlopeInDegrees){
        super(id, material, maxWeight, owner);
        this.currentSlopeInDegrees = currentSlopeInDegrees;
    }
    @Override
    public void adjustPosition(int value) {
        this.currentSlopeInDegrees += value;
    }
}
