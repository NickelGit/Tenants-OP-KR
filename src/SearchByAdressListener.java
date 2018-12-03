import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchByAdressListener implements ActionListener {
    SearchByAdressDialog searchByAdressDialog;
    String street, houseNumber, apartmentNumber;

    public SearchByAdressListener(SearchByAdressDialog searchByAdressDialog) {
        this.searchByAdressDialog = searchByAdressDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Solution.tenants.size() > 0) {
            TenantsLinkedList findTenants = new TenantsLinkedList();
            getText(searchByAdressDialog.textFields);

            if(Solution.curentTenants.size() > 0){
                search(Solution.curentTenants, findTenants);
            }
            else{
                search(Solution.tenants, findTenants);
            }


            Solution.curentTenants = findTenants;
            Object[][] obj;
            if(Solution.curentTenants.size() > 0){
                obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.curentTenants);
            }
            else{
                obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.tenants);
            }
            DefaultTableModel tableModel = new DefaultTableModel(obj, Solution.uiForm.header);

            Solution.uiForm.jTable.setModel(tableModel);
            searchByAdressDialog.setVisible(false);
        }

    }

    public void getText(ArrayList<JTextField> textFields){
        street = textFields.get(0).getText().toLowerCase().trim();
        houseNumber = textFields.get(1).getText().trim();
        apartmentNumber = textFields.get(2).getText().trim();
    }

    public void search(TenantsLinkedList tenants, TenantsLinkedList findTenants){
        TenantsIterator itr = new TenantsIterator(Solution.tenants);
        while(itr.hasNext()){
            Tenant t = itr.next();

            if(!street.equals("") && !houseNumber.equals("") && !apartmentNumber.equals("")){
                if(t.street.toLowerCase().trim().contains(street) && t.houseNumber.trim().equals(houseNumber)
                        && t.apartmentNumber.trim().equals(apartmentNumber)){
                    findTenants.cloneAdd(t);
                }
            }
            else if(!street.equals("") && !houseNumber.equals("") ){
                if(t.street.toLowerCase().trim().contains(street) && t.houseNumber.trim().equals(houseNumber)){
                    findTenants.cloneAdd(t);
                }
            }
            else if(!street.equals("")  && !apartmentNumber.equals("")){
                if(t.street.toLowerCase().trim().contains(street) && t.apartmentNumber.trim().equals(apartmentNumber)){
                    findTenants.cloneAdd(t);
                }
            }
            else if( !houseNumber.equals("") && !apartmentNumber.equals("")){
                if(t.houseNumber.trim().equals(houseNumber) && t.apartmentNumber.trim().equals(apartmentNumber)){
                    findTenants.cloneAdd(t);
                }
            }
            else if(!street.equals("")){
                if(t.street.toLowerCase().trim().contains(street)){
                    findTenants.cloneAdd(t);
                }
            }
            else if(!houseNumber.equals("")){
                if(t.houseNumber.trim().equals(houseNumber)){
                    findTenants.cloneAdd(t);
                }
            }
            else if(!apartmentNumber.equals("")){

                if(t.apartmentNumber.trim().equals(apartmentNumber)){
                    findTenants.cloneAdd(t);
                }
            }

        }

    }
}
