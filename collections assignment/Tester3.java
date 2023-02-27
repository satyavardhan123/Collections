package exc1;
import java.util.HashMap;
public class Tester3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 HashMap<String, Integer> mapOne = new HashMap<>();
	        mapOne.put("Kelly", 10);
	        mapOne.put("Micheal", 20);
	        mapOne.put("Ryan", 30);

	        HashMap<String, Integer> mapTwo = new HashMap<>();
	        mapTwo.put("Jim", 15);
	        mapTwo.put("Andy", 45);

	        HashMap<String, Integer> mergedMapOne = mergeMaps(mapOne, mapTwo);
	        System.out.println(mergedMapOne); 
	        HashMap<String, Integer> mapThree = new HashMap<>();
	        mapThree.put("Toby", 15);
	        mapThree.put("Micheal", 20);
	        mapThree.put("Angela", -30);

	        HashMap<String, Integer> mapFour = new HashMap<>();
	        mapFour.put("Toby", 15);
	        mapFour.put("Andy", 45);
	        mapFour.put("Micheal", 40);

	        HashMap<String, Integer> mergedMapTwo = mergeMaps(mapThree, mapFour);
	        System.out.println(mergedMapTwo); 
	    }

	    public static HashMap<String, Integer> mergeMaps(HashMap<String, Integer> mapOne, HashMap<String, Integer> mapTwo) {
	        HashMap<String, Integer> mergedMap = new HashMap<>();
	        for (String key : mapOne.keySet()) {
	            if (mapTwo.containsKey(key)) {
	                mergedMap.put(key + "new", mapTwo.get(key));
	                mapTwo.remove(key);
	            } else {
	                mergedMap.put(key, mapOne.get(key));
	            }
	        }
	        mergedMap.putAll(mapTwo);
	        return mergedMap;

	}

}
