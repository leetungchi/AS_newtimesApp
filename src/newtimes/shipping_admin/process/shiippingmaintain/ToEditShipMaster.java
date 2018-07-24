package newtimes.shipping_admin.process.shiippingmaintain;
import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
public class ToEditShipMaster implements AbleToEditShipMaster{
  public ToEditShipMaster() {

  }
  public void toEditShipMaster(){
    int pageHeight=907+60;
    try{
      boolean isAble2Delete=true;
      boolean isXCenter=false;
      if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
        if(util.PublicVariable.USER_RECORD.getInt(2)!=
           newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
          isAble2Delete=false;
        }
      }else{
        //for delete button,only eric have right to delete
        isAble2Delete=newtimes.shipping_admin.ShippingAdmin_Const.isUserEric();
      }
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      javax.swing.JFrame jframe = processhandler.template.Properties.
          getMainFrame();

          //new newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster();
      newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster pnl =null;
          if(util.PublicVariable.OPERATTING_CENTER.equals("001")||
             util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
             pnl=new newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster();
             isXCenter=false;
           }else{
             if("BW".equals(util.PublicVariable.OPERATTING_CENTER)||
                "PW".equals(util.PublicVariable.OPERATTING_CENTER)||
                "NTD".equals(util.PublicVariable.OPERATTING_CENTER)){
                if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
                  pnl = new newtimes.shipping_admin.guis.shippingmaintain.PnlShipMasterPwBwLauren();
                }else{
                  pnl = new newtimes.shipping_admin.guis.shippingmaintain.PnlShipMasterPWBW();
                }
             }else{
               pnl =new newtimes.shipping_admin.guis.shippingmaintain.PnlShipMasterNTFE();
               pageHeight=1120;
             }

             isXCenter=true;
          }


      pnl.lblShipStaff.setVisible(true);
      pnl.txtShipStaffCode.setVisible(true);

      pnl.setPagedDataFactory(
          newtimes.shipping_admin.ShippingAdmin_Const.DB_SHIP_SRN_HEAD_HANDLER
          );

