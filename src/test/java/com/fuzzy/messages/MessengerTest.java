package com.fuzzy.messages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.json.JsonObject;

import org.junit.jupiter.api.Test;

public class MessengerTest {

    private Messenger testMessenger;
    private String testFilePath = "src\\test\\java\\com\\fuzzy\\messages\\MockGardeningMessages.json";
    private String testSystemProperties = "src\\test\\java\\com\\fuzzy\\messages\\MockSystemProperties.json";

    @Test
    public void messengerSuccessfullyLoadsProvidedJSONData() {
        testMessenger = new Messenger(this.testFilePath);
        assertNotNull(testMessenger.getMessages());
    }

    @Test
    public void messengerRetrievesArrayOfMessageTypesFromJSON() {
        testMessenger = new Messenger(this.testFilePath);
        JsonObject englishMessages = testMessenger.getLocalizedMessages("english");
        assertEquals(2, englishMessages.size());
        assertEquals(2, englishMessages.get("messages").asJsonObject().size());
        assertEquals(2, englishMessages.get("plants").asJsonArray().size());

        JsonObject spanishMessages = testMessenger.getLocalizedMessages("spanish");
        assertEquals(2, spanishMessages.size());
        assertEquals(2, spanishMessages.get("messages").asJsonObject().size());
        assertEquals(3, spanishMessages.get("plants").asJsonArray().size());
    }

    @Test
    public void messengerRetrievesProperMessageValuesOfDefaultLanguage() throws Exception {
        testMessenger = new Messenger(this.testFilePath);
        testMessenger.setSystemPropertiesFilePath(this.testSystemProperties);
        String retrievedGreeting = testMessenger.getMessage("messages", "greeting");
        assertEquals("Welcome. Which plant would you like to grow?", retrievedGreeting);
    }

    @Test
    public void messengerRetrievesProperLanguageFromPropertiesFile() throws Exception {
        testMessenger = new Messenger(this.testFilePath);
        testMessenger.setSystemPropertiesFilePath(this.testSystemProperties);
        assertEquals("english", testMessenger.getSystemLanguage());
    }
    
}