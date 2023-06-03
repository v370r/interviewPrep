package udemyDSA.trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        System.out.println("The trie has been created !");
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Successfully inserted :" + word);
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);
            if (node == null) {
                System.out.println("Word : " + word + "does not exists in Trie");
                return false;
            }
            currentNode = node;

        }
        if (currentNode.endOfString == true) {
            System.out.println("Word : " + word + " exists in trie");
            return true;
        } else {
            System.out.println("Word : " + word + "does not exists in trie, But it is a prefix of another string");
        }
        return currentNode.endOfString;
    }

    /*
     * case 1 : Some other prefix of string is same as the one that we want to
     * delete (API, APPLE)
     * 
     * case 2 : the string is a prefix of another string (API, APIS)
     * 
     * case 3 : Other string isa prefix of this string (APIS,AP) REMOVE DELETE i and
     * 
     * case 4 : Not any node depends on this string (k)
     */
    private boolean delete(TrieNode parenTrieNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parenTrieNode.children.get(ch);
        boolean canThisNodeBeDeleted;
        if (currentNode.children.size() > 1) {
            delete(currentNode, word, index + 1);
            return false;
        }
        if (index == word.length() - 1) {
            if (currentNode.children.size() >= 1) {
                currentNode.endOfString = false;
                return false;
            } else {
                parenTrieNode.children.remove(ch);
                return true;
            }
        }
        if (currentNode.endOfString == true) {
            delete(currentNode, word, index + 1);
            return false;
        }
        canThisNodeBeDeleted = delete(currentNode, word, index + 1);
        if (canThisNodeBeDeleted == true) {
            parenTrieNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }

    public void delete(String word) {
        if (search(word) == true) {
            delete(root, word, 0);
        }
    }
}
