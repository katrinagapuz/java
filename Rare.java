import java.util.*;

public class Rare {
    public static int nthMostRare(int[] elements, int n) {
        HashMap<Integer, Integer> input = new HashMap<Integer, Integer>();

        for(int i = 0; i < elements.length; i++) {
        	int cnt = 1;
        	if(input.containsKey(elements[i]))
        		continue;
        	for(int j = i+1; j < elements.length; j++) {
        		if(elements[j] == elements[i])
        			cnt++;
        	}

        	input.put(elements[i], cnt);
        }

        LinkedList<Integer> sorted = new LinkedList<Integer>();

        Iterator it = input.entrySet().iterator();
        while(it.hasNext()) {
        	Map.Entry pair = (Map.Entry)it.next();

        	if(sorted.contains(pair.getKey()))
        		continue;

       		int minKey = (int)pair.getKey();
        	int minVal = (int)pair.getValue();

        	Iterator it2 = input.entrySet().iterator();
        	while(it2.hasNext()) {
        		Map.Entry pair2 = (Map.Entry)it2.next();

        		if(sorted.contains(pair2.getKey()))
        			continue;

        		if(minVal > (int)pair2.getValue()) {
        			minKey = (int)pair2.getKey();
        			minVal = (int)pair2.getValue();
        		}
        	}

        	sorted.add(minKey);

        }

        if(n > sorted.size())
        	return sorted.getLast();

        return sorted.get(n-1);
    }



    public static void main(String[] args) {
        int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5, 6, 6, 6, 6, 6, 6 }, 2);
        System.out.println(x);
    }
}