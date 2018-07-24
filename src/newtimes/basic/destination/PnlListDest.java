package newtimes.basic.destination;
import java.awt.*;
import exgui.ultratable.AbstractUltraTablePanel;
import exgui.ultratable.*;
import javax.swing.JButton;
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

public class PnlListDest
    extends AbstractUltraTablePanel{
  BorderLayout borderLayout1 = new BorderLayout();
  JButton btnAdd=new JButton("ADD");
  JButton btnEdit=new JButton("EDIT");
  JButton btnDLT=new JButton("DELETE");
  JButton btnExit=new JButton("EXIT");
  public PnlListDest() {
    super();
    try {
      //this.setLayout(borderLayout1); <----please be aware of this setting. is very terrible

      btnAdd.setFont(new java.awt.Font("Dialog", 1, 11));
      btnEdit.setFont(new java.awt.Font("Dialog", 1, 11));
      btnDLT.setFont(new java.awt.Font("Dialog", 1, 11));
      btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
      btnAdd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnAdd_actionPerformed(e);
        }
      });
      btnExit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnExit_actionPerformed(e);
        }
      });
      btnDLT.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          btnDLT_actionPerformed(e);
        }
      });

      btnEdit.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e) {
          tableClick();
        }
      });

      getLowerRightPanel().add(btnAdd,null);
      getLowerRightPanel().add(btnEdit,null);
      getLowerRightPanel().add(btnDLT,null);
      getLowerRightPanel().add(btnExit,null);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }


  void tableClick(){
    int rowNo=getJtable().getSelectedRow();
    if(rowNo<0){
        exgui.verification.VerifyLib.showPlanMsg("PLease Select A Row To EDIT",
                                                 "Please Select A Record");
        return;
      }

    DlgEditDestination dlg=
        new DlgEditDestination(
          processhandler.template.Properties.jframe,
          "Modify Destination Name",true);
    dlg.setSize(440,350);
    Record rec=(Record)getDisplayingRecords().get(rowNo);
    String oldString=(String)rec.get(1);
    if(oldString==null)oldString="";
    dlg.lblOrgDestString.setText(oldString);
    dlg.show();
    if(dlg.getDialogStatus()==dlg.STATUS_CLOSE_NORMALLY){
      String newString =dlg.txtNewDestString.getText();
      if(!newString.trim().toUpperCase().equals(oldString.trim().toUpperCase())){
        try{
          newtimes.production.ProdMaintain_Properties.setWaitCursor();
          util.MiscFunc.showProcessingMessage();
          rec.set(1, newString.trim().toUpperCase());
          rec.set("record_modify_user",
                  util.PublicVariable.USER_RECORD.get("USR_CODE"));
          java.util.Vector vct = new java.util.Vector();
          vct.add(rec);
          dbHandler.updateRecords(vct);
          reload();
          //exgui.verification.VerifyLib.showPlanMsg("UPDATE OK","UPDATE OK");
        }catch(javax.ejb.EJBException   ejbexp){
          util.MiscFunc.hideProcessingMessage();
          util.ExceptionLog.exp2File(ejbexp,"udpate destination,rec is "+rec.toString());
          exgui.verification.VerifyLib.showAlert("Update Fail!!\nPleaes Contact System Manager",
                                                 "Update Fail!!");

        }catch(java.rmi.RemoteException  rexp){
          util.MiscFunc.hideProcessingMessage();
          util.ExceptionLog.exp2File(rexp,"udpate destination,rec is "+rec.toString());
          exgui.verification.VerifyLib.showAlert("Update Fail!!\nPleaes Contact System Manager",
                                                 "Update Fail!!");
        }catch(Exception exp){
          util.MiscFunc.hideProcessingMessage();
           util.ExceptionLog.exp2File(exp,"udpate destination,rec is "+rec.toString());
           exgui.verification.VerifyLib.showAlert("Update Fail!!\nPleaes Contact System Manager",
                                                  "Update Fail!!");
        }finally{
          util.MiscFunc.hideProcessingMessage();
          newtimes.production.ProdMaintain_Properties.setNormalCursor();
        }
      }
    }
  }
