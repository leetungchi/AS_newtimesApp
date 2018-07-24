/**
 * Title:        Training
 * Description:  Training
 * Copyright:    Copyright (c) Topper,pluse Object encoding by Crazy John
 * Company:      inforich.com.tw
 * @author       Topper,reversioned by John.Cheng.
 * @version 1.0
 */
package database;
import java.sql.*;
public interface Encoder {
    /**
     * generate string as the encode result.
     * @param value as stirng to encode,able to void "'" problem.
     */
    public String encode( String value );
    /**
     * generate string as the encode result.
     * @param value as boolean
     */
    public String encode( boolean value ) ;
    /**
     * generate string as the encode result.
     * @param value as integer type
     */
    public String encode( int value );
    /**
     * generate string as the encode result.
     * @param value as long type
     */

    public String encode( long value );
    /**
     * generate string as the encode result.
     * @param value as float type
     */
    public String encode( float value );
    /**
     * generate string as the encode result.
     * @param value as double type
     */
    public String encode( double value );
    /**
     * generate string as the encode result.
     * @param value as java.sql.Data type
     */
    public String encode( Date value );
    /**
     * generate string as the encode result.
     * @param value as java.sql.Data type
     */
    public String encode (java.util.Date value);
    /**
     * generate string as the encode result.
     * @param value as java.sql.Tims type
     */
    public String encode( Time value );
    /**
     * generate string as the encode result.
     * @param value as java.sql.TimeStamp
     */
    public String encode( Timestamp value );
    /**
     * generate string as the encode result.
     * @param value as java.lang.Objct,prefers int,long,float,double,java.sql.Data,string.
     */
   public String encode(Object value);
}