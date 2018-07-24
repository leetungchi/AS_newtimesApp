package newtimes.production.process.prodmaintain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToListNthkStylesNoProdHead extends ToListStylesNoProdHead {
  public ToListNthkStylesNoProdHead() {
  }
  public void toListStylesNoProdHead()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlNTHKStyleList.SHIP_DRUP_DEST_AT=-1;
      newtimes.production.gui.prodmaintain.PnlNTHKStyleList  pnl=
          new newtimes.production.gui.prodmaintain.PnlNTHKStyleList();
      pnl.setPreferredSize(
         new java.awt.Dimension(300,200)
       );
      super.addLowerPanel("STYLE LIST",pnl);
      //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        pnl.IS_EDIT_AFTER_SHIPPED=false;
        setFunctionButtonStatus(true,true,true,true,true,false);
      }else{
        pnl.IS_EDIT_AFTER_SHIPPED=true;
        if(util.PublicVariable.OPERATTING_CENTER.equals("NTFE")){
          setFunctionButtonStatus(false,false,false,false,false,false);
        }else{
          setFunctionButtonStatus(true,true,true,true,true,false);
        }
        //setFunctionButtonStatus(false,false,true,false,false,false);
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

      processhandler.template.Properties.getSplitFrame().jSplitPane.setDividerSize(0);

      processhandler.template.Properties.getSplitFrame().addExtraTriggerButton("To Head",
        new newtimes.preproduction.process.TrggerEditAPreprod());

    String sc_no=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
    String today=new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date(System.currentTimeMillis())) ;
    String createUser=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("record_create_user");
    StringBuffer sb=new StringBuffer();
    sb.append(today); sb.append(" ");
    sb.append("USER ID:");sb.append(util.PublicVariable.USER_RECORD.get(0)); sb.append(" ");
    sb.append("Create By:");sb.append(createUser); sb.append(" ");
    sb.append("S/C: ");sb.append(sc_no);sb.append(" ");
    sb.append("REF NO: ");sb.append(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(0));
    util.PublicVariable.APP_FRAME.setTitle(sb.toString());

      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);

      if(pnl.getJtable().getRowCount()>0){
              for(int i=0;i<pnl.getJtable().getRowCount();i++){
                if(pnl.getJtable().isCellEditable(i,0)){
                  final int getRow=i;
                  final newtimes.production.gui.prodmaintain.PnlNTHKStyleList tmpPnl=pnl;
                  javax.swing.SwingUtilities.invokeLater(
                   new Runnable(){
                    public void run() {
                      tmpPnl.getJtable().changeSelection(getRow, 0, false, false);
                      tmpPnl.getJtable().editCellAt(getRow, 0);
                     ((javax.swing.text.JTextComponent)tmpPnl.getJtable().
                      getEditorComponent()).grabFocus();
                     ((javax.swing.text.JTextComponent)tmpPnl.getJtable().
                     getEditorComponent()).selectAll();
                   }
                   }

                  );
                  break;
                }
              }
              pnl.getMultiEditorJTable().getTableLayingScrollPanel().getHorizontalScrollBar().setValue(0);
            }

    /*
      if(pnl.getJtable().getRowCount()>0){
        for(int i=0;i<pnl.getJtable().getRowCount();i++){
          if(pnl.getJtable().isCellEditable(i,0)){
            pnl.getJtable().changeSelection(i,0,false,false);
            pnl.getJtable().editCellAt(i,0);
            ((javax.swing.text.JTextComponent)pnl.getJtable().getEditorComponent()).grabFocus();
            ((javax.swing.text.JTextComponent)pnl.getJtable().getEditorComponent()).selectAll();
            break;
          }
        }
      }*/

    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }

}
