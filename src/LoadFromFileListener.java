import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Nickolas on 09.11.2017.
 */
public class LoadFromFileListener implements ActionListener {
    String name; //имя жильца
    String street,houseNumber, apartmentNumber; //адрес жильца (улица,№дома,№квартиры)
    String phone; //телефон жильца
    double squareOfApartment; //площадь квартиры
    int numberOfTenants; //количество жильцов
    String districtName; //название района
    String districtHead; //имя главы района

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> fileContent = new ArrayList<>();
        File file = FileChooser.chooseFile();
        if(file != null){
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line = br.readLine();
                while(line != null){
                    fileContent.add(line);
                    line = br.readLine();
                }
            }
            catch(Exception exception){
                file = FileChooser.chooseFile();
            }

            for(int i = 0; i < fileContent.size(); i += 9){
                name = fileContent.get(i).trim();
                street = fileContent.get(i + 1).trim();
                houseNumber = fileContent.get(i + 2).trim();
                apartmentNumber = fileContent.get(i + 3).trim();
                phone = fileContent.get(i + 4).trim();
                squareOfApartment = Double.parseDouble(fileContent.get(i + 5).trim());
                numberOfTenants = Integer.parseInt(fileContent.get(i + 6).trim());
                districtName = fileContent.get(i + 7).trim();
                districtHead = fileContent.get(i + 8).trim();

                Solution.tenants.add(new Tenant(name,street,houseNumber,apartmentNumber,phone
                        ,squareOfApartment,numberOfTenants,districtName,districtHead));

                Solution.curentTenants.add(new Tenant(name,street,houseNumber,apartmentNumber,phone
                        ,squareOfApartment,numberOfTenants,districtName,districtHead));


            }

            Object[][] obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.tenants);
            DefaultTableModel tableModel = new DefaultTableModel(obj, Solution.uiForm.header);

            Solution.uiForm.jTable.setModel(tableModel);
        }
    }
}
