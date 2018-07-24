package database.datatype;
import java.util.Vector;
/**
 * Title:Tree TableInterface.
 * Description:the methods that tree table should contains.such as get parent linklist.get child,and get child & grand child function.
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author Crazy.John.
 * @version 1.0
 */

public interface TreeTableInterface extends TableInterface{
  /**
   * to get parent node into vector according this record object
   * the last elemet is the returned vector is the root node.
   * and the 1st elemet of the returned vector is the parent node.
   * @param record.
   * @return vector of sequentlly parent nodes
   * @exception Exception while column name not found or else.
   */
  public Vector getParentes(Record record) throws Exception;
  /**
   * to get Current child nodes belown to this node record object.
   * does not include the grandchild notes
   * @param record
   * @return child notes.
   */
  public Vector getCurChilds(Record record) throws Exception;
  /**
   * to get child notes,also include grand child notes
   * @param record. current node
   * @return child&grand child nodes.
   */
  public Vector getAllChilds(Record record) throws Exception;
  /**
   * to get the id column name in this tree table
   * @return id column name
   */
  public String getIdColumnName();
  /**
   * to get the parent column name in this tree table
   * @return parent column name
   */
  public String getParentColumnName();
  /**
   * to get the idle value defined for this tree table object
   * @return Object of idle status,such as -1 or null.
   */
  public Object getIdleValue();
  /**
   * to get the root value defined for this tree table object
   * @return Object of idle status,0,or ""
   */
  public Object getRootValue();
}