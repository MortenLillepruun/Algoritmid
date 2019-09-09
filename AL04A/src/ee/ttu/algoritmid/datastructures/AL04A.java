package ee.ttu.algoritmid.datastructures;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * AL04A lab task.
 */
public class AL04A {
    
    /**
     * The number of runs to measure average time.
     */
    public static final int NUMBER_OF_REPEATS = 3;
    
    /**
     * Exception penalty for violating data structures (to force them not to be not feasible).
     */
    public static final int EXCEPTION_PENALTY = 99999999;

        public class ComparisonListImpl implements ComparisonList {
        	
        	private ArrayList<Integer> list;

			public ComparisonListImpl() {
        		this.list = new ArrayList<Integer>();
        	}

			@Override
			public void clear() {
				list.clear();
				
			}

			@Override
			public void insert(Integer value) throws Exception {
				list.add(value);
				
			}

			@Override
			public boolean search(Integer value) {
				return list.contains(value);
			}

			@Override
			public Integer delete(Integer value) {
				for (int i = 0; i < list.size(); i++) {
					if (list.remove(i) == value) {
						return list.remove(i);
					}
				}
				return null;
			}

			@Override
			public Integer deleteMin() {
				Integer minIndex = list.indexOf(Collections.min(list));
				return delete(list.get(minIndex));
			}

			@Override
			public List<Integer> getData() {
				// TODO Auto-generated method stub
				return list;
			}
            //TODO implement the interface
            
        }

        public class ComparisonPriorityQueueImpl implements ComparisonPriorityQueue {
        	
        	private PriorityQueue<Integer> pq;

			public ComparisonPriorityQueueImpl() {
				this.pq = new PriorityQueue<Integer>();
			}

			@Override
			public void clear() {
				pq.clear();
				
			}

			@Override
			public void insert(Integer value) throws Exception {
				pq.add(value);
				
			}

			@Override
			public boolean search(Integer value) {
				return pq.contains(value);
			}

			@Override
			public Integer delete(Integer value) {
				if (pq.remove(value)) {
					pq.remove(value);
					return value;
				}
				return null;
			}

			@Override
			public Integer deleteMin() {
				return pq.remove();
			}

			@Override
			public PriorityQueue<Integer> getData() {
				// TODO Auto-generated method stub
				return pq;
			}
            //TODO implement the interface
            
        }

        public class ComparisonTreeSetImpl implements ComparisonTreeSet {
        	
        	private TreeSet<Integer> treeSet;

			public ComparisonTreeSetImpl() {
				this.treeSet = new TreeSet<Integer>();
			}

			@Override
			public void clear() {
				treeSet.clear();
				
			}

			@Override
			public void insert(Integer value) throws Exception {
				treeSet.add(value);
				
			}

			@Override
			public boolean search(Integer value) {
				return treeSet.contains(value);
			}

			@Override
			public Integer delete(Integer value) {
				if (treeSet.remove(value)) {
					treeSet.remove(value);
					return value;
				}
				return null;
			}

			@Override
			public Integer deleteMin() {
				return treeSet.first();
			}

			@Override
			public TreeSet<Integer> getData() {
				// TODO Auto-generated method stub
				return treeSet;
			}
            //TODO implement the interface
            
        }

        public class ComparisonHashtableImpl implements ComparisonHashtable {
        	
        	private Hashtable<Integer, Integer> hash;

			public ComparisonHashtableImpl() {
        		this.hash = new Hashtable<Integer, Integer>();
			}

			@Override
			public void clear() {
				hash.clear();
				
			}

			@Override
			public void insert(Integer value) throws Exception {
				hash.put(value, value);
				
			}

			@Override
			public boolean search(Integer value) {
				return hash.contains(value);
			}

			@Override
			public Integer delete(Integer value) {
				return hash.remove(value);
			}

			@Override
			public Integer deleteMin() {
				
				return Collections.min(hash.values());
			}

			@Override
			public Hashtable<Integer, Integer> getData() {
				// TODO Auto-generated method stub
				return hash;
			}
            //TODO implement the interface
            
        }
    
