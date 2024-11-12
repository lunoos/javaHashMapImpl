package hashMap;

import java.util.Objects;

public class HashMap<K, V> implements Map<K, V> {

	int mapLength = Constants.mapArrySize;
	private Bucket<K, V>[] mapArr = new Bucket[mapLength];
	float loadFact = Constants.loadFactor;
	int nodeCount = 0;

	@Override
	public void put(K key, V val) {
		// TODO Auto-generated method stub
		int index = getIndex(key);
		// if load factor is less then 0.75
		Bucket bucket = mapArr[(int) index];
		if (bucket == null) {
			Node<K, V> node = new Node(key, val);
			Bucket<K, V> tmpBkt = new Bucket<>(node);
			mapArr[(int) index] = tmpBkt;
			nodeCount++;
		} else {
			Node tmp = bucket.getNode();
			while (tmp != null) {
				if (tmp.getK().equals(key)) {
					tmp.setV(val);
					break;
				}
				if (tmp.next == null) {
					Node<K, V> node = new Node(key, val);
					bucket.incrementLen();
					tmp.next = node;
					nodeCount++;
					break;
				}
				tmp = tmp.next;
			}
		}
		if(nodeCount/mapLength>=loadFact)
			rehash();
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		int index = getIndex(key);
		// if load factor is less then 0.75
		Bucket bucket = mapArr[(int) index];
		Node tmp = bucket.getNode();
		boolean found = false;
		while (tmp != null) {
			if (tmp.getK().equals(key)) {
				return (V) tmp.getV();
			}
			tmp = tmp.next;
		}
		return null;
	}

	private int getIndex(K k) {
		long hasCode = k.hashCode();
		hasCode = hasCode < 0 ? hasCode * -1 : hasCode;
		return (int) (hasCode % (mapLength - 1));
	}
	
	@Override
	public void printLengthOfBukt() {
		for(int i=0; i<mapLength; i++) {
			if(!Objects.isNull(mapArr[i]))
			System.out.println("index "+i+" length "+mapArr[i].getLength());
		}
	}
	
	private void rehash() {
		int currLength = mapLength;
		Bucket[] crrArr = new Bucket[currLength];
		for(int i=0; i<currLength; i++) {
			crrArr[i] = mapArr[i];
		}
		mapLength = mapLength*2;
		Bucket[] newArray = new Bucket[mapLength];
		mapArr = newArray;
		for(int i=0; i<currLength; i++) {
			Bucket bucket = crrArr[i];
			if(bucket!=null) {
			Node<K,V> tmp = bucket.getNode();
			while(tmp!=null) {
				put(tmp.getK(),tmp.getV());
				tmp = tmp.next;
			}
			}
		}
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub

	}

}
