import java.util.*;

class Solution {
	public int solution(String[] words) {
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		int answer = 0;
		for (String word : words) {
			answer += trie.searchWordFromFront(word);
		}

		return answer;
	}
}

class Trie {
	private Node rootNode;

	Trie() {
		rootNode = new Node();
	}

	public void insert(String word) {
		Node node = rootNode;
		for (int i = 0; i < word.length(); i++) {
			node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
			node.count++;
		}
	}

	public int searchWordFromFront(String word) {
		Node node = rootNode;
		int move = 0;
		for (int i = 0; i < word.length(); i++) {
			node = node.children.get(word.charAt(i));
			move++;

			if (node.count == 1) {
				break;
			}
		}
		return node.count == 1 ? move : word.length();
	}
}

class Node {
	Map<Character, Node> children;
	int count;

	Node() {
		this.children = new HashMap<>();
		this.count = 0;
	}
}