    /**
     * Create a good example to demonstrate under which circumstances PriorityQueue is best.
     * Choose the appropriate parameters by experimentation and thinking logically.
     * Choose parameters reasonably (i.e., no point having no inserts etc.)
     *
     * @param insertOrder insertion order
     * @param searchOrder search order
     * @param deleteOrder delete order
     * @param deleteMin find and delete minimum element the number of elements times
     * @return            the list with data structure names and measurement times 
     *                    (e.g., ["ComparisonListArrayImpl", 0.3], ["ComparisonHashtableImpl", 0.4] etc.)
     */
    public final List<Entry<String, Double>> priorityQueueIsBestWhen(List<Integer> insertOrder, List<Integer> searchOrder,
                                                                     List<Integer> deleteOrder, List<Boolean> deleteMin) {
        //TODO finish this function
        insertOrder.clear();
        searchOrder.clear();
        deleteOrder.clear();
        deleteMin.clear();
        
        for (int i = 1; i <= 10000; i++) {
			insertOrder.add(i);
			deleteOrder.add(i);
			deleteMin.add(true);
		}

        // Fill the insertOrder, searchOrder, deleteOrder and deleteMin lists as necessary
        // ...
        
        return dataStructureComparison(insertOrder, searchOrder, deleteOrder, deleteMin, NUMBER_OF_REPEATS);
    }

    /**
     * Create a good example to demonstrate under which circumstances ArrayList is not the worst (or best!).
     * Choose the appropriate parameters by experimentation and thinking logically.
     * Choose parameters reasonably (i.e., no point having no inserts etc.)
     *
     * @param insertOrder insertion order
     * @param searchOrder search order
     * @param deleteOrder delete order
     * @param deleteMin find and delete minimum element the number of elements times
     * @return            the list with data structure names and measurement times (e.g., ["List", 0.3], ["Hashtable", 0.4] etc.)
     */
    public final List<Entry<String, Double>> arrayListIsNotTheWorstWhen(List<Integer> insertOrder, List<Integer> searchOrder,
                                                                        List<Integer> deleteOrder, List<Boolean> deleteMin) {
        //TODO finish this function
        insertOrder.clear();
        searchOrder.clear();
        deleteOrder.clear();

        // Fill the insertOrder, searchOrder, deleteOrder and deleteMin lists as necessary
        // ...
        
        for (int i = 1; i <= 10000; i++) {
			insertOrder.add(i);
			deleteOrder.add(i);
			searchOrder.add(i);
		}

        return dataStructureComparison(insertOrder, searchOrder, deleteOrder, deleteMin, NUMBER_OF_REPEATS);
    }

    /**
     * Create a good example to demonstrate under which circumstances HashTable is the best data structure to use.
     * Choose the appropriate parameters by experimentation and thinking logically.
     * Choose parameters reasonably (i.e., no point having no inserts etc.)
     *
     * @param insertOrder insertion order
     * @param searchOrder search order
     * @param deleteOrder delete order
     * @param deleteMin find and delete minimum element the number of elements times
     * @return            the list with data structure names and measurement times (e.g., ["List", 0.3], ["Hashtable", 0.4] etc.)
     */
    public final List<Entry<String, Double>> hashtableIsTheBestWhen(List<Integer> insertOrder, List<Integer> searchOrder,
                                                                    List<Integer> deleteOrder, List<Boolean> deleteMin) {
        //TODO finish this function
        insertOrder.clear();
        searchOrder.clear();
        deleteOrder.clear();
        deleteMin.clear();
        
        // Fill the insertOrder, searchOrder, deleteOrder and deleteMin lists as necessary
        // ...
        
        for (int i = 1; i <= 10000; i++) {
			insertOrder.add(i);
			deleteOrder.add(i);
			searchOrder.add(i);
		}

        return dataStructureComparison(insertOrder, searchOrder, deleteOrder, deleteMin, NUMBER_OF_REPEATS);
    }

