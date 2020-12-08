package nl.bioinf.debug;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTest {

    @Test
    void length() {
        Sequence seq = new Sequence("SP|12345", "gaattcagactagcat");
        assertEquals(16, seq.length());
    }

    @Test
    void getTruncatedIfTooLong() {
        Sequence seq = new Sequence("SP|12345", "gaattcagactagcat");
        final String truncatedIfTooLong = seq.getTruncatedIfTooLong();
        assertEquals("gaattcagac...", truncatedIfTooLong);

        Sequence seq2 = new Sequence("SP|12345", "gaatt");
        final String truncatedIfTooLong2 = seq2.getTruncatedIfTooLong();
        assertEquals("gaatt", truncatedIfTooLong2);
    }

    @Test
    void getID() {
        Sequence seq = new Sequence("some protein", "SP|12345", "gaattcagactagcat");
        assertEquals("some protein", seq.getDescription());
    }

    @Test
    void getSequenceType() {
        Sequence seq = new Sequence("SP|12345", "gaattcagactagcat");
        assertEquals(SequenceType.DNA, seq.getSequenceType());
    }

    @Test
    void addToCollection() {
        Sequence seq = new Sequence("SP|12345", "gaattcagactagcat");
        SequenceCollection collection = new SequenceCollection();
        collection.add(seq);
        assertEquals(seq, collection.get("SP|12345"));
    }

}