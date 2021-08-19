import java.util.ArrayList;

public class CriminalList {
	private static CriminalList criminalList = new CriminalList();
	private ArrayList<Criminal> criminals;
	/*
	 * Sets criminals variable by using DataLoader.getCriminals()
	 */
	private CriminalList()
	{
	//	if(criminalList == null) {
	//		criminalList = new CriminalList();
	//	}
		criminals = DataLoader.getCriminals();
	}
	/*
	 * creates a new instance of CriminalList
	 * @return criminalList
	 */
	public static CriminalList getInstance()
	{	
		return criminalList;
	}
	/*
	 * adds a new criminal to the current CriminalList
	 * @param Criminal criminal
	 */
	public void addCriminal(Criminal criminal)
	{
		for(Criminal crim : criminals) {
            if(crim.getID() == criminal.getID()){
                System.out.println("This criminal is already in the system");
                return;
            }
        }

        criminals.add(criminal);
        System.out.println("Criminal has been added to the system");
	}
	/*
	 * removes an existing criminal from the CriminalList by searching an ID
	 * @param a randomly generated int for ID
	 */
	public void removeCriminal(int ID)
	{
		for(Criminal crim : criminals) {
            if(crim.getID() == ID) {
                criminals.remove(crim);
                System.out.println("Criminal has been successfully removed");
                return;
            }
        }

        System.out.println("This criminal is not currently in the system");
	}
	/*
	 * returns a specific criminal from the CriminalList
	 * @return criminals
	 */
	public ArrayList<Criminal> getCriminals()
	{
		return criminals;
	}
	/*
	 * returns a specific criminal from CriminalList using an ID
	 * @param a randomly generated int for id
	 * @return Criminal crim or null
	 */
	public Criminal getCriminal(int id) {
		for(Criminal crim : criminals) {
            if(crim.getID() == id) {
				return crim;
			}
        }
		return null;
	}
	/*
	 * checks the ID entered and searches the CriminalList for the ID
	 * @param a randomly generated int for ID
	 * @return true or false
	 */
	public boolean checkIds(int ID) {
        for(Criminal crim : criminals) {
            if(crim.getID() == ID) {
                return true;
            }
        }

        return false;
    }
	/*
	 * searches the CriminalList with specific parameters that will display criminals with those specific parameters
	 * @param String parameter
	 * @param String searchVal
	 */
	public ArrayList<Criminal> searchCriminalList(String parameter, String searchVal) {
		ArrayList<Criminal> found = new ArrayList<Criminal>();

		switch (parameter.toLowerCase()) {
			case "hair color":
				for(Criminal crim : criminals) {
					if(crim.getHairColor().equalsIgnoreCase(searchVal)) {
					found.add(crim);
					}
				}
				break;
			case "eye color":
				for(Criminal crim : criminals) {
					if(crim.getEyeColor().equalsIgnoreCase(searchVal)) {
					found.add(crim);
					}
				}
				break;
			case "height":
				for(Criminal crim : criminals) {
					if(crim.getHeight().equalsIgnoreCase(searchVal)) {
					found.add(crim);
					}
				}
				break;
			case "tattoos":
				for(Criminal crim : criminals) {
					if(crim.getTattoos().equalsIgnoreCase(searchVal)) {
					found.add(crim);
					}
				}
				break;
			default:
				break;
		}
		return found;
	}
	/*
	 * Saves the criminals to the DataWriter class
	 */
	public void saveCriminals() {
		DataWriter.saveCriminals();
	}
}