/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package feature_extractor;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fbravo
 */
public class LexiconEvaluator {

    protected String path;
    protected Map<String, String> dict;

    public LexiconEvaluator(String file) {
        this.dict = new HashMap<String, String>();
        this.path = file;

    }

    public void processDict() {


        try {
            // first, we open the file
            Scanner sc = new Scanner(new File(this.path));
            sc.useDelimiter("\n");
            for (String line = sc.next(); sc.hasNext(); line = sc.next()) {
                String pair[] = line.split("\t");
                this.dict.put(pair[0], pair[1]);


            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LexiconEvaluator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Retorno la polaridad de la palabra
    public String retrieveValue(String word) {
        if (!this.dict.containsKey(word)) {
            return "not_found";
        } else {
            return this.dict.get(word);
        }


    }
    
    public Map<String,String> getDict(){
    	return this.dict;
    }

    static public void main(String args[]) {
//        LexiconEvaluator l = new LexiconEvaluator("extra/polarity-lexicon.txt");
//        l.processDict();
//        System.out.println(l.retrieveValue("wrong"));
//        System.out.println(l.retrieveValue("happy"));
//        System.out.println(l.retrieveValue("good"));
//
//
//        LexiconEvaluator l2 = new LexiconEvaluator("extra/AFINN-111.txt");
//        l2.processDict();
//        System.out.println(l2.retrieveValue("wrong"));
//        System.out.println(l2.retrieveValue("happy"));
//        System.out.println(l2.retrieveValue("good"));
//                System.out.println(l2.retrieveValue(":-("));
//        System.out.println(l2.retrieveValue(":)"));
//        System.out.println(l2.retrieveValue(":("));
        
        
        LexiconEvaluator l2 = new LexiconEvaluator("extra/Sentiment140-Lexicon-v0.1/unigrams-pmilexicon.txt");
        l2.processDict();
        System.out.println(l2.retrieveValue("love"));
        System.out.println(l2.retrieveValue("hate"));
        System.out.println(l2.retrieveValue("sick"));
        

        LexiconEvaluator l3 = new LexiconEvaluator("extra/NRC-Hashtag-Sentiment-Lexicon-v0.1/unigrams-pmilexicon.txt");
        l3.processDict();
        System.out.println(l3.retrieveValue("#love"));
        System.out.println(l3.retrieveValue("#sad"));
        System.out.println(l3.retrieveValue("#sick"));
        
        LexiconEvaluator l4 = new LexiconEvaluator("extra/BingLiu.csv");
        l4.processDict();
        System.out.println(l4.retrieveValue("love"));
        System.out.println(l4.retrieveValue("hate"));
        System.out.println(l4.retrieveValue("sick"));
        
        
        

    }
}
