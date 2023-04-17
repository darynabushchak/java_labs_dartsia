package src.main.java.ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class RockingChair extends Chair {
    private int currentSlopeInDegrees;

    public RockingChair(
            int id,
            String material,
            int maxWeight,
            String owner,
            int currentSlopeInDegrees) {

        super(id, material, maxWeight, owner);
        this.currentSlopeInDegrees = currentSlopeInDegrees;
    }

    @Override
    public void adjustPosition(int value) {
        this.currentSlopeInDegrees += value;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", currentSlopeInDegrees";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + currentSlopeInDegrees;
    }
}
