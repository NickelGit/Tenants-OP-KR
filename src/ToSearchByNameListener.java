import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToSearchByNameListener implements ActionListener {
    JFrame jFrame;

    public ToSearchByNameListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SearchByNameDialog searchByNameDialog = new SearchByNameDialog(jFrame);
        searchByNameDialog.pack();
        searchByNameDialog.setLocationRelativeTo(null);
        searchByNameDialog.setVisible(true);
    }
}
