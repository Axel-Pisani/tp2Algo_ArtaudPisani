public class EditDistance {

    public static int distanceBetween(String word, String comparedWord) {
        int[][] distances = new int[word.length()+1][comparedWord.length()+1];

        for (int index = 0 ; index < word.length() ; index++) {
            distances[index][0] = index;
        }
        for (int index = 0 ; index < comparedWord.length() ; index++) {
            distances[0][index] = index;
        }

        for (int i = 0 ; i < word.length() ; i++) {
            for (int j = 0 ; j < comparedWord.length() ; j++) {
                if (word.charAt(i) == comparedWord.charAt(j)) {
                    distances[i+1][j+1] = distances[i][j];
                } else if (distances[i][j] <= distances[i+1][j] && distances[i][j] <= distances[i][j+1]) {
                    distances[i+1][j+1] = distances[i][j] + 1;
                } else if (distances[i+1][j] <= distances[i][j]) {
                    distances[i+1][j+1] = distances[i+1][j] + 1;
                } else {
                    distances[i+1][j+1] = distances[i][j+1] + 1;
                }
            }
        }
        return distances[distances.length-1][distances[0].length-1];
    }
}
