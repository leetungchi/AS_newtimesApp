package exgui2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import exgui.*;

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
  private exgui2.DialogFactory popDialog = null;
  private String _orgTxt = null;
  private int maxStringLength = 0;
  protected static String _pkField = null;
  protected static String _showField = null;
  /**
   * Sets up selected value.
   */
  public static Object setSelectedItem = null;
  BorderLayout borderLayout1 = new BorderLayout();
  public static boolean isExit = false;
  java.util.Vector v = new java.util.Vector();

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
  public PopAndSelect2Text(exgui2.DialogFactory inDlg, String pkField,
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
    this.setLayout(borderLayout1);
    this.setBackground(new Color(204, 204, 225));
    butnPop.setFont(new java.awt.Font("Dialog", 1, 13));
    butnPop.setText("...");
    butnPop.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        butnPop_actionPerformed(e);
      }
    });
    this.add(txtPopSelect, BorderLayout.CENTER);
    this.add(butnPop, BorderLayout.EAST);
  }

  /**
   * Creates a PopDialog by setPopAndSelect2Text() method.
   * @param popDlg
   */
  public void setPopAndSelect2Text(exgui2.DialogFactory popDlg, String pkField,
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
    if (txtPopSelect.getText().trim().equals("")) {
      return null;
    } else {
      if (this.setSelectedItem == null) {
        return txtPopSelect.getText().trim();
      } else {
        return this.setSelectedItem;
      }
    }
  }

  /**
   * Set JTextField's text.
   * @return Object
   */
  public void setText(String s) {
    txtPopSelect.setText(s);
  }

  public void setTxtFieldEditable(boolean b) {
    if (b)
      txtPopSelect.setEditable(true);
    else
      txtPopSelect.setEditable(false);
  }

  /**
   * Get JTextField's value.<br>
   *<br>
   *  Values: Buyer Maker Type<br>
   * ===========================<br>
   *     1: Buyer<br>
   *     2: Maker<br>
   *     3: Fabric Mill<br>
   *     4: Wash Mill<br>
   *     5: Sewing Shop<br>
   *     6: Licensee<br>
   *     7: Shipping<br>
   *     8: Others<br>
   * ===========================<br>
   * @return Object
   */
  public Object getSelectedBuyerValue() {
    if (!txtPopSelect.getText().trim().equals("")) {
      return exgui2.DialogFactory._getSelectedBuyerValue;
    } else {
      return null;
    }
  }

  public Object getSelectedMakerValue() {
    if (!txtPopSelect.getText().trim().equals("")) {
      //System.out.println("get object "+exgui2.DialogFactory._getSelectedMakerValue);
      return exgui2.DialogFactory._getSelectedMakerValue;
    } else {
      return null;
    }
  }

  public Object getSelectedFabricMillValue() {
    if (!txtPopSelect.getText().trim().equals("")) {
      //System.out.println("get object "+exgui2.DialogFactory._getSelectedFabricMillValue);
      return exgui2.DialogFactory._getSelectedFabricMillValue;
    } else {
      return null;
    }
  }

  public Object getSelectedWashMillValue() {
    if (!txtPopSelect.getText().trim().equals("")) {
      //System.out.println("get object "+exgui2.DialogFactory._getSelectedWashMillValue);
      return exgui2.DialogFactory._getSelectedWashMillValue;
    } else {
      return null;
    }
  }

  public Object getSelectedSewingShopValue() {
    if (!txtPopSelect.getText().trim().equals("")) {
      //System.out.println("get object "+exgui2.DialogFactory._getSelectedSewingShopValue);
      return exgui2.DialogFactory._getSelectedSewingShopValue;
    } else {
      return null;
    }
  }

  public Object getSelectedShippingValue() {
    if (!txtPopSelect.getText().trim().equals("")) {
      //System.out.println("get object "+exgui2.DialogFactory._getSelectedShippingValue);
      return exgui2.DialogFactory._getSelectedShippingValue;
    } else {
      return null;
    }
  }

  public Object getSelectedLicenseeValue() {
    if (!txtPopSelect.getText().trim().equals("")) {
      return exgui2.DialogFactory._getSelectedLicenseeValue;
    } else {
      return null;
    }
  }

  public Object getSelectedOthersValue() {
    if (!txtPopSelect.getText().trim().equals("")) {
      return exgui2.DialogFactory._getSelectedOthersValue;
    } else {
      return null;
    }
  }

  private void showDialog() {
    try {
      this.popDialog.show();
    } catch (Exception eDlg) {
      eDlg.printStackTrace();
      System.out.println("#dialog create failed !");
    } finally {
      if (!this.isExit) {
        //System.out.println("get object setSelectedItem:"+setSelectedItem);
        txtPopSelect.setText(this.setSelectedItem != null ?
                             util.MiscFunc.split(this.setSelectedItem.toString(),"     ")[0].trim() : "");
      } else {
        if (txtPopSelect.getText().trim().equals("")) {
          txtPopSelect.setText("");
        } else {
          txtPopSelect.setText(this.setSelectedItem != null ?
                             util.MiscFunc.split(this.setSelectedItem.toString(),"     ")[0].trim() : "");
        }
      }
      this.setSelectedItem = txtPopSelect.getText();
    }
  }

  void butnPop_actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    if (cmd.equals("...")) {
      setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      this.isExit = false;
      this.showDialog();
      setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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

  public void setEditable(boolean b) {
    if (b) {
      txtPopSelect.setEditable(true);
      butnPop.setEnabled(true);
    } else {
      txtPopSelect.setEditable(false);
      butnPop.setEnabled(false);
    }
  }
}
