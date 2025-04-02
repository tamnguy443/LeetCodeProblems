class Solution {
    public long mostPoints(int[][] questions) {
        long[] best = new long[questions.length];

        find(0, questions, best);
        return best[0];
    }

    public long find(int i, int[][] questions, long[] b ) {
        if (i > questions.length - 1) {
            return 0;
        }
        b[i] = Math.max(questions[i][0] + find(questions[i][1]+i+1, questions, b)
            , find(i + 1, questions, b)
        );
        return b[i];
    }
}
