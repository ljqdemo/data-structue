


public class Solution {
    /**
     * 返回两次操作后，数组元素之和的最小值
     * @param nums int整型一维数组 这你你需要操作的数组
     * @return long长整型
     */
    public long minimumValueAfterDispel (int[] nums) {
    	  int index=nums.length/2;
          for(int i=0;i<2;i++){
              sort(nums);
              for(int j=0;j<nums.length;j++) {
          		System.out.print(nums[j]+" ");
          	}
              int reduce=nums[index];
              System.out.println("----- "+reduce );
              reduceByKey(reduce,nums);
          }
       
            
      return getsum(nums);
    }
    
    public long getsum( int [] nums){
         long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }
   public void sort( int []nums){
       int j;
       //对数据进行排序
       for(int i=1;i<nums.length;i++){
                 j=i;
                                 int temp=nums[i];
                while(j>0&&nums[j-1]>=temp)
                {
                    nums[j]=nums[j-1];
                    j--;
                }
           nums[j]=temp;
       }
   }
    //减少
   public void reduceByKey(int key,int[] nums){
       for(int i=0;i<nums.length;i++){
           if(nums[i]>=key){
               nums[i]-=key;
           }
       }
   } 
    public static void main(String[] args) {
    	Solution s=new Solution();
    	int [] a= {9, 1, 2, 7, 2, 1, 6, 0, 1, 8};
    	long ss =s.minimumValueAfterDispel(a);
    	System.out.println(ss);
    	for(int i=0;i<a.length;i++) {
    		System.out.print(a[i]+" ");
    	}
	}
}