package com.fuzzy.messages;

public class MessengerFactory {

    public Messenger createMessenger(String messageFilePath) {
        Messenger newMessenger = new Messenger(messageFilePath);
        newMessenger.setSystemPropertiesFilePath(System.getProperty("user.dir") + "properties.json");
        return newMessenger;
    } 
}