public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int result=0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums){
            if(!map.containsKey(num)){
                int oneLess=map.containsKey(num-1)?map.get(num-1):0;
                int oneMore=map.containsKey(num+1)?map.get(num+1):0;
                
                int sum=oneLess+oneMore+1;
                map.put(num,sum);
                //updating boundaries
                map.put(num-oneLess,sum);
                map.put(num+oneMore,sum);
                
                result=Math.max(result,sum);
            }
        }
        return result;
    }
}