package hashTable;

import java.util.LinkedList;

/**
 * @author Arnaldo Quintero Segura
 * Class that implements a HashTable.
 *
 * @param <T> the type of the objects to store on the hash table.
 */
public class HashTable<T> {
	
	
	/**
	 * Variable that holds the different slots of the
	 * hash table.
	 */
	private LinkedList<Pair<String,T>>[] buckets;
	
	
	/**
	 * Variable that holds the total amount of elements
	 * present on the hash table.
	 */
	private int size = 0;
	
	
	/**
	 * Constructor that creates a new hash table with an 
	 * initial amount of 3 buckets.
	 */
	@SuppressWarnings("unchecked")
	public HashTable() {
		buckets = new LinkedList[3];
	}
	
	/**
	 * @return the amount of elements inserted currently
	 * on the hash map.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Function that prints the Hash Table as a key value pair
	 * array. 
	 */
	public void print() {
		System.out.println(this);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "{";
		boolean first = true;
		for (LinkedList<Pair<String, T>> list : buckets) {
			if (list == null) {
				continue;
			}
			for (Pair<String, T> pair : list) {
				if (!first) {
					result += ",";
				}else {
					first = false;
				}
				result += " (" + pair.getKey() + ", " + pair.getValue() + ")";
			}
		}
		result += " }";
		return result;
	}
		
	/**
	 * @return the current load factor of the hash table.
	 */
	public float getLoadFactor() {
		return (float) size/buckets.length;
	}
	
	/**
	 * Function that inserts the new given value, given
	 * a key. Only if the key is not present.
	 * @param key to insert.
	 * @param value to be inserted.
	 * @return boolean value, true if
	 * correctly inserted. false otherwise.
	 */
	public boolean put(String key, T value) {
		boolean result = true;
		
		try {
			int index = getIndex(key);
			
			if (hasKey(key, buckets[index]) != null) {
				return false;
			}
			
			if (buckets[index] == null) {
				buckets[index] = new LinkedList<Pair<String,T>>();
			}
			
			boolean inserted = buckets[index].add(new Pair<String, T>(key,value));
			if (inserted) {
				size += 1;
				resizeTable();
			}
		} catch (Exception e) {
			size -= 1;
			result = false;
		}
		return result;
	}
	
	/**
	 * Function that checks if the given key is present in the
	 * hash table.
	 * @param key to check if it's inside the hash table.
	 * @return boolean value, true if
	 * the key is inside. false otherwise.
	 */
	public boolean containsKey(String key) {
		int index = getIndex(key);
		return hasKey(key, buckets[index]) != null;
	}
	
	/**
	 * Function that checks if the given value is present in the
	 * hash table.
	 * @param value to check if it's inside the hash table.
	 * @return boolean value, true if
	 * the value is inside. false otherwise.
	 */
	public String containsValue(T value) {
		for (LinkedList<Pair<String, T>> list : buckets) {
			Pair<String, T> pair = hasValue(value,list);
			if (pair != null) {
				return pair.getKey();
			}
		}
		return null;
	}
	
	/**
	 * Function that gets the value of the given key.
	 * @param key to look for.
	 * @return the value assigned to the specified key
	 * if found on the table, otherwise null.
	 */
	public T get(String key) {
		int index = getIndex(key);
		
		Pair<String, T> pair = hasKey(key, buckets[index]);
		return pair != null ? pair.getValue() : null;
	}

	/**
	 * Function that removes the element of the given key
	 * from the hash table, if present.
	 * @param key to look for.
	 * @return boolean value, true if it was correctly
	 * deleted, false otherwise.
	 */
	public boolean remove(String key) {
		boolean result = false;
		
		int index = getIndex(key);
		Pair<String,T> elem = hasKey(key, buckets[index]);
		
		if (elem != null) {
			buckets[index].remove(elem);
			size -= 1;
			resizeTable();
			result = true;
		}
		
		return result;
	}

