import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by Nickolas on 09.11.2017.
 */
public class PreCloseSaveListener implements ActionListener {
    JDialog jDialog;

    public PreCloseSaveListener(JDialog jDialog) {
        this.jDialog = jDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Solution.tenants.size() > 0) {
            File file = FileChooser.chooseFile();
            if (file != null) {
                try {
                    FileWriter fw = new FileWriter(file);
                    TenantsIterator itr = new TenantsIterator(Solution.tenants);
                    while (itr.hasNext()) {
                        fw.write(itr.next().toString());
                    }
                    fw.flush();
                    fw.close();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(Solution.uiForm , "Нет доступа к файлу!");
                    Solution.uiForm.saveToFile.getActionListeners()[0].actionPerformed(
                            new ActionEvent(Solution.uiForm.saveToFile, Event.MOUSE_DOWN,
                                    "Button 2 was pressed programmatically!"));
                }
                System.exit(0);
            }
        }
        else{
            JOptionPane.showMessageDialog(Solution.uiForm , "Нет данных для сохранения!");
            jDialog.setVisible(false);
        }


    }
}
