package com.fuzzy.messages;

import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.fuzzy.app.SystemAttributes;

public class Messenger {

    private String messagesFilePath;
    private String systemPropertiesFilePath;
    private JsonObject messageJSON;

    public Messenger(String messagesFilePath) {
        this.messagesFilePath = messagesFilePath;
        try {
            this.loadMessagesFromJSON();
        } catch (Exception e) {
            System.out.println("Problem parsing JSON file with message information. " + e.getMessage());
        }
        ;
    }

    protected void loadMessagesFromJSON() throws Exception {
        try {
            JsonReader parser = Json.createReader(new StringReader(Files.readString(Paths.get(this.messagesFilePath))));
            this.messageJSON = parser.readObject();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    protected JsonObject getMessages() {
        return this.messageJSON;
    }

    protected JsonObject getLocalizedMessages(String language) {
        return getMessages().get(language).asJsonObject();
    }

    protected String getMessage(String messageType, String messageLabel) throws Exception {
        String localizedMessage;
        try {
            localizedMessage = getLocalizedMessages(getSystemLanguage()).get(messageType).asJsonObject().getString(messageLabel);
            return localizedMessage;
        } catch (Exception e) {
            System.out.println("Problem retrieving localized message " + messageLabel + ". The error is: "
                    + e.getCause().toString());
            throw new Exception(e);
        }
    }

    protected String getSystemLanguage() throws Exception {
        JsonObject systemPropertiesJSON;
        try {
            JsonReader parser = Json
                    .createReader(new StringReader(Files.readString(Paths.get(this.systemPropertiesFilePath))));
            systemPropertiesJSON = parser.readObject();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return systemPropertiesJSON.getString(SystemAttributes.LANGUAGE.getLabel());
    }

    public void setSystemPropertiesFilePath(String filePath) {
        this.systemPropertiesFilePath = filePath;
    }

}