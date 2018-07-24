package newtimes.production.process.audit_sc_ct;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class SCCT_CmdSets implements
    AbleToListProdConfirm ,AbleToEditAudit{
  public SCCT_CmdSets() {
  }
  public void toListProdConfirm()throws Exception{
     ToListProdConfirm cmdToListPrdList=new ToListProdConfirm();
     cmdToListPrdList.toListProdConfirm();
  }
  public void toEditAudit()throws Exception{
    ToEditAudit cmdAdtEdt=new ToEditAudit();
    cmdAdtEdt.toEditAudit();
  }
}
