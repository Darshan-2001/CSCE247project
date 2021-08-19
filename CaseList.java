import java.util.ArrayList;

public class CaseList {
    private static CaseList caseList = new CaseList();
    private ArrayList<Case> crimes;
    /*
     * sets crimes variable by using DataLoader.getCases()
     */
    private CaseList() {
    //    if(caseList == null) {
	//		caseList = new CaseList();
	//	}
        crimes = DataLoader.getCases();
    }
    /*
     * creates a new instance of CaseList
     * @return caseList
     */
    public static CaseList getInstance() {
        return caseList;
    }
    /*
     * adds a new case to the current CaseList
     * @param Case crime
     */
    public void addCase(Case crime) {
        for(Case ca : crimes) {
            if(ca.getID() == crime.getID()){
                System.out.println("This case is already in the system");
                return;
            }
        }

        crimes.add(crime);
        System.out.println("Case has been added to the system");
    }
    /*
     * removes an existing case from the CaseList by searching for an ID
     * @param a randomly generated int for ID
     */
    public void removeCase(int ID) {
        for(Case ca : crimes) {
            if(ca.getID() == ID) {
                crimes.remove(ca);
                System.out.println("Case has been successfully removed");
                return;
            }
        }

        System.out.println("This case is not currently in the system");
    }
    /*
     * returns a specific case from the CaseList
     * @return crimes
     */
    public ArrayList<Case> getCases() {
        return crimes;
    }
    /*
     * checks the ID entered and searches the CaseList for the ID
     * @param a randomly generated int for ID
     * @return true or false
     */
    public boolean checkIds(int ID) {
        for(Case ca : crimes) {
            if(ca.getID() == ID) {
                return true;
            }
        }

        return false;
    }
    /*
     * Searches for a specific case using an ID
     * @param a randomly generated int for ID
     * @return Case ca or null
     */
    public Case searchCases(int ID) {
        for(Case ca : crimes) {
            if(ca.getID() == ID) {
                System.out.println("Case found");
                return ca;
            }
        }

        System.out.println("There are currently no cases with this id in the system");
        return null;
    }
    /*
     * Saves the cases to the DataWriter class
     */
    public void saveCases() {
        DataWriter.saveCases();
    }
}