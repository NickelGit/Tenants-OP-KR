import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nickolas on 05.11.2017.
 */
public class AddElementDialog extends JDialog{

    String[] formElementsArray = {"Улица","Номер дома","Номер квартиры","Ф.И.О.","Номер телефона"
            ,"Площадь квартиры","Количество жильцов","Район", "Глава района"};
    ArrayList<JTextField> textFields = new ArrayList<>();
    JFrame jFrame;

    public AddElementDialog(JFrame jFrame){


        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Отмена");

        JDialog addDialog = new JDialog(jFrame, "Добавление элемента", true);

        addDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel jPanel = new JPanel();


        jPanel.setLayout(new GridLayout(10,2));
        setContentPane(jPanel);

        Font lableFont = new Font("TimesRoman", Font.BOLD, 16);

        for(String s : formElementsArray){
            jPanel.add(newLable(s,lableFont));
            jPanel.add(newTextField(lableFont));
        }

        jPanel.add(ok);
        ok.addActionListener(new AddElementListener(this));

        jPanel.add(cancel);
        cancel.addActionListener(new CloseButtonListener((JDialog)this));

        jPanel.setPreferredSize(new Dimension(600,400));
    }

    public JLabel newLable(String lable, Font font){
        JLabel jLabel = new JLabel(lable);
        jLabel.setFont(font);
        return jLabel;
    }

    public JTextField newTextField(Font font){
        JTextField jTextField = new JTextField();
        jTextField.setFont(font);
        textFields.add(jTextField);
        return jTextField;
    }


}
