import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Nickolas on 12.11.2017.
 */
public class MainFrameKeyListener implements KeyListener {
    JFrame jFrame;

    public MainFrameKeyListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_F1){
            Solution.uiForm.houseTenants.getActionListeners()[0].actionPerformed(
                    new ActionEvent(Solution.uiForm.houseTenants, Event.MOUSE_DOWN,
                            "Button 2 was pressed programmatically!"));
        }

        else if(e.getKeyCode() == KeyEvent.VK_F2){
            Solution.uiForm.more20sqr.getActionListeners()[0].actionPerformed(
                    new ActionEvent(Solution.uiForm.more20sqr, Event.MOUSE_DOWN,
                            "Button 2 was pressed programmatically!"));
        }

        else if(e.getKeyCode() == KeyEvent.VK_F3){
            Solution.uiForm.searchByAdress.getActionListeners()[0].actionPerformed(
                    new ActionEvent(Solution.uiForm.searchByAdress, Event.MOUSE_DOWN,
                            "Button 2 was pressed programmatically!"));
        }

        else if(e.getKeyCode() == KeyEvent.VK_F4){
            Solution.uiForm.searchByName.getActionListeners()[0].actionPerformed(
                    new ActionEvent(Solution.uiForm.searchByName, Event.MOUSE_DOWN,
                            "Button 2 was pressed programmatically!"));
        }

        else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            Solution.uiForm.exit.getActionListeners()[0].actionPerformed(
                    new ActionEvent(Solution.uiForm.exit, Event.MOUSE_DOWN,
                            "Button 2 was pressed programmatically!"));
        }

        else if(e.getKeyCode() == KeyEvent.VK_F5){
            Solution.uiForm.addElement.getActionListeners()[0].actionPerformed(
                    new ActionEvent(Solution.uiForm.addElement, Event.MOUSE_DOWN,
                            "Button 2 was pressed programmatically!"));
        }

        else if(e.getKeyCode() == KeyEvent.VK_F6){
            Solution.uiForm.deleteElement.getActionListeners()[0].actionPerformed(
                    new ActionEvent(Solution.uiForm.deleteElement, Event.MOUSE_DOWN,
                            "Button 2 was pressed programmatically!"));
        }

        else if(e.getKeyCode() == KeyEvent.VK_F7){
            Solution.uiForm.loadFromFile.getActionListeners()[0].actionPerformed(
                    new ActionEvent(Solution.uiForm.loadFromFile, Event.MOUSE_DOWN,
                            "Button 2 was pressed programmatically!"));
        }

        else if(e.getKeyCode() == KeyEvent.VK_F8){
            Solution.uiForm.saveToFile.getActionListeners()[0].actionPerformed(
                    new ActionEvent(Solution.uiForm.saveToFile, Event.MOUSE_DOWN,
                            "Button 2 was pressed programmatically!"));
        }

        else if(e.getKeyCode() == KeyEvent.VK_F9){
            Solution.uiForm.wholeList.getActionListeners()[0].actionPerformed(
                    new ActionEvent(Solution.uiForm.wholeList, Event.MOUSE_DOWN,
                            "Button 2 was pressed programmatically!"));
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
