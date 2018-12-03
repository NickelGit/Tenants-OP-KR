import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nickolas on 30.11.2017.
 */
public class ChangeElementDialog extends JDialog {
    String[] formElementsArray = {"Улица","Номер дома","Номер квартиры","Ф.И.О.","Номер телефона"
            ,"Площадь квартиры","Количество жильцов","Район", "Глава района"};
    ArrayList<JTextField> textFields = new ArrayList<>();




    public ChangeElementDialog(JFrame jFrame, Tenant tenant){
        String[] txtParameters = {tenant.street,tenant.houseNumber, tenant.apartmentNumber,tenant.name,   tenant.phone,
                tenant.squareOfApartment + "", tenant.numberOfTenants + "", tenant.districtName, tenant.districtHead};


        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Отмена");

        JDialog addDialog = new JDialog(jFrame, "Изменение элемента", true);

        addDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel jPanel = new JPanel();


        jPanel.setLayout(new GridLayout(10,2));
        setContentPane(jPanel);

        Font lableFont = new Font("TimesRoman", Font.BOLD, 16);

        int i = 0;
        for(String s : formElementsArray){
            jPanel.add(newLable(s,lableFont));
            jPanel.add(newTextField(txtParameters[i],lableFont));
            i++;
        }

        jPanel.add(ok);
        ok.addActionListener(new ChangeElementListener(tenant,this));

        jPanel.add(cancel);
        cancel.addActionListener(new CloseButtonListener((JDialog)this));

        jPanel.setPreferredSize(new Dimension(600,400));
    }

    public JLabel newLable(String lable, Font font){
        JLabel jLabel = new JLabel(lable);
        jLabel.setFont(font);
        return jLabel;
    }

    public JTextField newTextField(String string, Font font){
        JTextField jTextField = new JTextField(string);
        jTextField.setFont(font);
        textFields.add(jTextField);
        return jTextField;
    }
}
