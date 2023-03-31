package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@ToString(callSuper = true)
@Getter
@Setter
public class FeedingTable extends Chair{
    private int maxHeight;
    private int minHeight;
    private int currentHeight;
    private int childAge;
    public FeedingTable(int id, String material, int maxWeight, String owner, int maxHeight, int minHeight, int currentHeight, int childAge) {
        super(id, material, maxWeight, owner);this.maxHeight = maxHeight;
        this.minHeight = minHeight;
        this.currentHeight = currentHeight;
        this.childAge = childAge;
    }

    @Override
    public void adjustPosition(int value) {
        if (value <= this.maxHeight - this.currentHeight){
            this.currentHeight += value;
        }
        this.currentHeight = this.maxHeight;
    }
}
