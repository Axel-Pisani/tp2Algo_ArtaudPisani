import java.util.ArrayList;
import java.util.HashMap;

public class Trigramme {
    private HashMap<String, ArrayList<String>> trigrammes;
    private ArrayList<String> dico;

    public Trigramme(ArrayList<String> dico) {
        this.trigrammes = new HashMap<>();
        this.dico = dico;
    }

    private void makeTrigrame(String word) {
        word = "<" + word + ">";
        ArrayList<String> draftTrigramme = new ArrayList<>();
        for (int i = 0; i + 2 < word.length(); i++) {
            System.out.println(word.substring(i, i + 3));
            draftTrigramme.add(word.substring(i, i + 3));
        }
        this.trigrammes.put(word, draftTrigramme);
    }

    public void Trigrame() {
        for (String word : this.dico)
            if (!isInTrigramme(word)) makeTrigrame(word);
        System.out.println(this.trigrammes.toString());
    }//makeTrig

    private boolean isInTrigramme(String word) {
        return this.trigrammes.containsKey(word);
    }

}
