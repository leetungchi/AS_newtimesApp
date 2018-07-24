package newtimes.production.process.prodmaintain;
import newtimes.production.process.prodmaintain.DB_FbcClrQty;
import database.datatype.Record;
import newtimes.production.gui.prodmaintain.PnlListStyleConsumption;
public class ToListStyleConsumption extends ToCheckB4StyleProc  implements AbleToListStyleConsumption{
  static java.util.Hashtable objstrcnv=new java.util.Hashtable();
  public ToListStyleConsumption() {
  }
  public util.InsertionOrderedHashMap getColumHeadMapping(){
    try{
    util.InsertionOrderedHashMap  columnMapping = new util.InsertionOrderedHashMap();
      columnMapping.put(PnlListStyleConsumption.DISP_CLM_FBRC_PO, "FCQ_SEQ");
      //columnMapping.put(PnlListStyleConsumption.DISP_CLM_COLOR_NAME, "fcqx_COLOR_NAME");
      //columnMapping.put(PnlListStyleConsumption.DISP_CLM_COLOR_CODE, "fcqx_COLOR_CODE");

      Record styRec = newtimes.production.ProdMaintain_Properties.
          EDITING_STYLE_RECORD;
      Object yy1StyVlu = styRec.get("sty_yy1");
      String strYY1 = (yy1StyVlu == null) ? "N/A" : yy1StyVlu.toString();
      PnlListStyleConsumption.STY_YY1_VALUE=(yy1StyVlu == null) ? 0 : Float.parseFloat(yy1StyVlu.toString());
      Object yy2StyVlu = styRec.get("sty_yy2");
      String strYY2 = (yy2StyVlu == null) ? "N/A" : yy2StyVlu.toString();
      PnlListStyleConsumption.STY_YY2_VALUE=(yy2StyVlu == null) ? 0 : Float.parseFloat(yy2StyVlu.toString());
      Object yy3StyVlu = styRec.get("sty_yy3");
      String strYY3 = (yy3StyVlu == null) ? "N/A" : yy3StyVlu.toString();
      PnlListStyleConsumption.STY_YY3_VALUE=(yy3StyVlu == null) ? 0 : Float.parseFloat(yy3StyVlu.toString());
      Object yy4StyVlu = styRec.get("sty_yy4");
      String strYY4 = (yy4StyVlu == null) ? "N/A" : yy4StyVlu.toString();
      PnlListStyleConsumption.STY_YY4_VALUE=(yy4StyVlu == null) ? 0 : Float.parseFloat(yy4StyVlu.toString());
      PnlListStyleConsumption.DISP_CLM_YY1="YY1("+strYY1+")";
      PnlListStyleConsumption.DISP_CLM_YY2="YY2("+strYY2+")";
      PnlListStyleConsumption.DISP_CLM_YY3="YY3("+strYY3+")";
      PnlListStyleConsumption.DISP_CLM_YY4="YY4("+strYY4+")";
      columnMapping.put(PnlListStyleConsumption.DISP_CLM_YY1,
                        "FCQD_STY_QTY1");
      columnMapping.put(PnlListStyleConsumption.DISP_CLM_YY2,
                        "FCQD_STY_QTY2");
      columnMapping.put(PnlListStyleConsumption.DISP_CLM_YY3,
                        "FCQD_STY_QTY3");
      columnMapping.put(PnlListStyleConsumption.DISP_CLM_YY4,
                        "FCQD_STY_QTY4");
      columnMapping.put(PnlListStyleConsumption.DISP_SUMMED_YIELD,
                        "fcqx_total_yield");
      return columnMapping;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
  public void toListStyleConsumption()throws Exception{
  	//System.out.println("toListStyleConsumption is not implemented");
          javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
          java.awt.Cursor ksr=jframe.getContentPane().getCursor();
          try{
            jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            if(!isStyleRecordSelected())
              throw new processhandler.commands.CommandIncompleteException();
            /*
            if(newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(2)==null||
               newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(3)==null){
              exgui.verification.VerifyLib.showAlert("Style or PO are not defined",
                                                     "Style ,PO not defined");
              return;
            }
           */
      DB_FbcClrQty db=new DB_FbcClrQty();
            if((db.fabricpo!=null) &&
                (db.fabricpo.size()>0)){
               newtimes.production.gui.prodmaintain.PnlListStyleConsumption pnl=
                   new newtimes.production.gui.prodmaintain.PnlListStyleConsumption(
                   db,99999,getColumHeadMapping(),objstrcnv,null,db.fabricpo);
              pnl.setPreferredSize(new java.awt.Dimension(150,150));

              Object styObj =
                  newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(2);
              Object poObj =
                  newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(3);


              addLowerPanel(
               "========Style Consumption edit========<br>"+"STYLE:"+
               ((styObj==null)?"":styObj.toString()) +
               "  P.O:"+((poObj==null)?"":poObj.toString())
               ,pnl);
              processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
              if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
                setFunctionButtonStatus(true,true,true,true,true,false);
              }else{
                setFunctionButtonStatus(false,false,true,false,false,false);
              }
              /*
              if(newtimes.production.ProdMaintain_Properties.
                 isProductionAuditConfirmedOrPrinted()){
                 if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")!=
                    newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
                    && util.PublicVariable.OPERATTING_CENTER.equals("001")){
                    setFunctionButtonStatus(false,false,true,false,false,false);
                 }else{
                    setFunctionButtonStatus(true,true,true,true,true,false);//allow mis user to modify record
                 }
              }else{
                  setFunctionButtonStatus(true,true,true,true,true,false);
              }*/


              //setFunctionButtonStatus(true,true,true,true,true,false);
              pnl.firstPage();
              if(pnl.getJtable().getRowCount()>0){
                 pnl.getJtable().changeSelection(0,0,false,false);
              }
            }
            jframe.repaint();
          }finally{
            jframe.getContentPane().setCursor(ksr);
          }
  }
}
