package hashMap;

public class JavaHashMapImpl {
	public static void main(String args[]) {
		System.out.println("hello world");
		Map<String,String> map = new HashMap<>();
		for(int i=0; i<10000; i++)
		map.put("key"+(i+1), "val1"+(i+1));
		
		map.printLengthOfBukt();
		
		for(int i=10000; i>0; i--) {
			System.out.println(map.get("key"+(i)));
		}
	}
}
