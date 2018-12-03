import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Nickolas on 05.11.2017.
 */
public class CloseButtonListener implements ActionListener {
    JFrame jFrame;
    JDialog jDialog;
    public CloseButtonListener(JFrame jFrame){
        this.jFrame = jFrame;
    }

    public CloseButtonListener(JDialog jDialog){
        this.jDialog = jDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(jFrame != null){
            close(jFrame);
        }
        if(jDialog != null){
            close(jDialog);
        }
    }

    public void close(JFrame jFrame){
        CloseDialog closeDialog = new CloseDialog(jFrame);
        closeDialog.pack();
        closeDialog.setLocationRelativeTo(null);
        closeDialog.setVisible(true);

    }

    public void close(JDialog jDialog){
        jDialog.setVisible(false);
    }
}
