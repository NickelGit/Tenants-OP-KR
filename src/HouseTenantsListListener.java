import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HouseTenantsListListener implements ActionListener {
    HouseTenantsListDialog houseTenantsListDialog;
    String street, houseNumber;

    public HouseTenantsListListener(HouseTenantsListDialog houseTenantsListDialog) {
        this.houseTenantsListDialog = houseTenantsListDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TenantsLinkedList findTenants = new TenantsLinkedList();
        getText(houseTenantsListDialog.textFields);
        TenantsIterator itr = new TenantsIterator(Solution.tenants);
        while(itr.hasNext()){
            Tenant t = itr.next();
            String tStreet;
            String tHouseNumber;
            if(!street.equals("") && !houseNumber.equals("")) {
                tStreet = t.street.trim().toLowerCase();
                tHouseNumber = t.houseNumber.trim();
                if (tStreet.contains(street)
                        && tHouseNumber.equals(houseNumber)) {
                    findTenants.cloneAdd(t);
                }
            }
            else if(!street.equals("")) {
                tStreet = t.street.trim().toLowerCase();
                if (tStreet.contains(street)) {
                    findTenants.cloneAdd(t);
                }
            }
            else if(!houseNumber.equals("")) {
                tHouseNumber = t.houseNumber.trim();
                if (tHouseNumber.equals(houseNumber)) {
                    findTenants.cloneAdd(t);
                }
            }
        }

        Solution.curentTenants = findTenants;
        Object[][] obj = DataFormatterToJTable.formateArrayListToObjectArray(findTenants);
        DefaultTableModel tableModel = new DefaultTableModel(obj, Solution.uiForm.header);

        Solution.uiForm.jTable.setModel(tableModel);
        houseTenantsListDialog.setVisible(false);

    }

    public void getText(ArrayList<JTextField> textFields){
        street = textFields.get(0).getText().trim().toLowerCase();
        houseNumber = textFields.get(1).getText().trim();
    }
}

