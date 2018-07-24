package util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public interface Constants {
  //public String ServerUrl="localhost";//local host
  public String ServerUrl="localhost";//local host
  public String UsrEJB="UsrMdlEJB.UserEJB";
  public String UsrRecord="Production.mastermaintain.UserRecord";
  public String mainFrame="Production.mastermaintain.ApplicationMainFrame";
  public String UsingProdRecord="Production.mastermaintain.ProductionRecord";

  public String Str_usingCenName="Production.mastermaintain.usingCenName";
  public String Str_usingCenCode="Production.mastermaintain.usingCenCode";
  public String Str_usingDepName="Production.mastermaintain.usingDepName";
  public String Str_usingDepCode="Production.mastermaintain.usingDepCode";
  public String Str_usingMngName="Production.mastermaintain.usingMngName";
  public String Str_usingMngCode="Production.mastermaintain.usingMngCode";
  public String Str_ProdLayOutName="Production.mastermaintain.Str_ProdLayOutName";
  public String Str_ProdLayOutCode="Production.mastermaintain.Str_ProdLayOutCode";
  public String HM_QUERY_SCR002="Production.mastermaintain.HM_QUERY_SCR002";
  public String INT_QUERY_SCR002_START_POSITION="Production.mastermaintain.INT_QUERY_SCR002_START_POSITION";

  public String Vct_Byr="Production.mastermaintain.Buyers";
  public String Vct_Szn="Production.mastermaintain.Seasons";
  public String Vct_Ftys="Production.mastermaintain.Factories";
  public String Vct_Divs="Production.mastermaintain.Divisions";
  public String Vct_prodType="Production.mastermaintain.ProductionType";
  public String Vct_Country="Production.mastermaintain.Country";
  public String Vct_Quota="Production.mastermaintain.Quota";
  public String Vct_City="Production.mastermaintain.City";
  public String Vct_Plan="Production.mastermaintain.Plan";
  public String Vct_ByrMkrAndTypes="Production.mastermaintain.Vct_ByrMkrAndTypes";

  public int AXN4PROD_REQ_ADD_PRODUCTION=0x1001;
  public int AXN4PROD_REQ_VIEW_PRODUCTION=0x1002;
  public int AXN4PROD_REQ_PAST_PRODUCTION=0x1003;
  //for S/C and T/C production status in table Production_status.
  public String PROD_SC_SENT_CONFIRM="2";
  public String PROD_CT_SENT_CONFIRM="3";
  public String PROD_SCnCT_SENT_CONFIRM="4";

  public String PROD_SC_CONFIRMED="5";
  public String PROD_CT_CONFIRMED="6";
  public String PROD_SCnCT_CONFIRMED="7";

  public String PROD_SC_REJECTED="8";
  public String PROD_CT_REJECTED="9";
  public String PROD_SCnCT_REJECTED="A";

 //============================================================
  public String key4AXN4PROD="Production.mastermaintain.ProductionInstruction";

  public String STR_USR_CODE="Production.mastermaintain.LoginedUser";

  public String NEW_RECORD_FOR_SCR003="Production.mastermaintain.NEW_RECORD_FOR_SCR003";
  public String BLANK_PLAN_RECORD_FOR_PRODUCT="Production.mastermaintain.BLANK_PLAN_RECORD_FOR_PRODUCT";

  public String MSG_DELETE_OK="Delete success";
  public String MSG_DELETE_FAIL="Delete fail";
  public String MSG_UPDATE_OK="Update success";
  public String MSG_UPDATE_FAIL="Update fail";
  public String MSG_INSERT_OK="Insert success";
  public String MSG_INSERT_FAIL="Insert fail";
  /***the following INT object is "java.math.BigDecimal" type class **/
  public String INT_SCROO3_COPIED_PROD_SEQ="Production.mastermaintain.INT_SCROO3_COPIED_PROD_SEQ";
  public String INT_SCROO2_CHOSED_PROD_SEQ="Production.mastermaintain.INT_SCROO2_CHOSED_PROD_SEQ";
 /**strings stored in SCR002 ,for latter panel to display.****/
  public String STR_SCROO2_CHOSED_CENTER_STRING="Production.mastermaintain.STR_SCROO2_CHOSED_CENTER_STRING";
  public String STR_SCROO2_CHOSED_DEPARTMENT_STRING="Production.mastermaintain.STR_SCROO2_CHOSED_DEPARTMENT_STRING";
  public String STR_SCROO2_CHOSED_YEAR_STRING="Production.mastermaintain.STR_SCROO2_CHOSED_YEAR_STRING";
  public String STR_SCROO2_CHOSED_BUYER_STRING="Production.mastermaintain.STR_SCROO2_CHOSED_BUYER_STRING";
  public String STR_SCROO2_CHOSED_MANAGER_STRING="Production.mastermaintain.STR_SCROO2_CHOSED_MANAGER_STRING";
  public String STR_SCROO2_CHOSED_SEASON_STRING="Production.mastermaintain.STR_SCROO2_CHOSED_SEASON_STRING";
  public String STR_SCROO2_CHOSED_FTY_STRING="Production.mastermaintain.STR_SCROO2_CHOSED_FTY_STRING";
  public String STR_SCROO2_CHOSED_PROD_TYPE_STRING="Production.mastermaintain.STR_SCROO2_CHOSED_PROD_TYPE_STRING";
  public String STR_SCROO2_CHOSED_DIV_STRING="Production.mastermaintain.STR_SCROO2_CHOSED_DIV_STRING";
  public String STR_SCROO2_CHOSED_RANGE_STRING="Production.mastermaintain.STR_SCROO2_CHOSED_RANGE_STRING";

  /**for style modify panel(panel 16) to use */
  public String PNL_SCRO04_PANEL ="Production.mastermaintain.STYLE_DATA_MAINTAIN_PANEL";
  /**for SCR016--COLOR_LIB** to use**/
  public String REC_RELATED_FLOATING="Production.mastermaintain.COLOR_LIB.REC_RELATED_FLOATING";

  public String STR_DUPX_MILL="Production.mastermaintain.COLOR_LIB.DUPX_MILL";
  public String STR_BULK_MILL="Production.mastermaintain.COLOR_LIB.BULK_MILL";
  //for SCR15 flocating copied record //
  public String INT_COPIED_FLOATING_SEQ="Production.mastermaintain.FLOATING.SCR15_COPIED_FLOATING";
  //for SCR016,
  /*
  public String ColorLibCmd_4_SCR016="Production.mastermaintain.COLOR_LIB.SCR16_INIT_COLOR_LIB_COMMAND_OBJECT";
  */
  //for SCR026
  /*
  public String ColorQtyCmd_4_SCR026="Production.mastermaintain.COLOR_LIB.SCR26_INIT_COLOR_QTY_COMMAND_OBJECT";
  */
  public String RECORD_SCR004_CHOSED_STYLE_RECORD="Production.mastermaintain.SCR004_CHOSED_STYLE_RECORD";
    //for SCR014,production others attributs maintain.
  public String VCT_OTHERS_PRX_TERM="Production.mastermaintain.PRODUCTION.OTHERS.PRICE_TERM_TABLE";
  public String VCT_OTHERS_CURRENCY="Production.mastermaintain.PRODUCTION.OTHERS.CURRENCY_TABLE";
  public String VCT_OTHERS_PAYMENT_TERM="Production.mastermaintain.PRODUCTION.OTHERS.PAYMENT_TERM_TABLE";
  public String VCT_OTHERS_BRANCH="Production.mastermaintain.PRODUCTION.OTHERS.BRANCH_TABLE";
  //for Fab-PO-Color copy data...
  public String VCT_FAB_PO_COLOR_COPIED_CLIBS="Production.mastermaintain.PRODUCTION.FAB_PO_COLOR.COPIED_CLIB";
  public String INT_FAB_PO_COLOR_COPY_USING_PROD_SEQ="Production.mastermaintain.PRODUCTION.FAB_PO_COLOR.COPY_USING_PROD_SEQ";
}