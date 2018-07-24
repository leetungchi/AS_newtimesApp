package newtimes.shipping_admin.guis.shippingmaintain;

import java.awt.*;
import javax.swing.JPanel;
import java.util.*;
import exgui.chaindialog.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ChainDlgCustNoListPo extends JPanel implements exgui.chaindialog.Responsible {
  BorderLayout borderLayout1 = new BorderLayout();
  Responsible nextResonsibale;
  PnlListPO pnlList=null;
  public ChainDlgCustNoListPo() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public javax.swing.JComponent getGUI(){
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("buyer","buyer");
    iso.put("maker","maker");
    iso.put("S/C NO","prod_sc_no");
    iso.put("STYLE","sty_style");
    iso.put("PO","sty_po");
    Hashtable ht=new Hashtable();
    pnlList=new PnlListPO(new DbEng(),10,iso,ht);
    pnlList.firstPage();
    this.removeAll();
    this.add(pnlList,borderLayout1.CENTER);
    return this;
  }
  public void setDefalutNext(Responsible dfltRsp){
    nextResonsibale=dfltRsp;

  }
  public Responsible next()throws NextResponsibleIsNotReady{
   if(pnlList.getJtable().getSelectedRow()==-1){
     exgui.verification.VerifyLib.showAlert("Please Select A Row","Please Select A Row");
     throw new NextResponsibleIsNotReady();
   }
   database.datatype.Record rec=(database.datatype.Record)pnlList.getDisplayingRecords().get(
      pnlList.getJtable().getSelectedRow());
   try{
     storedMap.put("SC_NO", (String)rec.get("prod_sc_no"));
   }catch(Exception exp){
     exp.printStackTrace();
   }
    return nextResonsibale;
  }
  public boolean isAllowOkNow(){
    return true;
  }

  void jbInit() throws Exception {
     this.setLayout(borderLayout1);
  }
  class PnlListPO extends exgui.ultratable.PagedTablePanel{
    PnlListPO(exgui.ultratable.PagedDataFactory pagedDataFxy,
        int rowlength,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor
    ){
      super(pagedDataFxy,rowlength,columnMapping,object2StringConvertor);
    }
  }
  class DbEng extends exgui.ultratable.PagedDataFactoryAdapter{
   String sql;
   String custPo=util.MiscFunc.Replace((String)storedMap.get("CUST_PO"),"'","''");
   DbEng(){
    StringBuffer sb=new StringBuffer();
    sb.append("select  ");
    sb.append("(select bymkr_addr1 from buyer_maker where bymkr_seq=a.prod_buyer) as buyer_addr1,");
    sb.append("(select bymkr_addr2 from buyer_maker where bymkr_seq=a.prod_buyer) as buyer_addr2,");
    sb.append("(select bymkr_addr3 from buyer_maker where bymkr_seq=a.prod_buyer) as buyer_addr3,");
    sb.append("(select bymkr_addr4 from buyer_maker where bymkr_seq=a.prod_buyer) as buyer_addr4,");

    sb.append("(select bymkr_addr1 from buyer_maker where bymkr_seq=a.prod_maker) as maker_addr1,");
    sb.append("(select bymkr_addr2 from buyer_maker where bymkr_seq=a.prod_maker) as maker_addr2,");
    sb.append("(select bymkr_addr3 from buyer_maker where bymkr_seq=a.prod_maker) as maker_addr3,");
    sb.append("(select bymkr_addr4 from buyer_maker where bymkr_seq=a.prod_maker) as maker_addr4,");

    sb.append("(select bymkr_chinese_brief from buyer_maker where bymkr_seq=a.prod_buyer) as buyer, ");
    sb.append("(select bymkr_chinese_brief from buyer_maker where bymkr_seq=a.prod_maker) as maker, ");
    sb.append("b.PROD_BYR_SC_NO as po_buyer_sc_no, ");
    sb.append("c.sty_style, ");
    sb.append("c.sty_po, ");
    sb.append("b.prod_sc_no ");
    sb.append("from  prod_head a,production b,style c ");
    sb.append("where 1=1  ");
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
       sb.append(" and a.PROD_OFFSHORE_CENTER='");
       sb.append(newtimes.shipping_admin.ShippingAdmin_Const.OFFSHORE_CENTER);sb.append("' ");
    }
    sb.append("and b.prod_head_pk=a.prod_head_pk ");
    sb.append("and a.prod_head_pk=c.prod_head_pk ");
    sb.append("and a.prod_cen_code='");
    sb.append(util.PublicVariable.OPERATTING_CENTER.toString());sb.append("' ");
    sb.append("and ");
    sb.append("(b.PROD_BYR_SC_NO like '%");sb.append(custPo);sb.append("%' or ");
    sb.append("c.sty_po like '%");sb.append(custPo);sb.append("%') ");
    sb.append("and a.record_delete_flag='1'  ");
    sb.append("and c.record_delete_flag='1'  ");
    if("NTD".equals(util.PublicVariable.OPERATTING_CENTER)){
     sb.append("and (select count(*) from style where style.record_create_user='NDANTHONYLIU' and style.sty_img is not null ");
     sb.append(" and style.prod_head_pk=b.prod_head_pk)=0 ");
    }
    sb.append("and b.prod_sc_no is not null ");
    /*
    sb.append("select ");
    sb.append("(select bymkr_brief from buyer_maker where bymkr_seq=a.prod_buyer) as buyer, ");
    sb.append("(select bymkr_brief from buyer_maker where bymkr_seq=a.prod_maker) as maker, ");
    sb.append("b.prod_sc_no ");
    sb.append("from prod_head a,production b ");
    sb.append("where ");
    sb.append("a.prod_head_pk=b.prod_head_pk ");
    sb.append("and a.record_delete_flag='1' ");
    sb.append("and a.prod_cen_code='");
    sb.append(util.PublicVariable.OPERATTING_CENTER.toString());sb.append("'");
    sb.append("and ");
    sb.append("(b.PROD_BYR_SC_NO like '%");sb.append(custPo);sb.append("%' or ");
    sb.append(" b.prod_head_pk in ");
    sb.append("(select prod_head_pk from style where sty_po like '%");
    sb.append(custPo);sb.append("%' and record_delete_flag='1'))  ");*/

    sql=sb.toString();
   }

    public Vector  getRecords(int bgn,int row)throws Exception{
      util.MiscFunc.showProcessingMessage();
      Vector vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sql,bgn,row);
       util.MiscFunc.hideProcessingMessage();
       return vct;
    }
  }

}
