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

public class ChainDlgPoNoFtyInvListPo extends JPanel implements exgui.chaindialog.Responsible {
  BorderLayout borderLayout1 = new BorderLayout();
  Responsible nextResonsibale;
  PnlListPO pnlList=null;
  public ChainDlgPoNoFtyInvListPo() {
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
    iso.put("ASN DATE","ASN_DATE");
    //iso.put("S/C NO","prod_sc_no");
    iso.put(" ASN# ","ASN_NO");
    iso.put("Fty Inv#","VENDORINV_NO");
    iso.put("  PO  ","sty_po");
    iso.put("  STYLE  ","sty_style");
    Hashtable ht=new Hashtable();
    pnlList=new PnlListPO(new DbEng(),10,iso,ht);
    pnlList.setPreferredSize(new java.awt.Dimension(600,300));

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
     //storedMap.put("INIT_ASN", (String)rec.get("asn_no"));
     newtimes.shipping_admin.ShippingAdmin_Const.INIT_ASN_CODE=(String)rec.get("asn_no");

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
   String custPo=util.MiscFunc.Replace((String)storedMap.get("CUST_PO"),"'","''").toUpperCase();
   String ftyInv=util.MiscFunc.Replace((String)storedMap.get("FTY_INV_PO"),"'","''").toUpperCase();
   DbEng(){
     newtimes.shipping_admin.ShippingAdmin_Const.INIT_QRY_LAUREN_PO=custPo;
     newtimes.shipping_admin.ShippingAdmin_Const.INIT_QRY_LAUREN_FTY_INV=ftyInv;
    StringBuffer sb=new StringBuffer();
    sb.append("select  distinct ");
    //§ï¥Îhk code
    sb.append("(select bymkr_HK_CODE from buyer_maker where bymkr_seq=a.prod_buyer) as buyer, ");
    sb.append("(select BYMKR_NAME from buyer_maker where bymkr_seq=a.prod_maker) as maker, ");
    sb.append("b.PROD_BYR_SC_NO as po_buyer_sc_no, ");
    sb.append("b.prod_sc_no ");
    sb.append(",d.asn_no ");
    sb.append(",d.vendorinv_no ");
    sb.append(",c.sty_po ");
    sb.append(",c.sty_style ");
    sb.append(",d.asn_date ");
    sb.append(",c.sty_seq ");
    sb.append("from  prod_head a,production b,asn_upload d ,style c ");
    sb.append("where 1=1  ");
    if(util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_ABROAD_USERS){
       sb.append(" and a.PROD_OFFSHORE_CENTER='");
       sb.append(newtimes.shipping_admin.ShippingAdmin_Const.OFFSHORE_CENTER);sb.append("' ");
    }
    sb.append("and b.prod_head_pk=a.prod_head_pk ");
    sb.append("and c.prod_head_pk=a.prod_head_pk ");
    sb.append("and c.sty_seq=d.sty_seq ");
    /*
    sb.append("and trim(b.PROD_BYR_SC_NO)=trim(d.PO_NO) ");
    sb.append("and trim(c.sty_po)=trim(d.PO_NO) ");
    sb.append("and trim(c.sty_style)=trim(d.style_NO) ");
    */
    sb.append("and d.sty_seq is not null ");
    sb.append("and a.prod_cen_code='");
    sb.append(util.PublicVariable.OPERATTING_CENTER.toString());sb.append("' ");
    if(custPo!=null && custPo.trim().length()>0){
      sb.append("and ");
      sb.append("b.PROD_BYR_SC_NO like '%");sb.append(custPo);sb.append("%' ");
    }
    if(ftyInv!=null && ftyInv.trim().length()>0){
      sb.append("and ");
      sb.append("d.vendorinv_no like '%");sb.append(ftyInv);sb.append("%' ");
    }
    sb.append("and a.record_delete_flag='1'  ");
    sb.append("and b.prod_sc_no is not null ");
    sql=sb.toString();
   }
    public Vector getRecordsByPseudoAsn(String poNo,String orgSeq)throws Exception{
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
      java.util.HashMap hm=new java.util.HashMap();
      hm.put("TPEMISCFUNC_ACTION_CODE","PSUEDO_ASN_HANDLE");
      hm.put("AXN_CODE","INIT_SRN");
      hm.put("SYS_MISC_SEC",String.valueOf(System.currentTimeMillis()));
      hm.put("PO_NOs",new String[]{poNo});
      ejb.tpeMisFunc(hm);
      Vector vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         orgSeq,1,99999);
      return vct;
    }
    public Vector  getRecords(int bgn,int row)throws Exception{
      try{
        util.MiscFunc.showProcessingMessage();
        Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            sql, bgn, row);
        if (vct.size() > 0)return vct;
        if (custPo != null && custPo.trim().length() > 0) {
          return getRecordsByPseudoAsn(custPo, sql);
        }
        return vct;
      }finally{
        util.MiscFunc.hideProcessingMessage();
      }

       //return vct;
    }
  }

}
