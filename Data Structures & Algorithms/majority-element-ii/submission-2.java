class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int num1=-1, num2=-1, cnt1=0, cnt2=0;
        for(int i : nums){
            if(i==num1) cnt1++;
            else if(i==num2) cnt2++;
            else if (cnt1==0){
                cnt1=1;
                num1=i;
            }
            else if (cnt2==0){
                cnt2=1;
                num2=i;
            } else  {
                cnt2--;
                cnt1--;
            }
        }
        cnt1=cnt2=0;
        for(int i : nums){
            if(i==num1) cnt1++;
            if(i==num2) cnt2++;
        }
        List<Integer> l = new ArrayList<>();
        if(cnt1>n/3) l.add(num1);
        if(cnt2>n/3) l.add(num2);
        return l;
    }
}