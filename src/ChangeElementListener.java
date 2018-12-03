import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nickolas on 30.11.2017.
 */
public class ChangeElementListener implements ActionListener {
    int[] selectedRows;
    Tenant tenant;
    ChangeElementDialog changeElementDialog;
    String name; //имя жильца
    String street,houseNumber, apartmentNumber; //адрес жильца (улица,№дома,№квартиры)
    String phone; //телефон жильца
    double squareOfApartment; //площадь квартиры
    int numberOfTenants; //количество жильцов
    String districtName; //название района
    String districtHead; //имя главы района



    public ChangeElementListener(Tenant tenant, ChangeElementDialog changeElementDialog) {
        this.tenant = tenant;
        this.changeElementDialog = changeElementDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getText();

        Tenant t;
        TenantsIterator itr = new TenantsIterator(Solution.curentTenants);
        while(itr.hasNext()){
            t = itr.next();
            if(tenant.name.equals(t.name) &&
                    tenant.street.equals(t.street) &&
                    tenant.houseNumber.equals(t.houseNumber) &&
                    tenant.apartmentNumber.equals(t.apartmentNumber) &&
                    tenant.phone.equals(t.phone)){

                t.name = name;
                t.street = street;
                t.houseNumber = houseNumber;
                t.apartmentNumber = apartmentNumber;
                t.phone = phone;
                t.squareOfApartment = squareOfApartment;
                t.numberOfTenants = numberOfTenants;
                t.districtName = districtName;
                t.districtHead = districtHead;
                break;
            }
        }

        tenant.name = name;
        tenant.street = street;
        tenant.houseNumber = houseNumber;
        tenant.apartmentNumber = apartmentNumber;
        tenant.phone = phone;
        tenant.squareOfApartment = squareOfApartment;
        tenant.numberOfTenants = numberOfTenants;
        tenant.districtName = districtName;
        tenant.districtHead = districtHead;

        Object[][] obj;
        if(Solution.curentTenants.size() > 0){
            obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.curentTenants);
        }
        else{
            obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.tenants);
        }

        DefaultTableModel tableModel = new DefaultTableModel(obj, Solution.uiForm.header);

        Solution.uiForm.jTable.setModel(tableModel);
        changeElementDialog.setVisible(false);
    }

    public void getText(){
        for(int i = 0; i < 9; i++){
            switch (i){
                case 0 :
                    street = changeElementDialog.textFields.get(i).getText().trim();
                    break;
                case 1 :
                    houseNumber = changeElementDialog.textFields.get(i).getText().trim();
                    break;
                case 2 :
                    apartmentNumber = changeElementDialog.textFields.get(i).getText().trim();
                    break;
                case 3 :
                    name = changeElementDialog.textFields.get(i).getText().trim();
                    break;
                case 4 :
                    phone = changeElementDialog.textFields.get(i).getText().trim();
                    break;
                case 5 :
                    if(changeElementDialog.textFields.get(i).getText().equals("")){
                        JOptionPane.showMessageDialog(changeElementDialog ,
                                "Поля \"Площадь\" и \"Кол-во жильцов\" обязвтельны для заполнения!");
                    }
                    squareOfApartment = Double.parseDouble(changeElementDialog.textFields.get(i).getText().trim());
                    break;
                case 6 :
                    if(changeElementDialog.textFields.get(i).getText().equals("")){
                        JOptionPane.showMessageDialog(changeElementDialog ,
                                "Поля \"Площадь\" и \"Кол-во жильцов\" обязвтельны для заполнения!");
                    }
                    numberOfTenants = Integer.parseInt(changeElementDialog.textFields.get(i).getText().trim());
                    break;
                case 7 :
                    districtName = changeElementDialog.textFields.get(i).getText().trim();
                    break;
                case 8 :
                    districtHead = changeElementDialog.textFields.get(i).getText().trim();
                    break;
            }
        }
    }
}
