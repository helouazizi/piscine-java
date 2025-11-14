import java.util.*;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first,
                                                       Map<String, List<String>> second) {

        Map<String, String> currentMatch = new HashMap<>();

        Queue<String> freeFirstMembers = new LinkedList<>(first.keySet());

        Map<String, Map<String, Integer>> ranking = new HashMap<>();
        for (var entry : second.entrySet()) {
            String person = entry.getKey();
            List<String> preferences = entry.getValue();
            Map<String, Integer> score = new HashMap<>();
            for (int i = 0; i < preferences.size(); i++) {
                score.put(preferences.get(i), i); 
            }
            ranking.put(person, score);
        }

        Map<String, Integer> nextChoiceIndex = new HashMap<>();
        for (String p : first.keySet()) nextChoiceIndex.put(p, 0);

        while (!freeFirstMembers.isEmpty()) {
            String proposer = freeFirstMembers.poll();

            List<String> prefs = first.get(proposer);
            int index = nextChoiceIndex.get(proposer);

            String chosen = prefs.get(index);  
            nextChoiceIndex.put(proposer, index + 1);

            if (!currentMatch.containsKey(chosen)) {
                currentMatch.put(chosen, proposer);
            } else {
                String currentPartner = currentMatch.get(chosen);

                int newScore = ranking.get(chosen).get(proposer);
                int oldScore = ranking.get(chosen).get(currentPartner);

                if (newScore < oldScore) {
                    currentMatch.put(chosen, proposer);
                    freeFirstMembers.add(currentPartner); 
                } else {
                    freeFirstMembers.add(proposer);
                }
            }
        }

        Map<String, String> result = new HashMap<>();
        for (var entry : currentMatch.entrySet()) {
            String receiver = entry.getKey();
            String proposer = entry.getValue();
            result.put(proposer, receiver);
        }

        return result;
    }
}
