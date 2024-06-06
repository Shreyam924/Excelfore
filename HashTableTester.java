
public class HashTableTester {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        System.out.println("Initial size:" + ht.size());
        ht.put("java", "programming");
        System.out.println("Size after insertion:" + ht.size());
        System.out.println("Value for java key:" + ht.get("java"));
        ht.remove("java");
        System.out.println("Size after removal:" + ht.size());
        System.out.println("Value for java key after removal:" + ht.get("java"));
    }
}
