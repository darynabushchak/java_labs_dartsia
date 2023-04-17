package src.main.java.ua.lviv.iot.algo.part1.lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class Writer {
    public void writeToFile(List<Chair> chairs) {
        if (chairs == null || chairs.isEmpty()) {
            return;
        }
        try (FileWriter writer = new FileWriter("src//main//java//resources//chairs.csv")) {
            for (var chair : chairs) {
                writer.write(chair.getClass().getSimpleName() + "\n");
                writer.write(chair.getHeaders());
                writer.write(" \r\n");
                writer.write(chair.toCSV());
                writer.write(" \r\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortedWriteToFile(List<Chair> chairs) {
        if (chairs == null || chairs.isEmpty()) {
            return;
        }

        List<Class<? extends Chair>> chairsType = chairs.stream()
                .map(Chair::getClass)
                .distinct()
                .collect(Collectors.toList());

        try (FileWriter writer = new FileWriter("src//main//java//resources//chairs-sorted.csv")) {
            for (var chairType : chairsType) {
                writer.write(chairType.getSimpleName() + "\n");
                writer.write(String.valueOf(chairType.getDeclaredMethod("getHeaders")
                        .invoke(chairType.getDeclaredConstructor().newInstance())));
                writer.write("\n");

                for (var chair : chairs) {
                    if (chairType == chair.getClass()) {
                        writer.write(chair.toCSV() + "\n");
                    }
                }
                writer.write("\n");
            }
        } catch (IOException
                 | NoSuchMethodException
                 | InvocationTargetException
                 | IllegalAccessException
                 | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

