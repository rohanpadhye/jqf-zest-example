package examples;

import java.util.HashMap;
import java.util.Map;

import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

@RunWith(JQF.class)
public class PatriciaTrieTest {
    
    @Fuzz
    public void testMap2Trie(Map<String, Integer> map, String key) {
        assumeTrue(map.containsKey(key));
        // Create new trie with input `map`
        Trie trie = new PatriciaTrie(map);
        // The key should exist in the trie as well
        assertTrue(trie.containsKey(key));
    }
}