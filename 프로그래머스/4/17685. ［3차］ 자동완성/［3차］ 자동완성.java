import java.util.*;

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    TrieNode root = new TrieNode();

    // 트라이에 단어 삽입
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.count++;
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.count++;
    }

    // 해당 단어가 몇 글자 입력해야 고유해지는지 계산
    private int countTyping(String word) {
        TrieNode node = root;
        int cnt = 0;
        for (char c : word.toCharArray()) {
            cnt++;
            node = node.children.get(c);
            if (node.count == 1) break;
        }
        return cnt;
    }

    public int solution(String[] words) {
        for (String word : words) {
            insert(word);
        }

        int total = 0;
        for (String word : words) {
            total += countTyping(word);
        }

        return total;
    }
}
