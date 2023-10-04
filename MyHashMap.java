package algorithm;

import java.util.LinkedList;

class MyHashMap {

	private static final int SIZE = 1000;
	private LinkedList<Entry>[] map;

	static class Entry {
		int key;
		int value;

		Entry(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public MyHashMap() {
		map = new LinkedList[SIZE];
	}

	private int getIdx(int key) {
		return key % SIZE;
	}

	public void put(int key, int value) {
		int index = getIdx(key);
		// initialize the linked list for a bucket if it doesn't exist yet.
		if (map[index] == null) {
			map[index] = new LinkedList<>();
		}
		// if the key already exist, add new value in map
		for (Entry entry : map[index]) {
			if (entry.key == key) {
				entry.value = value;
				return;
			}
		}
		map[index].add(new Entry(key, value));
	}

	public int get(int key) {
		int index = getIdx(key);
		if (map[index] != null) {
			for (Entry entry : map[index]) {
				if (entry.key == key) {
					return entry.value;
				}
			}
		}
		return -1;
	}

	public void remove(int key) {
		int index = getIdx(key);
		if (map[index] != null) {
			// remove all in entry (both key and value)
			// if entry.key == key
			// map[index].removeIf(entry -> entry.key == key);
			LinkedList<Entry> bucket = map[index];

			if (bucket != null) {
				for (int i = 0; i < bucket.size(); i++) {
					Entry entry = bucket.get(i);
					if (entry.key == key) {
						bucket.remove(i);
						return;
					}
				}
			}
		}
	}
}

//public class myHashMap {
//int[] data;
//public myHashMap() {
//	//initialize data array
//	data = new int[1000001];
//	Arrays.fill(data, -1);
//}
//
//public void put(int key, int value) {
//	data[key] = value;
//}
//
//public int get(int key) {
//	return data[key];
//}
//
//public void remove(int key) {
//	data[key] = -1;
//
//}
//}