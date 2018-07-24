package newtimes.material;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class CONST {
  private CONST(){}
  public static boolean isExit = false;
  public static boolean pageFlag = false;
  public static boolean detailPageFlag = false;
  public static UI_History HIST;
  public static class COMMON {
    private COMMON(){}
    public static final String CREATE_USER   = "RECORD_CREATE_USER";
    public static final String CREATE_DATE   = "RECORD_CREATE_DATE";
    public static final String DELETE_FLAG   = "RECORD_DELETE_FLAG";
    public static final String DELETE_DATE   = "RECORD_DELETE_DATE";
    public static final String DELETE_USER   = "RECORD_DELETE_USER";
    public static final String MODIFY_DATE   = "RECORD_MODIFY_DATE";
    public static final String MODIFY_USER   = "RECORD_MODIFY_USER";
  }

  public static class BYMK{
    private BYMK(){}
    public static class EJB {
      private EJB(){}
      //public static final String NAME = "BYMKR_NAME";
      public static final String NAME = "BYMKR_BRIEF";
      public static final String SEQ = "BYMKR_SEQ";
    }
  }

  public static class CEN{
    private CEN(){}
    public static class EJB {
      private EJB(){}
      public static final String NAME   = "CEN_NAME";
      public static final String CODE   = "CEN_CODE";
    }
  }

  public static class CNTY{
    private CNTY(){}
    public static class EJB {
      private EJB(){}
      public static final String NAME  = "CNTY_NAME";
      //public static final String CODE  = "CNTY_CODE";
    }
  }

  public static class DIV{
    private DIV(){}
    public static class EJB {
      private EJB(){}
      public static final String NAME   = "DIV_NAME";
      public static final String CODE   = "DIV_CODE";
    }
  }

  public static class MTR{
    private MTR(){}
    public static class EJB {
      private EJB(){}
      public static final String CENTER   = "Center";
      public static final String COUNTRY  = "Country";
      public static final String MILL     = "Mill";
      public static final String DIVISION = "Division";

      public static final String NO            = "MTR_NO";
      public static final String MILL_NO       = "MILL_NO";
      public static final String MILL_NAME     = "MILL_NAME";
      public static final String CEN_CODE      = "MTR_CEN_CODE";
      public static final String TYPE          = "MTR_TYPE";
      public static final String DESC          = "MTR_DESC";
      public static final String CONTENT       = "MTR_CONTENT";
      public static final String CONSTRUCTION  = "MTR_CONSTRUCTION";
      public static final String WEIGHT        = "MTR_WEIGHT";
      public static final String WIDTH         = "MTR_WIDTH";
      public static final String CUTABLE_WIDTH = "MTR_CUTABLE_WIDTH";
      public static final String FINISH        = "MTR_FINISH";
      public static final String YARN_ENDS     = "MTR_YARN_ENDS";
      public static final String YARN_GAUGE    = "MTR_YARN_GAUGE";
      public static final String YARN_HORIZON  = "MTR_YARN_HORIZON";
      public static final String YARN_VERTIC   = "MTR_YARN_VERTIC";
      public static final String WASH_METHOD   = "MTR_WASH_METHOD";
      public static final String PACKAGE       = "MTR_PACKAGE";
      public static final String GEN_REMARK    = "MTR_GEN_REMARK";
      public static final String DTL_DEL_CNT   = "CNT";
      public static final String PATTERN_NAME   = "MTR_PATTERN_NAME";
      public static final String TARIFF_NO   = "MTR_TARIFF_NO";
      public static final String QTA   = "MTR_QTA";

    }

    public static class APP{
      private APP(){}
      public static class SEARCH{
        private SEARCH(){}
        public static String CONDITIONS = "MtrSearchConds";
        public static String CEN_CODE    =  "CEN_CODE";
        public static String MILL_NAME   =  "MILL_NAME";
        public static String CNTY_CODE   =  "CNTY_CODE";
        public static String DIV_CODE    =  "DIV_CODE";
        public static String MTR_NO      =  "MTR_NO";
        public static String MILL_NO     =  "MILL_NO";
        public static String CREATE_DATE =  "RECORD_CREATE_DATE";
        public static String CREATE_USER =  "RECORD_CREATE_USER";
        public static String DELETE_FLAG =  "RECORD_DELETE_FLAG";

        public static int UNKNOWN     = 0;
        public static int EXISTING    = 1;
        public static int DELETED     = 2;
        public static int MTR_DETAIL  = 3;

        public static int MTR_HEAD_LIST       = 1;
        public static int MTR_NEW_REC         = 2;
        public static int DEL_MTR_HEAD_LIST   = 3;

      }
    }
  }

  public static class PRICE_TERM{
   private PRICE_TERM(){}
    public static class EJB {
      private EJB(){}
      public static final String PRC_TRM = "PRC_TRM";
    }
  }

  public static class CITY{
    private CITY(){}
    public static class EJB {
      private EJB(){}
      public static final String NAME         = "CITY_NAME";
      public static final String CNTY_NAME    = "CITY_CNTY_NAME";
      public static final String CHINESE_NAME = "CITY_CHINESE_NAME";
    }
  }


  public static class MTRDTL{
    private MTRDTL(){}
    public static class EJB {
      private EJB(){}
      public static final String BYMKR_NAME      = "BYMKR_NAME";
      public static final String BYMKR_BRIEF      = "BYMKR_BRIEF";
      public static final String PK              = "MTRDTL_PK";
      public static final String MTR_NO          = "MTRDTL_MTR_NO";
      public static final String MILL_NO         = "MTRDTL_MILL_NO";
      public static final String BYMKR_SEQ       = "MTRDTL_BYMKR_SEQ";
      public static final String PRX_USD         = "MTRDTL_PRX_USD";
      public static final String PRX_PRCTERM     = "MTRDTL_PRX_PRCTERM";
      public static final String PRX_DEST        = "MTRDTL_PRX_DEST";
      public static final String PRX_LOCAL       = "MTRDTL_PRX_LOCAL";
      public static final String UNIT_USD        = "MTRDTL_UNIT_USD";
      public static final String UNIT_LOCAL      = "MTRDTL_UNIT_LOCAL";
      public static final String CNFM_PRX_USD    = "MTRDTL_CNFM_PRX_USD";
      public static final String CNFM_PRX_LOCAL  = "MTRDTL_CNFM_PRX_LOCAL";
      public static final String DUPS_MINQTY     = "MTRDTL_DUPS_MINQTY";
      public static final String DUPS_LEADTIME   = "MTRDTL_DUPS_LEAD_TIME";
      public static final String BULK_MINQTY     = "MTRDTL_BULK_MINQTY";
      public static final String BULK_LEADTIME   = "MTRDTL_BULK_LEAD_TIME";
      public static final String GEN_REMARK      = "MTRDTL_GEN_REMARK";
      public static final String CONFIRM_PERSON1 = "MTRDTL_CONFIRM_PERSON1";
      public static final String CONFIRM_PERSON2 = "MTRDTL_CONFIRM_PERSON2";
      public static final String COMMITED_DATE1  = "MTRDTL_COMMITED_DATE1";
      public static final String COMMITED_DATE2  = "MTRDTL_COMMITED_DATE2";
      public static final String COMMITED_YARD1  = "MTRDTL_COMMITED_YARD1";
      public static final String COMMITED_YARD2  = "MTRDTL_COMMITED_YARD2";
      public static final String CURRENCY_LOCAL  = "MTRDTL_CURRENCY_LOCAL";
    }

    public static class APP{
      private APP(){}
      public static class LIST{
        private LIST(){}
        public static final String CONDITIONS     = "MtrDetailListConds";
        public static final String DELELTED_CONDS = "DelMtrDetailListConds";
      }
    }
  }

  public static class MTRHIST{
    private MTRHIST(){}
    public static class EJB {
      private EJB(){}
      public static final String SEQ        = "MTRH_SEQ";
      public static final String HIS_NO     = "MTRH_HIS_NO";
      public static final String MTR_NO     = "MTR_NO";
      public static final String CEN_CODE   = "MTRH_CEN_CODE";
      public static final String CIF_YD     = "MTRH_PRX_CIF_YD";
      public static final String COL_PTN    = "MTRH_PRX_COL_PTN";
      public static final String ORIG_YR    = "MTRH_ORIG_YR";
      public static final String ORIG_SEA   = "MTRH_ORIG_SEA";
      public static final String ORIG_DIV   = "MTRH_ORIG_DIV_CODE";
      public static final String PACKG_SENT = "MTRH_PACKG_SENT";
      public static final String NJ         = "MTRH_NJ";
      public static final String LOCK_YR    = "MTRH_LOCK_YR";
      public static final String LOCK_SEA   = "MTRH_LOCK_SEA";
      public static final String LOCK_DIV   = "MTRH_LOCK_DIV_CODE";
      public static final String LOCK_DATE  = "MTRH_LOCK_DATE";
    }

    public static class APP{
      private APP(){}
      public static class LIST{
        private LIST(){}
        public static final String CONDITIONS = "MtrHistListConds";
      }
    }
  }

  public static class SEASON{
    private SEASON(){}
    public static class EJB {
      private EJB(){}
      public static final String NAME = "SEA_NAME";
    }
  }





}