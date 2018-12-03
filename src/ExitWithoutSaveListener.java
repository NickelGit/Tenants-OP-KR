import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nickolas on 09.11.2017.
 */
public class ExitWithoutSaveListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
