package com.mycompany.app;

import java.util.HashMap;
import com.mycompany.module.Module;

public class LoadableMenuItem implements Loadable {

    private HashMap<MenuAttributes, String> attributes = new HashMap<MenuAttributes, String>();
    private Module module;


    @Override
    public HashMap<MenuAttributes, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<MenuAttributes, String> attributesToSet) {
        this.attributes = attributesToSet;
    }

    @Override
    public Module getModule() {
        return module;
    }

    public void setModule(Module moduleToSet) {
        this.module = moduleToSet;
    }
    
}