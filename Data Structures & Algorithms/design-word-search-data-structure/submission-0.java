class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isLeaf = true;
    }

    public boolean search(String word) {
        Node cur = root;
        return searchHelper(word, 0, cur);
    }

       public boolean searchHelper(String word, int curIdx, Node next){
        if(next == null) return false;
        
        if(curIdx == word.length()) return next.isLeaf;
        char c= word.charAt(curIdx);

        if(c == '.'){   
            for(int i =0; i < 26; i++){
                if(next.children[i] != null && searchHelper(word, curIdx+1, next.children[i])){
                    return true;
                }
            }
            return false;
        } 

        return searchHelper(word, curIdx+1, next.children[c - 'a']);
    }

    class Node {
        Node[] children;
        boolean isLeaf;

        Node() {
            this.children = new Node[26];
            this.isLeaf = false;
        }
    }
}
