package com.leetcode.ljia2.solution056;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leetcode.ljia2.Interval;

public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> results = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0) return results;
		
		// how to define a new comparator !!!! 
        Collections.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval e1, Interval e2){
                return e1.start - e2.start;
        	}
        });
        
        for(Interval interval : intervals){
        	mergeInterval(results, interval);
        }
        return results;	
	}
	
	public void mergeInterval(List<Interval> results, Interval interval){
		if(results == null || results.size() == 0) results.add(interval);
		
		Interval lastInterval = results.get(results.size()-1);
		if(lastInterval.end < interval.start){
			results.add(interval);
		}else{
			results.remove(results.size()-1);
			results.add(new Interval(lastInterval.start, Math.max(lastInterval.end, interval.end)));
		}
	}
}
