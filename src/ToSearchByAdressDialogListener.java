import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToSearchByAdressDialogListener implements ActionListener {
    JFrame jFrame;

    public ToSearchByAdressDialogListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SearchByAdressDialog searchByAdressDialog = new SearchByAdressDialog(jFrame);
        searchByAdressDialog.pack();
        searchByAdressDialog.setLocationRelativeTo(null);
        searchByAdressDialog.setVisible(true);
    }
}
