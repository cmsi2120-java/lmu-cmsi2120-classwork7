package senttools.solution;

import java.util.*;

/**
 * Simple library which might (outside of this assignment) contain
 * various functions related to some sentence tools.
 */
public class SentToolsRedux {

    /**
     * Returns the number of unique, unrepeated words that are found in the given
     * sentence sent
     * 
     * @param sent The sentence in which to count unique words
     * @return The number of unique, unrepeated words in sent
     */
    public static int uniqueWords (String sent) {
        if (sent.length() == 0) { return 0; }
        
        HashMap<String, Integer> wordCounts = getWordCounts(sent);
        int count = 0;

        for (Map.Entry<String, Integer> e : wordCounts.entrySet()) {
            count += (e.getValue() == 1) ? 1 : 0;
        }

        return count;
    }
    
    /**
     * Returns a Map of the k most frequent words in the given sentence where the
     * Map's keys are the words, and values are the number of times that word
     * appears.
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
        HashMap<String, Integer> wordCounts = getWordCounts(sent),
                                 result = new HashMap<>();
        PriorityQueue<WordCounter> wordCountPQ = new PriorityQueue<>();
        
        for (Map.Entry<String, Integer> e : wordCounts.entrySet()) {
            wordCountPQ.add(new WordCounter(e.getKey(), e.getValue()));
            // Toss the worst we have if we're at capacity
            if (wordCountPQ.size() > k) { wordCountPQ.poll(); }
        }
        
        // Assemble the solution with the k entries remaining
        while (!wordCountPQ.isEmpty()) {
            WordCounter current = wordCountPQ.poll();
            result.put(current.word, current.count);
        }
        return result;
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
            return this.count - other.count;
        }
    }
    
    /**
     * Private helper that returns a map of words mapped to their frequencies in the given
     * sentence.
     * @param sent The sentence in which to count each word.
     * @return The map of words to their counts.
     */
    private static HashMap<String, Integer> getWordCounts (String sent) {
        String[] words = sent.split(" ");
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String s : words) {
            if (s.trim().equals("")) { continue; }
            wordCounts.put(s, (wordCounts.containsKey(s)) ? wordCounts.get(s) + 1 : 1);
        }
        return wordCounts;
    }
    
}