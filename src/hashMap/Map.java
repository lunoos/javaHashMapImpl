package hashMap;

public interface Map<K,V> {
	public void put(K key,V val);
	public V get(K key);
	public void delete(K key);
	public void printLengthOfBukt();
}
