package com.erste.wordcounter;

import java.util.Comparator;

/**
 * In natural ordering uppercase come before lowercase. This comparator does
 * this change: lowercase comes before uppercase.
 */
public class LowercaseFirstComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		for (int i = 0, len = Math.min(arr1.length, arr2.length); i < len; i++) {
			char c1 = arr1[i];
			char c2 = arr2[i];
			if (c1 == c2)
				continue;
			if (Character.isLowerCase(c1) && Character.isUpperCase(c2)) {
				return -1;
			}
			if (Character.isUpperCase(c1) && Character.isLowerCase(c2)) {
				return 1;
			}
			return Character.compare(c1, c2);
		}
		if (arr1.length == arr2.length) {
			return 0;
		}
		return arr1.length > arr2.length ? 1 : -1;
	}
}
