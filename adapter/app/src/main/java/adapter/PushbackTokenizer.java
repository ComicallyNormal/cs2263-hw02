package edu.isu.cs.cs2263;
/** Tokenizer interface.
 *
 * @author Alex Diviney
 * @version 2.1.0
 */
public interface PushbackTokenizer {

        // Returns the next token
        String nextToken();

        // Returns true if and only if there are more tokens
        boolean hasMoreTokens();

        // The token read is pushed back, so it can be read again using nextToken.
        void pushback(String s);


}
