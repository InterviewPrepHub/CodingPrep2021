package Trie;

public class TrieImpl {

    TNode root;

    public TrieImpl() {
        root = new TNode();

    }

    public void insert(String word) {

        /*TNode curr = root;
        for(char c : word.toCharArray()){
            curr.children.putIfAbsent(c, new TNode());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;*/

        TNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TNode node = current.children.get(ch);
            if (node == null){
                node = new TNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.endOfWord = true;

    }

    public boolean search(String word) {

        TNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.endOfWord;

    }

    public boolean startsWith(String prefix) {
        TNode curr = root;
        for(char c : prefix.toCharArray()){
            if(!curr.children.containsKey(c)) {
                return false;
            }

            curr = curr.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] input = {{}, {"apple"}, {"apple"}, {"app"}, {"app"}, {"app"}, {"app"}};
        TrieImpl trie = new TrieImpl();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app"));       // return True
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.startsWith("app"));
    }
}

//    public boolean delete(String word) {
//        return delete(root,word,0);
//    }
//
//    private boolean delete(TNode root, String word, int index) {
//        TNode currNode = root;
//        if (index == word.length()) {
//            if(!currNode.endOfWord) {
//                return false;
//            }
//            currNode.endOfWord = false;
//            return currNode.children.size() == 0;
//        }
//
//        TNode node = currNode.children.get(word.charAt(index));
//        if (node == null) {
//            return false;
//        }
//        boolean shouldDeleteCurrNode = delete(node,word,index+1);
//    }

