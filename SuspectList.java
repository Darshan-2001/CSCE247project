import java.util.ArrayList;

public class SuspectList {
    private static SuspectList suspectList = new SuspectList();
    private ArrayList<Suspect> suspects;
    /* 
     * Sets suspects variable by using DataLoader.getSuspects()
     */
    private SuspectList() {
    //    if(suspectList == null) {
	//		suspectList = new SuspectList();
	//	}
        suspects = DataLoader.getSuspects();
    }
    /*
     * creates a new instance of SuspectList
     * @return suspectList
     */
    public static SuspectList getInstance() {
        return suspectList;
    }
    /*
     * adds a new suspect to the current SuspectList
     * @param Suspect suspect
     */
    public void addSuspect(Suspect suspect) {
        for(Suspect sus : suspects) {
            if(sus.getID() == suspect.getID()){
                System.out.println("This suspect is already in the system");
                return;
            }
        }

        suspects.add(suspect);
        System.out.println("Suspect has been added to the system");
    }
    /*
     * removes an exisitng suspect from the SuspectList by search an ID
     * @param a randomly generated int for ID
     */
    public void removeSuspect(int ID) {
        for(Suspect sus : suspects) {
            if(sus.getID() == ID) {
                suspects.remove(sus);
                System.out.println("Suspect has been successfully removed");
                return;
            }
        }

        System.out.println("This suspect is not currently in the system");
    }    
    /*
     * returns a specific suspect from the SuspectList
     * @return suspects
     */
    public ArrayList<Suspect> getSuspects(){
        return suspects;
    }
    /*
     * returns a specific suspect from SuspectList using an ID
     * @param a randomly generated int for id
     * @return Suspect sus or null
     */
    public Suspect getSuspect(int id) {
		for(Suspect sus : suspects) {
            if(sus.getID() == id) {
				return sus;
			}
        }
		return null;
	}
    /*
     * checks the ID entered and searches SuspectList for the ID
     * @param a randomly generated int for ID
     * @return true or false
     */
    public boolean checkIds(int ID) {
        for(Suspect sus : suspects) {
            if(sus.getID() == ID) {
                return true;
            }
        }

        return false;
    }
    /*
     * Saves the suspects to the DataWriter class
     */
    public void saveSuspects() {
        DataWriter.saveSuspects();
    }
}