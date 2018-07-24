package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class JCompPnlProdHeadRemark extends JPanel implements Intf_SC_CT_Edit{
  protected JScrollPane jScrollPane1 = new JScrollPane();
  protected JLabel whiteBkgBlueCharLabel1 = new JLabel();
  public JTextArea txtProdHeadRMK = new JTextArea();
  protected String title="Production Head Remark";
  protected String data2Show;
  protected Record prod_rec;
  protected String columnFrom;
  protected String columnCopyFrom;
  protected String defaultHeadRemark;
  protected JLabel jLabel1 = new JLabel();
  public JCompPnlProdHeadRemark(){
      try{
        jbInit();
      }catch(Exception exp){

      }
  }
  public JCompPnlProdHeadRemark(String _title,
                                Record rec,
                                String _columnFrom,
                                String _columnCopyFrom,
                                String dftHdRmk) {
    try {
      title=_title;
      columnFrom=_columnFrom;
      columnCopyFrom=_columnCopyFrom;
      prod_rec=rec;
      defaultHeadRemark=dftHdRmk;
      txtProdHeadRMK.setFont(new java.awt.Font("DialogInput", 0, 12));
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public Record getRecord()throws Exception{
    prod_rec.set(columnFrom,txtProdHeadRMK.getText());
    return prod_rec;
  }
  public void setData(String dataString){
    data2Show=dataString;
  }
  public void doSet2Default()throws Exception{
    //if(txtProdHeadRMK.getText().trim().length()>0)return;
    if(defaultHeadRemark!=null)
    txtProdHeadRMK.setText(defaultHeadRemark);
    //jScrollPane1.getViewport().add(txtProdHeadRMK, null);
    txtProdHeadRMK.setCaretPosition(0);
  }
  public void doSetClear(){
    txtProdHeadRMK.setText("");
  }
  public void doCopyFormSc()throws Exception{
    Object data=prod_rec.get(columnCopyFrom);
    //if(txtProdHeadRMK.getText().trim().length()==0){
      txtProdHeadRMK.setText((data == null) ? "" : data.toString());
      txtProdHeadRMK.setCaretPosition(0);
    //}
  }
 protected void jbInit() throws Exception {
    jScrollPane1.setBounds(new Rectangle(2, 38, 623, 163));
    //btnCpProdHdRmk.addActionListener(new PnlCT_Desc_btnCpProdHdRmk_actionAdapter(this));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText(title);
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(2, 1, 622, 21));
    Object prodRmk=prod_rec.get(columnFrom);
    jLabel1.setFont(new java.awt.Font("DialogInput", 0, 12));
    jLabel1.setForeground(Color.red);
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      jLabel1.setText("                                                                                V");
    }else{
      jLabel1.setText("                                   V");
    }
    jLabel1.setBounds(new Rectangle(2, 18, 622, 21));
    this.add(jLabel1, null);
    txtProdHeadRMK.setText((prodRmk==null)?"":prodRmk.toString());
    jScrollPane1.getViewport().add(txtProdHeadRMK, null);
    this.add(jScrollPane1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    jScrollPane1.getVerticalScrollBar().setValue(0);
  }
}
