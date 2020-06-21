package com.mycompany.app;

import java.util.HashMap;
import com.mycompany.module.Module;

public interface Loadable {

    public HashMap<MenuAttributes, String> getAttributes();

    public Module getModule();
}
