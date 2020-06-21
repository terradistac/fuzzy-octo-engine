package com.mycompany.app;

import java.util.ArrayList;

public class Menu {

    private ArrayList<Loadable> options;

    public Menu(ArrayList<Loadable> optionsToLoad) {
        this.options = optionsToLoad;
    }

    public boolean isInitialized() {
        return true;
    }

	public ArrayList<Loadable> getOptions() {
		return options;
	}

	public ArrayList<String> getUserMessages() {
        ArrayList<String> userMessages = new ArrayList<String>();
        for (Loadable option : options) {
            userMessages.add(option.getAttributes().get(MenuAttributes.USER_MESSAGE));
        }
		return userMessages;
    }
    
    public void load(Loadable optionToLoad) {
        optionToLoad.getModule().execute();
    }
}