import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchByNameDialog extends JDialog {
    String[] formElementsArray = {"Фамилия","Имя","Отчество"};
    ArrayList<JTextField> textFields = new ArrayList<>();
    JFrame jFrame;

    public SearchByNameDialog(JFrame jFrame){


        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Отмена");

        JDialog searchDialog = new JDialog(jFrame, "Поиск по адресу", true);

        searchDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel jPanel = new JPanel();


        jPanel.setLayout(new GridLayout(4,2));
        setContentPane(jPanel);

        Font lableFont = new Font("TimesRoman", Font.BOLD, 16);

        for(String s : formElementsArray){
            jPanel.add(newLable(s,lableFont));
            jPanel.add(newTextField(lableFont));
        }

        jPanel.add(ok);
        SearchByNameListener searchByNameListener = new SearchByNameListener(this);
        ok.addActionListener(searchByNameListener);

        jPanel.add(cancel);
        cancel.addActionListener(new CloseButtonListener((JDialog)this));

        jPanel.setPreferredSize(new Dimension(300,200));
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
