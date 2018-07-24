package newtimes.production.report;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import exgui.*;
import java.util.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlNoneScList
    extends newtimes.production.report.AbsQryPanel{
    //extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel1 = new JLabel();
  JComboBox cbxCenter = new JComboBox();
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JComboBox cbxDep[] ;
  JButton btnQry = new JButton();
  protected   DataBindJCombobox dbCbxCenter,dbCbxDep[];
  public PnlNoneScList() {
    try {
      //jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    cbxDep=new JComboBox[10];
    for(int i=0;i<10;i++) cbxDep[i]=new JComboBox();
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(border1,"DEPARTMENT");
    blueBkgWhiteCharLabel1.setText("NONE S/C# LIST");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 18, 804, 36));
    this.setLayout(null);
    setBackground(new Color(204, 204, 225));
    jLabel1.setVerifyInputWhenFocusTarget(true);
    jLabel1.setText("CENTER");
    jLabel1.setBounds(new Rectangle(7, 63, 62, 26));
    cbxCenter.setBounds(new Rectangle(63, 63, 127, 24));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(224, 68, 442, 163));
    jPanel1.setLayout(null);
    jPanel1.setBackground(new Color(204, 204, 225));
    cbxDep[0].setBounds(new Rectangle(10, 20, 199, 23));
    cbxDep[1].setBounds(new Rectangle(227, 20, 199, 23));
    cbxDep[2].setBounds(new Rectangle(227, 48, 199, 23));
    cbxDep[3].setBounds(new Rectangle(10, 48, 199, 23));
    cbxDep[4].setBounds(new Rectangle(227, 75, 199, 23));
    cbxDep[5].setBounds(new Rectangle(10, 75, 199, 23));
    cbxDep[6].setBounds(new Rectangle(228, 100, 199, 23));
    cbxDep[7].setBounds(new Rectangle(11, 100, 199, 23));
    cbxDep[8].setBounds(new Rectangle(228, 125, 199, 23));
    cbxDep[9].setBounds(new Rectangle(11, 125, 199, 23));
    btnQry.setBounds(new Rectangle(673, 202, 109, 26));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jLabel1, null);
    this.add(cbxCenter, null);
    this.add(jPanel1, null);
    jPanel1.add(cbxDep[1], null);
    jPanel1.add(cbxDep[2], null);
    jPanel1.add(cbxDep[3], null);
    jPanel1.add(cbxDep[4], null);
    jPanel1.add(cbxDep[5], null);
    jPanel1.add(cbxDep[6], null);
    jPanel1.add(cbxDep[7], null);
    jPanel1.add(cbxDep[8], null);
    jPanel1.add(cbxDep[9], null);
    jPanel1.add(cbxDep[0], null);
    this.add(btnQry, null);
    genDataBindObj();
    }
     protected void genDataBindObj(){
       try{
         dbCbxDep=new exgui.DataBindJCombobox[10];
         dbCbxCenter =
              new exgui.DataBindJCombobox(
              cbxCenter, "P_CENTER",
             newtimes.preproduction.guis.tempProperties.tmpCenters,
              "CEN_NAME", "CEN_CODE",
              (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
         dataBindComps.add(dbCbxCenter);

         Vector depVects=
             (Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
             dbCbxCenter.getSelectedValue());
               String str[]={null,"QQ","SS","MM","KA","KS","JJ","JW","JC","JP"};
         for(int i=0;i<10;i++){
            dbCbxDep[i] =
               new exgui.DataBindJCombobox(
               cbxDep[i], "P_DEP",
               depVects,
               "DEP_NAME", "DEP_ABBR",
               str[i],
               " ", null);
         }
         super.reportName="NONE_SC.RPT";
         }catch(Exception exp){
             exp.printStackTrace();
       }

     }
     protected java.util.HashMap composeParameters(){
       HashMap hm = super.composeParameters();
       StringBuffer sbDEP=new StringBuffer();
       for(int i=0;i<10;i++){
         Object depObj=dbCbxDep[i].getSelectedValue();
         if(depObj!=null){
           if(sbDEP.length()>0)sbDEP.append(",");
           sbDEP.append("'");
           sbDEP.append(depObj);
           sbDEP.append("'");
         }
       }
       if(sbDEP.length()>0){
         hm.put("P_DEP","["+sbDEP.toString()+"]");
       }else{
         hm.put("P_DEP","['ALL']");
       }

       return hm;
     }

  void btnQry_actionPerformed(ActionEvent e) {
    super.JButtonQueryButtonAction(null);
  }

}

