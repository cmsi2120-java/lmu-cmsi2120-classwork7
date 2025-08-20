package main.senttools;

import java.util.*;

/**
 * Simple library which might (outside of this assignment) contain
 * various functions related to some sentence tools.
 */
public class SentToolsRedux {

    /**
     * Returns the number of unique, unrepeated words that are found in the given
     * sentence sent
     * [!] MUST be implemented with O(n) runtime complexity
     * 
     * @param sent The sentence in which to count unique words
     * @return The number of unique, unrepeated words in sent
     */
    public static int uniqueWords (String sent) {
        // TODO
        throw new UnsupportedOperationException();
    }
    
    /**
     * Returns a Map of the k most frequent words in the given sentence where the
     * Map's keys are the words, and values are the number of times that word
     * appears.
     * [!] MUST be implemented with O(n*log(k)) runtime complexity!
     * 
     * @param sent The text corpus to process for the k-most frequent words
     * @param k    The maximum number of words / keys to return in the resulting
     *             Map; if k is greater than the number of unique words in the
     *             sentence, the returned Map will only have as many words / keys as
     *             there are unique words in the sentence.
     * @return A Map with keys representing the k most frequent words in the
     *         sentence, and values that are Integer counts of the number of times
     *         each word appears in the sentence.
     */
    public static Map<String, Integer> kMostFrequentWords (String sent, int k) {
        // TODO
        throw new UnsupportedOperationException();
    }
    
    /**
     * Small private tuple class useful for implementing the kMostFrequentWords
     * method such that each WordCounter stores a word and the number of times it
     * appears in some text corpus. For the purposes of priority, words with higher
     * counts will have higher priority.
     */
    private static class WordCounter implements Comparable<WordCounter> {
        String word;
        int count;
        
        public WordCounter (String w, int c) {
            this.word = w;
            this.count = c;
        }
        
        /**
         * Compares two WordCounters and establishes the one with the higher count as
         * the higher priority.
         * 
         * @param other The other WordCounter compared to this one.
         * @return Integer value that is 0 if the priority of this and other are equal,
         *         less than 0 if this has a higher priority than other, and greater
         *         than 0 if this has a lower priority than other.
         */
        @Override
        public int compareTo (WordCounter other) {
            // TODO: Implement such that you can maintain a PriorityQueue that has *at most*
            // k words for the O(n * log(k)) guarantee of kMostFrequentWords
            // HINT: Remember that Java's PriorityQueues are implemented using minheaps!
            throw new UnsupportedOperationException();
        }
    }
    
}