class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        genPar(set, "", n, 0, 0);
        List<String> res = new ArrayList<>(set);;

        return res;
    }

    private void genPar(Set<String> set, String s, int n, int c,int o) {
        if(c == n ) {
            set.add(s);

        } else if(o == 0) {
            genPar(set, s + "(", n, c , o + 1);

        } else if(o == n && c != n) {
            //all open start closing
            genPar(set, s + ")", n, c + 1, o);

        } else {
            if(c != o) {
                genPar(set, s + ")", n, c + 1, o);
            }           
            genPar(set, s + "(", n, c , o + 1);

            
        }
    }
}
