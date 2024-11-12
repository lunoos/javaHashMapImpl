package hashMap;

class Bucket<K,V> {
	private Node<K,V> node;
	private int length = 0;
	public Bucket(Node<K,V> node){
		this.node = node;
		this.length = 0;
	}
	public Node<K, V> getNode() {
		return node;
	}
	public void setNode(Node<K, V> node) {
		this.node = node;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void incrementLen() {
		length++;
	}
	
}
