package com.fuzzy.app;

import java.util.HashMap;

import com.fuzzy.module.Module;

public interface Loadable {

    public HashMap<MenuAttributes, String> getAttributes();

    public Module getModule();
}
