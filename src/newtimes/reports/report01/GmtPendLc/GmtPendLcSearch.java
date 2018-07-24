package newtimes.reports.report01.GmtPendLc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import newtimes.*;
import newtimes.material.Util;
import java.util.HashMap;
//import newtimes.material.Util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class GmtPendLcSearch extends JPanel {
  private GmtPendLcMain parent=null;
  JLabel jLabel3 = new JLabel();
  JTextField tfYear = new JTextField();
  JComboBox cboDep = new JComboBox();
  JLabel jLabel2 = new JLabel();
  JButton btnExtract = new JButton();
  private ReportEJBs.RepGMTPendLC.GMTPendLc gmtPendLcEJB=
      (ReportEJBs.RepGMTPendLC.GMTPendLc)util.ApplicationProperites.getProperties("gmtPendLcEJB");
  java.util.Vector depList = null;

  public GmtPendLcSearch(GmtPendLcMain _parent) {
    parent = _parent;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    this.setBackground(new Color(204, 204, 225));
    this.setOpaque(true);
    this.setLayout(null);
    this.setSize(800,150);


    jLabel3.setBounds(new Rectangle(256, 56, 93, 20));
    jLabel3.setText("DEPARTMENT:");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel3.setForeground(new Color(10,36,106));
    tfYear.setBorder(BorderFactory.createEtchedBorder());
    tfYear.setText("");
    tfYear.setBounds(new Rectangle(357, 22, 68, 22));
    cboDep.setBorder(BorderFactory.createEtchedBorder());
    cboDep.setBounds(new Rectangle(357, 56, 177, 22));
    cboDep.setBackground(Color.WHITE);
    jLabel2.setBounds(new Rectangle(256, 22, 93, 20));
    jLabel2.setText("YEAR:");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(10,36,106));
    btnExtract.setText("Extract");
    btnExtract.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExtract_actionPerformed(e);
      }
    });
    btnExtract.setBorder(BorderFactory.createEtchedBorder());
    btnExtract.setForeground(Color.darkGray);
    btnExtract.setFont(new java.awt.Font("Dialog", 1, 13));
    btnExtract.setBounds(new Rectangle(345, 96, 80, 25));
    btnExtract.setBackground(Color.lightGray);
    this.add(cboDep, null);
    this.add(tfYear, null);
    this.add(jLabel3, null);
    this.add(jLabel2, null);
    this.add(btnExtract, null);
    initAllComboBox();

  }
  void btnExtract_actionPerformed(ActionEvent e) {
    HashMap hm = setConds();
    util.ApplicationProperites.setProperties("gmtPendSearchConds", hm);
    parent.refreshCurrQuery();
  }
   private void initAllComboBox() throws Exception {
     depList = gmtPendLcEJB.getDepList();
     Util.setComboValues(cboDep, depList, "DEP_NAME",true);

     String userType = (String)util.PublicVariable.USER_RECORD.get("USR_TYPE");
     Object depCode = util.PublicVariable.USER_RECORD.get("USR_DEP_CODE");
     if(!userType.equals("2")){
       for(int i=0; i<depList.size(); i++){
         database.datatype.Record rec = (database.datatype.Record)depList.get(i);
         Object code = rec.get("DEP_CODE");
         if(code.equals(depCode)){
           cboDep.setSelectedIndex(i+1);
         }
       }
       cboDep.setEnabled(false);
     }
   }
   private HashMap setConds(){
     Object dep  = null;
     Object code = null;
     Object user = null;
     try{
       dep = cboDep.getSelectedItem();
       int index = cboDep.getSelectedIndex();
       System.out.println("combo index:"+index);
       database.datatype.Record rec = null;
       if(index >0){
         rec = (database.datatype.Record) depList.get(index - 1);
         code = rec.get("DEP_CODE");
         System.out.println("DEP_CODE:" + code);
       }

       rec = util.PublicVariable.USER_RECORD;
       user = rec.get("USR_CODE");
       System.out.println("USR_CODE:" + user);
     }
     catch(Exception exp){
       exp.printStackTrace();
     }
     finally{
       HashMap hm = new HashMap();
       hm.put("DEP_ITEM", dep);
       hm.put("DEP_CODE", code);
       hm.put("YEAR", tfYear.getText());
       hm.put("USER", user);
       return hm;
     }
  }



}
