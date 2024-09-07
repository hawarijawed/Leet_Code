class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(target < Integer.MIN_VALUE || target > Integer.MAX_VALUE){
            return res;
        }
        //Sort the array  -2,147,483,648 to 2,147,483,647.
        Arrays.sort(nums);
        int size = nums.length;
        if(size == 4){
            if((nums[0] +  nums[1] + nums[2] + nums[3]) > target){
                return res;
            }
        }
        for(int i=0; i<size-3; i++){
            if( i>0 && nums[i] ==nums[i-1]){
                continue;
            }

            for(int j =i+1; j<size-2; j++){
                if( j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int left = j+1;
                int right = size-1;
                while(left < right){
                    long val = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
                    // if(val < Integer.MIN_VALUE || val > Integer.MAX_VALUE){
                    //     return res;
                    // }
                    if(val == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while( left<right && nums[left] == nums[left+1]){
                            left++;
                        }

                        while( left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(val<target){
                        left++;
                    }
                    else if(val > target){
                        right--;
                    }
                    
                }
            }
        }

        return res;

    }
}
