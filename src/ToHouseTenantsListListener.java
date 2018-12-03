import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToHouseTenantsListListener implements ActionListener{
    JFrame jFrame;

    public ToHouseTenantsListListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HouseTenantsListDialog houseTenantsListDialog = new HouseTenantsListDialog(jFrame);
        houseTenantsListDialog.pack();
        houseTenantsListDialog.setLocationRelativeTo(null);
        houseTenantsListDialog.setVisible(true);
    }
}
