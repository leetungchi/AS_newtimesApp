package exgui;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

public class ImageFileView extends FileView {
    ImageIcon jpgIcon = new ImageIcon("images/jpgIcon.gif");
    ImageIcon gifIcon = new ImageIcon("images/gifIcon.gif");
    ImageIcon tiffIcon = new ImageIcon("images/tiffIcon.gif");

    public String getName(File f) {
        return null; // let the L&F FileView figure this out
    }

    public String getDescription(File f) {
        return null; // let the L&F FileView figure this out
    }

    public Boolean isTraversable(File f) {
        return null; // let the L&F FileView figure this out
    }

    public String getTypeDescription(File f) {
        String extension = FileViewerUtils.getExtension(f);
        String type = null;

        if (extension != null) {
            if (extension.equals(FileViewerUtils.jpeg) ||
                extension.equals(FileViewerUtils.jpg)) {
                type = "JPEG Image";
            } else if (extension.equals(FileViewerUtils.gif)){
                type = "GIF Image";
            } else if (extension.equals(FileViewerUtils.tiff) ||
                       extension.equals(FileViewerUtils.tif)) {
                type = "TIFF Image";
            }
        }
        return type;
    }

    public Icon getIcon(File f) {
        String extension = FileViewerUtils.getExtension(f);
        Icon icon = null;

        if (extension != null) {
            if (extension.equals(FileViewerUtils.jpeg) ||
                extension.equals(FileViewerUtils.jpg)) {
                icon = jpgIcon;
            } else if (extension.equals(FileViewerUtils.gif)) {
                icon = gifIcon;
            } else if (extension.equals(FileViewerUtils.tiff) ||
                       extension.equals(FileViewerUtils.tif)) {
                icon = tiffIcon;
            }
        }
        return icon;
    }
}
