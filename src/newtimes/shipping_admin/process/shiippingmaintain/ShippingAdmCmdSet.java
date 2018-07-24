package newtimes.shipping_admin.process.shiippingmaintain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ShippingAdmCmdSet
    implements
    AbleToAddShipMaster,
    AbleToAddSty2Shipping,
    AbleToEditAddedStyle,
    AbleToEditShipMaster,
    AbleToListAddedStyles,
    AbleToListStyle2Add,
    AbleToQryAddedStyles,
    AbleToQryScStyPo4Style,
    AbleToQryShipMaster,AbleToListShippingMaster,
    AbleToDirectListShipStyles,
    AbleToListToEditSI,AbleToEdit_SI
    {
  ToAddShipMaster cmdToAddShipMaster=new ToAddShipMaster();
  ToAddSty2Shipping cmdToAddSty2Shipping=new ToAddSty2Shipping();
  ToEditAddedStyle cmdToEditAddedStyle=new ToEditAddedStyle();
  ToEditShipMaster cmdToEditShipMaster=new ToEditShipMaster();

  ToListStyle2Add cmdToListStyle2Add=new ToListStyle2Add();
  ToQryAddedStyles cmdToQryAddedStyles=new ToQryAddedStyles();
  ToQryScStyPo4Style cmdToQryScStyPo4Style=new ToQryScStyPo4Style();
  ToQryShipMaster cmdToQryShipMaster=new ToQryShipMaster();
  ToListShippingMaster  cmdToListShipppingMaster=new ToListShippingMaster();
  ToDirectListShipStyles cmdToDirectListShipStyles=new ToDirectListShipStyles();
  ToListToEditSI cmdToListToEditSI=new ToListToEditSI();
  ToEdit_SI    cmdToEdit_SI   =new ToEdit_SI();
  //ToQryShipMaster cmd2QryShipMaster =new ToQryShipMaster();
  //ToAddShipMaster cmd2AddShipMaster=new ToAddShipMaster();
  public ShippingAdmCmdSet() {

  }
   public void  toListToEditSI()throws processhandler.commands.CommandException{
       cmdToListToEditSI.toListToEditSI();
   }
   public void  toEdit_SI()throws processhandler.commands.CommandException{
       cmdToEdit_SI.toEdit_SI();
   }

   public void  toAddShipMaster(){cmdToAddShipMaster.toAddShipMaster();}
   public void  toAddSty2Shipping(){cmdToAddSty2Shipping.toAddSty2Shipping(); }
   public void  toEditAddedStyle(){cmdToEditAddedStyle.toEditAddedStyle();}
   public void  toEditShipMaster(){cmdToEditShipMaster.toEditShipMaster();}
   public void  toListAddedStyles(){
     ToListAddedStyles cmdToListAddedStyles=new ToListAddedStyles();
     cmdToListAddedStyles.toListAddedStyles();
   }
   public void  toListStyle2Add(){cmdToListStyle2Add.toListStyle2Add();}
   public void  toQryAddedStyles(){
     cmdToQryAddedStyles.toQryAddedStyles();
   }
   public void  toQryScStyPo4Style(){cmdToQryScStyPo4Style.toQryScStyPo4Style();}
   public void  toQryShipMaster(){cmdToQryShipMaster.toQryShipMaster();}
   public void  toDirectListShipStyles(){
     cmdToDirectListShipStyles.toDirectListShipStyles();
   }
   public void  toListShippingMaster() throws processhandler.commands.CommandException{
     cmdToListShipppingMaster.toListShippingMaster();}
}
