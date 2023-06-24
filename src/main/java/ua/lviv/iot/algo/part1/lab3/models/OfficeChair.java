package ua.lviv.iot.algo.part1.lab3.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfficeChair extends Chair {
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

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", chairUpholstery, currentSlopeInDegrees";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + chairUpholstery + ", " + currentSlopeInDegrees;
    }

}
