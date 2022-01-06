/*
January 5th 2021

There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that 
the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. 
The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.


*/
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int takenSeats = 0;
        int from = 0;
        int i = 0;
        boolean possible = true;
        Queue<Integer> q = new LinkedList<>();
        
        while(takenSeats <= capacity && i != trips.length) {
            if(from > trips[i][1]) {
                return false;
            }
            
            //passenger off at from
            from = trips[i][1];
            takenSeats = takenSeats - passengerOff(trips, from);
            q.remove(trips[i][1]);
            
            //check q to see if current trips[i] bigger than q peek
            if(!q.isEmpty() && q.peek() < trips[i][1]) {
                
                while(!q.isEmpty()) {
                    takenSeats = takenSeats - passengerOff(trips, q.poll());
                }
            }
            
                       
            if(takenSeats + trips[i][0] > capacity) {
                takenSeats = takenSeats + trips[i][0];
                possible = false;
                break;
            }
            takenSeats = takenSeats + trips[i][0];       
            q.add(trips[i][2]);            
            i++;
            
        }
        
        return possible;
    }
    
    public int passengerOff(int[][] trips, int to) {
        //returns how many passenger getting off at the stop "to"
        
        for(int i = 0; i < trips.length; i++) {
            if(trips[i][2] == to) {
               return trips[i][0]; 
            }
        }
        return 0;
    }
}
