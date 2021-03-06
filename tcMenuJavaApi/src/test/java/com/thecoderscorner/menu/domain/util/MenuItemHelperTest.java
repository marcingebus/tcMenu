/*
 * Copyright (c) 2018 https://www.thecoderscorner.com (Nutricherry LTD).
 * This product is licensed under an Apache license, see the LICENSE file in the top-level directory.
 */

package com.thecoderscorner.menu.domain.util;

import com.thecoderscorner.menu.domain.*;
import org.junit.Test;

import static com.thecoderscorner.menu.domain.BooleanMenuItem.*;
import static com.thecoderscorner.menu.domain.DomainFixtures.*;
import static org.junit.Assert.*;

public class MenuItemHelperTest {

    private AnalogMenuItem analogItem = anAnalogItem("123", 4);
    private EnumMenuItem enumItem = anEnumItem("111", 3);
    private SubMenuItem subItem = aSubMenu("321", 2);
    private BooleanMenuItem boolMenuItem = aBooleanMenu("321", 33, BooleanNaming.TRUE_FALSE);
    private RemoteMenuItem remoteItem = aRemoteMenuItem("2432", 22);
    private TextMenuItem textItem = aTextMenu("2222", 33);
    private FloatMenuItem floatItem = aFloatMenu("fkgo", 223);
    private ActionMenuItem actionItem = anActionMenu("act", 333);

    @Test
    public void testSubMenuHelper() {
        assertEquals(subItem, MenuItemHelper.asSubMenu(subItem));
        assertNull(MenuItemHelper.asSubMenu(enumItem));
        assertNull(MenuItemHelper.asSubMenu(analogItem));
        assertNull(MenuItemHelper.asSubMenu(floatItem));
    }

    @Test
    public void testCreateFromExisting() {
        MenuItem newAnalog = MenuItemHelper.createFromExistingWithId(analogItem, 11);
        MenuItem newEnum = MenuItemHelper.createFromExistingWithId(enumItem, 94);
        MenuItem newSub = MenuItemHelper.createFromExistingWithId(subItem, 97);
        MenuItem newBool = MenuItemHelper.createFromExistingWithId(boolMenuItem, 99);
        MenuItem newFloat = MenuItemHelper.createFromExistingWithId(floatItem, 3333);
        MenuItem newRemote = MenuItemHelper.createFromExistingWithId(remoteItem, 2222);
        MenuItem newText = MenuItemHelper.createFromExistingWithId(textItem, 1111);
        MenuItem newAction = MenuItemHelper.createFromExistingWithId(actionItem, 9999);

        assertTrue(newAnalog instanceof AnalogMenuItem);
        assertEquals(11, newAnalog.getId());

        assertTrue(newEnum instanceof EnumMenuItem);
        assertEquals(94, newEnum.getId());

        assertTrue(newSub instanceof SubMenuItem);
        assertEquals(97, newSub.getId());

        assertTrue(newBool instanceof BooleanMenuItem);
        assertEquals(99, newBool.getId());

        assertTrue(newFloat instanceof FloatMenuItem);
        assertEquals(3333, newFloat.getId());

        assertTrue(newRemote instanceof RemoteMenuItem);
        assertEquals(2222, newRemote.getId());

        assertTrue((newAction instanceof ActionMenuItem));
        assertEquals(9999, newAction.getId());

        assertTrue(newText instanceof TextMenuItem);
        assertEquals(1111, newText.getId());
    }

    @Test
    public void testEeepromSizeForItem() {
        assertEquals(2, MenuItemHelper.eepromSizeForItem(analogItem));
        assertEquals(2, MenuItemHelper.eepromSizeForItem(enumItem));
        assertEquals(0, MenuItemHelper.eepromSizeForItem(subItem));
        assertEquals(1, MenuItemHelper.eepromSizeForItem(boolMenuItem));
        assertEquals(10, MenuItemHelper.eepromSizeForItem(textItem));
        assertEquals(0, MenuItemHelper.eepromSizeForItem(remoteItem));
        assertEquals(0, MenuItemHelper.eepromSizeForItem(floatItem));
        assertEquals(0, MenuItemHelper.eepromSizeForItem(actionItem));
    }
}