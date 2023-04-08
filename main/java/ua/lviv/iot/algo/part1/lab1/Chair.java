package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
public abstract class Chair {
    private int id = 1;
    private String material;
    private int maxWeight;
    private String owner;
    public Chair() {}
    public void occupy(String owner) {
        this.owner = owner;
    }
    public void release(){
        this.owner = null;
    }
    public boolean isOccupied(){
        return this.owner == null;
    }
    public abstract void adjustPosition(int value);
}