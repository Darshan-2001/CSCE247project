import java.util.ArrayList;

public class WitnessList {
    private static WitnessList witnessList = new WitnessList();
    private ArrayList<Witness> witnesses;
    /*
     * Sets witnesses variable by using DataLoader.getWitnesses
     */
    private WitnessList() {
     //   if(witnessList == null) {
	//		witnessList = new WitnessList();
	//	}
        witnesses = DataLoader.getWitnesses();
    }
    /*
     * creates a new instance of WitnessList
     * @return witnessList
     */
    public static WitnessList getInstance() {
        return witnessList;
    }
    /*
     * adds a new witness to the current WitnessList
     * @param Witness witness
     */
    public void addWitness(Witness witness) {
		for(Witness wit : witnesses) {
            if(wit.getID() == witness.getID()){
                System.out.println("This witness is already in the system");
                return;
            }
        }

        witnesses.add(witness);
        System.out.println("Witness has been added to the system");
	}
    /*
     * removes an existing witness from the WitnessList by searching an ID
     * @param a randomly generated int for ID
     */
    public void removeWitness(int ID) {
        for(Witness wit : witnesses) {
            if(wit.getID() == ID) {
                witnesses.remove(wit);
                System.out.println("Witness has been successfully removed");
                return;
            }
        }

        System.out.println("This witness is not currently in the system");
        }
    /*
     * returns a specific witness from the WitnessList
     * @return witnesses
     */
    public ArrayList<Witness> getWitnesses(){
        return witnesses;
    }
    /*
     * returns a specific witness from WitnessList using an ID
     * @param a randomly generated int for ID
     * @return Witness wit or null
     */
    public Witness getWitness(int ID) {
		for(Witness wit : witnesses) {
            if(wit.getID() == ID) {
				return wit;
			}
        }
		return null;
	}
    /*
     * checks the ID entered and searches the WitnessList for the ID
     * @param a randomly generated int for ID
     * @return true or false
     */
    public boolean checkIds(int ID) {
        for(Witness wit : witnesses) {
            if(wit.getID() == ID) {
                return true;
            }
        }

        return false;
    }
    /*
     * Saves the witnesses to the DataWriter class
     */
    public void saveWitnesses() {
        DataWriter.saveWitnesses();
    }
}