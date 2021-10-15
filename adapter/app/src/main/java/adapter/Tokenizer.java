package edu.isu.cs.cs2263;

/** Tokenizer class. Implements tokenizer.
 *
 * @author Alex Diviney
 * @version 2.1.0
 */
public class Tokenizer implements PushbackTokenizer {

    String tokenStr = "";

    public Tokenizer(){

    }
    public Tokenizer(String ts){
        tokenStr=ts;
    }
    @Override
    public String nextToken() {
        tokenStr = tokenStr.substring(1,tokenStr.length());

        return tokenStr;
    }

    @Override
    public boolean hasMoreTokens() {
        if (!tokenStr.equals("")){
            return true;
        }
        return false;
    }

    @Override
    public void pushback(String s) {
    //no clue what this is. assume you append string s to the beginning of the string.
        tokenStr = s+tokenStr;

    }
}