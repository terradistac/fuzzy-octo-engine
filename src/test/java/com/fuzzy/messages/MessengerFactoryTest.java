package com.fuzzy.messages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MessengerFactoryTest extends MessengerTestBase {

    @Test
    public void testMessengerFactoryReadsProperPropertiesFile() {
        Messenger testMessenger = MessengerFactory.createMessenger(this.testFilePath);
        assertEquals(System.getProperty("user.dir") + "\\properties.json", testMessenger.getSystemPropertiesFilePath());
    }
    
}