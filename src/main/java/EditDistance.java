public class EditDistance {

    public int distanceBetween(String word, String comparedWord) {
        int distance = 0;
        distance = distanceBetween(word, comparedWord, distance);
        return distance;
    }

    private int distanceBetween(String word, String comparedWord, int distance) {
        if (word.charAt(word.length() - 1) == comparedWord.charAt(comparedWord.length() - 1))
            distance = distanceBetween(word.substring(0, word.length() - 2),
                    comparedWord.substring(0, comparedWord.length() - 2), distance);
        return distance;
    }
}
