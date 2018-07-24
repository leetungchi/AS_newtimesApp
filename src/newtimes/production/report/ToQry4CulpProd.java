package newtimes.production.report;
public class ToQry4CulpProd implements AbleToQry4CulpProd{
  public ToQry4CulpProd() {

  }
  public void toQry4CulpProd()throws Exception{
  	//set upper panel to qry culp panel
       //set panel to blank panel
       newtimes.production.ProdMaintain_Properties.setWaitCursor();
       javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
       try{
         System.out.println("is report engine ok ? "+
                            newtimes.production.report.ReportCmdSet.myReportEngin.checkOk());
          javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
          tempDownPnl.setLayout(new java.awt.BorderLayout());
          tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
          processhandler.template.Properties.getSplitFrame().setPanel(
             new PnlQry4CulpProd(),
             tempDownPnl
           );
          processhandler.template.Properties.getSplitFrame().setDividerLocation(0.4);
          newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
              setFunctionButtonStatus(
              false, false, false, false,false,false,false);
          processhandler.template.Properties.getSplitFrame().validate();
          processhandler.template.Properties.getSplitFrame().repaint();

          jframe.getContentPane().removeAll();
          jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());

          jframe.validate();
          jframe.repaint();

       }finally{
          newtimes.production.ProdMaintain_Properties.setNormalCursor();
       }

  }
}
