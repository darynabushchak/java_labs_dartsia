package ua.lviv.iot.algo.part1.lab3.writers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab3.manager.ChairManager;
import ua.lviv.iot.algo.part1.lab3.writer.Writer;
import ua.lviv.iot.algo.part1.lab3.models.DentalChair;
import ua.lviv.iot.algo.part1.lab3.models.FeedingTable;
import ua.lviv.iot.algo.part1.lab3.models.OfficeChair;
import ua.lviv.iot.algo.part1.lab3.models.RockingChair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


class WriterTest {
    Writer writer;
    ChairManager chairs;

    @BeforeEach
    void setUp() {
        writer = new Writer();
        chairs = new ChairManager();
        for (int i = 0; i < 2; i++) {
            chairs.addChair(new DentalChair(5, "plastic", 100, "Vedmid",
                    200, 50, 166));
            chairs.addChair(new FeedingTable(8, "wood", 147, "Zhaba",
                    100, 70, 80, 2));
            chairs.addChair(new OfficeChair(9, "poliester", 200, "Zayets",
                    "vata", 87));
            chairs.addChair(new RockingChair(3, "wood", 150, "Bilka",
                    83));
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of("src\\main\\java\\resources\\chairs-sorted.csv"));
    }

    @Test
    public void testSortedWriteNull() {
        writer.sortedWriteToFile(null);
        File result = new File("src\\main\\java\\resources\\chairs-sorted.csv");
        assertFalse(result.exists());
    }

    @Test
    public void testSortedWriteToFile() throws IOException {
        writer.sortedWriteToFile(chairs.getChairs());

        Path expected = new File("src\\test\\java\\resources\\expected-chairs-sorted.csv").toPath();
        Path actual = new File("src\\main\\java\\resources\\chairs-sorted.csv").toPath();

        assertEquals(-1L, Files.mismatch(expected, actual));
    }

    @Test
    public void testSortedRewriteToFile() throws IOException {
        try (FileWriter fileWriter = new FileWriter("src\\main\\java\\resources\\chairs-sorted.csv")) {
            fileWriter.write("rewriting (sorted)...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        testSortedWriteToFile();
    }

}
