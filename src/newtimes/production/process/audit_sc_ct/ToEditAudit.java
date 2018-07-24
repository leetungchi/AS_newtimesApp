package newtimes.production.process.audit_sc_ct;
public class ToEditAudit implements AbleToEditAudit{
  public ToEditAudit() {

  }
  public void toEditAudit()throws Exception{
  	//System.out.println("toEditAudit is not implemented");
          newtimes.production.ProdMaintain_Properties.setWaitCursor();
          try{
            newtimes.production.gui.audit_sc_ct.PnlAuditDataList pnlAuditDataList=
                new newtimes.production.gui.audit_sc_ct.PnlAuditDataList();
            if(!pnlAuditDataList.isInitOK()){
            	throw new processhandler.commands.CommandIncompleteException();
            }

            newtimes.production.gui.audit_sc_ct.PnlAuditHistory  pnl=
                new newtimes.production.gui.audit_sc_ct.PnlAuditHistory(
                       pnlAuditDataList,
                       pnlAuditDataList.getAuditDbHanlder());
            pnlAuditDataList.firstPage();
            pnl.setPreferredSize(new java.awt.Dimension(780,450));
            processhandler.template.Properties.getSplitFrame().setUpperPanel(pnl);
            //only manager whom were sent confirm for this production is able to confirm or reject
            String usrCode=(String)
                util.PublicVariable.USER_RECORD.get("usr_code");
            if(!usrCode.equals(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PROD_CONFIRM_MNG"))){
              pnl.btnConfirmOK.setEnabled(false);
              pnl.btnReject.setEnabled(false);
            }

            newtimes.production.gui.prodmaintain.PnlSC_CT_SndCnfm    pnlRptView=
                new newtimes.production.gui.prodmaintain.PnlSC_CT_SndCnfm(
                newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
            pnlRptView.cbxMgr2Cnfm.setVisible(false);
            pnlRptView.setPreferredSize(new java.awt.Dimension(780,300));
            pnlRptView.btnSendConfirm.setVisible(false);


            processhandler.template.Properties.getSplitFrame().setLowerPanel(pnlRptView);
            processhandler.template.Properties.getSplitFrame().setDividerLocation(0.5);
            processhandler.template.Properties.getSplitFrame().repaint();
            newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
                setFunctionButtonStatus(
                false, false, false, false,false,false);
            /*
            processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
            processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
            processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
            processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
            processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(false);
            processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
            */
            processhandler.template.Properties.getSplitFrame().butnEdit.setText("CONFIRM EDIT");
            processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
          }finally{
             newtimes.production.ProdMaintain_Properties.setNormalCursor();
          }

  }

}
