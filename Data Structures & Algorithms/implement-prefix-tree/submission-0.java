class PrefixTree {
    Node root;
    public PrefixTree() {
          root = new Node();
    }

    public void insert(String word) {
Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c-'a'] = new Node();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
  Node curr = root;
        for(char c : word.toCharArray()){
            if (curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
 Node curr = root;
        for(char c : prefix.toCharArray()){
            if (curr.children[c - 'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return true;
    }

    class Node{
        Node[] children;
        boolean isEnd;

        Node(){
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
}
