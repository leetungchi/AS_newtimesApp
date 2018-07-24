package newtimes.nthk_accounting_enqry;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;

public class TgrListShipLackDetail extends CommandTrigger {
  static util.InsertionOrderedHashMap iso=null;
  public TgrListShipLackDetail() {

  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().
        setSystemCommander(
        newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
    commander = processhandler.template.Properties.getCenteralControler().
        getCurrentSystemCommand();
    ctnCtl.recordProcess(this); //store this node as "go back" required

    if(iso==null){
     iso=new util.InsertionOrderedHashMap();
     iso.put("SHIP NO","SHIP_NO");
     iso.put("DEPARTMENT","DEPT");
     iso.put("ETD\nDATE","ETD_DATE");
     iso.put("BUYER NAME","buyer_name");
     iso.put("MAKER NAME","maker_name");
     iso.put("CREATE\nDate","CREATE_DATE");
     iso.put("CREATE\nUSER  ","record_create_user");
    }
    javax.swing.JFrame jframe = processhandler.template.Properties.
        getMainFrame();
    jframe.getContentPane().removeAll();
    jframe.getContentPane().setCursor(new Cursor(
        Cursor.WAIT_CURSOR));
    PnlListShipLackDetail pnl=
        new PnlListShipLackDetail(new DbListShipLackDtl(),13,iso,new java.util.Hashtable());
    pnl.setSize(800, 500);
    pnl.pgTblList.firstPage();
    jframe.getContentPane().add(pnl);
    jframe.repaint();
    jframe.show();

  }
  class DbListShipLackDtl extends exgui.ultratable.PagedDataFactoryAdapter{

    public java.util.Vector getRecords(int bgn,int rowcount)throws Exception{
      util.MiscFunc.showProcessingMessage();
      try{
        StringBuffer sb = new StringBuffer();
        sb.append("select a.ship_no,b.prod_head_pk, ");
        sb.append("(select buyer_maker.BYMKR_NAME from buyer_maker where bymkr_seq=pd.prod_buyer) as buyer_name, ");
        sb.append("(select buyer_maker.BYMKR_NAME from buyer_maker where bymkr_seq=pd.prod_maker) as maker_name, ");
        sb.append("to_char(a.record_create_date,'YYYY/MM/DD') as create_Date, ");
        sb.append("a.record_create_user, ");
        sb.append("to_char(a.ship_etd_date,'YYYY/MM/DD') as ETD_Date, ");
        sb.append(
            "(select department.DEP_NAME from department where dep_code=pd.PROD_DEPTMENT ");
        sb.append("and department.DEP_CEN_CODE=pd.prod_cen_code) as dept  ");
        sb.append("from shipping a,ship_sc b,prod_head pd ");
        sb.append("where  ");
        sb.append("a.ship_no =b.ship_no(+) and ");
        sb.append("b.record_delete_flag='1' ");
        sb.append("and a.record_delete_flag='1' ");
        sb.append("and b.prod_head_pk =pd.prod_head_pk ");
        sb.append("and pd.prod_cen_code='");
        sb.append(util.PublicVariable.OPERATTING_CENTER);
        sb.append("'");

        sb.append(" and (select count(c.ship_style_pk) from ship_style c ");
        sb.append("where c.ship_sc_pk=b.ship_sc_pk and c.record_delete_flag='1')=0 ");

        java.util.Vector vct =
            exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            sb.toString(), bgn, rowcount);
        return vct;
      }finally{
        util.MiscFunc.hideProcessingMessage();
      }
    }

  }
}
