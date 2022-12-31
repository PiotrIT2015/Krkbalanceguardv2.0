package engine.pp.gekon.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

@Service
@Component
public class windowService {

   public windowService() {

    }

    @PostConstruct
    String initUI() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv files", "csv");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.showOpenDialog(null);
        String path = fileChooser.getSelectedFile().getAbsolutePath();
        return path;
    }
}
