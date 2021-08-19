/*
 * Made by Connor Shipman
 * In this class, we will be testing certain methods within the CaseList class.  
 * The methods tested will be addCase, removeCase, checkIds, & searchCases methods
 */
import java.util.ArrayList;
public class CaseListTester {
    CaseList crimes = CaseList.getInstance();
    String author = "Connor Shipman";
    String location = "University of South Carolina";
    String city = "Columbia";
    int zip = 29208;
    String type = "Robbery";
    String weapon = "Knife";
    String story = "Perp was involved in a robbery at a gas station in UofSC premises.  Suspect still unknown";
    CriminalList criminals = CriminalList.getInstance();
    ArrayList<Criminal> criminal = criminals.getCriminals();
    VictimList victims = VictimList.getInstance();
    ArrayList<Victim> victim = victims.getVictims();
    WitnessList witnesses = WitnessList.getInstance();
    ArrayList<Witness> witness = witnesses.getWitnesses();
    SuspectList suspects = SuspectList.getInstance();
    ArrayList<Suspect> suspect = suspects.getSuspects();
    UsersList users = UsersList.getInstance();
    ArrayList<User> user = users.getUsers();
    EvidenceList evidenceList = EvidenceList.getInstance();
    ArrayList<Evidence> evidence = evidenceList.getEvidence();
    Case newCrime = new Case(author,location,city,zip,type,weapon,story,criminal,victim,witness,suspect,user,evidence);
    public static void main(String args[]) {
        CaseListTester tester = new CaseListTester();
        tester.addTester();
        tester.checkIdTester();
        tester.searchTester();
        tester.removeTester();
        tester.checkIdTester();
    }
    public void addTester()
    {
        crimes.addCase(newCrime);
        System.out.println(crimes.getCases());
    }
    public void removeTester()
    {
        System.out.println("");
        crimes.removeCase(newCrime.getID());
    }
    public void checkIdTester()
    {
        System.out.println("\nDoes this Case Exist: "+criminals.checkIds(newCrime.getID()));
    }
    public void searchTester()
    {
        System.out.println("");
        crimes.searchCases(newCrime.getID());
    }
}