void btnDLT_actionPerformed(ActionEvent e){
  if(getJtable().getSelectedRow()<0){
      exgui.verification.VerifyLib.showPlanMsg("PLease Select A Row To Delete",
                                               "Please Select A Record");
      return;
    }
    Record rec=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
    try{
      util.MiscFunc.showProcessingMessage();
    //rec.set("record_delete_flag",0);
    dbHandler.deleteRecord(rec);
    reload();
    //exgui.verification.VerifyLib.showPlanMsg("DELETE OK","DELTE OK");
  } catch (javax.ejb.EJBException ejbexp) {
    util.ExceptionLog.exp2File(ejbexp, "");
    exgui.verification.VerifyLib.showAlert(
        "Update Fail!!\nPleaes Contact System Manager",
        "Update Fail!!");

  } catch (java.rmi.RemoteException rexp) {
    util.ExceptionLog.exp2File(rexp, "");
    exgui.verification.VerifyLib.showAlert(
        "Update Fail!!\nPleaes Contact System Manager",
        "Update Fail!!");
  } catch (Exception exp) {
    util.ExceptionLog.exp2File(exp, "");
    exgui.verification.VerifyLib.showAlert(
        "Update Fail!!\nPleaes Contact System Manager",
        "Update Fail!!");
  } finally {
    util.MiscFunc.hideProcessingMessage();
    newtimes.production.ProdMaintain_Properties.setNormalCursor();
  }
 }
  void btnAdd_actionPerformed(ActionEvent e){
    DlgBchAddDestination dlg=
        new DlgBchAddDestination(processhandler.template.Properties.jframe,
          "Modify Destination Name",true);
    dlg.setSize(440,300);
    dlg.show();
    String str[]=dlg.getDestStrings();
    java.util.Vector vct=new java.util.Vector();
    try{
      for (int i = 0; i < str.length; i++) {
        if (str[i].trim().length() > 0) {
          Record tmpRec = dbHandler.getBlankRecord();
          tmpRec.set(1, str[i].trim().toUpperCase());
          vct.add(tmpRec);
        }
      }

      if(vct.size()>0){
        util.MiscFunc.showProcessingMessage();
        dbHandler.updateRecords(vct);
        reload();
        //exgui.verification.VerifyLib.showPlanMsg("INSERT OK", "INSERT OK");
      }
    }catch(javax.ejb.EJBException   ejbexp){
      util.ExceptionLog.exp2File(ejbexp,"");
      exgui.verification.VerifyLib.showAlert("Update Fail!!\nPleaes Contact System Manager",
                                             "Update Fail!!");

    }catch(java.rmi.RemoteException  rexp){
      util.ExceptionLog.exp2File(rexp,"");
      exgui.verification.VerifyLib.showAlert("Update Fail!!\nPleaes Contact System Manager",
                                             "Update Fail!!");
    }catch(Exception exp){
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Update Fail!!\nPleaes Contact System Manager",
                                              "Update Fail!!");
    }finally{
      util.MiscFunc.hideProcessingMessage();
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }


  }
  void btnExit_actionPerformed(ActionEvent e){
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    util.ApplicationProperites.removeProperites("allData");
    newtimes.Frame1 frame=(newtimes.Frame1)processhandler.template.Properties.jframe;
    frame.showPanel(new newtimes.basic.BasicMenu(frame));
    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }

  protected  void refineEditors(MultiEditorJTable multiEditorJTableInSuper){
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
  }
  protected Record setObject2Record(Record rec,int columnAt,Object value2update){
        return null;
  }
  protected PagedDataFactory getPagedDataFactory(){
     DB_Destinations db=DB_Destinations.getInstance();
     return db;
  }
  protected util.InsertionOrderedHashMap getHeadColumnMap(){
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("                  Destination Name                     ","DEST_NAME");
    return iso;
  }
  protected java.util.Hashtable getObject2StringConvertor(){
    return new java.util.Hashtable();
  }
  protected int getEachPageRowCount(){return 100;}

}
