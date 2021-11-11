import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.zip.ZipEntry;

public class Trigramme {
    private HashMap<String, ArrayList<String>> hashTrig;
    private ArrayList<String> dico;

    public Trigramme(ArrayList<String> dico) {
        this.dico = dico;
        this.hashTrig = new HashMap<>();
        for (String word : this.dico)
            rangerTrigram(word);
    }

    public void startTrigrame(String word) {
        boolean contain = false;
        for (ArrayList<String> values : this.hashTrig.values()) {
            if (values.contains(word)) {
                contain = true;
                break;
            }
        }
        if (!contain) rangerTrigram(word);
    }

    /**
     * Fait le trigramme pour un mot donné en parametre.
     * Chaque trigramme sera rangé dans une liste qui sera renvoié.
     * */
    public ArrayList<String> makeTrig(String word) {
        ArrayList<String> trigOfWord = new ArrayList<>();
        for (int i = 0; i + 2 < word.length(); i++) {
            String trig = word.substring(i, i + 3);
            if (!trigOfWord.contains(trig))
                trigOfWord.add(trig);
        }
        return trigOfWord;
    }
    /**
     * S'il n'existe pas, ajoute dans la hashmap les trigrammes d'un mot qui est argument en clefs
     * et le mot en lui même dans le tableau des valeurs associé a chque trigramme concerné.
     * */
    private void rangerTrigram(String word) {
//        if (this.dico.contains(word)) return;
        ArrayList<String> trigOfWord = this.makeTrig("<" + word + ">");
        for (String trig : trigOfWord) {
            ArrayList<String> listWordHaveTrig = new ArrayList<>();
            if (this.hashTrig.containsKey(trig) && !this.hashTrig.get(trig).contains(word)) {
                this.hashTrig.get(trig).add(word);
            } else {
                listWordHaveTrig.add(word);
                this.hashTrig.put(trig, listWordHaveTrig);
            }
        }
    }

    /**
     * Parcour la HashMap afin de trouver tous les mots qui ont
     * au moins un trigramme en commun avec le mot en parametre.
     * Si il y en a, il sera ajouté à la liste résultat ignoré sinon.
     * La liste contiendra au plus 100 mots.
     * */
    public ArrayList<String> detectWordAccout(String word) {
        if (!word.contains("<") && !word.contains(">"))
            word = "<" + word + ">";
        ArrayList<String> wordTrig = this.makeTrig(word);
        ArrayList<String> matchTrig = new ArrayList<>();
        for (int i = 0; i < this.hashTrig.size(); i++) {
//            if (this.hashTrig.containsKey(wordTrig.get(i)) && !matchTrig.contains(wordTrig.get(i)))
            if (this.hashTrig.containsKey(wordTrig.get(i)))
                matchTrig.addAll(this.hashTrig.get(wordTrig.get(i)));
        }
        return matchTrig;
    }

    /**
     * Renvoi un nombre représente le nombres d'occurence ou un mot apparait
     * dans la liste de tous les mots qui ont la bonne ortographe.
     * */
    public int occurenceOfWordTrigInDico(String word) {
        int occurence = 0;
        for (ArrayList<String> wordOfList : this.hashTrig.values()) {
            for (String s : wordOfList) {
                if (word.equals(s)) occurence += 1;
            }
        }
        return occurence;
    }

    public ArrayList<String> moreTrigMatches(String word) {
        HashMap<String, Integer> counterWord = new HashMap<>();
        ArrayList<String> wordCommun = this.detectWordAccout(word);
        for (String s : wordCommun)
            counterWord.put(s, this.occurenceOfWordTrigInDico(s));
        return trierTableauDansOrdreCrois(word, counterWord);
    }

    private ArrayList<String> trierTableauDansOrdreCrois(String word, HashMap<String, Integer> counterWord) {
        ArrayList<String> res = new ArrayList<>();
        for (String keys : counterWord.keySet()) {
            res.add(keys);
            break;
        }
        int index = 0;
        for (String keys : counterWord.keySet()) {
            int inTab = counterWord.get(res.get(index));
            if (counterWord.get(keys) > inTab) {
                index++;
            } else if (counterWord.get(keys) <= inTab) {
                reorganisationDesMots(index, word, res);
                index++;
            }
        }
        return res;
    }


    /**
     * Permet de deplacer toutes les valeurs de tab afin de placer le mot word à la position index.
     * Ignore les valeurs qui depasse l'index 100.
     * */
    private void reorganisationDesMots(int indexStart, String word, ArrayList<String> tab) {
        String tmpWord = tab.get(indexStart);
        tab.add(indexStart, word);
        for (int i = indexStart + 1; i < tab.size(); i++) {
            String tmp = tab.get(i);
            tab.add(i, tmpWord);
            tmpWord = tmp;
            if (i < 100 && i == tab.size() - 1)
                tab.add(tmpWord);
        }
    }

}





















