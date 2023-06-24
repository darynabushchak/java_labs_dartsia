package ua.lviv.iot.algo.part1.lab3.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public
class FeedingTable extends Chair {
    private int maxHeight;
    private int minHeight;
    private int currentHeight;
    private int childAge;

    public FeedingTable(
            int id,
            String material,
            int maxWeight,
            String owner,
            int maxHeight,
            int minHeight,
            int currentHeight,
            int childAge) {

        super(id, material, maxWeight, owner);
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
        this.currentHeight = currentHeight;
        this.childAge = childAge;
    }

    @Override
    public void adjustPosition(int value) {
        if (value + this.currentHeight <= this.maxHeight) {
            this.currentHeight += value;
        } else {
            this.currentHeight = this.maxHeight;
        }
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", maxHeight, minHeight, currentHeight, childAge";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + maxHeight + ", " + minHeight + ", " + currentHeight + ", " + childAge;
    }
}
