package util;
import java.util.*;
import java.util.HashMap;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class InsertionOrderedHashMap extends HashMap {
    private LinkedList ordered;
    public InsertionOrderedHashMap() {
    	super();
        ordered = new LinkedList();
    }
    public Object put(Object key, Object value) {
    	Object prevvalue = super.get(key);
        super.put(key, value);
        ordered.add(key);
        return prevvalue;
    }
    public Object remove(Object key) {
      Object prevvalue = super.get(key);
      ordered.remove(key);
      super.remove(key);
      return prevvalue;
    }

    private static class Entry implements Map.Entry    {
    	private Object key, value;
        Entry(Object _key, Object _value) {
          key=_key;
          value=_value;
        }
        public boolean equals(Object o) {
          return key.equals(o);
        }
        public Object getKey() {
           return key;
        }
        public Object getValue() {
           return value;
        }
        public int hashCode() {
            return key.hashCode();
        }
        public Object setValue(Object _value) {
           Object prevvalue = value;
           value = _value;
           return prevvalue;
        }

    }
    private static class InsertionOrderedSet extends AbstractSet    {
    	public boolean containsAll(Collection c) {
           return elements.containsAll(c);
        }
        public boolean addAll(Collection c) {
           return elements.addAll(c);
        }
        public boolean retainAll(Collection c) {
           return elements.retainAll(c);
        }

        public boolean remove(Object o) {
           return elements.remove(o);
        }
        public Object[] toArray() {
          return elements.toArray();
        }
        public Object[] toArray(Object[] a) {
           return elements.toArray(a);
        }
        public boolean contains(Object key) {
          return elements.contains(key);
        }
        public boolean isEmpty() { return elements.isEmpty(); }
        public int size() { return elements.size(); }
        private LinkedList elements;
        InsertionOrderedSet() {
           super();
           elements = new LinkedList();
        }
        public boolean add(Object elem) {
            if(elements.contains(elem)) elements.remove(elem);
              elements.add(elem);
              return true;
        }
        public Iterator iterator() {
           return elements.iterator();
        }
    }
    public Set entrySet() {
      InsertionOrderedSet entryset = new InsertionOrderedSet();
      Iterator orderediterator = ordered.iterator();
      while(orderediterator.hasNext()) {
        Object key = orderediterator.next();
        Entry entry = new Entry(key, super.get(key));
        entryset.add(entry);
      }
      return entryset;
    }
}
