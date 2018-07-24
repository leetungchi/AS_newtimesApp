package newtimes.production.process.prodmaintain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class NTD_ProdMaintain_CmdSet extends NTHK_ProdMaintain_CmdSet
  implements AbleToListColorPcixAndBoard{
  ToListColorPcixBoard cmdToListColorPcixBoard=null;
  public NTD_ProdMaintain_CmdSet() {
    super();
    setCommandButtons();
  }
  public void setCommandButtons(){
    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL=new
        newtimes.preproduction.guis.PnlTabbedButtons();
    String tgrStyStringNtfe[] = {
        "Sty/PO",
        //"PCIX/BOARD",
        "C/T HEAD",
        "Extra",
        "PS",
        "Print Draf",
        "S/C Desc",
        "C/T Desc",
        "ORDER PRINT"

    };

    //"Handling Charge" removed at 0925,depends on production change form
    java.util.List tgrStyList = new java.util.ArrayList();
    tgrStyList.add(new TgrToListStylesNoProdHead()); //sty
    //tgrStyList.add(new TgrToListColorPcixBoard()); //PCIX/BOARD in color--this is only for NTD upload

    tgrStyList.add(new TgrToListNthkCtInfor()); //C/T Head
    tgrStyList.add(new TgrToEdit_SC_Head()); //Extra
    tgrStyList.add(new TgrToListStyle_PS_List()); //ps
    tgrStyList.add(new TgrToEditSty_SC_SndCfm()); //print draft
    tgrStyList.add(new TgrToEditStyScDesc()); //SCdesc
    tgrStyList.add(new TgrToEditStyCtDesc()); //CTdesc
    tgrStyList.add(new newtimes.production.process.prodmaintain.TgrToGotoOderPrint()); //other
    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.
        setButtonActions(
        tgrStyStringNtfe,
        tgrStyList);
  }

  public void toListColorPcixAndBoard() throws Exception{
      if(cmdToListColorPcixBoard==null) cmdToListColorPcixBoard=new ToListColorPcixBoard();
      cmdToListColorPcixBoard.toListColorPcixAndBoard();
  }
}
