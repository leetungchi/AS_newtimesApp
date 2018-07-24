package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import exgui2.*;
import newtimes.preproduction.buyermakerselect.*;
import java.util.Vector;
import exgui.DataBindJCombobox;
import newtimes.preproduction.guis.tempProperties;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryStyles2AddByScPo extends JPanel {
  JButton btnQryStyles = new JButton();
  JButton btnExit = new JButton();
  JRadioButton rb_PO_Style = new JRadioButton();
  JLabel jLabel110 = new JLabel();
  JRadioButton rb_Prod = new JRadioButton();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JComboBox cmboDep = new JComboBox();
  JLabel jLabel111 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JComboBox cmboDiv = new JComboBox();
  myText txtScNo3 = new myText();
  myText txtScNo1 = new myText();
  JLabel jLabel7 = new JLabel();
  JComboBox cmboCen = new JComboBox();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel120 = new JLabel();


  myText txtScNo6 = new myText();
  myText txtScNo7 = new myText();
  myText txtScNo8 = new myText();
  myText txtScNo9 = new myText();
  myText txtScNo10 = new myText();

  myText txtScNo11 = new myText();
  myText txtScNo12= new myText();
  myText txtScNo13= new myText();
  myText txtScNo14= new myText();
  myText txtScNo15 = new myText();



  myText txtScNo4 = new myText();
  myText txtRange = new myText();
  JLabel jLabel22 = new JLabel();
  myText txtYear = new myText();
  JLabel jLabel9 = new JLabel();
  myText txtScNo2 = new myText();
  JLabel jLabel10 = new JLabel();
  myText txtScNo5 = new myText();


  JComboBox cmboSeason = new JComboBox();
  myText txtSty18 = new myText();
  myText txtPo4 = new myText();
  myText txtPo3 = new myText();
  myText txtPo9 = new myText();
  myText txtSty3 = new myText();
  myText txtPo14 = new myText();
  myText txtPo12 = new myText();
  myText txtSty8 = new myText();
  myText txtPo17 = new myText();
  myText txtSty11 = new myText();
  myText txtSty12 = new myText();
  myText txtSty9 = new myText();
  myText txtSty10 = new myText();
  myText txtSty16 = new myText();
  myText txtSty5 = new myText();
  myText txtSty13 = new myText();
  myText txtPo16 = new myText();
  myText txtPo10 = new myText();
  JPanel jPanel2 = new JPanel();
  myText txtPo2 = new myText();
  JLabel jLabel117 = new JLabel();
  myText txtPo11 = new myText();
  myText txtSty6 = new myText();
  myText txtPo15 = new myText();
  myText txtPo18 = new myText();
  myText txtSty15 = new myText();
  JLabel jLabel11 = new JLabel();
  myText txtSty7 = new myText();
  myText txtPo5 = new myText();
  myText txtPo8 = new myText();
  myText txtPo13 = new myText();
  myText txtSty4 = new myText();
  myText txtPo6 = new myText();
  myText txtPo1 = new myText();
  myText txtSty1 = new myText();
  myText txtPo7 = new myText();
  myText txtSty2 = new myText();
  myText txtSty17 = new myText();
  myText txtSty14 = new myText();
  Record recToMapping;
  SelectBuyerMaker slkProdMaker = new SelectBuyerMaker();
  SelectBuyerMaker slkProdBuyer = new SelectBuyerMaker();
  exgui.DataBindJCombobox dbCBX_Center,dbCBX_Dep,dbCbxdiv,dbCbxSzn;
   myText[] txtSC_NO = {txtScNo1,txtScNo2,txtScNo3,txtScNo4,txtScNo5,
                        txtScNo6,txtScNo7,txtScNo8,txtScNo9,txtScNo10,
                        txtScNo11,txtScNo12,txtScNo13,txtScNo14,txtScNo15,
                        };
  public static String defaultScNo=null;
  public static String defaultStyleName=null;
  public static String defaultStylePo=null;

  myText[] txtPO = {txtPo1,txtPo2,txtPo3,txtPo4,txtPo5,txtPo6,txtPo7,txtPo8,txtPo9,
                      txtPo10,txtPo11,txtPo12,txtPo13,txtPo14,txtPo15,txtPo16,txtPo17,txtPo18};
  myText[] txtStyle = {txtSty1,txtSty2,txtSty3,txtSty4,txtSty5,txtSty6,txtSty7,txtSty8,txtSty9,
                         txtSty10,txtSty11,txtSty12,txtSty13,txtSty14,txtSty15,txtSty16,txtSty17,txtSty18};
String pfx_Cen=null;
String pfx_Dep=null;

  javax.swing.ButtonGroup   buttonGroup1=new ButtonGroup();
  public PnlQryStyles2AddByScPo() {
    try {
      newtimes.shipping_admin.process.shiippingmaintain.ToListAddedStyles.PAGE_BEGIN=0;
      jbInit();
      slkProdMaker.init(null,null,slkProdMaker.TYPE_MAKER,false);
      slkProdBuyer.init(null,null,slkProdMaker.TYPE_BUYER,false);

      java.util.Vector centRecords=tempProperties.tmpCenters;

      java.util.Vector dptRecords=(Vector)tempProperties.tmpH_tbl_CenterDepMap.get(util.PublicVariable.OPERATTING_CENTER);

      //java.util.Vector dvsnRecords=tempProperties.tmpDivision;
      //java.util.Vector sznRecords=tempProperties.tmpSeason;
      //set defalut value to year feild
      //txtYear.setText(String.valueOf(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)));
      //============================
      //for other centers,SRN formate are different
      //============================
      String srn=newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN;
      if(util.PublicVariable.OPERATTING_CENTER.equals("001")||
         util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        pfx_Cen = srn.substring(2, 4);
        pfx_Dep = srn.substring(4, 6);
      }else{
        pfx_Cen = srn.substring(3, 5);
        pfx_Dep = srn.substring(5, 7);
      }
      int cen_prefiex_at=0;
      Object objCen=null;
      Object objDep=null;
      for(int i=0;i<centRecords.size();i++){
        Record recCen=(Record)centRecords.get(i);
        if(i==0){
          cen_prefiex_at=util.MiscFunc.getFieldIndexAtRecord(recCen,"cen_prefix");
        }
        if(recCen.get(cen_prefiex_at).toString().equals(pfx_Cen)){
          objCen=recCen.get(0);
          break;
        }
      }
      /*
      java.util.Vector dptRecords=(java.util.Vector) tempProperties.tmpH_tbl_CenterDepMap.get(
                                  util.PublicVariable.USER_RECORD.get("usr_cen_code").toString());
      */
      /*
             if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
               //2006,DAMMMED NTHK set production's sub-group code into SRN,there is no RULE to search by prefix
               //only to search by the PO's Dep.
               StringBuffer sb=new StringBuffer();
               sb.append("select ");
               sb.append("b.prod_head_pk,b.prod_deptment ");
               sb.append("from ship_sc a,prod_head b ");
               sb.append("where a.PROD_HEAD_PK=b.prod_head_pk ");
               sb.append("and a.SHIP_NO='");
               sb.append(srn);sb.append("' ");
               sb.append("and a.record_delete_flag='1' ");
               sb.append("and rownum=1");

               Vector vctDep=
                   exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                   util.PublicVariable.USER_RECORD,
                   sb.toString(),1,1);
               Record recDep=(Record)vctDep.get(0);
               objDep=recDep.get(1);

             }else{

               for (int i = 0; i < dptRecords.size(); i++) {
                 Record recDep = (Record)dptRecords.get(i);
                 if (i == 0) {
                   dep_prefiex_at = util.MiscFunc.getFieldIndexAtRecord(recDep,
                       "dep_prefix");
                 }
                 if (recDep.get(dep_prefiex_at).toString().equals(pfx_Dep)) {
                   objDep = recDep.get(0);
                   break;
                 }
               }
             }

       */

      StringBuffer sb=new StringBuffer();
      sb.append("select ");
      sb.append("b.prod_head_pk,b.prod_deptment ");
      sb.append("from ship_sc a,prod_head b ");
      sb.append("where a.PROD_HEAD_PK=b.prod_head_pk ");
      sb.append("and a.SHIP_NO='");
      sb.append(srn);sb.append("' ");
      sb.append("and a.record_delete_flag='1' ");
      sb.append("and rownum=1");

      Vector vctDep=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          sb.toString(),1,1);
      Record recDep=(Record)vctDep.get(0);
      objDep=recDep.get(1);

      dbCBX_Center= new exgui.DataBindJCombobox(
            cmboCen,"USR_CEN_CODE",
            centRecords,"CEN_NAME",
            "CEN_CODE",
            objCen);


      dbCBX_Dep = new exgui.DataBindJCombobox(
            cmboDep,
            "USR_DEP_CODE",
            dptRecords,
            "DEP_NAME",
            "DEP_CODE",
            objDep);
      cmboCen.setEnabled(false);
      cmboDep.setEnabled(false);

    /*
        dbCbxdiv=new exgui.DataBindJCombobox(
             cmboDiv,
             null,
             dvsnRecords,
             "DIV_NAME",
             "DIV_CODE",
             null,"",null);

           dbCbxSzn= new exgui.DataBindJCombobox(
                       cmboSeason,
                       null,
                       sznRecords,
                       "SEA_NAME",
                        "SEA_NAME",
                        null,"",null);
     */
      cmboCen.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(ItemEvent e) {
          cmboCen_itemStateChanged(e);
        }
      });
      //cmboCen_itemStateChanged(null);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public java.util.HashMap  getQueryConditionDatas() throws Exception{
      java.util.HashMap hm = new java.util.HashMap();
      try {
        hm.put("PROD_CEN_CODE",  dbCBX_Center.getSelectedValue());
        hm.put("PROD_DEPTMENT",
               (dbCBX_Dep.getSelectedValue()==null)?"null":dbCBX_Dep.getSelectedValue());

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (rb_Prod.isSelected()) {
          //this.type = "prod";
          hm.put("type", "prod");
          /*
          hm.put("PROD_BUYER", slkProdBuyer.getSelectedValue());
          hm.put("PROD_MAKER", slkProdMaker.getSelectedValue());
          hm.put("PROD_BUYER_DIVISION", dbCbxdiv.getSelectedValue());
          hm.put("PROD_SEASON", dbCbxSzn.getSelectedValue());
          hm.put("PROD_YEAR", txtYear.getText().trim().equals("")?
                 "null":txtYear.getText().trim());
          hm.put("PROD_RANGE", txtRange.getText().trim().equals("")?
                 "null":txtRange.getText().trim());
          */
         String tgtScNo=null;
          for (int x = 1; x <= txtSC_NO.length; x++){
            tgtScNo=txtSC_NO[x - 1].getText().trim();
            if(tgtScNo.length()>=6){
              /*
              if((!tgtScNo.startsWith("S"))||(!tgtScNo.substring(2,4).equals(pfx_Cen))||
                 (!tgtScNo.substring(4,6).equals(pfx_Dep))){
                exgui.verification.VerifyLib.showAlert("SC No. Format Error\nOr SC Does Not Belong To This Center Department",
                                                       "Incorrect Sc No");
                txtSC_NO[x - 1].selectAll();
                txtSC_NO[x - 1].grabFocus();
                return null;
              }*/

            }
            hm.put("scNo_" + x, tgtScNo.equals("") ?"null" : tgtScNo);
          }

        } else {
          //this.type = "style";

          hm.put("type", "style");
          for (int y = 1; y <= 18; y++) {
            hm.put("po_" + y, txtPO[y-1].getText().trim().equals("")?
                   "null":txtPO[y-1].getText().trim());
            hm.put("sty_" + y,txtStyle[y-1].getText().trim().equals("")?
                   "null":txtStyle[y-1].getText().trim());
          }
        }
        //util.ApplicationProperites.setProperties("getData", hm);
        return hm;
      } finally {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
      }
    }


 protected void jbInit() throws Exception {
    this.setLayout(null);
    btnQryStyles.setBounds(new Rectangle(51, 460, 128, 33));
    btnQryStyles.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQryStyles.setActionCommand("Extract");
    btnQryStyles.setText("EXTRACT");
    btnQryStyles.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQryStyles_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(273, 460, 106, 33));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    rb_PO_Style.setBackground(Color.white);
    rb_PO_Style.setFont(new java.awt.Font("Dialog", 1, 12));
    //rb_PO_Style.setForeground(Color.darkGray);
    rb_PO_Style.setText("PO and Style");
    rb_PO_Style.setBounds(new Rectangle(292, 21, 129, 20));
    rb_PO_Style.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rb_PO_Style_itemStateChanged(e);
      }
    });
    jLabel110.setBounds(new Rectangle(7, 21, 155, 20));
    jLabel110.setVerticalAlignment(SwingConstants.CENTER);
    jLabel110.setText(" Condition of :");
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setOpaque(true);
    jLabel110.setForeground(Color.white);
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setBackground(new Color(143, 143, 188));
    rb_Prod.setBackground(Color.white);
    rb_Prod.setFont(new java.awt.Font("Dialog", 1, 12));
    //rb_Prod.setForeground(Color.darkGray);
    rb_Prod.setHorizontalAlignment(SwingConstants.LEADING);
    rb_Prod.setSelected(true);
    rb_Prod.setText("Production");
    rb_Prod.setBounds(new Rectangle(164, 21, 129, 20));
    rb_Prod.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        rb_Prod_itemStateChanged(e);
      }
    });
    jLabel8.setBackground(new Color(143, 143, 188));
    jLabel8.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel8.setForeground(new Color(10,36,106));
    jLabel8.setOpaque(true);
    jLabel8.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel8.setText(" Division :");
    jLabel8.setBounds(new Rectangle(9, 87, 155, 20));
    jLabel21.setBounds(new Rectangle(378, 87, 155, 20));
    jLabel21.setText(" Season :");
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setOpaque(true);
    jLabel21.setForeground(new Color(10,36,106));
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel21.setBackground(new Color(143, 143, 188));
    cmboDep.setDebugGraphicsOptions(0);
    cmboDep.setBounds(new Rectangle(535, 29, 209, 20));
    cmboDep.setBackground(Color.white);
    jLabel111.setBackground(new Color(143, 143, 188));
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel111.setForeground(new Color(10,36,106));
    jLabel111.setOpaque(true);
    jLabel111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel111.setText(" Department :");
    jLabel111.setBounds(new Rectangle(378, 29, 155, 20));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setForeground(new Color(10,36,106));
    jLabel19.setOpaque(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" Center :");
    jLabel19.setVerticalAlignment(SwingConstants.CENTER);
    jLabel19.setBounds(new Rectangle(9, 29, 155, 20));
    cmboDiv.setBounds(new Rectangle(166, 87, 209, 20));
    cmboDiv.setBackground(Color.white);

    txtScNo3.setBounds(new Rectangle(398, 99, 115, 20));
    txtScNo3.setForeground(new Color(10,36,106));
    txtScNo8.setBounds(new Rectangle(398, 129, 115, 20));
    txtScNo8.setForeground(new Color(10,36,106));
    txtScNo13.setBounds(new Rectangle(398, 159, 115, 20));
    txtScNo13.setForeground(new Color(10,36,106));
    jPanel1.add(txtScNo8,null);
    jPanel1.add(txtScNo13,null);



    txtScNo1.setForeground(new Color(10,36,106));
    txtScNo1.setBounds(new Rectangle(166, 99, 115, 20));

    txtScNo6.setForeground(new Color(10,36,106));
    txtScNo6.setBounds(new Rectangle(166, 129, 115, 20));

    txtScNo11.setForeground(new Color(10,36,106));
    txtScNo11.setBounds(new Rectangle(166, 159, 115, 20));
    jPanel1.add(txtScNo6,null);
    jPanel1.add(txtScNo11,null);


    jLabel7.setBounds(new Rectangle(9, 58, 155, 20));
    jLabel7.setText(" FTY :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(Color.white);
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    cmboCen.setBounds(new Rectangle(166, 29, 209, 20));
    cmboCen.setBackground(Color.white);
    jPanel1.setBorder(BorderFactory.createTitledBorder(" Condition of Production "));
    jPanel1.setBackground(new Color(204, 204, 225));
    jPanel1.setLayout(null);
    jPanel1.setBounds(new Rectangle(1, 56, 752, 190));
    jLabel2.setBounds(new Rectangle(227, 115, 55, 20));
    jLabel2.setText("( Year )");
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel120.setBounds(new Rectangle(378, 115, 155, 20));
    jLabel120.setText(" Range :");
    jLabel120.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel120.setOpaque(true);
    jLabel120.setForeground(Color.white);
    jLabel120.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel120.setBackground(new Color(143, 143, 188));

    txtScNo4.setForeground(new Color(10,36,106));
    txtScNo4.setBounds(new Rectangle(513, 99, 115, 20));

    txtScNo9.setForeground(new Color(10,36,106));
    txtScNo9.setBounds(new Rectangle(513, 129, 115, 20));

    txtScNo14.setForeground(new Color(10,36,106));
    txtScNo14.setBounds(new Rectangle(513, 159, 115, 20));
    jPanel1.add(txtScNo14,null);jPanel1.add(txtScNo9,null);

    txtRange.setForeground(new Color(10,36,106));
    txtRange.setBounds(new Rectangle(535, 115, 209, 20));
    jLabel22.setBackground(new Color(143, 143, 188));
    jLabel22.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel22.setForeground(Color.white);
    jLabel22.setOpaque(true);
    jLabel22.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel22.setText(" Buyer :");
    jLabel22.setBounds(new Rectangle(378, 58, 155, 20));
    txtYear.setBounds(new Rectangle(214, 240, 54, 20));
    txtYear.setBounds(new Rectangle(166, 115, 54, 20));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(new Color(10,36,106));
    jLabel9.setOpaque(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText(" SC No. :");
    jLabel9.setBounds(new Rectangle(8, 99, 155, 20));

    txtScNo2.setForeground(new Color(10,36,106));
    txtScNo2.setBounds(new Rectangle(282, 99, 115, 20));

    txtScNo7.setForeground(new Color(10,36,106));
    txtScNo7.setBounds(new Rectangle(282, 129, 115, 20));

    txtScNo12.setForeground(new Color(10,36,106));
    txtScNo12.setBounds(new Rectangle(282, 159, 115, 20));
    jPanel1.add(txtScNo7,null);jPanel1.add(txtScNo12,null);



    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" Year :");
    jLabel10.setBounds(new Rectangle(9, 115, 155, 20));

    txtScNo5.setForeground(new Color(10,36,106));
    txtScNo5.setBounds(new Rectangle(629, 99, 115, 20));
    txtScNo10.setForeground(new Color(10,36,106));
    txtScNo10.setBounds(new Rectangle(629, 129, 115, 20));
    txtScNo15.setForeground(new Color(10,36,106));
    txtScNo15.setBounds(new Rectangle(629, 159, 115, 20));
    jPanel1.add(txtScNo10,null); jPanel1.add(txtScNo15,null);



    cmboSeason.setBounds(new Rectangle(535, 87, 209, 20));
    cmboSeason.setBackground(Color.white);
    txtSty18.setForeground(new Color(10,36,106));
    txtSty18.setEditable(false);
    txtSty18.setBounds(new Rectangle(650, 154, 96, 20));
    txtPo4.setBounds(new Rectangle(456, 34, 96, 20));
    txtPo4.setForeground(new Color(10,36,106));
    txtPo4.setEditable(false);
    txtPo3.setBounds(new Rectangle(359, 34, 96, 20));
    txtPo3.setForeground(new Color(10,36,106));
    txtPo3.setEditable(false);
    txtPo9.setForeground(new Color(10,36,106));
    txtPo9.setEditable(false);
    txtPo9.setBounds(new Rectangle(359, 56, 96, 20));
    txtSty3.setForeground(new Color(10,36,106));
    txtSty3.setEditable(false);
    txtSty3.setBounds(new Rectangle(359, 110, 96, 20));
    txtPo14.setForeground(new Color(10,36,106));
    txtPo14.setEditable(false);
    txtPo14.setBounds(new Rectangle(262, 78, 96, 20));
    txtPo12.setForeground(new Color(10,36,106));
    txtPo12.setEditable(false);
    txtPo12.setBounds(new Rectangle(650, 56, 96, 20));
    txtSty8.setBounds(new Rectangle(262, 132, 96, 20));
    txtSty8.setForeground(new Color(10,36,106));
    txtSty8.setEditable(false);
    txtPo17.setBounds(new Rectangle(553, 78, 96, 20));
    txtPo17.setForeground(new Color(10,36,106));
    txtPo17.setEditable(false);
    txtSty11.setBounds(new Rectangle(553, 132, 96, 20));
    txtSty11.setForeground(new Color(10,36,106));
    txtSty11.setEditable(false);
    txtSty12.setForeground(new Color(10,36,106));
    txtSty12.setEditable(false);
    txtSty12.setBounds(new Rectangle(650, 132, 96, 20));
    txtSty9.setForeground(new Color(10,36,106));
    txtSty9.setDoubleBuffered(false);
    txtSty9.setEditable(false);
    txtSty9.setBounds(new Rectangle(359, 132, 96, 20));
    txtSty10.setBounds(new Rectangle(456, 132, 96, 20));
    txtSty10.setForeground(new Color(10,36,106));
    txtSty10.setEditable(false);
    txtSty16.setBounds(new Rectangle(456, 154, 96, 20));
    txtSty16.setForeground(new Color(10,36,106));
    txtSty16.setEditable(false);
    txtSty5.setBounds(new Rectangle(553, 110, 96, 20));
    txtSty5.setForeground(new Color(10,36,106));
    txtSty5.setEditable(false);
    txtSty13.setForeground(new Color(10,36,106));
    txtSty13.setEditable(false);
    txtSty13.setBounds(new Rectangle(165, 154, 96, 20));
    txtPo16.setForeground(new Color(10,36,106));
    txtPo16.setEditable(false);
    txtPo16.setBounds(new Rectangle(456, 78, 96, 20));
    txtPo10.setForeground(new Color(10,36,106));
    txtPo10.setEditable(false);
    txtPo10.setBounds(new Rectangle(456, 56, 96, 20));
    jPanel2.setBounds(new Rectangle(2, 254, 752, 190));
    jPanel2.setLayout(null);
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setBorder(BorderFactory.createTitledBorder(" Condition of "));
    txtPo2.setBounds(new Rectangle(262, 34, 96, 20));
    txtPo2.setForeground(new Color(10,36,106));
    txtPo2.setEditable(false);
    jLabel117.setBackground(new Color(143, 143, 188));
    jLabel117.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel117.setForeground(new Color(10,36,106));
    jLabel117.setOpaque(true);
    jLabel117.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel117.setText(" PO :");
    jLabel117.setBounds(new Rectangle(8, 34, 155, 63));
    txtPo11.setBounds(new Rectangle(553, 56, 96, 20));
    txtPo11.setForeground(new Color(10,36,106));
    txtPo11.setEditable(false);
    txtSty6.setForeground(new Color(10,36,106));
    txtSty6.setEditable(false);
    txtSty6.setBounds(new Rectangle(650, 110, 96, 20));
    txtPo15.setForeground(new Color(10,36,106));
    txtPo15.setEditable(false);
    txtPo15.setBounds(new Rectangle(359, 78, 96, 20));
    txtPo18.setBounds(new Rectangle(650, 78, 96, 20));
    txtPo18.setForeground(new Color(10,36,106));
    txtPo18.setEditable(false);
    txtSty15.setBounds(new Rectangle(359, 154, 96, 20));
    txtSty15.setForeground(new Color(10,36,106));
    txtSty15.setEditable(false);
    jLabel11.setBounds(new Rectangle(8, 110, 155, 63));
    jLabel11.setText(" Style :");
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setOpaque(true);
    jLabel11.setForeground(Color.white);
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setBackground(new Color(143, 143, 188));
    txtSty7.setForeground(new Color(10,36,106));
    txtSty7.setEditable(false);
    txtSty7.setBounds(new Rectangle(165, 132, 96, 20));
    txtPo5.setForeground(new Color(10,36,106));
    txtPo5.setEditable(false);
    txtPo5.setBounds(new Rectangle(553, 34, 96, 20));
    txtPo8.setBounds(new Rectangle(262, 56, 96, 20));
    txtPo8.setForeground(new Color(10,36,106));
    txtPo8.setEditable(false);
    txtPo13.setBounds(new Rectangle(165, 78, 96, 20));
    txtPo13.setForeground(new Color(10,36,106));
    txtPo13.setEditable(false);
    txtSty4.setBounds(new Rectangle(456, 110, 96, 20));
    txtSty4.setForeground(new Color(10,36,106));
    txtSty4.setEditable(false);
    txtPo6.setBounds(new Rectangle(650, 34, 96, 20));
    txtPo6.setForeground(new Color(10,36,106));
    txtPo6.setEditable(false);
    txtPo1.setBounds(new Rectangle(165, 34, 96, 20));
    txtPo1.setForeground(new Color(10,36,106));
    txtPo1.setEditable(false);
    txtSty1.setForeground(new Color(10,36,106));
    txtSty1.setEditable(false);
    txtSty1.setBounds(new Rectangle(165, 110, 96, 20));
    txtPo7.setForeground(new Color(10,36,106));
    txtPo7.setEditable(false);
    txtPo7.setBounds(new Rectangle(165, 56, 96, 20));
    txtSty2.setBounds(new Rectangle(262, 110, 96, 20));
    txtSty2.setForeground(new Color(10,36,106));
    txtSty2.setEditable(false);
    txtSty17.setForeground(new Color(10,36,106));
    txtSty17.setEditable(false);
    txtSty17.setBounds(new Rectangle(553, 154, 96, 20));
    txtSty14.setForeground(new Color(10,36,106));
    txtSty14.setEditable(false);
    txtSty14.setBounds(new Rectangle(262, 154, 96, 20));
    slkProdMaker.setBounds(new Rectangle(164, 58, 212, 20));
    slkProdBuyer.setBounds(new Rectangle(534, 57, 206, 22));
    jPanel1.add(jLabel19, null);
    //jPanel1.add(jLabel7, null);
    //jPanel1.add(jLabel8, null);
    //jPanel1.add(jLabel10, null);
    //jPanel1.add(jLabel120, null);
    //jPanel1.add(txtRange, null);
    //jPanel1.add(jLabel21, null);
    //jPanel1.add(jLabel22, null);
    //jPanel1.add(cmboDiv, null);
    //jPanel1.add(cmboSeason, null);
    jPanel1.add(cmboCen, null);
    jPanel1.add(jLabel111, null);
    jPanel1.add(cmboDep, null);
    //jPanel1.add(jLabel2, null);
    jPanel1.add(txtScNo5, null);
    //jPanel1.add(txtYear, null);
    jPanel1.add(txtScNo1, null);


    jPanel1.add(txtScNo2, null);
    jPanel1.add(txtScNo3, null);
    jPanel1.add(txtScNo4, null);
    jPanel1.add(jLabel9, null);
    //jPanel1.add(slkProdMaker, null);
    this.add(jPanel2, null);
    jPanel2.add(jLabel117, null);
    jPanel2.add(jLabel11, null);
    jPanel2.add(txtPo7, null);
    jPanel2.add(txtPo8, null);
    jPanel2.add(txtPo9, null);
    jPanel2.add(txtPo10, null);
    jPanel2.add(txtPo11, null);
    jPanel2.add(txtPo12, null);
    jPanel2.add(txtPo18, null);
    jPanel2.add(txtPo17, null);
    jPanel2.add(txtPo16, null);
    jPanel2.add(txtPo15, null);
    jPanel2.add(txtPo14, null);
    jPanel2.add(txtPo13, null);
    jPanel2.add(txtSty1, null);
    jPanel2.add(txtSty2, null);
    jPanel2.add(txtSty3, null);
    jPanel2.add(txtSty4, null);
    jPanel2.add(txtSty5, null);
    jPanel2.add(txtSty6, null);
    jPanel2.add(txtSty12, null);
    jPanel2.add(txtSty18, null);
    jPanel2.add(txtSty17, null);
    jPanel2.add(txtSty11, null);
    jPanel2.add(txtSty10, null);
    jPanel2.add(txtSty16, null);
    jPanel2.add(txtSty15, null);
    jPanel2.add(txtSty9, null);
    jPanel2.add(txtSty8, null);
    jPanel2.add(txtSty14, null);
    jPanel2.add(txtSty13, null);
    jPanel2.add(txtSty7, null);
    jPanel2.add(txtPo1, null);
    jPanel2.add(txtPo2, null);
    jPanel2.add(txtPo3, null);
    jPanel2.add(txtPo4, null);
    jPanel2.add(txtPo5, null);
    jPanel2.add(txtPo6, null);
    this.add(btnQryStyles, null);
    this.add(btnExit, null);
    this.add(jLabel110, null);
    this.add(rb_Prod, null);
    this.add(rb_PO_Style, null);
    this.add(jPanel1, null);
    //jPanel1.add(slkProdBuyer, null);
    this.setBackground(newtimes.shipping_admin.ShippingAdmin_Const.PANEL_BACKGROUNDCOLOR);
    buttonGroup1.add(rb_Prod);
    buttonGroup1.add(rb_PO_Style);
    recToMapping=util.PublicVariable.USER_RECORD;

    if(defaultScNo!=null && rb_Prod.isSelected()){
      txtScNo1.setText(new String(defaultScNo));
      //defaultScNo=null;//turn it off.
      //return;
    }
    if(rb_PO_Style.isSelected()){
      if(defaultStylePo!=null &&txtPO[0].getText().trim().length()==0){
        txtPO[0].setText(defaultStylePo);
      }
      /*
      if(defaultStyleName!=null &&txtStyle[0].getText().trim().length()==0){
        txtStyle[0].setText(defaultStyleName);
      }*/


      //txtScNo1.setText(new String(defaultScNo));
      //defaultScNo=null;//turn it off.
      //return;
    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("PW")||
       util.PublicVariable.OPERATTING_CENTER.equals("BW")||
       util.PublicVariable.OPERATTING_CENTER.equals("NTD")){
      rb_PO_Style.setSelected(true);
    }

  }
  void setMaxLength() {
    exgui.DataBindText tx = null;
    tx = new exgui.DataBindText(txtYear, null, "", 4);
    tx = new exgui.DataBindText(txtRange, null, "", 40);
    for (int i = 0; i < txtSC_NO.length; i++)
      tx = new exgui.DataBindText(txtSC_NO[i], null, "", 20);
    for (int x = 0; x < 18; x++){
      tx = new exgui.DataBindText(txtPO[x], null, "", 20);
      tx = new exgui.DataBindText(txtStyle[x], null, "", 25);
    }
  }

  void rb_Prod_itemStateChanged(ItemEvent e) {
    if (rb_Prod.isSelected()) {
      for (int i = 0; i < 18; i++) {
        txtPO[i].setEditable(false);
        txtStyle[i].setEditable(false);
      }
      /*
      if (!this._isCenSelected)
        cmboCen.setEnabled(this._isCenSelected);
      else
        cmboCen.setEnabled(this._isCenSelected);
      */
      /*
      cmboCen.setEnabled(true);
      cmboDep.setEnabled(true);
      cmboCen.setBackground(Color.WHITE );
      cmboDep.setBackground(Color.WHITE);
      slkProdBuyer.setEnabled(true);
      slkProdBuyer.setBackground(Color.WHITE);
      slkProdMaker.setEnabled(true);
      slkProdMaker.setBackground(Color.WHITE);
      cmboDiv.setEnabled(true);
      cmboDiv.setBackground(Color.WHITE);
      cmboSeason.setEnabled(true);
      cmboSeason.setBackground(Color.WHITE);
      txtYear.setEditable(true);
      txtRange.setEditable(true);
      */
      for (int x = 0; x < txtSC_NO.length; x++)
        txtSC_NO[x].setEditable(true);
    }
    if(defaultScNo!=null && txtSC_NO[0].getText().trim().length()==0){
      txtSC_NO[0].setText(new String(defaultScNo));
      defaultScNo=null;//turn it off.
      //return;
    }
  }

  void rb_PO_Style_itemStateChanged(ItemEvent e) {
    if (rb_PO_Style.isSelected()) {
      for (int i = 0; i < 18; i++) {
        txtPO[i].setEditable(true);
        txtStyle[i].setEditable(true);
      }
      /*
      cmboCen.setEnabled(false);
      cmboDep.setEnabled(false);
      cmboCen.setBackground(Color.GRAY);
      cmboDep.setBackground(Color.GRAY);
      slkProdBuyer.setEnabled(false);
      slkProdBuyer.setBackground(Color.GRAY);
      slkProdMaker.setEnabled(false);
      slkProdMaker.setBackground(Color.GRAY);
      cmboDiv.setEnabled(false);
      cmboDiv.setBackground(Color.GRAY);
      cmboSeason.setEnabled(false);
      cmboSeason.setBackground(Color.GRAY);
      txtYear.setEditable(false);
      txtRange.setEditable(false);
      */
      for (int x = 0; x < txtSC_NO.length; x++)
        txtSC_NO[x].setEditable(false);
    }
      if(defaultStylePo!=null &&txtPO[0].getText().trim().length()==0){
        txtPO[0].setText(defaultStylePo);
      }
      /*
      if(defaultStyleName!=null &&txtStyle[0].getText().trim().length()==0){
        txtStyle[0].setText(defaultStyleName);
      }*/

  }

  boolean checkFieldsData() {
    int po = 0;
    int style = 0;
    for (int y = 1; y <= 18; y++) {
      if (!txtPO[y - 1].getText().trim().equals(""))
        po++;
      if (!txtStyle[y - 1].getText().trim().equals(""))
        style++;
    }

    if (po == 0 && style == 0) {
      return false;
    } else {
      return true;
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
    try{
      processhandler.template.Properties.getCenteralControler().goBack();
      /*
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditShipMaster());
      */
    }catch(Exception ie){
      ie.printStackTrace();
    }
  }
  protected boolean isNthkScFound()throws Exception{
    StringBuffer sb = new StringBuffer();
    sb.append("select ");
     boolean hasSc=false;

    for (int i = 0; i < txtSC_NO.length; i++) {
      String str=txtSC_NO[i].getText().trim();
      if(str.length()>0){
        if(hasSc)sb.append(",");
        hasSc=true;
        sb.append("(select count(prod_sc_no) from production where prod_sc_no =");
        sb.append("'");sb.append(str);sb.append("')");sb.append(" as ");sb.append(
            util.MiscFunc.Replace(str,"-","_")
            );

          sb.append(",((select count(price.pri_seq)  ");
          sb.append("from price,style  ");
          sb.append("where  price.pri_sty_seq=style.sty_seq  ");
          sb.append("and price.record_delete_flag='1' ");
          sb.append("and style.record_delete_flag='1' ");
          sb.append("and sty_sc_no='");sb.append(str);sb.append("'");
          sb.append(")- ");
          sb.append("(select count(price.pri_seq)  ");
          sb.append("from price,style  ");
          sb.append("where  price.pri_sty_seq=style.sty_seq  ");
          sb.append("and price.record_delete_flag='1'  ");
          sb.append("and style.record_delete_flag='1' ");
          sb.append("and ((price.PRI_MKR_ACT_PRX is null ) and  (price.PRI_MKR_DOC_PRX is null))  ");
          sb.append("and sty_sc_no='");sb.append(str);sb.append("')) ");
          sb.append(" as ");sb.append(
                      util.MiscFunc.Replace(str,"-","_")
                      );
          sb.append("_unnullprx_count");


      }
    }
    if(hasSc){
      sb.append(" from dual ");
      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,sb.toString(),1,99999);
      if(vct.size()==0){
        exgui.verification.VerifyLib.showAlert("Sorry,S/C Not Found",
            "S/C No Not Found");
        return false;
      }
      Record rec=(Record)vct.get(0);
      StringBuffer sb2=new StringBuffer();
      StringBuffer sbCkNull=new StringBuffer();
      for (int i=0;i<rec.getFieldName().size();i++){
        String columnName=(String)rec.getFieldName().get(i);
        String sc_no=util.MiscFunc.Replace(columnName,"_","-");

        if(rec.getInt(i)==0){
          if(sb2.length()>0)sb2.append(",");
          sb2.append(sc_no);
        }

        if(rec.getInt(i+1)==0){
          if(sbCkNull.length()>0)sbCkNull.append(",");
          sbCkNull.append(sc_no);
        }

        i++;
      }
      if(sb2.length()>0){
        exgui.verification.VerifyLib.showAlert("S/C:"+sb2.toString()+" Not Found",
                                               "S/C Not Found");
        return false;
      }
      if(sbCkNull.length()>0){
        exgui.verification.VerifyLib.showAlert("All Maker Price of S/C:"+sbCkNull.toString()+" Are Not Set Yet",
                                               "Please Check Maker Price Of Detail");
        return false;
      }
    }
    return true;
  }
  protected boolean isNoneNthkScFound()throws Exception{
    StringBuffer sb = new StringBuffer();
    sb.append("select ");
     boolean hasSc=false;
    java.util.List noneBlankTextField=new java.util.ArrayList();
    for (int i = 0; i < txtSC_NO.length; i++) {
      String str=txtSC_NO[i].getText().trim();
      if(str.length()>5){
        if(hasSc)sb.append(",");
        noneBlankTextField.add(new Integer(i));
        hasSc=true;
        /*
        sb.append("(select count(prod_sc_no) from production where (prod_audit_status='7' or prod_audit_status='3') and  prod_sc_no =");
        sb.append("'");sb.append(str);sb.append("')");sb.append(" as ");sb.append(str);
        */
       sb.append("(select a.prod_sc_no from production a,prod_head b ");
       sb.append(" where a.prod_head_pk=b.prod_head_pk and b.prod_cen_code='");
       sb.append((String)util.PublicVariable.OPERATTING_CENTER);sb.append("' ");
       sb.append(" and a.record_delete_flag='1' ");
       sb.append(" and a.prod_sc_no like ");
       //sb.append(" and  (a.prod_audit_status='7' or a.prod_audit_status='3') and  a.prod_sc_no like ");
       sb.append("'%");sb.append(str);sb.append("' and rownum=1) ");sb.append(" as ");sb.append("A_");sb.append(str);

      }
    }
    if(hasSc){
      sb.append(" from dual ");
      java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,sb.toString(),1,99999);
      if(vct.size()==0){
        exgui.verification.VerifyLib.showAlert("Sorry,S/C Not Found\nOr PO is not Approve yet",
            "S/C No Not Found Or PO is not Approve yet");
        return false;
      }
      Record rec=(Record)vct.get(0);
      StringBuffer sb2=new StringBuffer();
      for (int i=0;i<rec.getFieldName().size();i++){
        String columnName=(String)rec.getFieldName().get(i);
        if(rec.get(i)==null){
          if(sb2.length()>0)sb2.append(",");
          sb2.append(columnName.substring(2,columnName.length()) );
        }else{
          txtSC_NO[((Integer)noneBlankTextField.get(i)).intValue()].setText(rec.get(i).toString());
        }
      }
      if(sb2.length()>0){
        exgui.verification.VerifyLib.showAlert("S/C:"+sb2.toString()+" Not Found Or PO is not Approve yet",
                                               "S/C Not Found Or PO is not Approve yet");
        return false;
      }
    }
    return true;
  }

  void btnQryStyles_actionPerformed(ActionEvent e) {
    try{
      if(rb_PO_Style.isSelected()){
        boolean hasPoStyle=false;
        for(int i=0;i<txtStyle.length;i++){
          JTextField txtXstyle=(JTextField)txtStyle[i];
          JTextField txtXpo=(JTextField)txtPO[i];
          if(txtXstyle.getText().trim().length()>0||txtXpo.getText().trim().length()>0){
           hasPoStyle=true;
           break;
          }
        }
        if(!hasPoStyle){
          exgui.verification.VerifyLib.showAlert(
              "Please Input Style/PO to search Style",
              "Please Input Style/PO to search Style");
                return;
        }
      }else{
        boolean hasSC=false;
        for(int i=0;i<txtSC_NO.length;i++){
          JTextField txtXSC=(JTextField)txtSC_NO[i];
          if(txtXSC.getText().trim().length()>5){
           hasSC=true;
           break;
          }
        }
        if(!hasSC){
          exgui.verification.VerifyLib.showAlert(
              "Please Input S/C to search Style",
              "Please Input S/C to search Style");
                return;
        }

      }
      //test if inputed SC is not existed,for user's miss type.
      if(rb_Prod.isSelected()){
        String centerCode=(String)util.PublicVariable.OPERATTING_CENTER;
        if(centerCode.equals("001")){

        }else if(centerCode.equals("NTHK")){
          if(!isNthkScFound())return;
        }else {
          if(!isNoneNthkScFound())return;
        }
      }
    }catch(Exception exp2){
        exp2.printStackTrace();
        util.ExceptionLog.exp2File(exp2,"");
        exgui.verification.VerifyLib.showAlert("Error While Checking S/C No ",
                                               "Error In Checking S/C No");
        return ;
    }
    try{
      //check if any SC No. does not match the prefix code(center/department) of this SRN.
      java.util.HashMap hm=getQueryConditionDatas();
      if(hm==null)return;
      //set condition to hash map
      //getQueryConditionDatas();
      newtimes.shipping_admin.ShippingAdmin_Const.HM_CONDITION_QRY_STYLES=hm;
      PnlListStyles2Add.rowPosition=-1;
      newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ=-1;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.shipping_admin.process.shiippingmaintain.TgrToListStyle2Add());
    }catch(Exception ie){
      ie.printStackTrace();
    }
  }

  void cmboCen_itemStateChanged(ItemEvent e) {
    try{

      //find out the vector to add dbDeps.
      if (dbCBX_Center.getSelectedValue()==null) {
        //only the all dep is allow to add now.
         dbCBX_Dep =
            new exgui.DataBindJCombobox(
            cmboDep,"USR_DEP_CODE",
            new Vector(),
            "DEP_NAME", "DEP_CODE",
            (String)recToMapping.get("USR_DEP_CODE"),
            "ALL", null);
      }else {
        //deps and "ALL"dep allow to add.
        Vector depVects=
            (Vector)tempProperties.tmpH_tbl_CenterDepMap.get(
            dbCBX_Center.getSelectedValue());
         dbCBX_Dep=null;
        if(depVects==null){

          dbCBX_Dep =
             new exgui.DataBindJCombobox(
             cmboDep, "USR_DEP_CODE",
             new Vector(),
             "DEP_NAME", "DEP_CODE",
             (String)recToMapping.get("USR_DEP_CODE"),
             "ALL", null);

        }else if(depVects.size()>1){
           dbCBX_Dep =
              new exgui.DataBindJCombobox(
              cmboDep, "USR_DEP_CODE",
              depVects,
              "DEP_NAME", "DEP_CODE",
              recToMapping.get("USR_DEP_CODE"),
              "ALL", null);
          //guis.add(DbJcbxcbxDep);
        }else{
          dbCBX_Dep =
              new exgui.DataBindJCombobox(
              cmboDep, "USR_DEP_CODE",
              depVects,
              "DEP_NAME", "DEP_CODE",
              recToMapping.get("USR_DEP_CODE"));
          //guis.add(DbJcbxcbxDep);
        }

      }

    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

}

class myText extends javax.swing.JTextField  {
   public myText(){super();}
   public myText(String title){
     super(title);
   }
   public void setEditable(boolean enable){
     if(enable)
       setBackground(Color.white);
     else
       setBackground(Color.GRAY);
     super.setEditable(enable);
   }

   public void setEnabled(boolean enable){
     if(enable)
       setBackground(Color.white);
     else
       setBackground(Color.GRAY);
     super.setEnabled(enable);
   }
}
