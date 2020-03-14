package com.telegrafo.model;

import java.util.HashMap;
import java.util.List;

public class Message {
    private String receivedMessage;

    private Binary binary;

    private List<String> textMessage;

    private List<String> morseMessage;

    public static final HashMap<String, String> TRANSLATION_TABLE = new HashMap<String, String>() {{
        put("A", ".-");
        put("B", "-...");
        put("C", "-.-.");
        put("D", "-..");
        put("E", ".");
        put("F", "..-.");
        put("G", "--.");
        put("H", "....");
        put("I", "..");
        put("J", ".---");
        put("K", "-.-");
        put("L", ".-..");
        put("M", "--");
        put("N", "-.");
        put("O", "---");
        put("P", ".--.");
        put("Q", "--.-");
        put("R", ".-.");
        put("S", "...");
        put("T", "-");
        put("U", "..-");
        put("V", "...-");
        put("W", ".--");
        put("X", "-..-");
        put("Y", "-.--");
        put("Z", "--..");
        put("0", "-----");
        put("1", ".----");
        put("2", "..---");
        put("3", "...--");
        put("4", "....-");
        put("5", ".....");
        put("6", "-....");
        put("7", "--...");
        put("8", "---..");
        put("9", "----.");
        put(".", ".-.-.-");
        put(" ", " ");
    }};

    public String getReceivedMessage() {
        return receivedMessage;
    }

    public void setReceivedMessage(String receivedMessage) {
        this.receivedMessage = receivedMessage;
    }

    public Binary getBinary() {
        return binary;
    }

    public void setBinary(Binary binary) {
        this.binary = binary;
    }

    public List<String> getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(List<String> textMessage) {
        this.textMessage = textMessage;
    }

    public List<String> getMorseMessage() {
        return morseMessage;
    }

    public void setMorseMessage(List<String> morseMessage) {
        this.morseMessage = morseMessage;
    }
}
