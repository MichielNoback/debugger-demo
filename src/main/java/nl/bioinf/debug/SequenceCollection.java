package nl.bioinf.debug;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SequenceCollection {
    private Map<String, Sequence> sequences;

    /**
     * Adds a single sequence.
     * @param sequence the sequence
     */
    public void add(Sequence sequence) {
        this.sequences.put(sequence.getId(), sequence);
    }

    /**
     * Retrieve a sequence based on its ID.
     * @param id the ID
     * @return sequence the Sequence
     */
    public Sequence get(String id) {
        return this.sequences.get(id);
    }

    /**
     * Returns a List of all sequences in the collection.
     * @return all Sequences
     */
    public List<Sequence> getAll() {
        List<Sequence> sequenceList = new ArrayList<>();
        sequenceList.addAll(this.sequences.values());
        return sequenceList;
    }


}
