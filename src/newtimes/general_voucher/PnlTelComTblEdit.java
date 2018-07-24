package newtimes.general_voucher;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import processhandler.template.PnlFieldsEditor;
import exgui.ultratable.*;
import java.util.*;
import database.datatype.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlTelComTblEdit extends JPanel {
  //JPanel jPanel1 = new JPanel();

  JButton btnExit = new JButton();
  JButton btnAddNew = new JButton();
  JButton btnUpdate = new JButton();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtCode = new JTextField();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JComboBox cbxCompany = new JComboBox();
  JLabel jLabel3 = new JLabel();
  JTextField txtGrp = new JTextField();
  JLabel jLabel4 = new JLabel();
  JTextField txtNumber = new JTextField();
  JLabel jLabel5 = new JLabel();
  JTextField txtDesc = new JTextField();
  //JPanel pnlEditTelCode = new JPanel();
  PnlDtlEditor pnlEditTelCode=new PnlDtlEditor();
  exgui.ultratable.PagedTablePanel pnlListTelCode;
  public PnlTelComTblEdit() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    this.setBackground(new Color(202, 202, 224));
    this.setLayout(null);
    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("Dialog", 0, 16));
    blueBkgWhiteCharLabel1.setText("電信編號  維護(點選任一列進行編輯)");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-5, 6, 806, 26));
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("CODE","CODE");
    iso.put(" 公司 ","CMP_NAME");
    iso.put("GROUP","GRP");
    iso.put(" 號碼 ","SyS_CODE");
    iso.put("   說明   ","remark");
    pnlListTelCode=new exgui.ultratable.PagedTablePanel(new Db4List(),99999,iso,new Hashtable());
    //jPanel1.setBounds(new Rectangle(8, 117, 782, 439));
    pnlListTelCode.setBounds(new Rectangle(8, 117, 782, 439));
    btnExit.setBounds(new Rectangle(581, 81, 140, 29));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnAddNew.setText("NEW");
    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setForeground(Color.black);
    btnAddNew.setBounds(new Rectangle(153, 83, 140, 29));

    //this.add(jPanel1, null);
    this.add(pnlListTelCode);
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(btnAddNew, null);
    this.add(btnExit, null);
    this.add(pnlEditTelCode, null);
  }
  class PnlDtlEditor extends PnlFieldsEditor{
       PnlDtlEditor(){
         try{
           jbInit();
         }catch(Exception exp){
           exp.printStackTrace();
         }
       }
       public void jbInit()throws Exception{
         setBackground(new Color(202, 202, 224));
         setBorder(BorderFactory.createEtchedBorder());
         setBounds(new Rectangle(2, 40, 791, 38));
         setLayout(null);
         btnUpdate.setBounds(new Rectangle(707, 5, 79, 26));
         btnUpdate.setFont(new java.awt.Font("Dialog", 1, 11));
         btnUpdate.setText("UPDATE");
         txtCode.setText("");
         txtCode.setBounds(new Rectangle(28, 9, 37, 21));
         jLabel1.setText("代號");
         jLabel1.setBounds(new Rectangle(-1, 9, 35, 23));
         jLabel2.setBounds(new Rectangle(69, 9, 35, 23));
         jLabel2.setText("公司:");
         cbxCompany.setBounds(new Rectangle(100, 9, 157, 22));
         jLabel3.setBounds(new Rectangle(265, 7, 42, 23));
         jLabel3.setText("組別");
         txtGrp.setText("");
         txtGrp.setBounds(new Rectangle(299, 8, 74, 21));
         jLabel4.setText("號碼");
         jLabel4.setBounds(new Rectangle(377, 6, 36, 23));
         txtNumber.setText("");
         txtNumber.setBounds(new Rectangle(405, 7, 81, 21));
         jLabel5.setBounds(new Rectangle(493, 6, 36, 23));
         jLabel5.setText("說明");
         txtDesc.setBounds(new Rectangle(521, 7, 182, 21));
         txtDesc.setText("");

         add(btnUpdate, null);
         add(jLabel2, null);
         add(jLabel1, null);
         add(txtCode, null);
         add(cbxCompany, null);
         add(jLabel3, null);
         add(txtGrp, null);
         add(txtNumber, null);
         add(jLabel4, null);
         add(jLabel5, null);
         add(txtDesc, null);

       }
       public void record2Gui(){

       }
       public void doPrint(){}
  }
  class Db4Update extends exgui.ultratable.PagedDataFactoryAdapter{

  }

  class Db4List extends exgui.ultratable.PagedDataFactoryAdapter{
    public Vector getRecords(int bgn,int rowcount )throws Exception{
    StringBuffer sb=new StringBuffer();
    sb.append("select ");
    sb.append("a.*, ");
    sb.append("(select B.FIELD_DESC from tpe_date_range b  where substr(b.field_name,length(b.field_name),1)=A.COMPANY )as cmp_name, ");
    sb.append("'...' as del ");
    sb.append("from vh_tel_code a ");
    sb.append("order by a.code ");

     Vector vct2return=new Vector();
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,99999);
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        String grpCode=(String)rec.get(2);
        if(null!=grpCode){
          String reGrpCode=util.MiscFunc.Replace(grpCode,","," ").trim();
          rec.set(2,reGrpCode);
        }
        rec.getModifiedFields().clear();
        vct2return.add(rec);
      }
     return vct2return;
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }

  void btnAddNew_actionPerformed(ActionEvent e) {

  }

}
