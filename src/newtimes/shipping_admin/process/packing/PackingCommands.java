package newtimes.shipping_admin.process.packing;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PackingCommands extends newtimes.shipping_admin.process.shiippingmaintain.ShippingAdmCmdSet
    implements
    AbleToListStyles2Add,
    AbleToListAddedStyles,
    AbleToEditPackingStyle,
    AbleToViewPackingBySRN{
    ToListStyles2Add cmdTolistsStylesAdd=new ToListStyles2Add();
    //ToListAddedStyles cmdToListAddedStyles=new ToListAddedStyles();
    ToEditPackingStyle cmdToEditPackingStyle=new ToEditPackingStyle();
    ToViewPackingBySRN cmdToViewPackingBySRN=new ToViewPackingBySRN();
  public PackingCommands() {

  }
  public void toListStyles2Add()throws processhandler.commands.CommandException{
    cmdTolistsStylesAdd.toListStyles2Add();
  }
  /*
  public void toListAddedStyles() throws processhandler.commands.CommandException{
    cmdToListAddedStyles.toListAddedStyles();
  }*/
  public void toEditPackingStyle() throws processhandler.commands.CommandException{
    cmdToEditPackingStyle.toEditPackingStyle();
  }
  public void toViewPackingBySRN() throws processhandler.commands.CommandException{
    cmdToViewPackingBySRN.toViewPackingBySRN();
  }
}
