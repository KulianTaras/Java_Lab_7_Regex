package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {
    private String line;
    private List<String> list;

    public StringProcessor(){}

    public StringProcessor(String line, List<String> list) {
        this.line = line;
        this.list = list;
    }

    public String getLine() {
        return line;
    }

    public List<String> getList() {
        return list;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public static String readInputText() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String");
        return br.readLine();
    }

    public final List<String> findMatch() {
        list = new LinkedList<String>();
        Pattern wordsWithMission = Pattern.compile("\\b[S][T][S].\\d+\\b");
        Matcher matcher = wordsWithMission.matcher(this.getLine());
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public final void showResults() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Show missions:\n");

        if (list.isEmpty()) {
            System.out.println("There is no matches found :c ");
        } else {
            System.out.println("Result: " + list);
        }
    }
}
