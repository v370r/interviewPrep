package leetCode;

import java.util.*;

class WordDictionary {
    TrieNode trie;

    public WordDictionary() {
        trie = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode node = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.endOfString = true;

    }

    public boolean search(String word) {
        return helper(trie, word, 0);

    }

    private boolean helper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.endOfString;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode trieNode : node.children.values()) {
                if (helper(trieNode, word, index + 1)) {
                    return true;
                }
            }
        } else {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
            return helper(node, word, index + 1);
        }

        return false;
    }

}

class TrieNode {
    HashMap<Character, TrieNode> children;
    Boolean endOfString;

    public TrieNode() {
        children = new HashMap<>();
        endOfString = false;
    }
}

class Test {
    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        dict.addWord("pad");
        System.out.println("id founc? :" + dict.search("bad"));
        System.out.println("id founc? :" + dict.search("b.."));

    }
}
