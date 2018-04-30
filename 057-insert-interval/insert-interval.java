// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
// You may assume that the intervals were initially sorted according to their start times.
//
// Example 1:
//
//
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
//
//
// Example 2:
//
//
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int len=intervals.size();
        int[] starts=new int[len+1];
        int[] ends=new int[len+1];
        for(int i=0;i<len;i++){
            starts[i]=intervals.get(i).start;
            ends[i]=intervals.get(i).end;            
        }
        starts[len]=newInterval.start;
        ends[len]=newInterval.end;
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> res=new ArrayList<Interval>();
        for(int j=0,k=0;j<=len;j++){
            if(j==len ||starts[j+1]>ends[j]){
                res.add(new Interval(starts[k],ends[j]));
                k=j+1;
            }
        }return res;
    }
}
