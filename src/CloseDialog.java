import javax.swing.*;
import java.awt.*;

/**
 * Created by Nickolas on 09.11.2017.
 */
public class CloseDialog extends JDialog {
    public CloseDialog(JFrame jFrame) {
        JDialog closeDialog = new JDialog(jFrame,"Выход", true);


        closeDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        createCloseDialog(this.getContentPane(),jFrame, this);
        closeDialog.setPreferredSize(new Dimension(300,200));


    }

    public void createCloseDialog(Container container, JFrame jFrame, JDialog jDialog) {
        JButton button;
        Font buttonFont = new Font("TimesRoman", Font.BOLD, 20);
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.gridy = 0;

        Font lableFont = new Font("TimesRoman", Font.BOLD, 24);
        JLabel jLabel = new JLabel("Вы действительно хотите выйти?");
        jLabel.setFont(lableFont);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        container.add(jLabel, constraints);

        button = new JButton("Да");
        ToPreCloseSaveListener toPreCloseSaveListener = new ToPreCloseSaveListener(jDialog, jFrame);
        button.addActionListener(toPreCloseSaveListener);
        button.setFont(buttonFont);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        constraints.gridx = 0;
        container.add(button, constraints);

        button = new JButton("Нет");
        CloseButtonListener closeButtonListener = new CloseButtonListener(jDialog);
        button.addActionListener(closeButtonListener);
        button.setFont(buttonFont);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        container.add(button, constraints);
    }

}
