public class EditDistance {

    public static int distanceBetween(String word, String comparedWord) {
        int distance = 0;
        int endIndexWord = word.length() - 1;
        int endIndexComparedWord = comparedWord.length() - 1;

        while (endIndexWord >= 0 || endIndexComparedWord >= 0) {
            if (endIndexWord == -1) { // ajout d'une lettre
                distance++;
                endIndexComparedWord--;
            } else if (endIndexComparedWord == -1) { // suppression d'une lettre
                distance++;
                endIndexWord--;
            } else if (word.charAt(endIndexWord) != comparedWord.charAt(endIndexComparedWord)) { // modification d'une lettre
                distance++;
                endIndexWord--;
                endIndexComparedWord--;
            } else { //dernière lettre identique
                endIndexWord--;
                endIndexComparedWord--;
            }
        }

        return distance;
    }
}
