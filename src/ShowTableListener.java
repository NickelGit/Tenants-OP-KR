import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nickolas on 10.11.2017.
 */
public class ShowTableListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Solution.curentTenants = Solution.tenants;
        Object[][] obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.tenants);
        DefaultTableModel tableModel = new DefaultTableModel(obj, Solution.uiForm.header);

        Solution.uiForm.jTable.setModel(tableModel);
    }
}
