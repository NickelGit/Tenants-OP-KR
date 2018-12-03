import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Nickolas on 10.11.2017.
 */
public class More20Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        if(Solution.tenants.size() > 0) {
            TenantsLinkedList more20sqrPerTenant = new TenantsLinkedList();
            if(Solution.curentTenants.size() > 0) {
                TenantsIterator itr = new TenantsIterator(Solution.curentTenants);
                while(itr.hasNext()){
                    Tenant t = itr.next();
                    if (t.squarePerTenant > 20) {
                        more20sqrPerTenant.cloneAdd(t);
                    }
                }

            }
            else{

                TenantsIterator itr = new TenantsIterator(Solution.tenants);
                while(itr.hasNext()){
                    Tenant t = itr.next();
                    if (t.squarePerTenant > 20) {
                        more20sqrPerTenant.cloneAdd(t);
                    }
                }
            }

            Solution.curentTenants = more20sqrPerTenant;

            Object[][] obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.curentTenants);

            DefaultTableModel tableModel = new DefaultTableModel(obj, Solution.uiForm.header);

            Solution.uiForm.jTable.setModel(tableModel);
        }
    }
}
