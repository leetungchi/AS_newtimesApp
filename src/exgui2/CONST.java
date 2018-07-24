package exgui2;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
/* 傳回 ejb 入口名稱*/

public class CONST {
  public static BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB BASIC_MAIN_EJB =
    (BasicMdlEJBs.BasicMaintainEJB.BasicMaintainEJB)util.ApplicationProperites.getProperties("basicMainEJB");
  public static BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB BASIC_BASE_EJB =
    (BasicMdlEJBs.BasicBaseEJB.BasicBaseEJB)util.ApplicationProperites.getProperties("basicEJB");
  public static BasicMdlEJBs.SystemValueEJB.SystemValueEJB SYSTEM_VALUE_EJB =
    (BasicMdlEJBs.SystemValueEJB.SystemValueEJB)util.ApplicationProperites.getProperties("sysValueEJB");
  public static ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJB STYLE_CLOSE_EJB =
    (ShippingMdlEJBs.ShipStyleCloseEJB.ShipStyleCloseEJB)util.ApplicationProperites.getProperties("shipStyCloseEJB");
  public static ShippingMdlEJBs.ShipMaintainEJB.ShipMaintainEJB SHIP_MAIN_EJB =
    (ShippingMdlEJBs.ShipMaintainEJB.ShipMaintainEJB)util.ApplicationProperites.getProperties("shipMainEJB");
  public static ShippingMdlEJBs.ShipAddDetailEJB.ShipAddDetailEJB SHIP_DETAIL_EJB =
    (ShippingMdlEJBs.ShipAddDetailEJB.ShipAddDetailEJB)util.ApplicationProperites.getProperties("shipDetailEJB");
  public static ShippingMdlEJBs.ShipStyleEJB.ShipStyleEJB SHIP_STYLE_EJB =
    (ShippingMdlEJBs.ShipStyleEJB.ShipStyleEJB)util.ApplicationProperites.getProperties("shipStyleEJB");
  public static ShippingMdlEJBs.ShipQTYEJB.ShipQTYEJB SHIP_QTY_EJB =
    (ShippingMdlEJBs.ShipQTYEJB.ShipQTYEJB)util.ApplicationProperites.getProperties("shipQtyEJB");
  public static ShippingMdlEJBs.SC_List_EJB.SC_List_EJB SC_LIST_EJB =
    (ShippingMdlEJBs.SC_List_EJB.SC_List_EJB)util.ApplicationProperites.getProperties("scListEJB");
  public static ReportEJBs.PPSEJB.PPSEJB PPS_EJB =
    (ReportEJBs.PPSEJB.PPSEJB)util.ApplicationProperites.getProperties("ppsEJB");
  public static ReportEJBs.QuotaEmbargoEJB.QuotaEmbargoEJB QTA_EMBARGO_EJB =
    (ReportEJBs.QuotaEmbargoEJB.QuotaEmbargoEJB)util.ApplicationProperites.getProperties("qtaEmbargoEJB");
  public static MaterialMdlEJBs.StickerEJB.StickerData Sticker_EJB=
    (MaterialMdlEJBs.StickerEJB.StickerData)util.ApplicationProperites.getProperties("materialStickerEJB");
  public static MaterialMdlEJBs.MaterialEJB.MtrEJB Material_EJB =
    (MaterialMdlEJBs.MaterialEJB.MtrEJB)util.ApplicationProperites.getProperties("materialEJB");
  public static MaterialMdlEJBs.MaterialDtlEJB.MtrDtlEJB Material_Dtl_EJB =
    (MaterialMdlEJBs.MaterialDtlEJB.MtrDtlEJB)util.ApplicationProperites.getProperties("materialDtlEJB");
  public static MaterialMdlEJBs.MaterialHistEJB.MtrHistEJB Material_Hist_EJB =
    (MaterialMdlEJBs.MaterialHistEJB.MtrHistEJB)util.ApplicationProperites.getProperties("materialHistEJB");
  public static ShippingMdlEJBs.ShipPriceEJB.ShipPriceEJB SHIP_PRICE_EJB =
    (ShippingMdlEJBs.ShipPriceEJB.ShipPriceEJB)util.ApplicationProperites.getProperties("shipPrxEJB");
  public CONST() {}
}
