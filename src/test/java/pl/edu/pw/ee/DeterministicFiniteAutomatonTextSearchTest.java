package pl.edu.pw.ee;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.edu.pw.ee.services.PatternSearch;

public class DeterministicFiniteAutomatonTextSearchTest {

    @Test
    public void shouldFindPatternInTextWhenPatternIsAtTheBegginig() {
        // given
        String pattern = "troll";
        String text = "trollface";
        PatternSearch instance = new DeterministicFiniteAutomatonTextSearch(pattern);
        int expected = 0;
        // when
        int result = instance.findFirst(text);
        // then
        assertEquals(expected, result);
    }

    @Test
    public void shouldFindPatternInTextWhenPatternIsInTheText() {
        // given
        String pattern = "llfa";
        String text = "trollface";
        PatternSearch instance = new DeterministicFiniteAutomatonTextSearch(pattern);
        int expected = 3;
        // when
        int result = instance.findFirst(text);
        // then
        assertEquals(expected, result);
    }

    @Test
    public void shouldFindPatternInTextWhenPatternIsAtTheEndOfTheText() {
        // given
        String pattern = "face";
        String text = "trollface";
        PatternSearch instance = new DeterministicFiniteAutomatonTextSearch(pattern);
        int expected = 5;
        // when
        int result = instance.findFirst(text);
        // then
        assertEquals(expected, result);
    }

    @Test
    public void shouldNotFindPatternInTextWhenThereIsNoPatternInTheText() {
        // given
        String pattern = "amogus";
        String text = "trollface";
        PatternSearch instance = new DeterministicFiniteAutomatonTextSearch(pattern);
        int expected = -1;
        // when
        int result = instance.findFirst(text);
        // then
        assertEquals(expected, result);
    }

    @Test
    public void shouldNotFindPatternInTextWhenThereIsExtraCharacterInPattern() {
        // given
        String pattern = "rollk";
        String text = "trollface";
        PatternSearch instance = new DeterministicFiniteAutomatonTextSearch(pattern);
        int expected = -1;
        // when
        int result = instance.findFirst(text);
        // then
        assertEquals(expected, result);
    }

    @Test
    public void shouldFindAllOccurencesOfPatternInText() {
        // given
        String pattern = "ra";
        String text = "karatarazara";
        PatternSearch instance = new DeterministicFiniteAutomatonTextSearch(pattern);
        int[] expected = {2, 6, 10};
        // when
        int[] result = instance.findAll(text);
        // then
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldFindNoPatternsInTextWhenThereIsNoPatternInTheText() {
        // given
        String pattern = "amogus";
        String text = "trollface";
        PatternSearch instance = new DeterministicFiniteAutomatonTextSearch(pattern);
        int[] expected = {};
        // when
        int[] result = instance.findAll(text);
        // then
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldFindNoPatternsInTextWhenThereIsExtraCharInPattern() {
        // given
        String pattern = "olla";
        String text = "trollface";
        PatternSearch instance = new DeterministicFiniteAutomatonTextSearch(pattern);
        int[] expected = {};
        // when
        int[] result = instance.findAll(text);
        // then
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldworkForFindFirst() {
        // given
        String pattern = "ababa";
        String text = "ababababa";
        PatternSearch instance = new DeterministicFiniteAutomatonTextSearch(pattern);
        int expected = 0;
        // when
        int result = instance.findFirst(text);
        // then
        assertEquals(expected, result);
    }

    @Test
    public void shouldWorkForFindAll() {
        // given
        String pattern = "ababa";
        String text = "ababababa";
        PatternSearch instance = new DeterministicFiniteAutomatonTextSearch(pattern);
        int[] expected = {0, 2, 4};
        // when
        int[] result = instance.findAll(text);
        // then
        Assert.assertArrayEquals(expected, result);
    }
}
