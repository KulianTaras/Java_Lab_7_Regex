package ua.lviv.iot;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StringProcessor manager = new StringProcessor();
        manager.setLine(manager.readInputText());
        manager.findMatch();
        manager.showResults();
    }
}
