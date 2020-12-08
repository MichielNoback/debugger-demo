package nl.bioinf.debug;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Sequence represents a Biological sequence; DNA, RNA or Protein.
 * The type is determined at runtime
 */
public class Sequence {
    private static final int TRUNCATION_LIMIT = 10;
    private static final Pattern DNA_PATTERN;
    private static final Pattern RNA_PATTERN;
    private static final Pattern PROTEIN_PATTERN;
    private String id;
    private String description;
    private String sequence;
    private SequenceType sequenceType;

    static {
        DNA_PATTERN = Pattern.compile("[^ACGTRYSWKMBDHVN]");
        RNA_PATTERN = Pattern.compile("[^ACGURYSWKMBDHVN]");
        PROTEIN_PATTERN = Pattern.compile("[^ACDEFGHIKLMNPQRSTVWY]");
    }

    public Sequence(String id, String sequence) {
        this.id = id;
        this.sequence = sequence;
    }

    public Sequence(String id, String description, String sequence) {
        this.id = id;
        this.description = description;
        this.sequence = sequence;
        determineSequenceType();
    }

    private void determineSequenceType() {
        if (PROTEIN_PATTERN.matcher(this.sequence).matches()) {
            this.sequenceType = SequenceType.PROTEIN;
        } else if (RNA_PATTERN.matcher(this.sequence).matches()) {
            this.sequenceType = SequenceType.RNA;
        } else if (DNA_PATTERN.matcher(this.sequence).matches()) {
            this.sequenceType = SequenceType.DNA;
        } else {
            this.sequenceType = SequenceType.UNKNOWN;
        }
    }

    public SequenceType getSequenceType() {
        return sequenceType;
    }

    /**
     * Returns the length of the sequence.
     * @return length
     */
    public int length() {
        return this.sequence.length();
    }

    /**
     * Returns a truncated version of this sequence, with an ellipsis appended to indicate it has been truncated.
     * Truncation size defaults to 10.
     * @return truncated
     */
    public String getTruncatedIfTooLong() {
        if (length() > TRUNCATION_LIMIT) {
            return sequence.substring(0, 10) + "...";
        } else {
            return sequence;
        }
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSequence() {
        return sequence;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", sequence='" + sequence + '\'' +
                ", sequenceType=" + sequenceType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sequence sequence = (Sequence) o;

        return getId() != null ? getId().equals(sequence.getId()) : sequence.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
