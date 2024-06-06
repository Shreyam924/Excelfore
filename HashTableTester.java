
public class HashTableTester {
	public static void main(String[] args) {
		HashTable ht=new HashTable();
		ht.put("java","programming");
		System.out.println(ht.get("java"));
		ht.remove("java");
		System.out.println(ht.get("java"));	
	}
}