    /**
     * Create a good example to demonstrate under which circumstances TreeSet is the best data structure to use.
     * Choose the appropriate parameters by experimentation and thinking logically.
     * Choose parameters reasonably (i.e., no point having no inserts etc.)
     *
     * @param insertOrder insertion order
     * @param searchOrder search order
     * @param deleteOrder delete order
     * @param deleteMin   find and delete minimum element the number of elements times
     * @return            the list with data structure names and measurement times (e.g., ["List", 0.3], ["Hashtable", 0.4] etc.)
     */
    public final List<Entry<String, Double>> treeSetIsTheBestWhen(List<Integer> insertOrder, List<Integer> searchOrder,
                                                                  List<Integer> deleteOrder, List<Boolean> deleteMin) {
        //TODO finish this function
        insertOrder.clear();
        searchOrder.clear();
        deleteOrder.clear();
        deleteMin.clear();

        // Fill the insertOrder, searchOrder, deleteOrder and deleteMin lists as necessary
        // ...
        
        for (int i = 1; i <= 10000; i++) {
			insertOrder.add(i);
			deleteMin.add(true);
			searchOrder.add(i);
		}
        
        return dataStructureComparison(insertOrder, searchOrder, deleteOrder, deleteMin, NUMBER_OF_REPEATS);
    }
    
    /* ----------------------------------------------------------------------------------------------
     * The stuff below you don't need to change. It's bookkeeping stuff for making the measurements.
     * ----------------------------------------------------------------------------------------------
     */

    /**
     * Data structure procedures - insert, search and delete.
     * Insert all elements in insertOrder, then
     * Search for every item in searchOrder and then
     * Delete all of the items in deleteMin and deleteOrder.
     * 
     * @param insertOrder insertion order
     * @param searchOrder search order
     * @param deleteOrder delete order
     * @param deleteMin   find and delete minimum element the number of elements times
     */
    public final void procedures(ComparisonGeneric dataStructure, List<Integer> insertOrder, List<Integer> searchOrder,
                                 List<Integer> deleteOrder, List<Boolean> deleteMin) 
                                 throws Exception {
        for (Integer l : insertOrder) {
            dataStructure.insert(l);
        }
        for (Integer l : searchOrder) {
            dataStructure.search(l);
        }
        for (int i = 0; i < deleteMin.size(); i++) {
            dataStructure.deleteMin();
        }
        for (Integer l : deleteOrder) {
            dataStructure.delete(l);
        }
    }

    /**
     * Compare the data structures to each other by measuring their performance given the input data.
     * 
     * @param insertOrder    insertion order
     * @param searchOrder    search order
     * @param deleteOrder    delete order
     * @param deleteMin      find and delete minimum element the number of elements times
     * @param numberOfTimes  the number of repeats for averaging
     * @return    the resulting data structure
     */
    public final List<Entry<String, Double>> dataStructureComparison(List<Integer> insertOrder, List<Integer> searchOrder,
                                                                     List<Integer> deleteOrder, List<Boolean> deleteMin,
                                                                     int numberOfTimes) {
        List<Entry<String, Double>> rv = new ArrayList<>();
        List<ComparisonGeneric> dataStructures = new ArrayList<>();
        dataStructures.add(new ComparisonListImpl());
        dataStructures.add(new ComparisonHashtableImpl());
        dataStructures.add(new ComparisonPriorityQueueImpl());
        dataStructures.add(new ComparisonTreeSetImpl());
        for (int i = 0; i < dataStructures.size(); i++) {
            long total = 0;
            for (int j = 0; j < numberOfTimes; j++) {
                long start = System.currentTimeMillis();
                long end = start;
                try {
                    dataStructures.get(i).clear();
                    procedures(dataStructures.get(i), insertOrder, searchOrder, deleteOrder, deleteMin);
                    end = System.currentTimeMillis();
                } catch (Exception e) {
                    end = System.currentTimeMillis() + EXCEPTION_PENALTY;
                }
                total += end - start;
                System.out.println(dataStructures.get(i).getClass().getSimpleName() + " procedures took " + (end - start) + " ms.");
            }
            System.out.println(dataStructures.get(i).getClass().getSimpleName() + " average is " + (total / numberOfTimes) + " ms.");
            rv.add(new SimpleEntry<String, Double>(dataStructures.get(i).getClass().getSimpleName(), ((double) (total / numberOfTimes)) / 1000.0));
        }
        return rv;
    }
}