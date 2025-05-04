/*
In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
If it cannot be done, return -1.

Example 1:
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
*/
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int[] topsC= new int[6];
        int[] bottomsC= new int[6];

        for(int i = 1; i < tops.length; i++) {
            //return -1 if no matches
            if((tops[i] != tops[i - 1] 
                && tops[i] != bottoms[i - 1]) 
                &&
                (bottoms[i] != tops[i - 1] 
                && bottoms[i] != bottoms[i - 1])) {

                return -1;
            }

        }
        for(int i = 0; i < tops.length; i++) {
            // count how manytime each int shows up in tops and bottom
            topsC[tops[i]-1]++;
            bottomsC[bottoms[i]-1]++;
        }

        int maxT= 0;
        int maxB= 0;

        for (int i = 0; i < topsC.length; i++) {
            if (topsC[i] > topsC[maxT]) {
                maxT = i;
            }
            if (bottomsC[i] > bottomsC[maxB]) {
                maxB = i;
            }
        }

        if(topsC[maxT] > bottomsC[maxB]) {

            return tops.length - topsC[maxT];
        } else {

            return bottoms.length - bottomsC[maxB];
        }

    }
}
