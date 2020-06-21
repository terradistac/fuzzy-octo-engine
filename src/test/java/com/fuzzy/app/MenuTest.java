package com.fuzzy.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;

import com.fuzzy.module.Module;

import org.easymock.EasyMock;

public class MenuTest {

    private Menu menu;

    @Test
    public void menuLoadsOptions() {
        ArrayList<Loadable> options = new ArrayList<Loadable>();
        menu = new Menu(options);
        assertNotNull(menu.getOptions());
    }

    @Test
    public void menuRetrievesUserMessageAttributesOfOptions() {
        ArrayList<Loadable> options = new ArrayList<Loadable>();
        LoadableMenuItem item1 = new LoadableMenuItem();
        HashMap<MenuAttributes, String> attributesToSet = new HashMap<MenuAttributes, String>();
        attributesToSet.put(MenuAttributes.USER_MESSAGE, "UserMessage");
        item1.setAttributes(attributesToSet);
        options.add(item1);

        menu = new Menu(options);
        ArrayList<String> userMessages = menu.getUserMessages();
        assertEquals(1, userMessages.size());
    }

    @Test
    public void menuExecutesAssociatedModuleFromSelectedOption() {
        ArrayList<Loadable> options = new ArrayList<Loadable>();
        LoadableMenuItem item1 = new LoadableMenuItem();
        HashMap<MenuAttributes, String> attributesToSet = new HashMap<MenuAttributes, String>();
        attributesToSet.put(MenuAttributes.USER_MESSAGE, "UserMessage");
        item1.setAttributes(attributesToSet);
        options.add(item1);

        Module mockModule = EasyMock.createMock(Module.class);
        mockModule.execute();
        EasyMock.expectLastCall().once();

        item1.setModule(mockModule);

        menu = new Menu(options);

        menu.load(item1);
    }


}