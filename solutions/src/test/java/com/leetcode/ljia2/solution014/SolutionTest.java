package com.leetcode.ljia2.solution014;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test() throws FileNotFoundException{
		Solution solution = new Solution();
		BufferedReader br = new BufferedReader(new FileReader("src/test/resources/com/leetcode/ljia2/solutions/lcp014/test.case.1.txt"));
		List<String> strs = new ArrayList<String>();
		String str;
		try {
			while((str = br.readLine()) != null){
				strs.add(str);
			}
			br.close();
			
			System.out.println("Longest Common Prefix : " + solution.longestCommonPrefix(strs.toArray(new String[strs.size()])));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
