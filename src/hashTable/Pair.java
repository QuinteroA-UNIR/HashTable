package hashTable;

/**
 * Class that represent a generic object
 * with a key-value pair structure.
 * @author Arnaldo Quintero Segura
 *
 * @param <K> type of the key.
 * @param <T> type of the value.
 */
public class Pair<K,T> {
	
	/**
	 * Variable that holds the key. 
	 */
	private K key;
	
	/**
	 * Variable that holds the value. 
	 */
	private T value;
	
	
	/**
	 * Constructor of the key-value pair.
	 * @param key.
	 * @param value.
	 */
	public Pair(K key, T value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Function that gets the key of the pair.
	 * @return the key of the pair.
	 */
	public K getKey() {
		return key;
	}
	
	/**
	 * Function that gets the value of the pair.
	 * @return the value of the pair.
	 */
	public T getValue() {
		return value;
	}
	
	/**
	 * Function that sets the key of the pair.
	 * @param key to set.
	 */
	public void setKey(K key) {
		this.key = key;
	}
	
	/**
	 * Function that sets the value of the pair.
	 * @param value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}
}
