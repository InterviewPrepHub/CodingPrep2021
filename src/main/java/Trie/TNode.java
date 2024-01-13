package Trie;

import java.util.HashMap;
import java.util.Map;

public class TNode {

    Map<Character, TNode> children;
    boolean endOfWord;

    TNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}
