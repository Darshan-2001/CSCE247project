/*
 * @description Class that creates evidence.
 */
import java.util.Random;

public class Evidence {
	private String location;
	private String type;
	private String date;
	private String time;
	private int id;
	Random r = new Random();
    EvidenceList evidences = EvidenceList.getInstance();
	/*
	 * method that creates evidence without ID
	 * @param type		type of evidence
	 * @param location	where the evidence was found
	 * @param date		date it was found 
	 * @param time		time it was found
	 */
	public Evidence(String location,String type,String date,String time){
		this.type = type;
		this.location = location;
		setID();
		this.date = date;
		this.time = time;
	}
	/*
	 * method that creates evidence with ID
	 * @param id		sets ID of the evidence
	 * @param type		type of evidence
	 * @param location	where the evidence was found
	 * @param date		date it was found 
	 * @param time		time it was found
	 */
	public Evidence(String location, String type, String date, String time, int id){
		this.type = type;
		this.location = location;
		this.id = id;
		this.date = date;
		this.time = time;
	}
		
	private void setID() {
        id = r.nextInt(5000);

        while (evidences.checkIds(id)) {
            id = r.nextInt(5000);
        }
    }
	/*
	 * method that gets id
	 * @return integer id number
	 */
	public int getID() {
		return id;
	}
	/*
	 * method gets location
	 * @return string location of evidence
	 */
	public String getLocation() {
        return location;
    }
	/*
	 * method that sets the location
	 * @param location 		evidence location
	 */
	public void setLocation(String location) {
		this.location=location;
	}
	
	
	/*
	 * method gets the type of evidence
	 * @return String type of the evidence
	 */
	public String getType() {
        return type;
    }
	/*
	 * method that sets type of evidence
	 * @param type 		the type of evidence
	 */
	public void setType(String type) {
		this.type=type;
	}
	
	/*
	 * method that gets the date it was found
	 * @return String date of evidence
	 */
	public String getDate() {
        return date;
    }
	/*
	 * method that sets date it was found
	 * @param date		date evidence was found on
	 */
	public void setDate(String date) {
		this.date=date;
	}
	
	/*
	 * method that gets the time it was found
	 * @return string time of evidence
	 */
	public String getTime() {
        return time;
    }
	/*
	 * method that sets the time
	 * @param time		time evidence was found on
	 */
	public void setTime(String time) {
		this.time=time;
	}
}
