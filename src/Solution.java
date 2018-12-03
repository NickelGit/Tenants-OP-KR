
import java.awt.*;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

/**
 * Created by Nickolas on 04.11.2017.
 */
public class Solution {
    static TenantsLinkedList tenants = new TenantsLinkedList();
    static TenantsLinkedList curentTenants = new TenantsLinkedList();
    static UIForm uiForm = new UIForm();



    public static void main(String[] args) {
        uiForm.loadFromFile.getActionListeners()[0].actionPerformed(
                new ActionEvent(uiForm.loadFromFile, Event.MOUSE_DOWN,
                        "Button 2 was pressed programmatically!"));
    }


}