      pnl.setRecord(
          newtimes.shipping_admin.ShippingAdmin_Const.
          SHIPPING_EDITING_HEAD_RECORD
          );
      jframe.getContentPane().removeAll();
      pnl.setBounds(0,0,774,907+60);
      //pnl.PnlShipExtra.setEnabled(true);
      pnl.setEnableShipExtraPanel(true);
      String shipShipPanelTitle="SRN DATA EDIT,SRN:"+newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("SHIP_NO");
      pnl.lblTItleBar.setText(shipShipPanelTitle);
      if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
        shipShipPanelTitle+=" CREATE BY:"+
            newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("record_create_user");
        pnl.lblTItleBar.setText(shipShipPanelTitle);
      }
      newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN=
           (String)newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(0);

       newtimes.shipping_admin.PnlBaseContainer pnlFunc =
           new newtimes.shipping_admin.PnlBaseContainer();
       newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL =
           pnlFunc;


       if(
             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(pnl.COLUMN_INDEX_ship_agent)==null &&
             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(pnl.COLUMN_INDEX_ship_prc_trm)==null &&
             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(pnl.COLUMN_INDEX_ship_prx_term_dest)==null &&
             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(pnl.COLUMN_INDEX_SHIP_PAYMENT_TERM)==null &&
             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(pnl.COLUMN_INDEX_ship_dest)==null &&
             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(pnl.COLUMN_INDEX_ship_USA_port)==null &&
             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(pnl.COLUMN_INDEX_ship_ic_sea)==null &&
             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(pnl.COLUMN_INDEX_ship_bill_to)==null &&
             newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get(pnl.COLUMN_INDEX_ship_ship_to)==null

         ){
           //since this is add without S/C,can not go further.
         pnlFunc.setButtons(false, true, true, true,isAble2Delete);
         pnlFunc.removalAddExtralButtons();
         pnlFunc.addTriggerButton(pnl.JBUTTON_CAPTION_INI_BY_LATTER_PRODUCTION,
                                  new newtimes.shipping_admin.process.
                                  shiippingmaintain.TgrToInitShipMasterByLatterSc(pnl));

       }else{
         if(!newtimes.shipping_admin.ShippingAdmin_Const.isShipClosed()){
           pnl.txtShip_IC_date.setEditable(true);
           pnl.txtShipDate.setEditable(true);
           pnl.txtShipETAdate.setEditable(true);
           pnl.txtShipETDdate.setEditable(true);
           pnlFunc.setButtons(false, true, true, true, isAble2Delete);
         }else{
           pnl.txtShip_IC_date.setEditable(false);
           pnl.txtShipDate.setEditable(false);
           pnl.txtShipETAdate.setEditable(false);
           pnl.txtShipETDdate.setEditable(false);
           pnlFunc.setButtons(false, false, true, false, false);
         }
         pnlFunc.removalAddExtralButtons();
         if(isXCenter){
           pnlFunc.addTriggerButton("To Enquiry",
                                    new newtimes.shipping_admin.process.shiippingmaintain.TgrToQryShipMaster());
           pnlFunc.addTriggerButton("PRINT SRN",
                                    new newtimes.shipping_admin.process.
                                    shiippingmaintain.TgrToReportUnit()
                                    );
         }
         if(util.PublicVariable.OPERATTING_CENTER.equals("001") &&
            util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
           javax.swing.JButton btnReInit=new javax.swing.JButton("Re-Init");
            btnReInit.setFont(new java.awt.Font("Dialog", 1, 11));
            btnReInit.addActionListener(new clsReInitAdp(pnl));
            pnlFunc.PnlExtraFunctions.add(btnReInit);
         }
         pnlFunc.addTriggerButton("Detail Records",
                                  new newtimes.shipping_admin.process.
                                  shiippingmaintain.TgrToListAddedStyles());
       }
      //pnlFunc.setPreferredSize(new java.awt.Dimension(800,590));
      jframe.getContentPane().add(pnlFunc,null);
      pnlFunc.setEditPanel(pnl);

      pnl.record2Gui();
      if(isXCenter){
        //for the NONE-NTHK/001 center, Country of orgin is as the part of srn,can not modify after srn head create.
        pnl.cbxShipOrgCnty.setEnabled(false);
      }

      //pnlFunc.validate();
      //pnlFunc.repaint();
      //pnl.setPreferredSize(new java.awt.Dimension(775, 580));
      //pnl.setPreferredSize(new java.awt.Dimension(775, 720));
      pnl.setPreferredSize(new java.awt.Dimension(774, pageHeight));

      pnl.repaint();
      pnl.validate();

      pnlFunc.setBounds(0, 0, 790, 580);
      pnlFunc.repaint();
      pnlFunc.validate();

      newtimes.shipping_admin.ShippingAdmin_Const.pnlQryStylesByScPo=null;
      jframe.repaint();
      jframe.validate();
    }catch(Exception e){
       e.printStackTrace();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  public void reInit(newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster pnl)throws Exception{
    String result=JOptionPane.showInputDialog(
     util.PublicVariable.APP_FRAME,
      "Please Input S/C No:","Re-init by S/C",
      JOptionPane.QUESTION_MESSAGE);
    if(result==null)return;
    if(result.trim().length()==0){
      return;
    }
    if(result.trim().length()<"SATWJJ400039".length()){
      exgui.verification.VerifyLib.showAlert("S/C# length mis-match","Legnth Mis-Match");
      return;
    }
    //search sc no.
    java.util.Vector vctTest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       "select prod_head_pk from production where prod_sc_no='"+result.trim()+"'",1,999999);
     if(vctTest.size()==0){
       exgui.verification.VerifyLib.showAlert("No Such S/C#","No Such S/C");
     }else{
       Record rectst=(Record)vctTest.get(0);
       int pk=rectst.getInt(0);
       database.datatype.Record prod_rec= newtimes.preproduction.process.DB_Preprod.getInstance().findbyPk(pk);
       Record rec=pnl.getProcessingRecord();
       rec.set("ship_agent",prod_rec.get("production_brnch_brief"));
       rec.set("ship_prc_trm",prod_rec.get("production_sc_prc_trm"));
       rec.set("ship_dest",prod_rec.get("production_sc_dest"));
       rec.set("ship_USA_port",prod_rec.get("production_tgt_dest"));
       rec.set("ship_ic_div",prod_rec.get("prod_buyer_division"));
       rec.set("ship_ic_sea",prod_rec.get("prod_season"));
       rec.set("ship_bill_to",prod_rec.get("prod_buyer"));
       rec.set("ship_ship_to",prod_rec.get("prod_buyer"));
       rec.set("ship_dep",prod_rec.get("prod_deptment"));
       if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
         rec.set(pnl.COLUMN_INDEX_SHIP_PAYMENT_TERM,
                 prod_rec.get("PRODuction_PYT_TRM"));
       }
       pnl.setRecord(rec);
       newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD=rec;
       pnl.record2Gui();
     }
  }
  class clsReInitAdp implements java.awt.event.ActionListener{
      newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster _pnl;
      clsReInitAdp(newtimes.shipping_admin.guis.shippingmaintain.PnlShipMaster pnl){
        _pnl=pnl;
      }
      public void actionPerformed(java.awt.event.ActionEvent e) {
        try{
          reInit(_pnl);
        }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"");
        }
      }
  }

}
