import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nickolas on 30.11.2017.
 */
public class ToChangeElementDialogListener implements ActionListener {
    int[] selectedRows;
    JFrame jFrame;
    Tenant tenant;

    public ToChangeElementDialogListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selectedRows = Solution.uiForm.selectedRows;

        for (int i = 0; i < selectedRows.length; i++) {
            Tenant tenant;
            int selIndex = selectedRows[i];
            TableModel model = Solution.uiForm.jTable.getModel();
            Object value0 = model.getValueAt(selIndex, 0);
            Object value1 = model.getValueAt(selIndex, 1);
            Object value2 = model.getValueAt(selIndex, 2);
            Object value3 = model.getValueAt(selIndex, 3);

            TenantsIterator itr = new TenantsIterator(Solution.tenants);
            while (itr.hasNext()) {
                Tenant t = itr.next();
                if (t.name.equals(value3) && t.street.equals(value0) &&
                        t.houseNumber.equals(value1) && t.apartmentNumber.equals(value2)) {
                    tenant = t;
                    ChangeElementDialog changeElementDialog = new ChangeElementDialog(jFrame,tenant );
                    changeElementDialog.pack();
                    changeElementDialog.setLocationRelativeTo(null);
                    changeElementDialog.setVisible(true);
                    break;
                }
            }



        }
    }
}
