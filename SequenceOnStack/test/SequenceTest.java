import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Amy Wu,
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    // TODO - add test cases for constructor, add, remove, and length
    @Test
    public final void testNoArgumentConstructor() {
        /* Set up variables and call method under test */
        Sequence<String> seq = this.constructorTest();
        Sequence<String> expectedSeq = this.constructorRef();
        /* Assert that values of variables match expectations */
        assertEquals(expectedSeq, seq);
    }

    @Test
    public final void testAddEmpty() {
        /* Set up variables */
        Sequence<String> seq = this.createFromArgsTest();
        Sequence<String> expectedSeq = this.createFromArgsRef("red");
        /* Call method under test */
        seq.add(0, "red");
        /* Assert that values of variables match expectations */
        assertEquals(seq, expectedSeq);
    }

    @Test
    public final void testAddNonEmptyOne() {
        /* Set up variables */
        Sequence<String> seq = this.createFromArgsTest("red");
        Sequence<String> expectedSeq = this.createFromArgsRef("red", "blue");
        /* Call method under test */
        seq.add(1, "blue");
        /* Assert that values of variables match expectations */
        assertEquals(expectedSeq, seq);
    }

    @Test
    public final void testAddNonEmptyMoreThanOne() {
        /* Set up variables */
        Sequence<String> seq = this.createFromArgsTest("red", "blue", "green");
        Sequence<String> expectedSeq = this.createFromArgsRef("red", "blue",
                "green", "yellow");
        /* Call method under test */
        seq.add(3, "yellow");
        /* Assert that values of variables match expectations */
        assertEquals(expectedSeq, seq);
    }

    @Test
    public final void testRemoveLeavingEmpty() {
        /* Set up variables */
        Sequence<String> seq = this.createFromArgsTest("red");
        Sequence<String> expectedSeq = this.createFromArgsRef();
        /* Call method under test */
        String s = seq.remove(0);
        /* Assert that values of variables match expectations */
        assertEquals(expectedSeq, seq);
        assertEquals("red", s);
    }

    @Test
    public final void testRemoveLeavingNonEmptyOne() {
        /* Set up variables */
        Sequence<String> seq = this.createFromArgsTest("red", "blue");
        Sequence<String> expectedSeq = this.createFromArgsRef("blue");
        /* Call method under test */
        String s = seq.remove(0);
        /* Assert that values of variables match expectations */
        assertEquals(expectedSeq, seq);
        assertEquals("red", s);
    }

    @Test
    public final void testRemoveLeavingNonEmptyMoreThanOne() {
        /* Set up variables */
        Sequence<String> seq = this.createFromArgsTest("red", "green", "blue");
        Sequence<String> expectedSeq = this.createFromArgsRef("green", "blue");
        /* Call method under test */
        String s = seq.remove(0);
        /* Assert that values of variables match expectations */
        assertEquals(expectedSeq, seq);
        assertEquals("red", s);
    }

    @Test
    public final void testLengthEmpty() {
        /* Set up variables */
        Sequence<String> seq = this.createFromArgsTest();
        Sequence<String> expectedSeq = this.createFromArgsRef();
        /* Call method under test */
        int i = seq.length();
        /* Assert that values of variables match expectations */
        assertEquals(expectedSeq, seq);
        assertEquals(0, i);
    }

    @Test
    public final void testLengthNonEmptyOne() {
        /* Set up variables */
        Sequence<String> seq = this.createFromArgsTest("red");
        Sequence<String> expectedSeq = this.createFromArgsRef("red");
        /* Call method under test */
        int i = seq.length();
        /* Assert that values of variables match expectations */
        assertEquals(expectedSeq, seq);
        assertEquals(1, i);
    }

    @Test
    public final void testLengthNonEmptyMoreThanOne() {
        /* Set up variables */
        Sequence<String> seq = this.createFromArgsTest("red", "green", "blue");
        Sequence<String> expectedSeq = this.createFromArgsRef("red", "green",
                "blue");
        /* Call method under test */
        int i = seq.length();
        /* Assert that values of variables match expectations */
        assertEquals(expectedSeq, seq);
        assertEquals(3, i);
    }

}
