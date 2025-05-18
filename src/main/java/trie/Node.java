package trie;

class Node {
  Node[] links = new Node[26];
  boolean flag = false;

  boolean containsKey(char ch) {
    return links[ch - 'a'] != null;
  }

  void put(char ch, Node node) {
    links[ch - 'a'] = node;
  }

  Node get(char ch) {
    return links[ch - 'a'];
  }

  void setEnd() {
    flag = true;
  }

  boolean isEnd() {
    return flag;
  }
}

class Trie {
  private Node root;

  Trie() {
    root = new Node();
  }

  void insert(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.containsKey(ch)) {
        Node temp = new Node();
        node.put(ch, temp);
      }
      node = node.get(ch);
    }
    node.setEnd();
  }

  boolean search(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.containsKey(ch)) return false;
      node = node.get(ch);
    }
    return node.isEnd();
  }

  boolean startsWith(String prefix) {
    Node node = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      if (!node.containsKey(ch)) return false;
      node = node.get(ch);
    }
    return true;
  }
}
