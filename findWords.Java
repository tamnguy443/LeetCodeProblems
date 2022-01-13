/*
January 12th 2022

Given an array of strings words, return the words that can be typed using letters of the alphabet 
on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".


*/
class Solution {
    public String[] findWords(String[] words) {
        List<String> al = new ArrayList<String>();
        
        String a = "qwertyuiop";
        String b = "asdfghjkl";
        String c = "zxcvbnm";
        
        for(int i = 0; i < words.length; i++) {
            
		    if(words[i].toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")) {
			    
	            al.add(words[i]);
	        } 
                                
        }
        
        String[] arr = new String[al.size()];
        arr = al.toArray(arr);      
        
        return arr;
    }
    
    
}
