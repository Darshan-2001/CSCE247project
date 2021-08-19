/**
 * Doug Stokes
 * Tests the EvidenceList class methods.
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvidenceListTest {
    private EvidenceList evidence = EvidenceList.getInstance();
    private ArrayList<Evidence> evidenceList = evidence.getEvidence();

    @BeforeEach
    public void setup() {
        evidenceList.clear();
        evidenceList.add(new Evidence("here", "bloodstain", "tuesday", "noon", 1));
        evidenceList.add(new Evidence("there", "fingerprint", "monday", "midnight", 2));
    }

    @AfterEach
    public void done() {
        EvidenceList.getInstance().getEvidence().clear();
    }

    //Test case for adding evidence with an ID that already exists
    @Test
    public void EvidenceListIDDuplicate() {
        evidence.addEvidence(new Evidence("over yonder", "knife", "wednesday", "3:00", 1));
        assertEquals(2, evidenceList.size());
    }

    //Test case for adding evidence with an ID that does not exist
    @Test
    public void EvidenceListIDNonDuplicate() {
        evidence.addEvidence(new Evidence("over yonder", "knife", "wednesday", "3:00", 3));
        assertEquals(3, evidenceList.size());
    }

    //Test case for removing evidence with an ID that does exist
    @Test
    public void EvidenceListRemoveIDValid() {
        evidence.removeEvidence(1);
        assertEquals(1, evidenceList.size());
    }

    //Test case for removing evidence with an ID that does not exist
    @Test
    public void EvidenceListRemoveIDInvalid() {
        evidence.removeEvidence(20);
        assertEquals(2, evidenceList.size());
    }

    //Test case for checking an ID that does match an evidence's ID
    @Test
    public void EvidenceListCheckIDValid() {
        assertTrue(evidence.checkIds(1));
    }

    //Test case for checking an ID that does not match an evidence's ID
    @Test
    public void EvidenceListCheckIDInvalid() {
        assertFalse(evidence.checkIds(20));
    }
}
