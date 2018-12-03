import javax.swing.*;
import java.io.File;

/**
 * Created by Nickolas on 09.11.2017.
 */
public class FileChooser {

    public static File chooseFile(){
        File file = null;
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileopen.getSelectedFile();
        }

        return file;
    }

}
