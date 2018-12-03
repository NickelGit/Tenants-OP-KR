import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * Created by Nickolas on 04.11.2017.
 */
public class UIForm extends JFrame {
    String[] header = {"Улица","Дом","Квартира","Ф.И.О.","№ телефона","Площадь","Кол-во жильцов"};
    JTable jTable;
    JButton houseTenants, more20sqr, searchByAdress, searchByName, exit,
            addElement, deleteElement, loadFromFile, saveToFile, wholeList;
    ListSelectionModel listSelectionModel;
    int[] selectedRows ;

    public UIForm(){

        super();

        this.setTitle("Курсовой проект Рябов Н.А. ЦПИбву-11");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,400);
        Container container = this.getContentPane();

        Font buttonFont = new Font("TimesRoman", Font.BOLD, 20);
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setFocusable(true);
        this.setFocusable(true);

        MainFrameKeyListener mainFrameKeyListener = new MainFrameKeyListener(this);
        container.addKeyListener(mainFrameKeyListener);
        this.addKeyListener(mainFrameKeyListener);

        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridy = 0;

        houseTenants = new JButton("F1:Список жильцов дома");
        houseTenants.setFont(buttonFont);
        ToHouseTenantsListListener toHouseTenantsListListener = new ToHouseTenantsListListener(this);
        houseTenants.addActionListener(toHouseTenantsListListener);
        houseTenants.setFocusable(true);
        houseTenants.addKeyListener(mainFrameKeyListener);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        container.add(houseTenants, constraints);

        more20sqr = new JButton("F2:>20 м.кв на человека");
        more20sqr.setFont(buttonFont);
        More20Listener more20Listener = new More20Listener();
        more20sqr.addActionListener(more20Listener);
        more20sqr.setFocusable(true);
        more20sqr.addKeyListener(mainFrameKeyListener);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        container.add(more20sqr, constraints);

        searchByAdress = new JButton("F3:поиск по адресу");
        searchByAdress.setFont(buttonFont);
        ToSearchByAdressDialogListener toSearchByAdressDialogListener = new ToSearchByAdressDialogListener(this);
        searchByAdress.addActionListener(toSearchByAdressDialogListener);
        searchByAdress.setFocusable(true);
        searchByAdress.addKeyListener(mainFrameKeyListener);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        container.add(searchByAdress, constraints);

        searchByName = new JButton("F4:поиск по Ф.И.О.");
        ToSearchByNameListener toSearchByNameListener = new ToSearchByNameListener(this);
        searchByName.addActionListener(toSearchByNameListener);
        searchByName.setFocusable(true);
        searchByName.addKeyListener(mainFrameKeyListener);
        searchByName.setFont(buttonFont);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        container.add(searchByName, constraints);

        exit = new JButton("ESC: Выход");
        CloseButtonListener closeButtonListener = new CloseButtonListener(this);
        exit.addActionListener(closeButtonListener);
        exit.setFocusable(true);
        exit.addKeyListener(mainFrameKeyListener);
        exit.setFont(buttonFont);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 4;
        container.add(exit, constraints);

        addElement = new JButton("F5:Добавить элемент списка");
        ToAddElementDialogListener addElementDialogListener = new ToAddElementDialogListener(this);
        addElement.addActionListener(addElementDialogListener);
        addElement.setFocusable(true);
        addElement.addKeyListener(mainFrameKeyListener);
        addElement.setFont(buttonFont);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 1;
        constraints.gridx = 0;
        container.add(addElement, constraints);

        deleteElement = new JButton("F6:Удалить элемент списка");
        DeleteElementListener deleteElementListener = new DeleteElementListener();
        deleteElement.addActionListener(deleteElementListener);
        deleteElement.setFocusable(true);
        deleteElement.addKeyListener(mainFrameKeyListener);
        deleteElement.setFont(buttonFont);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        container.add(deleteElement, constraints);

        loadFromFile = new JButton("F7:Загрузить из файла");
        LoadFromFileListener loadFromFileListener = new LoadFromFileListener();
        loadFromFile.addActionListener(loadFromFileListener);
        loadFromFile.setFocusable(true);
        loadFromFile.addKeyListener(mainFrameKeyListener);
        loadFromFile.setFont(buttonFont);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        container.add(loadFromFile, constraints);

        saveToFile = new JButton("F8:Сохранить в файл");
        SaveToFileListener saveToFileListener = new SaveToFileListener();
        saveToFile.addActionListener(saveToFileListener);
        saveToFile.setFocusable(true);
        saveToFile.addKeyListener(mainFrameKeyListener);
        saveToFile.setFont(buttonFont);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        container.add(saveToFile, constraints);

        wholeList = new JButton("F9:Полный список");
        ShowTableListener showTableListener = new ShowTableListener();
        wholeList.addActionListener(showTableListener);
        wholeList.setFocusable(true);
        wholeList.addKeyListener(mainFrameKeyListener);
        wholeList.setFont(buttonFont);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 4;
        container.add(wholeList, constraints);

        Object[][] obj = DataFormatterToJTable.formateArrayListToObjectArray(Solution.tenants);
        jTable = new JTable(obj , header);
        jTable.setFocusable(true);
        jTable.addKeyListener(mainFrameKeyListener);
        listSelectionModel = jTable.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                selectedRows = jTable.getSelectedRows();
            }
        });

        JPopupMenu popup = new JPopupMenu();
        JMenuItem changeItem = new JMenuItem("Изменить");
        changeItem.addActionListener(new ToChangeElementDialogListener(this));
        popup.add(changeItem);

        jTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                if (SwingUtilities.isRightMouseButton(event)) {
                    int column = jTable.columnAtPoint(event.getPoint());
                    int row = jTable.rowAtPoint(event.getPoint());
                    jTable.setColumnSelectionInterval(column, column);
                    jTable.setRowSelectionInterval(row, row);
                    popup.show(jTable, event.getX(), event.getY());
                }
            }
        });

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 2;
        constraints.gridx = 0;
        constraints.gridwidth = 5;
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setFocusable(true);
        jScrollPane.addKeyListener(mainFrameKeyListener);
        container.add(jScrollPane, constraints);



        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
