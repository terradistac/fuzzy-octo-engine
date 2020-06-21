package com.mycompany.messages;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

public class Messager {

    private String messagesFilePath;
    private JsonArray messages;

    public Messager(String messagesFilePath) {
        this.messagesFilePath = messagesFilePath;
        try {
            this.loadMessagesFromJSON();
        } catch (Exception e) {
            System.out.println("Problem parsing JSON file with message information");
        };
    }

    protected void loadMessagesFromJSON() throws Exception {
        try {
        JsonReader parser = Json.createReader(new StringReader(Files.readString(FileSystems.getDefault().getPath(this.messagesFilePath))));
        this.messages = parser.readArray();
        } catch (IOException ie) {
            throw new Exception (ie);
        }
    }

}