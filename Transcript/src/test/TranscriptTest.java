package test;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Float.NaN;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TranscriptTest {

    private Transcript testTranscript;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student Name", 1000);
        //TODO: write new values in testTranscript constructor
    }

    @Test
    public void testaddGradeNotThere(){
        //TODO: write tests for Transcript methods
        //check that course not in transcript
        checkDoesntContainGrade("HowtoProgram");

        //add Grade into the Transcript
        testTranscript.addGrade("HowtoProgram", 3.4);

        //check course is in transcript
        checkhasGradeOnce("HowtoProgram");
    }

    @Test
    public void testaddGradeAlreadyThere(){
        //TODO: write tests for Transcript methods
        //check that course already in transcript
        checkDoesntContainGrade("HowtoProgram");

        //add Grade into the Transcript
        testTranscript.addGrade("HowtoProgram", 3.4);

        //check course is in Transcript once
        checkhasGradeOnce("HowtoProgram");

        //add Grade again
        testTranscript.addGrade("HowtoProgram", 3.4);

        //check course is in transcript
        checkhasGradeOnce("HowtoProgram");
    }
    //getGPA tests
    @Test
    public void testgetGPAemptylist(){
        //check the list is empty
        assertEquals(testTranscript.getGradelist().size(), 0);
        //GPA should be equal to zero
        assertEquals(testTranscript.getGPA(), NaN, 0.01);
    }

    @Test
    public void testgetGPAnonemptylist(){
        //check the list is empty
        assertEquals(testTranscript.getGradelist().size(), 0);
        //insert 2 course
        testTranscript.addGrade("HowtoProgram", 4.0);
        testTranscript.addGrade("HowtoProgram2", 2.0);
        //check the GPA
        assertEquals(testTranscript.getGPA(), 3.0, 0.01);
    }

    private void checkDoesntContainGrade(String name) {
        assertFalse(testTranscript.hasCourse(name));
        assertEquals(testTranscript.size(), 0);
    }

    private void checkhasGradeOnce(String name) {
        assertTrue(testTranscript.hasCourse(name));
        assertEquals(testTranscript.size(), 1);
    }
}

