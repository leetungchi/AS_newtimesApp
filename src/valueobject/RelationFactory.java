package valueobject;
import database.datatype.Record;
import java.util.Vector;
/**
 * <p>Title:RelationFactory of a compound value objct </p>
 * <p>Description:this's a Factory which an compose and de-compose the assemblied value object. </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public interface RelationFactory {
   /**
    * to "plug in" a valueobject into an container valueobject as its attribute"
    * @param containerObj--the target object to plug in
    * @param obj2bind--the source object to put into
    * @throws Exception--caused by record if the record is not updated/insert into database yet.
    */
   public void bindRelation(Record containerObj ,Record obj2bind) throws Exception;
   /**
    * to "unplug" a valueobject from an container valueobject which contains the valuobject as its attribute
    * @param containerObj--the object which contains the valueobject to remove from.
    * @param obj2bind--the value object to remove
    * @throws Exception--caused by record if the record is not updated/insert into database yet
    */
   public void unbindRelation(Record containerObj,Record obj2Unbind)throws Exception;
    /**
     * to compose a valueobject include all it's attributes(also value objects)
     * @param valueObj--the conatiner object which will be assemblied in this factory.
     * @return ValueObject as composed object whitch contains every attribute recursivly
     * @throws Exception --runtime exception ,such as null exception.
     */
   public ValueObjectInterface getComposedObject(Record rec)throws Exception;
     /**
      * get record which may contains this record
      * @param rec--record object to contain
      * @return Vector contains record of each parent node.that last elemet is the top node,and the last element is the nearest parent node
      * @throws Exception
      */
   public Vector getContainersRecordChain(Record rec)throws Exception;
    /**
     * to check if a value object contains a record or not.
     * @param valueObj
     * @param rec
     * @return
     * @throws Exception
     */
   public boolean contain(ValueObjectInterface valueObj,Record rec)throws Exception;
   /**
    * find out  the parent valueobject which may contains the record belongs this tree(parameterd ValueObjectInterface)
    * @param valueObj--target to search
    * @param rec2find--record object to find.
    * @return--the parent node contains the record object to search
    * @throws Exception--null exception or sql exception.
    */
   public ValueObjectInterface getContainObj(ValueObjectInterface valueObj,Record rec2find )throws Exception;
  /**
   * assume table name is an attribue name,we also can find out the record under this object.
   * @param tableName--the table name to find.
   * @param valueobj--the valueobjectinterface object to search
   * @return Records in vector,which's source table name is parametered as tablename
   * @throws Exception--sql exception.or null exception
   */
  public Vector getRecordsByTableName(ValueObjectInterface valueobj,String tableName)throws Exception;
   /**
    * delete a tree valueobject and include the source table which contains the record
    * @param valueobj--object to delete
    * @throws Exception--null exception or sql exception cause by sub process.
    */
  public void deleteTree(ValueObjectInterface valueobj)throws Exception;
    /**
     * to get valueobject which contains the 1st row objects
     * @param rec--record to search in relation-reg table.
     * @return valueobjectinterface which contains only one row,row contains records or valueobject(without deeper relation)
     * @throws Exception--runtime exception(null),or sql exception.
     */
  public ValueObjectInterface getCurChildComposedObject(Record rec)throws Exception;
}