	/**
	 * Function that given a key and a new value,
	 * replaces the value of the given key.
	 * @param key to look for.
	 * @param newValue to replace the given key.
	 * @return boolean value, true if the value was correctly
	 * replaced, false otherwise.
	 */
	public boolean replace(String key, T newValue) {
		boolean result = false;
		
		int index = getIndex(key);
		Pair<String,T> elem = hasKey(key, buckets[index]);

		if (elem != null) {
			elem.setValue(newValue);
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Function that given a string key, generates a hashed index
	 * in between the positions of the buckets
	 * @param key to generate the index for.
	 * @return the index in which to insert the key.
	 */
	private int getIndex(String key) {
		int result = key.hashCode() % buckets.length;
		return result >= 0 ? result : -result;
	}
	
	/**
	 * Function that given a string key, generates a hashed index
	 * in between the positions of the buckets
	 * @param key to generate the index for.
	 * @param bucketSize to calculate the index.
	 * @return the index in which to insert the key.
	 */
	private int getIndex(String key, int bucketSize) {
		int result = key.hashCode() % bucketSize;
		return result >= 0 ? result : -result;
	}
	
	/**
	 * Function that gets the new size for the buckets to be resized.
	 * @return the new table size to be resized.
	 */
	private int getNewTableSize() {
		int actualSize = size > buckets.length ? buckets.length : size;
		for (int prime : PrimeNumbers.primeNumbers) {
			if (prime > actualSize*2) {
				return prime;
			}
		}
		return actualSize*2;
	}
	
	/**
	 * Function that checks if a given value is present on the hash table.
	 * @param value to look for.
	 * @param list in which to look.
	 * @return the key-value pair, if present on the given list,
	 * otherwise null.
	 */
	private Pair<String, T> hasValue(T value, LinkedList<Pair<String,T>> list) {
		if (list == null) return null;
		for (Pair<String, T> pair : list) {
			if (pair.getValue().equals(value)) {
				return pair;
			}
		}
		return null;
	}
	
	/**
	 * Function that checks if a given key is present on the hash table.
	 * @param key to look for.
	 * @param list in which to look.
	 * @return the key-value pair, if present on the given list,
	 * otherwise null.
	 */
	private Pair<String, T> hasKey(String key, LinkedList<Pair<String,T>> list) {
		if (list == null) return null;
		for (Pair<String, T> pair : list) {
			if (pair.getKey().equals(key)) {
				return pair;
			}
		}
		return null;
	}
	
	/**
	 * Function that insert a list of values in a bucket list.
	 * @param destinationBuckets in which to insert the given values.
	 * @param values to be inserted.
	 */
	private void insertIntoBuckets(LinkedList<Pair<String,T>>[] destinationBuckets, LinkedList<Pair<String,T>> values) {
		for (Pair<String,T> pair : values) {
			int index = getIndex(pair.getKey(), destinationBuckets.length);
			
			if (destinationBuckets[index] == null) {
				destinationBuckets[index] = new LinkedList<Pair<String,T>>();
			}
			destinationBuckets[index].add(pair);
			
		}
	}
	
	/**
	 * Function that checks if the value needs a resize. And if so, it does
	 * resize the amount of buckets present.
	 */
	private void resizeTable() {
		
		float actualLoadFactor = getLoadFactor();
		if (actualLoadFactor != 0.0 && (actualLoadFactor > 1 || actualLoadFactor < 0.33)) {
			int size = getNewTableSize();
			
			@SuppressWarnings("unchecked")
			LinkedList<Pair<String,T>>[] newBuckets = new LinkedList[size];
			for (LinkedList<Pair<String,T>> list : buckets) {
				if (list != null && list.size() > 0) {
					insertIntoBuckets(newBuckets, list);
				}
			}
			
			buckets = newBuckets;
		}
		
	}
	
	
	
	
	
}
