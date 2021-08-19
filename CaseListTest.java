/**
 * Doug Stokes
 * Tests the CaseList class methods.
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CaseListTest {
    private UsersList users = UsersList.getInstance();
	private CriminalList criminals = CriminalList.getInstance();
	private SuspectList suspects = SuspectList.getInstance();
	private VictimList victims = VictimList.getInstance();
	private WitnessList witnesses = WitnessList.getInstance();
	private EvidenceList evidence = EvidenceList.getInstance();
	private CaseList cases = CaseList.getInstance();
	private ArrayList<User> userList = users.getUsers();
	private ArrayList<Criminal> criminalList = criminals.getCriminals();
	private ArrayList<Suspect> suspectList = suspects.getSuspects();
	private ArrayList<Victim> victimList = victims.getVictims();
	private ArrayList<Witness> witnessList = witnesses.getWitnesses();
	private ArrayList<Evidence> evidenceList = evidence.getEvidence();
	private ArrayList<Case> caseList = cases.getCases();

    @BeforeEach
    public void setup() {
        userList.clear();
		criminalList.clear();
		suspectList.clear();
		victimList.clear();
		witnessList.clear();
		evidenceList.clear();
        caseList.clear();
        
        userList.add(new User("Alice", "Test", "atest", "AAAA", "1111111111", true));
		userList.add(new User("Bob", "Test", "btest", "BBBB", "9999999999", false));
		
        criminalList.add(new Criminal("A", "B", 5, "stud", "Male", "8888888888", "is a stud", true, false, 1, "5'8", "180", "brown", "brown", "none"));
		criminalList.add(new Criminal("C", "D", 5, "stud", "Male", "8888888888", "is a stud", true, false, 1, "5'8", "180", "brown", "brown", "none"));
		
        suspectList.add(new Suspect("A", "B", 10, "sus", "Female", "3333333333", "pretty sus", true, 0, "5'4", "120", "black", "black", "none"));
		suspectList.add(new Suspect("C", "D", 10, "sus", "Female", "3333333333", "pretty sus", true, 0, "5'4", "120", "black", "black", "none"));
		
        victimList.add(new Victim("A", "B", 3, "m", "ghost", "111111111", "is dead", false));
		victimList.add(new Victim("C", "D", 3, "m", "ghost", "111111111", "is dead", false));
		
        witnessList.add(new Witness("A", "B", 0, "f", "wit", "9999999999", "idk st", "witnessed something"));
		witnessList.add(new Witness("C", "D", 0, "f", "wit", "9999999999", "idk st", "witnessed something"));
        
        evidenceList.add(new Evidence("here", "bloodstain", "tuesday", "noon"));
        evidenceList.add(new Evidence("there", "fingerprint", "monday", "midnight"));
        
        caseList.add(new Case("Good Cop", 1, "Grocery Store", "Columbia", 29203, "murder", "pistol", "someone got shot",
        criminalList, victimList, witnessList, suspectList, userList, evidenceList));

        caseList.add(new Case("Bad Cop", 2, "Chinese Restaurant", "Columbia", 29202, "robbery", "none", "50 dollars worth of Chinese food stolen",
        criminalList, victimList, witnessList, suspectList, userList, evidenceList));
    }

    @AfterEach
    public void done() {
        CaseList.getInstance().getCases().clear();
    }

    //Test case for adding cases with an ID that already exists
    @Test
    public void CaseListIDDuplicate() {
        caseList.add(new Case("So-so Cop", 1, "Alleyway", "Columbia", 29204, "mugging", "knife", "A man in an alleyway was mugged for his wallet and phone",
        criminalList, victimList, witnessList, suspectList, userList, evidenceList));
        assertEquals(2, caseList.size());
    }

    //Test case for adding cases with an ID that does not exist
    @Test
    public void CaseListIDNonDuplicate() {
        caseList.add(new Case("So-so Cop", 1, "Alleyway", "Columbia", 29204, "mugging", "knife", "A man in an alleyway was mugged for his wallet and phone",
        criminalList, victimList, witnessList, suspectList, userList, evidenceList));
        assertEquals(3, caseList.size());
    }

    //Test case for removing cases with an ID that does exist
    @Test
    public void CaseListRemoveIDValid() {
        cases.removeCase(1);
        assertEquals(1, caseList.size());
    }

    //Test case for removing cases with an ID that does not exist
    @Test
    public void CaseListRemoveIDInvalid() {
        cases.removeCase(20);
        assertEquals(2, caseList.size());
    }

    //Test case for checking an ID that does match an case's ID
    @Test
    public void CaseListCheckIDValid() {
        assertTrue(cases.checkIds(1));
    }
    
    //Test case for checking an ID that does not match an case's ID
    @Test
    public void CaseListCheckIDInvalid() {
        assertFalse(cases.checkIds(20));
    }

    //Test case for searching an ID with a corresponding case
    @Test
    public void CaseListSearchIDValid() {
        assertNotNull(cases.searchCases(1));
    }

    //Test case for searching an ID with no corresponding case
    @Test
    public void CaseListSearchIDInvalid() {
        assertNull(cases.searchCases(20));
    }
}
