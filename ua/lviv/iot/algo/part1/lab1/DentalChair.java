package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;

@ToString(callSuper = true)
public class DentalChair extends Chair{
    private int maxHeight;
    private int minHeight;
    private int currentHeight;

    public DentalChair(int id, String material, int maxWeight, String owner, int maxHeight, int minHeight, int currentHeight) {
        super(id, material, maxWeight, owner);
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
        this.currentHeight = currentHeight;
    }

    @Override
    public void adjustPosition(int value) {
        if (value <= this.maxHeight - this.currentHeight){
            this.currentHeight += value;
        }
        this.currentHeight = this.maxHeight;
    }
}
