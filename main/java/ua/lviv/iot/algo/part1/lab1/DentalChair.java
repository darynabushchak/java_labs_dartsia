package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
public class DentalChair extends Chair {
    private int maxHeight;
    private int minHeight;
    private int currentHeight;

    public DentalChair(
            int id,
            String material,
            int maxWeight,
            String owner,
            int maxHeight,
            int minHeight,
            int currentHeight) {

        super(id, material, maxWeight, owner);
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
        this.currentHeight = currentHeight;
    }

    @Override
    public void adjustPosition(int value) {
        if (value + this.currentHeight <= this.maxHeight) {
            this.currentHeight += value;
        } else this.currentHeight = this.maxHeight;
    }
}
