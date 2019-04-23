package ua.lviv.iot;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringProcessorTest {
    private StringProcessor manager = new StringProcessor();
    private String testString;
    private List<String> expected;
    private List<String> actual;

    @BeforeEach
    public void setUp() {
        expected = new LinkedList<>();
        actual = new LinkedList<>();

        testString = "The longest orbital flight of the shuttle was STS-80 " +
                "at 17 days 15 hours, while the shortest flight was STS-51 " +
                "at one minute 13 seconds. During the STS-7 mission, Ride " +
                "and the other four astronauts onboard, led by Bob Crippen " +
                "deployed two telecommunications satellites—one for Canada " +
                "and one for Indonesia.";

        expected.add("STS-80");
        expected.add("STS-51");
        expected.add("STS-7");
    }

    @Test
    public void testFindMatch() {
        manager.setLine(testString);
        actual = manager.findMatch();
        Assertions.assertEquals(expected, actual);
        manager.showResults();
    }

    @Test
    public void testFindMatchNotFound() {
        testString = "There are not any of STS";
        manager.setLine(testString);
        actual = manager.findMatch();
        Assertions.assertEquals(0, actual.size());
        manager.showResults();
    }
}