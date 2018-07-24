package newtimes.production.gui.prodmaintain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class JCbxOnChange extends JComponent {
  JComboBox cbx2show = new JComboBox();
  JTextField txt2Show = new JTextField();
  FlowLayout flowLayout1 = new FlowLayout();
  String[] vct2Chose;
  String[] vct2Show;
  public JCbxOnChange() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public JCbxOnChange(String[] vctClrName,String[] vctClrCode) {
    try {
      vct2Chose=vctClrName;
      vct2Show=vctClrCode;
      cbx2show=new JComboBox(vct2Chose);
      cbx2show.setEditable(true);
      jbInit();
      cbx2show.setSelectedIndex(-1);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public String getOnChangeText(){return txt2Show.getText();}
  public String getComboboxText(){
    return cbx2show.getEditor().getItem().toString();
  }
  private void jbInit() throws Exception {
    this.setLayout(flowLayout1);
    txt2Show.setText("");
    cbx2show.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbx2show_itemStateChanged(e);
      }
    });
    txt2Show.setPreferredSize(
      cbx2show.getPreferredSize());
    this.add(cbx2show, null);
    this.add(txt2Show, null);
  }

  void cbx2show_itemStateChanged(ItemEvent e) {
     if(cbx2show.getSelectedIndex()==-1){
       txt2Show.setText("");
     }else
     txt2Show.setText(vct2Show[cbx2show.getSelectedIndex()]);
  }

}
