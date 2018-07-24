package exgui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: PopSelect</p>
 * <p>Description: Provides interface to create DialogFactory for accessing
 *                 database, and return value back.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author Chloe.H
 * @version 1.0
 */

public class PopAndSelect2Text extends DataBindTextWithChecker {
  private Frame frame;
  private JButton butnPop = new JButton();
  private JTextField txtPopSelect = new JTextField();
  private exgui.DialogFactory popDialog = null;
  private String _orgTxt = null;
  private int maxStringLength = 0;
  protected static String _pkField = null;
  protected static String _showField = null;
  /**
   * Sets up selected value.
   */
  public static Object setSelectedItem = null;

  /**
   * Creates a PopSelect.
   */
  public PopAndSelect2Text(){
    this(null, null, null);
  }

  /**
   * Creates a PopSelect.
   * @param inDlg
   */
  public PopAndSelect2Text(exgui.DialogFactory inDlg, String pkField,
                           String showField) {
    this.popDialog = inDlg;
    this._pkField = pkField;
    this._showField = showField;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    this.setLayout(null);
    this.setBackground(new Color(204, 204, 225));
    butnPop.setBounds(new Rectangle(160, 0, 26, 23));
    butnPop.setFont(new java.awt.Font("Dialog", 1, 13));
    butnPop.setBorder(BorderFactory.createEtchedBorder());
    butnPop.setText("...");
    butnPop.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnPop_actionPerformed(e);
      }
    });
    txtPopSelect.setBorder(BorderFactory.createEtchedBorder());
    txtPopSelect.setBounds(new Rectangle(0, 0, 158, 23));
    this.add(txtPopSelect, null);
    this.add(butnPop, null);
  }

  /**
   * Creates a PopDialog by setPopDialog() method.
   * @param popDlg
   */
  public void setPopDialog(exgui.DialogFactory popDlg, String pkField,
                           String showField) {
    this.popDialog = popDlg;
    this._pkField = pkField;
    this._showField = showField;
  }

  /**
   * Get JTextField's text.
   * @return Object
   */
  public Object getText() {
    return this.setSelectedItem;
  }

  /**
   * Get JTextField's value.
   * @return Object
   */
  public Object getSelectedValue() {
    return exgui.DialogFactory._getSelectCode;
  }

  private void showDialog() {
    try {
      this.popDialog.show();
    } catch (Exception eDlg) {
      eDlg.printStackTrace();
      System.out.println("#dialog create failed !");
    } finally {
      txtPopSelect.setText(this.setSelectedItem != null ?
                           this.setSelectedItem.toString() : "");
      this.setSelectedItem = txtPopSelect.getText();
    }
  }

  void butnPop_actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    if (cmd.equals("...")) {
      this.showDialog();
    }
  }

  public void setObj2StringCnv(exgui.Object2String obj2Strkvt){
    this._obj2Strkvt = obj2Strkvt;
  }

  public void setFormatChecker(exgui.ultratable.CellTxtEditorFormat verifier){
    this._klmVfy = verifier;
  }

  public void setMaxstringLength(int len){
    maxStringLength = len;
    new exgui.DataBindText(txtPopSelect,null,"",maxStringLength);
  }

  public void init(String fromCurrRecFld,Object orgValueObj){
    //after all the components are set up,you should have to call this method..
    super.init(txtPopSelect,fromCurrRecFld,orgValueObj,
      this.maxStringLength,this._obj2Strkvt,this._klmVfy);
  }
}
