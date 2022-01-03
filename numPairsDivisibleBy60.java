/*
January 2nd, 2022

You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. 
Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60

my solution works, but with huge time lentgh, there was a run time error, will comment a useable solution
below
*/
class Solution {
    
    public int numPairsDivisibleBy60(int[] time) {
        //if time size is 0 or 1 return 
        if(time.length == 0 || time.length == 1) {
            return 0;
            
        }

//        System.out.println(1/2);
                
        //dobule loop through each index in l and compare theire time and see if
        //(time[i] + time[j]) % 60 == 0 , and add to a count
        int count = 0;
        
        //if they match, store index in arraylist
        List<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
        
        
        for(int i = 0; i < time.length; i++) {
            for(int j = 0; j < time.length; j++) {
                
                //check if the time % == 0 then add the count and make sure 
                //that they are not the same index
                if((time[i] + time[j]) % 60 == 0 && i != j) {
                    count++;
                }                                
                
            }
        }
        
        
        if(count % 2 == 0) {
            count = count / 2;
        } else {
            count = (count / 2) + 1;
        }
        
        
        return count;       
        
    }
}

//within runtime solution
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int arr[] = new int[60];
        int ans = 0;
        for(int i=0;i<time.length;i++){
            arr[time[i]%60]++;    // calculating the freq
        }
        for(int i=0;i<=30;i++){
            if(i==0 || i==30){
                int n = arr[i];
                ans += (n*(n-1))/2;
            }
            else{
                ans += arr[i]*arr[60-i];           // counting pairs
            }
        }
        return ans;
    }
}
