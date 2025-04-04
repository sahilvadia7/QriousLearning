package collectionEclipse.set.hashset;

import java.util.HashSet;

public class HashSetDemo1 {
	
	public static void main(String[] args) {
		HashSet<String> hashset = new HashSet<>();
		
		hashset.add("hash101");
		hashset.add("hash201");
		hashset.add("hash301");
		hashset.add("hash401");
		hashset.add("hash501");
		hashset.add("hash601");
		hashset.add(null);
		hashset.add(null);
		hashset.add(null);
		
		System.out.println(hashset.size());
		System.out.println(hashset.contains("hash501"));
		hashset.remove("hash501");
		
		hashset.forEach((n) ->System.out.println(n));
		hashset.clear();
		hashset.forEach((n) ->System.out.println(n));

		
		
	}

}
