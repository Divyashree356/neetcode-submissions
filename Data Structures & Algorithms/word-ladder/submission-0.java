class Solution {
    class Pair {
        String s;
        int count;

        public Pair(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();

        for (String s : wordList)
            hs.add(s);

        q.add(new Pair(beginWord, 1));
        hs.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().s;
            int steps = q.peek().count;
            q.poll();

            if (word.equals(endWord))
                return steps;
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] wordToChar = word.toCharArray();
                    wordToChar[i] = c;
                    String newWord = new String(wordToChar);
                    if (hs.contains(newWord)) {
                        q.add(new Pair(newWord, steps + 1));
                        hs.remove(newWord);
                    }
                }
            }

        }
        return 0;
    }
}