package com.fuzzy.messages;

import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Messenger {

    private String messagesFilePath;
    private JsonObject messageJSON;

    public Messenger(String messagesFilePath) {
        this.messagesFilePath = messagesFilePath;
        try {
            this.loadMessagesFromJSON();
        } catch (Exception e) {
            System.out.println("Problem parsing JSON file with message information. " + e.getMessage());
        };
    }

    protected void loadMessagesFromJSON() throws Exception {
        try {
        JsonReader parser = Json.createReader(new StringReader(Files.readString(Paths.get(this.messagesFilePath))));
        this.messageJSON = parser.readObject();
        } catch (Exception e) {
            throw new Exception (e);
        }
    }

    protected JsonObject getMessages() {
        return this.messageJSON;
    }

	protected JsonObject getLocalizedMessages(String language) {
		return getMessages().get(language).asJsonObject();
	}

}