import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToAddElementDialogListener implements ActionListener {
    JFrame jFrame;

    public ToAddElementDialogListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddElementDialog addElementDialog = new AddElementDialog(jFrame);
        addElementDialog.pack();
        addElementDialog.setLocationRelativeTo(null);
        addElementDialog.setVisible(true);
    }
}
