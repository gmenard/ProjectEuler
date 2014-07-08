import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private static HashMap<Integer, List<Integer>> roads = new HashMap<Integer, List<Integer>>();

    public static void addRoad(Integer key, Integer value) {
        if(!roads.containsKey(key)) {
    		List<Integer> values = new ArrayList<Integer>();
    		values.add(value);
        	roads.put(key, values);
        }
    	else {
    		List<Integer> values = roads.get(key);
    		values.add(value);
    	}
	}

    public static void find_city(Integer n, Integer home_city, Integer dest_city, Integer[] firstCityRoads, Integer[] secondCityRoads) {
        for(int i = 0; i < firstCityRoads.length; i++) {
            addRoad(firstCityRoads[i], secondCityRoads[i]);
            addRoad(secondCityRoads[i], firstCityRoads[i]);
        }
        
        // BFS
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        queue.add(Arrays.asList(home_city));
        Boolean[] visitedCities = new Boolean[n];
    	Arrays.fill(visitedCities, Boolean.FALSE);
    	visitedCities[home_city] = true;
        while(!queue.isEmpty()) {
            List<Integer> path = queue.remove();
    		List<Integer> cities = roads.get(path.get(path.size() - 1));
    		for(Integer city1 : cities) {
    			if(!visitedCities[city1 - 1]) {
	    	    	visitedCities[city1 - 1] = true;
	    			if(city1.equals(dest_city)) {
	    				System.out.println(path.size());
	    			}
	    			else {
	    				List<Integer> newpath = new ArrayList<Integer>();
	    				newpath.addAll(path);
	    				newpath.add(city1);
	    				queue.add(newpath);
	    			}
    			}
    		}
        }
    }
}