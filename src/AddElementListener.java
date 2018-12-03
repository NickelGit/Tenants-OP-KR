import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nickolas on 09.11.2017.
 */
public class AddElementListener implements ActionListener {
    AddElementDialog addElementDialog;
    String name; //имя жильца
    String street,houseNumber, apartmentNumber; //адрес жильца (улица,№дома,№квартиры)
    String phone; //телефон жильца
    double squareOfApartment; //площадь квартиры
    int numberOfTenants; //количество жильцов
    String districtName; //название района
    String districtHead; //имя главы района

    public AddElementListener(AddElementDialog addElementDialog){
        this.addElementDialog = addElementDialog;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        getText();
        Tenant t = new Tenant(name,street,houseNumber,apartmentNumber,phone,
                squareOfApartment,numberOfTenants,districtName,districtHead);
        Solution.tenants.cloneAdd(t);
        Solution.curentTenants.cloneAdd(t);

        Object[][] obj;
        if(Solution.curentTenants.size() > 0){
            obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.curentTenants);
        }
        else{
            obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.tenants);
        }
        DefaultTableModel tableModel = new DefaultTableModel(obj, Solution.uiForm.header);

        Solution.uiForm.jTable.setModel(tableModel);
        addElementDialog.setVisible(false);
    }

    public void getText(){
        for(int i = 0; i < 9; i++){
            switch (i){
                case 0 :
                    street = addElementDialog.textFields.get(i).getText().trim();
                    break;
                case 1 :
                    houseNumber = addElementDialog.textFields.get(i).getText().trim();
                    break;
                case 2 :
                    apartmentNumber = addElementDialog.textFields.get(i).getText().trim();
                    break;
                case 3 :
                    name = addElementDialog.textFields.get(i).getText().trim();
                    break;
                case 4 :
                    phone = addElementDialog.textFields.get(i).getText().trim();
                    break;
                case 5 :
                    if(addElementDialog.textFields.get(i).getText().equals("")){
                        JOptionPane.showMessageDialog(addElementDialog ,
                                "Поля \"Площадь\" и \"Кол-во жильцов\" обязвтельны для заполнения!");
                    }
                    squareOfApartment = Double.parseDouble(addElementDialog.textFields.get(i).getText().trim());
                    break;
                case 6 :
                    if(addElementDialog.textFields.get(i).getText().equals("")){
                        JOptionPane.showMessageDialog(addElementDialog ,
                                "Поля \"Площадь\" и \"Кол-во жильцов\" обязвтельны для заполнения!");
                    }
                    numberOfTenants = Integer.parseInt(addElementDialog.textFields.get(i).getText().trim());
                    break;
                case 7 :
                    districtName = addElementDialog.textFields.get(i).getText().trim();
                    break;
                case 8 :
                    districtHead = addElementDialog.textFields.get(i).getText().trim();
                    break;
            }
        }
    }
}
