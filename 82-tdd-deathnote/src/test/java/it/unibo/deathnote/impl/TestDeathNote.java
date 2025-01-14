package it.unibo.deathnote.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


public class TestDeathNote {

    private DeathNoteImplementation deathnote;

    @BeforeEach
    void Initialization() {
        deathnote = new DeathNoteImplementation();
    }

    @Test
    void testGetDeathCause() {
        
    }   

    @Test
    void testGetDeathDetails() {

    }

    @Test
    void testGetRule() {
        // Test per verificare che la regola numero 1 esista e sia corretta
        assertEquals(        """
            This note will not take effect unless the writer has the subject's face in mind when
            writing his/her name. This is to prevent people who share the same name from being
            affected.
            """, deathnote.getRule(1));

            
    }

    @Test
    void testIsNameWritten() {

    }

    @Test
    void testWriteDeathCause() {

    }

    @Test
    void testWriteDetails() {

    }

    @Test
    void testWriteName() {

    }
}
