import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nickolas on 09.11.2017.
 */
public class DeleteElementListener implements ActionListener {
    int[] selectedRows;

    @Override
    public void actionPerformed(ActionEvent e) {
        selectedRows = Solution.uiForm.selectedRows;

                for(int i = 0; i < selectedRows.length; i++) {
                    Tenant tenant;
                    int selIndex = selectedRows[i];
                    TableModel model = Solution.uiForm.jTable.getModel();
                    Object value0 = model.getValueAt(selIndex, 0);
                    Object value1 = model.getValueAt(selIndex, 1);
                    Object value2 = model.getValueAt(selIndex, 2);
                    Object value3 = model.getValueAt(selIndex, 3);

                    TenantsIterator itr = new TenantsIterator(Solution.tenants);
                    while(itr.hasNext()){
                        Tenant t = itr.next();
                        if(t.name.equals(value3) && t.street.equals(value0) &&
                                t.houseNumber.equals(value1) && t.apartmentNumber.equals(value2)){
                            tenant = t;
                            Solution.tenants.remove(tenant);
                            break;

                        }
                    }
                    itr = new TenantsIterator(Solution.curentTenants);
                    while(itr.hasNext()){
                        Tenant t = itr.next();
                        if(t.name.equals(value3) && t.street.equals(value0) &&
                                t.houseNumber.equals(value1) && t.apartmentNumber.equals(value2)){
                            tenant = t;
                            Solution.curentTenants.remove(tenant);
                            break;
                        }
                    }
                }

        Object[][] obj;
                if(Solution.curentTenants.size() > 0){
                    obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.curentTenants);
                }
                else{
                    obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.tenants);
                }

        DefaultTableModel tableModel = new DefaultTableModel(obj, Solution.uiForm.header);

        Solution.uiForm.jTable.setModel(tableModel);

    }
}
