public class EditDistance {

    public static int distanceBetween(String word, String comparedWord) {
        int distance = 0;
        distance = distanceBetween(word, comparedWord, distance);
        return distance;
    }

    private static int distanceBetween(String word, String comparedWord, int distance) {
        if (word.length() == 0 && comparedWord.length() == 0) return distance;
        else if (word.length() == 0) // ajout d'une lettre
            distance = distanceBetween(word, comparedWord.substring(0, comparedWord.length() - 1), distance) + 1;
        else if (comparedWord.length() == 0) // suppression d'une lettre
            distance = distanceBetween(word.substring(0, word.length() - 1), comparedWord, distance) + 1;
        else if (word.charAt(word.length() - 1) != comparedWord.charAt(comparedWord.length() - 1)) // modification d'une lettre
            distance = distanceBetween(word.substring(0, word.length() - 1),
                    comparedWord.substring(0, comparedWord.length() - 1), distance) + 1;
        else //dernière lettre identique
            distance = distanceBetween(word.substring(0, word.length() - 1),
                    comparedWord.substring(0, comparedWord.length() - 1), distance);
        return distance;
    }
}
