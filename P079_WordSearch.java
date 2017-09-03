/**
 * Created by linzhou on 8/26/17.
 */
public class P079_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null
                || board.length == 0 || board[0].length == 0) {
            return false;
        }

        // Time O(n), Space O(1), Recursion stack O(word length)
        char[] charWord = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, i, j, charWord, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, char[] word, int n) {
        if (n == word.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word[n]) {
            return false;
        }

        board[i][j] += 100;
        boolean res = search(board, i + 1, j, word, n + 1)
                || search(board, i - 1, j, word, n + 1)
                || search(board, i, j + 1, word, n + 1)
                || search(board, i, j - 1, word, n + 1);
        board[i][j] -= 100;
        return res;
    }
}
