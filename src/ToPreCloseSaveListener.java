import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nickolas on 09.11.2017.
 */
public class ToPreCloseSaveListener implements ActionListener{
    JDialog jDialog;
    JFrame jFrame;

    public ToPreCloseSaveListener(JDialog jDialog, JFrame jFrame) {
        this.jDialog = jDialog;
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jDialog.setVisible(false);
        PreCloseSaveDialog preCloseSaveDialog = new PreCloseSaveDialog(jFrame);
        preCloseSaveDialog.pack();
        preCloseSaveDialog.setLocationRelativeTo(null);
        preCloseSaveDialog.setVisible(true);


    }
}
