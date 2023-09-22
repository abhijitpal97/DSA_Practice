package com.example.gspractice;

import java.util.*;

public class LongestTreeInaForest {
	public static Integer getTreeSize(final Map<Integer, List<Integer>> parentToChild, final Integer rootIndex) {
		Integer result = 0;
		final Stack<Integer> nodes = new Stack<>();
		nodes.push(rootIndex);
		while (!nodes.empty()) {
			final Integer index = nodes.pop();
			for (final Integer childIndex : parentToChild.getOrDefault(index, new ArrayList<>())) {
				nodes.push(childIndex);
				result++;
			}
		}
		System.out.println("Tree Size: "+result);
		return result;
	}

	/*
	 ** Find the largest tree.
	 */
	public static Integer largestTree(final Map<Integer, Integer> immediateParent) {
		Integer maxTreeSize = 0;
		Integer minRootId = 0;
		final Map<Integer, List<Integer>> parentToChild = new HashMap<>();
		final List<Integer> rootIndexes = new ArrayList<>();
		for (final Map.Entry<Integer, Integer> childToParent : immediateParent.entrySet()) {
			final Integer childIndex = childToParent.getKey();
			final Integer parentIndex = childToParent.getValue();

			System.out.println("Child Index: "+childIndex+", parent Index: "+parentIndex);

			parentToChild.putIfAbsent(parentIndex, new ArrayList<>());
			parentToChild.get(parentIndex).add(childIndex);
			for(Map.Entry<Integer, List<Integer>> ptC:parentToChild.entrySet()) {
				System.out.print("key: "+ptC.getKey()+" ---> "+ptC.getValue().toString());
			}
			System.out.println("");
			if (!immediateParent.containsKey(parentIndex)) {
				rootIndexes.add(parentIndex);
				System.out.println("parent Index added in root indexes: "+parentIndex);
			}
			System.out.println("--------------------------------------------------------");
		}
		for (final Integer rootIndex : rootIndexes) {
			final Integer treeSize = getTreeSize(parentToChild, rootIndex);
			System.out.println("Root Indexes : "+rootIndex+" and size of tree : "+treeSize);
			if (treeSize > maxTreeSize) {
				maxTreeSize = treeSize;
				minRootId = rootIndex;
			} else if (treeSize == maxTreeSize) {
				minRootId = Math.min(minRootId, rootIndex);
			}
		}

		return minRootId;
	}

	/*
	 ** Returns true if the tests pass. Otherwise, returns false;
	 */
	public static boolean doTestsPass() {
		// map of test cases to expected results
		final Map<Map<Integer, Integer>, Integer> testCases = new HashMap<>();

		// example
		final Map<Integer, Integer> testCaseOneKey = new HashMap<>() {
			{
				put(1, 2);
				put(3, 4);
			}
		};
		testCases.put(testCaseOneKey, 2);

		// More than two trees
		final Map<Integer, Integer> testCaseTwoKey = new HashMap<>() {
			{
				put(2, 3);
				put(7, 8);
				put(12, 15);
				put(3, 1);
				put(0, 20);
				put(13, 15);
				put(11, 15);
				put(9, 8);
				put(5, 12);
			}
		};
		testCases.put(testCaseTwoKey, 15);

		// really large index values
		final Map<Integer, Integer> testCaseThreeKey = new HashMap<>() {
			{
				put(200000000, 300000000);
				put(500000000, 200000000);
				put(700000000, 300000000);
				put(600000000, 700000000);
				put(900000000, 400000000);
				put(100000000, 400000000);
				put(800000000, 400000000);
				put(1000000000, 400000000);
			}
		};
		testCases.put(testCaseThreeKey, 300000000);

		// two trees of same size
		final Map<Integer, Integer> testCaseFourKey = new HashMap<>() {
			{
				put(9, 4);
				put(1, 4);
				put(5, 2);
				put(8, 4);
				put(7, 3);
				put(2, 3);
				put(6, 7);
				put(10, 4);
			}
		};
		testCases.put(testCaseFourKey, 3);

		// tree sizes differ by one
		final Map<Integer, Integer> testCaseFiveKey = new HashMap<>() {
			{
				put(35, 33);
				put(33, 28);
				put(31, 22);
				put(28, 25);
				put(34, 31);
				put(29, 27);
				put(21, 23);
				put(25, 21);
				put(22, 29);
			}
		};
		testCases.put(testCaseFiveKey, 23);

		boolean passed = true;
		//		for (Map.Entry<Map<Integer, Integer>, Integer> entry : testCases.entrySet()) {
		//			final Integer actual = largestTree(entry.getKey());
		//			if (!actual.equals(entry.getValue())) {
		//				passed = false;
		//				System.out.println("Failed for " + entry.getKey().toString() + "\n  expected " + entry.getValue()
		//				+ ", actual " + actual);
		//			}else {
		//				System.out.println("Actual : "+actual+", entry.getValue() : "+entry.getValue());
		//			}
		//			break;
		//		}

		for (Map.Entry<Map<Integer, Integer>, Integer> entry : testCases.entrySet()) {
			final Integer actual = largestTreeUsingQueue(entry.getKey());
			if (!actual.equals(entry.getValue())) {
				passed = false;
				System.out.println("Failed for " + entry.getKey().toString() + "\n  expected " + entry.getValue()
				+ ", actual " + actual);
			}else {
				System.out.println("Actual : "+actual+", entry.getValue() : "+entry.getValue());
			}
			break;
		}

		return passed;
	}

	/*
	 ** Execution entry point.
	 */
	public static void main(String[] args) {
		// Run the tests
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
	}

	public static int largestTreeUsingQueue(Map<Integer,Integer> map)
	{
		Map<Integer,List<Integer>> parentToChild = new HashMap<>();
		List<Integer> possibleRoots = new ArrayList<>();

		for(Map.Entry<Integer,Integer> m1 : map.entrySet())
		{
			int child = m1.getKey();
			int parent = m1.getValue();

			if(parentToChild.containsKey(parent)) parentToChild.get(parent).add(child);
			else parentToChild.put(parent, new ArrayList<>(Arrays.asList(child)));

			if(! map.containsKey(parent)) possibleRoots.add(parent);
		}

		int maxLen = 0;
		int id = 0;
		for(Integer root : possibleRoots)
		{
			int size = getSize(parentToChild , root);
			if(size>maxLen)
			{
				maxLen = size;
				id = root;
			}
		}

		return id;
	}

	static int getSize(Map<Integer,List<Integer>> parentToChild , int index)
	{
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(index);

		while(! queue.isEmpty())
		{
			int curr = queue.poll();
			count++;
			if(! parentToChild.containsKey(curr)) continue;
			for(Integer i : parentToChild.get(curr))
			{
				queue.offer(i);
			}
		}

		return count;
	}
}

