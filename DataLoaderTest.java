/**
 * made by Shaquivius Trell Sloan
 * This tester is used to test loading all the different types of data from the json
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {
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
		//caseList.clear();
		userList.add(new User("Amy", "Smith", "aSmith", "AAAAA", "803-454-3344", true));
		userList.add(new User("Bob", "White", "bWhite", "BBBBB", "803-333-3544", false));
		criminalList.add(new Criminal("A", "B", 5, "stud", "Male", "8888888888", "is a stud", true, false, 1, "5'8", "180", "brown", "brown", "none"));
		criminalList.add(new Criminal("C", "D", 5, "stud", "Male", "8888888888", "is a stud", true, false, 1, "5'8", "180", "brown", "brown", "none"));
		suspectList.add(new Suspect("A", "B", 10, "sus", "Female", "3333333333", "pretty sus", true, 0, "5'4", "120", "black", "black", "none"));
		suspectList.add(new Suspect("C", "D", 10, "sus", "Female", "3333333333", "pretty sus", true, 0, "5'4", "120", "black", "black", "none"));
		victimList.add(new Victim("A", "B", 3, "m", "ghost", "111111111", "is dead", false));
		victimList.add(new Victim("C", "D", 3, "m", "ghost", "111111111", "is dead", false));
		witnessList.add(new Witness("A", "B", 0, "f", "wit", "9999999999", "idk st", "witnessed something"));
		witnessList.add(new Witness("C", "D", 0, "f", "wit", "9999999999", "idk st", "witnessed something"));
		evidenceList.add(new Evidence("here", "dna", "today", "now"));
		evidenceList.add(new Evidence("here", "dna", "today", "now"));
		//caseList.add(new Case("A", "here", "SC", 29909, "murder", "these hands", "man killed", criminalList, victimList, witnessList, suspectList, userList, evidenceList));
		//caseList.add(new Case("B", "here", "SC", 29909, "murder", "these hands", "man killed", criminalList, victimList, witnessList, suspectList, userList, evidenceList));
		DataWriter.saveCriminals();
		DataWriter.saveSuspects();
		DataWriter.saveVictims();
		DataWriter.saveWitnesses();
		DataWriter.saveEvidence();
		//DataWriter.saveCases();
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		UsersList.getInstance().getUsers().clear();
		CriminalList.getInstance().getCriminals().clear();
		SuspectList.getInstance().getSuspects().clear();
		VictimList.getInstance().getVictims().clear();
		WitnessList.getInstance().getWitnesses().clear();
		EvidenceList.getInstance().getEvidence().clear();
		//CaseList.getInstance().getCases().clear();
		DataWriter.saveUsers();
		DataWriter.saveCriminals();
		DataWriter.saveSuspects();
		DataWriter.saveVictims();
		DataWriter.saveWitnesses();
		DataWriter.saveEvidence();
		//DataWriter.saveCases();
	}
	
	
	@Test
	public void testGetUsersSize() {
		userList = DataLoader.getUsers();
		assertEquals(2, userList.size());
	}

	@Test
	public void testGetUsersSizeZero() {
		UsersList.getInstance().getUsers().clear();
		DataWriter.saveUsers();
		assertEquals(0, userList.size());
	}
	
	@Test
	public void testGetUserFirstUserName() {
		userList = DataLoader.getUsers();
		assertEquals("aSmith", userList.get(0).getUserName());
	}

	@Test
	public void testGetCriminalsSize() {
		criminalList = DataLoader.getCriminals();
		assertEquals(2, criminalList.size());
	}

	@Test
	public void testGetCriminalsSizeZero() {
		CriminalList.getInstance().getCriminals().clear();
		DataWriter.saveCriminals();
		assertEquals(0, criminalList.size());
	}

	@Test
	public void testGetCriminalFirstName() {
		criminalList = DataLoader.getCriminals();
		assertEquals("A", criminalList.get(0).getFirstName());
	}

	@Test
	public void testGetSuspectsSize() {
		suspectList = DataLoader.getSuspects();
		assertEquals(2, suspectList.size());
	}

	@Test
	public void testGetSuspectsSizeZero() {
		SuspectList.getInstance().getSuspects().clear();
		DataWriter.saveSuspects();
		assertEquals(0, suspectList.size());
	}

	@Test
	public void testGetSuspectFirstName() {
		suspectList = DataLoader.getSuspects();
		assertEquals("A", suspectList.get(0).getFirstName());
	}

	@Test
	public void testGetVictimsSize() {
		victimList = DataLoader.getVictims();
		assertEquals(2, victimList.size());
	}

	@Test
	public void testGetVictimsSizeZero() {
		VictimList.getInstance().getVictims().clear();
		DataWriter.saveVictims();
		assertEquals(0, victimList.size());
	}

	@Test
	public void testGetVictimFirstName() {
		victimList = DataLoader.getVictims();
		assertEquals("A", victimList.get(0).getFirstName());
	}

	@Test
	public void testGetWitnessesSize() {
		witnessList = DataLoader.getWitnesses();
		assertEquals(2, witnessList.size());
	}

	@Test
	public void testGetWitnessesSizeZero() {
		WitnessList.getInstance().getWitnesses().clear();
		DataWriter.saveWitnesses();
		assertEquals(0, witnessList.size());
	}

	@Test
	public void testGetWitnessesFirstName() {
		witnessList = DataLoader.getWitnesses();
		assertEquals("A", witnessList.get(0).getFirstName());
	}

	@Test
	public void testGetEvidenceSize() {
		evidenceList = DataLoader.getEvidence();
		assertEquals(2, evidenceList.size());
	}

	@Test
	public void testGetEvidenceSizeZero() {
		EvidenceList.getInstance().getEvidence().clear();
		DataWriter.saveEvidence();
		assertEquals(0, evidenceList.size());
	}

	@Test
	public void testGetEvidenceLocation() {
		evidenceList = DataLoader.getEvidence();
		assertEquals("here", evidenceList.get(0).getLocation());
	}

	@Test
	public void testGetCaseSize() {
		caseList = DataLoader.getCases();
		assertEquals(2, caseList.size());
	}

	@Test
	public void testGetCaseSizeZero() {
		CaseList.getInstance().getCases().clear();
		assertEquals(0, caseList.size());
	}

	@Test
	public void testGetCaseAuthor() {
		caseList = DataLoader.getCases();
		assertEquals("A", caseList.get(0).getAuthorUserName());
	}
}
