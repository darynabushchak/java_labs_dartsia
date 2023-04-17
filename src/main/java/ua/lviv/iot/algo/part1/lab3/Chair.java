package src.main.java.ua.lviv.iot.algo.part1.lab3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class Chair {
    private int id = 1;
    private String material;
    private int maxWeight;
    private String owner;

    public String getHeaders() {
        return "material, maxWeight, owner";
    }

    public String toCSV() {
        return material + ", " + maxWeight + ", " + owner;
    }

    public void occupy(String owner) {
        this.owner = owner;
    }

    public void release() {
        this.owner = null;
    }

    public boolean isOccupied() {
        return this.owner == null;
    }

    public abstract void adjustPosition(int value);
}