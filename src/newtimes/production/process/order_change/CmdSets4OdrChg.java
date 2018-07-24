package newtimes.production.process.order_change;

public class CmdSets4OdrChg implements
    AbleToChangePrice ,AbleToChangeQty,
    AbleToFieldsModify ,AbleToInputSCNO,
    AbleToGenOdrChgReport,AbleToListStyle,
    AbleToEditScRemark,AbleToEditCtRemark,
    AbleToGenCtOdrChgReport{
  public CmdSets4OdrChg(){
  }
  public void toGenCtOdrChgReport() throws processhandler.commands.CommandException{
    ToGenCtOdrChgReport cmdToGenCtOdrChgReport=new ToGenCtOdrChgReport();
    cmdToGenCtOdrChgReport.toGenCtOdrChgReport();
  }
  public void toChangePrice()throws Exception{
    ToChangePrice cmd2ChgPrx=new ToChangePrice();
    cmd2ChgPrx.toChangePrice();
  }
  public void toChangeQty()throws Exception{
    ToChangeQty cmd2ChgQty=new ToChangeQty();
    cmd2ChgQty.toChangeQty();

  }
  public void toFieldsModify()throws Exception{
    ToFieldsModify  cmd2FldMdfy=new ToFieldsModify();
    cmd2FldMdfy.toFieldsModify();
  }
  public void toInputSCNO()throws Exception{
    ToInputSCNO  cmd2InputScNo=new ToInputSCNO();
    cmd2InputScNo.toInputSCNO();
  }
  public void toListStyle()throws Exception{
    ToListStyle cmd2ListSty=new ToListStyle();
    cmd2ListSty.toListStyle();
  }
  public void toEditScRemark()throws Exception{
    ToEditScRemark cmd=new ToEditScRemark();
    cmd.toEditScRemark();

  }
  public void toEditCtRemark()throws Exception{
    ToEditCtRemark cmd=new ToEditCtRemark();
    cmd.toEditCtRemark();
  }

  public void toGenOdrChgReport()throws Exception{
    ToGenOdrChgReport cmd2GenChgReport=new ToGenOdrChgReport();
    cmd2GenChgReport.toGenOdrChgReport();
  }
}
