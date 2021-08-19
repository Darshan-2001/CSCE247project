/**
 * made by Shaquivius Trell Sloan
 * This tester is used to test writing all the different types of data from the json
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
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
	void testWritingZeroUsers() {
		userList = DataLoader.getUsers();
		assertEquals(0, userList.size());
	}

	@Test
	void testWritingOneUser() {
		userList.add(new User("Amy", "Smith", "aSmith", "AAAAA","803-454-3344", true));
		DataWriter.saveUsers();
		assertEquals("aSmith", DataLoader.getUsers().get(0).getUserName());
	}
	
	@Test
	void testWritingFiveUsers() {
		userList.add(new User("Amy", "Smith", "aSmith", "AAAAA","803-454-3344", true));
		userList.add(new User("Amy", "Smith", "bSmith", "AAAAA","803-454-3344", true));
		userList.add(new User("Amy", "Smith", "cSmith", "AAAAA","803-454-3344", true));
		userList.add(new User("Amy", "Smith", "dSmith", "AAAAA","803-454-3344", true));
		userList.add(new User("Amy", "Smith", "eSmith", "AAAAA","803-454-3344", true));
		DataWriter.saveUsers();
		assertEquals("eSmith", DataLoader.getUsers().get(4).getUserName());
	}
	
	@Test
	void testWritingEmptyUser() {
		userList.add(new User("", "", "", "","", true));
		DataWriter.saveUsers();
		assertEquals("", DataLoader.getUsers().get(0).getUserName());
	}
	
	@Test
	void testWritingNullUser() {
		userList.add(new User("", "", null, "", "", true));
		DataWriter.saveUsers();
		assertEquals(null, DataLoader.getUsers().get(0).getUserName());
	}

	@Test
	public void testWritingZeroCriminals() {
		criminalList = DataLoader.getCriminals();
		assertEquals(0, criminalList.size());
	}

	@Test
	public void testWritingOneCriminal() {
		criminalList.add(new Criminal("A", "B", 5, "stud", "Male", "8888888888", "is a stud", true, false, 1, "5'8", "180", "brown", "brown", "none"));
		DataWriter.saveCriminals();
		assertEquals("A", DataLoader.getCriminals().get(0).getFirstName());
	}

	@Test
	public void testWritingFiveCriminals() {
		criminalList.add(new Criminal("A", "B", 5, "stud", "Male", "8888888888", "is a stud", true, false, 1, "5'8", "180", "brown", "brown", "none"));
		criminalList.add(new Criminal("C", "D", 5, "stud", "Male", "8888888888", "is a stud", true, false, 1, "5'8", "180", "brown", "brown", "none"));
		criminalList.add(new Criminal("E", "F", 5, "stud", "Male", "8888888888", "is a stud", true, false, 1, "5'8", "180", "brown", "brown", "none"));
		criminalList.add(new Criminal("G", "H", 5, "stud", "Male", "8888888888", "is a stud", true, false, 1, "5'8", "180", "brown", "brown", "none"));
		criminalList.add(new Criminal("I", "J", 5, "stud", "Male", "8888888888", "is a stud", true, false, 1, "5'8", "180", "brown", "brown", "none"));
		DataWriter.saveCriminals();
		assertEquals("I", DataLoader.getCriminals().get(4).getFirstName());
	}

	@Test
	public void testWritingZeroSuspects() {
		suspectList = DataLoader.getSuspects();
		assertEquals(0, suspectList.size());
	}

	@Test
	public void testWritingOneSuspect() {
		suspectList.add(new Suspect("A", "B", 10, "sus", "Female", "3333333333", "pretty sus", true, 0, "5'4", "120", "black", "black", "none"));
		DataWriter.saveSuspects();
		assertEquals("A", DataLoader.getSuspects().get(0).getFirstName());
	}

	@Test
	public void testWritingFiveSuspects() {
		suspectList.add(new Suspect("A", "B", 10, "sus", "Female", "3333333333", "pretty sus", true, 0, "5'4", "120", "black", "black", "none"));
		suspectList.add(new Suspect("C", "D", 10, "sus", "Female", "3333333333", "pretty sus", true, 0, "5'4", "120", "black", "black", "none"));
		suspectList.add(new Suspect("E", "F", 10, "sus", "Female", "3333333333", "pretty sus", true, 0, "5'4", "120", "black", "black", "none"));
		suspectList.add(new Suspect("G", "H", 10, "sus", "Female", "3333333333", "pretty sus", true, 0, "5'4", "120", "black", "black", "none"));
		suspectList.add(new Suspect("I", "J", 10, "sus", "Female", "3333333333", "pretty sus", true, 0, "5'4", "120", "black", "black", "none"));
		DataWriter.saveSuspects();
		assertEquals("J", DataLoader.getSuspects().get(4).getLastName());
	}

	@Test
	public void testWritingZeroVictims() {
		victimList = DataLoader.getVictims();
		assertEquals(0, victimList.size());
	}

	@Test
	public void testWritingOneVictim() {
		victimList.add(new Victim("A", "B", 3, "m", "ghost", "111111111", "is dead", false));
		DataWriter.saveVictims();
		assertEquals("ghost", DataLoader.getVictims().get(0).getOcc());
	}

	@Test
	public void testWritingFiveVictims() {
		victimList.add(new Victim("A", "B", 3, "m", "ghost", "111111111", "is dead", false));
		victimList.add(new Victim("C", "D", 3, "m", "ghost", "111111111", "is dead", false));
		victimList.add(new Victim("E", "F", 3, "m", "ghost", "111111111", "is dead", false));
		victimList.add(new Victim("G", "H", 3, "m", "ghost", "111111111", "is dead", false));
		victimList.add(new Victim("I", "J", 3, "m", "not a ghost", "111111111", "is not dead", true));
		DataWriter.saveVictims();
		assertEquals("not a ghost", DataLoader.getVictims().get(4).getOcc());
	}

	@Test
	public void testWritingZeroWitnesses() {
		witnessList = DataLoader.getWitnesses();
		assertEquals(0, witnessList.size());
	}

	@Test
	public void testWritingOneWitness() {
		witnessList.add(new Witness("A", "B", 0, "f", "wit", "9999999999", "idk st", "witnessed something"));
		DataWriter.saveWitnesses();
		assertEquals("idk st", DataLoader.getWitnesses().get(0).getAddress());
	}

	@Test
	public void testWritingFiveWitnesses() {
		witnessList.add(new Witness("A", "B", 0, "f", "wit", "9999999999", "idk st", "witnessed something"));
		witnessList.add(new Witness("C", "D", 0, "f", "wit", "9999999999", "idk st", "witnessed something"));
		witnessList.add(new Witness("E", "F", 0, "f", "wit", "9999999999", "idk st", "witnessed something"));
		witnessList.add(new Witness("G", "H", 0, "f", "wit", "9999999999", "idk st", "witnessed something"));
		witnessList.add(new Witness("I", "J", 0, "f", "wit", "9999999999", "idk av", "witnessed something"));
		DataWriter.saveWitnesses();
		assertEquals("idk av", DataLoader.getWitnesses().get(4).getAddress());
	}

	@Test
	public void testWritingZeroEvidence() {
		evidenceList = DataLoader.getEvidence();
		assertEquals(0, evidenceList.size());
	}

	@Test
	public void testWritingOneEvidence() {
		evidenceList.add(new Evidence("here", "dna", "today", "now"));
		DataWriter.saveEvidence();
		assertEquals("here", DataLoader.getEvidence().get(0).getLocation());
	}

	@Test
	public void testWritingFiveEvidence() {
		evidenceList.add(new Evidence("here", "dna", "today", "now"));
		evidenceList.add(new Evidence("here", "dna", "today", "now"));
		evidenceList.add(new Evidence("here", "dna", "today", "now"));
		evidenceList.add(new Evidence("here", "dna", "today", "now"));
		evidenceList.add(new Evidence("there", "dna", "today", "now"));
		DataWriter.saveEvidence();
		assertEquals("there", DataLoader.getEvidence().get(4).getLocation());
	}

	@Test
	public void testWritingZeroCase() {
		caseList = DataLoader.getCases();
		assertEquals(0, caseList.size());
	}

	@Test
	public void testWritingOneCases() {
		caseList.add(new Case("A", "here", "SC", 29909, "murder", "these hands", "man killed", criminalList, victimList, witnessList, suspectList, userList, evidenceList));
		DataWriter.saveCases();
		assertEquals("A", DataLoader.getCases().get(0).getAuthorUserName());
	}

	@Test
	public void testWritingFiveCases() {
		caseList.add(new Case("A", "here", "SC", 29909, "murder", "these hands", "man killed", criminalList, victimList, witnessList, suspectList, userList, evidenceList));
		caseList.add(new Case("B", "here", "SC", 29909, "murder", "these hands", "man killed", criminalList, victimList, witnessList, suspectList, userList, evidenceList));
		caseList.add(new Case("C", "here", "SC", 29909, "murder", "these hands", "man killed", criminalList, victimList, witnessList, suspectList, userList, evidenceList));
		caseList.add(new Case("D", "here", "SC", 29909, "murder", "these hands", "man killed", criminalList, victimList, witnessList, suspectList, userList, evidenceList));
		caseList.add(new Case("E", "here", "SC", 29909, "murder", "these hands", "man killed", criminalList, victimList, witnessList, suspectList, userList, evidenceList));
		DataWriter.saveEvidence();
		assertEquals("E", DataLoader.getCases().get(4).getAuthorUserName());
	}
}
