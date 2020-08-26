package edu.rit.se.testsmelss;

import edu.rit.se.testsmells.TestFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

public class TestFileTest {
    String fname;
    TestFile sut;

    @Test
    @EnabledOnOs({OS.WINDOWS})
    void splitFilepath() {
        fname = "C:\\textfiles\\db\\query\\query.txt";
        sut = new TestFile(fname);
        String[] splitted = sut.splitFilepath(fname);
        assertEquals(5, splitted.length);
        assertEquals("C:", splitted[0]);
        assertEquals("textfiles", splitted[1]);
        assertEquals("db", splitted[2]);
        assertEquals("query", splitted[3]);
        assertEquals("query.txt", splitted[4]);
    }

    @Test
    @EnabledOnOs({OS.LINUX})
    void splitUNIXFilepath() {
        fname = "relativePath/textfiles/db/query/query.txt";
        sut = new TestFile(fname);
        String[] splitted = sut.splitFilepath(fname);
        assertEquals(5, splitted.length);
        assertEquals("relativePath", splitted[0]);
        assertEquals("textfiles", splitted[1]);
        assertEquals("db", splitted[2]);
        assertEquals("query", splitted[3]);
        assertEquals("query.txt", splitted[4]);
    }
}
