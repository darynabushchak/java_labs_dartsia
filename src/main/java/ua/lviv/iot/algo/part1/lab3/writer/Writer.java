package ua.lviv.iot.algo.part1.lab3.writer;

import ua.lviv.iot.algo.part1.lab3.models.Chair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Writer {
    public void sortedWriteToFile(List<Chair> chairs) {
        if (chairs == null || chairs.isEmpty()) {
            return;
        }
        chairs.sort(Comparator.comparing(chair -> chair.getClass().getSimpleName()));

        try (FileWriter writer = new FileWriter("src//main//java//resources//chairs-sorted.csv")) {
            String chairType = null;

            for (var chair : chairs) {
                if (!chair.getClass().getSimpleName().equals(chairType)) {
                    chairType = chair.getClass().getSimpleName();
                    writer.write( chairType + "\n");
                    writer.write(chair.getHeaders() + "\n");
                }
                writer.write(chair.toCSV() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}