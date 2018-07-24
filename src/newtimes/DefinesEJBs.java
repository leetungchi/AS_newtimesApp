package newtimes;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DefinesEJBs {

  public DefinesEJBs() {
  }

  public static void setEJBs() {
    try {
      System.out.println("Server URL: "+util.PublicVariable.SERVER_URL.toString());
      //----------------------- Defined EJBs -----------------------------------
      BasicMdlEJBs.BasicBaseEJB.BasicBaseEJBHome basicBase_ejb_home = (BasicMdlEJBs.BasicBaseEJB.BasicBaseEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB");
      BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJBHome basicMain_ejb_home = (BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB");
      BasicMdlEJBs.SystemValueEJB.SystemValueEJBHome sysValue_ejb_home = (BasicMdlEJBs.SystemValueEJB.SystemValueEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"BasicMdlEJBs.SystemValueEJB.SystemValueEJB");
      ShippingMdlEJBs.ShipMaintainEJB.ShipMaintainEJBHome shipMain_ejb_home = (ShippingMdlEJBs.ShipMaintainEJB.ShipMaintainEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ShippingMdlEJBs.ShipMaintainEJB.ShipMaintainEJB");
      ShippingMdlEJBs.ShipAddDetailEJB.ShipAddDetailEJBHome shipAddDetail_ejb_home = (ShippingMdlEJBs.ShipAddDetailEJB.ShipAddDetailEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ShippingMdlEJBs.ShipAddDetailEJB.ShipAddDetailEJB");
      ShippingMdlEJBs.SC_List_EJB.SC_List_EJBHome scList_ejb_home = (ShippingMdlEJBs.SC_List_EJB.SC_List_EJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ShippingMdlEJBs.SC_List_EJB.SC_List_EJB");
      ShippingMdlEJBs.ShipQTYEJB.ShipQTYEJBHome shipQTY_ejb_home = (ShippingMdlEJBs.ShipQTYEJB.ShipQTYEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ShippingMdlEJBs.ShipQTYEJB.ShipQTYEJB");
      ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJBHome shipStyClose_ejb_home = (ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJB");
      ShippingMdlEJBs.ShipStyleEJB.ShipStyleEJBHome shipStyle_ejb_home = (ShippingMdlEJBs.ShipStyleEJB.ShipStyleEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ShippingMdlEJBs.ShipStyleEJB.ShipStyleEJB");
      ShippingMdlEJBs.ShipPriceEJB.ShipPriceEJBHome shipPrx_ejb_home = (ShippingMdlEJBs.ShipPriceEJB.ShipPriceEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ShippingMdlEJBs.ShipPriceEJB.ShipPriceEJB");

      BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB basicEJB = basicBase_ejb_home.create();
      BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB basicMainEJB = basicMain_ejb_home.create();
      BasicMdlEJBs.SystemValueEJB.SystemValueEJB sysValueEJB = sysValue_ejb_home.create();
      ShippingMdlEJBs.ShipMaintainEJB.ShipMaintainEJB shipMainEJB = shipMain_ejb_home.create();
      ShippingMdlEJBs.ShipAddDetailEJB.ShipAddDetailEJB shipDetailEJB = shipAddDetail_ejb_home.create();
      ShippingMdlEJBs.SC_List_EJB.SC_List_EJB scListEJB = scList_ejb_home.create();
      ShippingMdlEJBs.ShipQTYEJB.ShipQTYEJB shipQtyEJB = shipQTY_ejb_home.create();
      ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJB shipStyCloseEJB = shipStyClose_ejb_home.create();
      ShippingMdlEJBs.ShipStyleEJB.ShipStyleEJB shipStyleEJB = shipStyle_ejb_home.create();
      ShippingMdlEJBs.ShipPriceEJB.ShipPriceEJB shipPrxEJB = shipPrx_ejb_home.create();

      util.ApplicationProperites.setProperties("basicMainEJB", basicMainEJB);
      util.ApplicationProperites.setProperties("basicEJB", basicEJB);
      util.ApplicationProperites.setProperties("sysValueEJB", sysValueEJB);
      util.ApplicationProperites.setProperties("shipMainEJB", shipMainEJB);
      util.ApplicationProperites.setProperties("shipDetailEJB", shipDetailEJB);
      util.ApplicationProperites.setProperties("scListEJB", scListEJB);
      util.ApplicationProperites.setProperties("shipQtyEJB", shipQtyEJB);
      util.ApplicationProperites.setProperties("shipStyCloseEJB", shipStyCloseEJB);
      util.ApplicationProperites.setProperties("shipStyleEJB", shipStyleEJB);
      util.ApplicationProperites.setProperties("shipPrxEJB", shipPrxEJB);

      //--------------Added by Mos---------------------------------------
      //MaterialMdlEJBs.MaterialEJB.MtrEJBHome mtrEjbHome = (MaterialMdlEJBs.MaterialEJB.MtrEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome("172.16.0.26","MaterialMdlEJBs.MaterialEJB.MtrEJB");//util.PublicVariable.SERVER_URL
      MaterialMdlEJBs.MaterialEJB.MtrEJBHome mtrEjbHome = (MaterialMdlEJBs.MaterialEJB.MtrEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"MaterialMdlEJBs.MaterialEJB.MtrEJB");
      MaterialMdlEJBs.MaterialEJB.MtrEJB materialEJB = mtrEjbHome.create();
      util.ApplicationProperites.setProperties("materialEJB", materialEJB);

      MaterialMdlEJBs.MaterialDtlEJB.MtrDtlEJBHome mtrDtlEjbHome = (MaterialMdlEJBs.MaterialDtlEJB.MtrDtlEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"MaterialMdlEJBs.MaterialDtlEJB.MtrDtlEJB");
      MaterialMdlEJBs.MaterialDtlEJB.MtrDtlEJB materialDtlEJB = mtrDtlEjbHome.create();
      util.ApplicationProperites.setProperties("materialDtlEJB", materialDtlEJB);

      MaterialMdlEJBs.MaterialHistEJB.MtrHistEJBHome mtrHistEjbHome = (MaterialMdlEJBs.MaterialHistEJB.MtrHistEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"MaterialMdlEJBs.MaterialHistEJB.MtrHistEJB");
      MaterialMdlEJBs.MaterialHistEJB.MtrHistEJB materialHistEJB = mtrHistEjbHome.create();
      util.ApplicationProperites.setProperties("materialHistEJB", materialHistEJB);

      MaterialMdlEJBs.StickerEJB.StickerDataHome mtrStickerEjbHome = (MaterialMdlEJBs.StickerEJB.StickerDataHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"MaterialMdlEJBs.StickerEJB.StickerData");
      MaterialMdlEJBs.StickerEJB.StickerData mtrStickerEjb = mtrStickerEjbHome.create();
      util.ApplicationProperites.setProperties("materialStickerEJB", mtrStickerEjb);

      //-------------Report Module(GUI) EJB---------------------------------
      ReportEJBs.RepGMTLC.GMTLcHome gmtLcHome = (ReportEJBs.RepGMTLC.GMTLcHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ReportEJBs.RepGMTLC.GMTLc");
      ReportEJBs.RepGMTLC.GMTLc gmtLcEJB = gmtLcHome.create();
      util.ApplicationProperites.setProperties("gmtLcEJB", gmtLcEJB);

      ReportEJBs.RepGMTPendLC.GMTPendLcHome gmtPendLcHome = (ReportEJBs.RepGMTPendLC.GMTPendLcHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ReportEJBs.RepGMTPendLC.GMTPendLc");
      ReportEJBs.RepGMTPendLC.GMTPendLc gmtPendLcEJB = gmtPendLcHome.create();
      util.ApplicationProperites.setProperties("gmtPendLcEJB", gmtPendLcEJB);

      ReportEJBs.RepPsEJB.RepPSHome repPsHome = (ReportEJBs.RepPsEJB.RepPSHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ReportEJBs.RepPsEJB.RepPS");
      ReportEJBs.RepPsEJB.RepPS repPsEJB = repPsHome.create();
      util.ApplicationProperites.setProperties("repPsEJB", repPsEJB);

      ReportEJBs.PPSEJB.PPSEJBHome ppsHome = (ReportEJBs.PPSEJB.PPSEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ReportEJBs.PPSEJB.PPSEJB");
      ReportEJBs.PPSEJB.PPSEJB ppsEJB = ppsHome.create();
      util.ApplicationProperites.setProperties("ppsEJB", ppsEJB);

      ReportEJBs.QuotaEmbargoEJB.QuotaEmbargoEJBHome qtaEmbargoHome = (ReportEJBs.QuotaEmbargoEJB.QuotaEmbargoEJBHome)info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,"ReportEJBs.QuotaEmbargoEJB.QuotaEmbargoEJB");
      ReportEJBs.QuotaEmbargoEJB.QuotaEmbargoEJB qtaEmbargoEJB = qtaEmbargoHome.create();
      util.ApplicationProperites.setProperties("qtaEmbargoEJB", qtaEmbargoEJB);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}