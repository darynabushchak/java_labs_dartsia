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
        Chair[] chairs;
        chairs = new Chair[4];
        chairs[0] = new Chair();
        chairs[0].setId(130);
        chairs[0].setMaterial("dub");
        chairs[0].setOwner("Oleksiy");
        chairs[0].setMaxWeight(130);

        chairs[1] = new Chair(12, "bereza", 150, "Andriy");

        chairs[2] = getInstance();
        chairs[2].setId(140);
        chairs[2].setMaterial("verba");
        chairs[2].setOwner("Sashko");
        chairs[2].setMaxWeight(170);

        chairs[3] = getInstance();

        for (Chair chair : chairs) {
            System.out.println(chair);
        }
    }
}
