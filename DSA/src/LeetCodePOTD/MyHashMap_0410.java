package LeetCodePOTD;

import java.util.Arrays;

// https://leetcode.com/problems/design-hashmap/description/

public class MyHashMap_0410 {
	int[] map;
	public MyHashMap_0410() {
		map = new int[1000001];
		Arrays.fill(map , -1);
	}

	public void put(int key, int value) {
		map[key] = value;
	}

	public int get(int key) {
		if(map[key] == -1) return -1;
		return map[key];
	}

	public void remove(int key) {
		map[key] = -1;
	}
}
