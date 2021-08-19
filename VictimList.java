import java.util.ArrayList;

public class VictimList {
	private static VictimList victimList = new VictimList();
	private ArrayList<Victim> victims;
    /*
	 * Sets victims variable by using DataLoader.getVictims()
	 */
	private VictimList()
	{
	//	if(victimList == null) {
	//		victimList = new VictimList();
	//	}
		victims = DataLoader.getVictims();
	}
	/*
	 * creates a new instance of VictimList
	 * @return victimList
	 */
	public static VictimList getInstance()
	{
		return victimList;
	}
	/*
	 * adds a new victim to the current VictimList
	 * @param Victim victim
	 */
	public void addVictim(Victim victim)
	{
		for(Victim vic : victims) {
            if(vic.getID() == victim.getID()){
                System.out.println("This victim is already in the system");
                return;
            }
        }

        victims.add(victim);
        System.out.println("Victim has been added to the system");
	}
	/*
	 * removes an existing victim from the Victim List by searching for an ID
	 * @param a randomly generated int for ID
	 */
	public void removeVictim(int ID)
	{
		for(Victim vic : victims) {
            if(vic.getID() == ID) {
                victims.remove(vic);
                System.out.println("Victim has been successfully removed");
                return;
            }

			System.out.println("This victim is not currently in the system");
			}
	}
	/*
	 * returns a specific victim from the VictimList
	 * @return victims
	 */
	public ArrayList<Victim> getVictims()
	{
        return victims;
	}
	/*
	 * returns a specific victim from VictimList using an ID
	 * @param a randomly generated int for ID
	 * @return Victim vic or null
	 */
	public Victim getVictim(int ID) {
		for(Victim vic : victims) {
            if(vic.getID() == ID) {
				return vic;
			}
        }
		return null;
	}
	/*
	 * checks the ID entered and searches the VictimList for the ID
	 * @param a randomly generated int for ID
	 * @return true or false
	 */
	public boolean checkIds(int ID) {
        for(Victim vic : victims) {
            if(vic.getID() == ID) {
                return true;
            }
        }

        return false;
    }
	/*
	 * Saves the victims to the DataWriter class
	 */
	public void saveVictims() {
		DataWriter.saveVictims();
	}
}