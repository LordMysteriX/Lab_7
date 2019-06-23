package main.java.ua.lviv.iot.TextEditor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringProcessor {

    private StringBuilder resultsList;

    private String userInput;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public StringBuilder getResultsList() {
        return resultsList;
    }

    public void setResultsList(StringBuilder resultsList) {
        this.resultsList = resultsList;
    }

    public StringProcessor() {

    }

    public void readInputText() throws IOException {

        System.out.println("Print the text you want to process: ");

        Scanner scanner = new Scanner(System.in);

        this.userInput = scanner.nextLine();

        scanner.close();

    }

    public StringBuilder processText() {

        resultsList = new StringBuilder();

        Pattern pattern = Pattern.compile(
                "(\\$([A-Z]|[a-z])+(\\-)([A-Z]|[a-z])+)"); // сама регулярка, (\\$) - шукає знак долара, ([A-Z]|[a-z])- шукає всі
        // великі і маленькі літери від A до Z, (*)- означає шо тих літер може бути один або більше раз,
        // ([A-Z]|[a-z])+) - знову шукає літери один або більше раз
        Matcher matcher = pattern.matcher(this.getUserInput()); // передаєш стрічке по якій шукати
        while (matcher.find()) { // matcher.find() - повертає true або false
            String s = matcher.group(); // записує кожне знайдене слово яке підходить нашій регулярці в змінну s
            resultsList.append((s.replaceAll("\\-", ""))); // s.replaceAll - приймає два параметри,
            // перший - що замінити, другий на що замінити
            //resultsList.add(matcher.replaceAll(s.replaceAll("\\-", "")));
        }

        return resultsList;

    }
    public void showResults() {
        System.out.println("Exclamation: " + resultsList);
    }


    public static void main(String[] args) throws IOException {

        StringProcessor sp = new StringProcessor();

        sp.readInputText();

        sp.processText();

        sp.showResults();

    }

}
