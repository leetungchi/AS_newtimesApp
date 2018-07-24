package exgui;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlCenterSelections extends JPanel {
  protected BorderLayout borderLayout1 = new BorderLayout();
  protected java.util.HashMap hmSelectableCenter=null,hmSeqJChkCbxCenterMap2Code=null;
  protected java.awt.GridLayout gridLayout1=null;
  protected javax.swing.JCheckBox chkCbxCenters[];
  public PnlCenterSelections() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void setCenterCammaString(String centerString){makeCenterSelections(centerString);}
  public String getCenterCammaString(){
    StringBuffer sbBelongedCenter=new StringBuffer();
    for(int i=0;i<chkCbxCenters.length;i++){
       if(chkCbxCenters[i].isSelected()){
          String centerCode=(String)hmSeqJChkCbxCenterMap2Code.get(String.valueOf(i));
          sbBelongedCenter.append(",");
          sbBelongedCenter.append(centerCode);
          sbBelongedCenter.append(",");
       }
    }
    return sbBelongedCenter.toString();
  }
  protected void makeCenterSelections(String str){
     if(str==null)str="";
      try{
        if(hmSelectableCenter==null){

          this.removeAll();
             java.util.Vector centers=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
             "select CEN_CODE, CEN_NAME from center where record_delete_flag='1' order by cen_name",
             1,99999);
           hmSelectableCenter=new java.util.HashMap();
           hmSeqJChkCbxCenterMap2Code=new java.util.HashMap();
           chkCbxCenters=new JCheckBox[centers.size()];
           gridLayout1=new java.awt.GridLayout(centers.size(),1);
           this.setLayout(gridLayout1);
            for(int i=0;i<centers.size();i++){
             database.datatype.Record recCenter=
                 (database.datatype.Record)centers.get(i);
             chkCbxCenters[i]=new JCheckBox();
             chkCbxCenters[i].setText((String)recCenter.get(1));
             hmSelectableCenter.put((String)recCenter.get(0),chkCbxCenters[i]);
             hmSeqJChkCbxCenterMap2Code.put(String.valueOf(i),(String)recCenter.get(0));
             this.add(chkCbxCenters[i]);
           }

           java.util.Iterator itr=hmSelectableCenter.keySet().iterator();
           while(itr.hasNext()){
             String key=(String)itr.next();
             JCheckBox chkCbx=(JCheckBox)hmSelectableCenter.get(key);
             if(str.indexOf(","+key+",")!=-1){
               chkCbx.setSelected(true);
             }else{
               chkCbx.setSelected(false);
             }
           }

        }else{
          java.util.Iterator itr=hmSelectableCenter.keySet().iterator();
          while(itr.hasNext()){
            String key=(String)itr.next();
            JCheckBox chkCbx=(JCheckBox)hmSelectableCenter.get(key);
            if(str.indexOf(","+key+",")!=-1){
              chkCbx.setSelected(true);
            }else{
              chkCbx.setSelected(false);
            }
          }
        }
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Error While Generating Centers List\nPlease Contatc System Manager",
                                               "Error At Server Side");
      }
  }

  protected void jbInit() throws Exception {
    this.setLayout(borderLayout1);
  }
}
