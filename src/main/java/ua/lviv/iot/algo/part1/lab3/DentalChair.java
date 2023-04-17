package src.main.java.ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", maxHeight, minHeight, currentHeight";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + maxHeight + ", " + minHeight + ", " + currentHeight;
    }
}
