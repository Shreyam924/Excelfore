
import java.util.Arrays;

public class HashTable {
	private static final int INITIAL_CAPACITY=16;
	private static final double LOAD_FACTOR=0.75;
	private Entry[] table;
	private int size;
	
	public HashTable()
	{
		table=new Entry[INITIAL_CAPACITY];
		size=0;
	}
	
	private int hash(String key)
	{
		return key.hashCode() % table.length;
	}
	
	private static class Entry
	{
		String key;
		String value;
		Entry next;
		
		Entry(String key, String value)
		{
			this.key=key;
			this.value=value;
		}
	}
	
	public void put(String key, String value)
	{
		int index=hash(key);
		Entry entry=new Entry(key,value);
		
		if(table[index]==null)
		{
			table[index]=entry;
		}
		else {
			Entry current=table[index];
			while(current.next!= null)
			{
				if(current.key.equals(key))
				{
					current.value=value;
					return;
				}
				current=current.next;
			}
			current.next=entry;
		}
		size++;
		resizeIfNeeded();
	}
	
	public String get(String key)
	{
			int index=hash(key);
			Entry current=table[index];
			
			while(current != null)
			{
				if(current.key.equals(key))
				{
					return current.value;
				}
				current=current.next;
			}
			return null;
		}
		
		public void remove(String key)
		{
			int index = hash(key);
			Entry current =table[index];
			Entry prev= null;
			while(current != null)
			{
				if(current.key.equals(key))
				{
					if(prev == null)
					{
						table[index] = current.next;
					}
					else {
						prev.next=current.next;
					}
					size--;
					return;
				}
				prev=current;
				current=current.next;
			}
		}
		
		private void resizeIfNeeded()
		{
			if(size >= LOAD_FACTOR * table.length)
			{
				int newCapacity = table.length * 2;
				Entry[] newTable = new Entry[newCapacity];
				Arrays.fill(newTable,null);
				
				for(Entry entry : table)
				{
					while(entry != null)
					{
						int newIndex=hash(entry.key);
						Entry temp=entry.next;
						entry.next=newTable[newIndex];
						newTable[newIndex] = entry;
						entry=temp;
					}
				}
				table=newTable;
			}
		}
		
		public static void main(String[] args) {
			HashTable ht=new HashTable();
			ht.put("java","programming");
			System.out.println(ht.get("java"));
			ht.remove("java");
			System.out.println(ht.get("java"));	
		}		
}
	
