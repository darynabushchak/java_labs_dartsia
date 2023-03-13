package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Chair {
    private int id = 1;
    private String material;
    private int maxWeight;
    private String owner;
    private static Chair defaultChair = new Chair();
    public static Chair getInstance() {
        return defaultChair;
    }

    public void occupy(String owner) {
        this.owner = owner;
    }
    public void release(){
        this.owner = null;
    }
    public boolean isOccupied(){
        return this.owner == null;
    }

    public static void main (String[] args){
        var chairs = new Chair[4];
        chairs[0] = new Chair();
        chairs[1] = new Chair(12, "bereza", 150, "Andriy");
        chairs[2] = getInstance();
        chairs[3] = getInstance();

        int i = 0;
        do {
            System.out.println(chairs[i++]);
        } while (i < chairs.length);
    }
}