import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchByNameListener implements ActionListener {
    SearchByNameDialog searchByNameDialog;
    String firstName, surname, patronymic;

    public SearchByNameListener(SearchByNameDialog searchByNameDialog) {
        this.searchByNameDialog = searchByNameDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Solution.tenants.size() > 0) {
            TenantsLinkedList findTenants = new TenantsLinkedList();
            getText(searchByNameDialog.textFields);

            if(Solution.curentTenants.size() > 0){
                search(Solution.curentTenants, findTenants);
            }
            else{
                search(Solution.tenants, findTenants);
            }

            Solution.curentTenants = findTenants;
            Object[][] obj = DataFormatterToJTable.formateArrayListToObjectArray(findTenants);
            DefaultTableModel tableModel = new DefaultTableModel(obj, Solution.uiForm.header);

            Solution.uiForm.jTable.setModel(tableModel);
            searchByNameDialog.setVisible(false);
        }
    }

    public void getText(ArrayList<JTextField> textFields){
        surname = textFields.get(0).getText().trim().toLowerCase();
        firstName = textFields.get(1).getText().trim().toLowerCase();
        patronymic = textFields.get(2).getText().trim().toLowerCase();
    }

    public void search(TenantsLinkedList tenants, TenantsLinkedList findTenants){
        TenantsIterator itr = new TenantsIterator(Solution.tenants);
        while(itr.hasNext()){
            Tenant t = itr.next();
            String name = t.name.trim().toLowerCase();
            if(!firstName.equals("")  && !surname.equals("")  && !patronymic.equals("")){
                if(name.contains(firstName) && name.contains(surname) && name.contains(patronymic)){
                    findTenants.cloneAdd(t);
                }
            }
            else if(!firstName.equals("") && !surname.equals("") ){
                if(name.contains(firstName) && name.contains(surname)){
                    findTenants.cloneAdd(t);
                }
            }
            else if(!firstName.equals("")  && !patronymic.equals("")){
                if(name.contains(firstName) && name.contains(patronymic)){
                    findTenants.cloneAdd(t);
                }
            }
            else if( !surname.equals("") && !patronymic.equals("")){
                if(name.contains(surname) && name.contains(patronymic)){
                    findTenants.cloneAdd(t);
                }
            }
            else if(!firstName.equals("") ){
                if(name.contains(firstName)){
                    findTenants.cloneAdd(t);
                }
            }
            else if(!surname.equals("") ){
                if(name.contains(surname)){
                    findTenants.cloneAdd(t);
                }
            }
            else if(!patronymic.equals("")){
                if(name.contains(patronymic)){
                    findTenants.cloneAdd(t);
                }
            }
        }

    }
}
