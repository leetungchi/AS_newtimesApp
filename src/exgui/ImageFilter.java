package exgui;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

public class ImageFilter extends FileFilter {

    // Accept all directories and all gif, jpg, or tiff files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = FileViewerUtils.getExtension(f);
	if (extension != null) {
            if (extension.equals(FileViewerUtils.tiff) ||
                extension.equals(FileViewerUtils.tif) ||
                extension.equals(FileViewerUtils.gif) ||
                extension.equals(FileViewerUtils.jpeg) ||
                extension.equals(FileViewerUtils.jpg)) {
                    return true;
            } else {
                return false;
            }
    	}

        return false;
    }

    // The description of this filter
    public String getDescription() {
        return "Just Images";
    }
}
