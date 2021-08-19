/*
 * Made by Connor Shipman
 * In this tester class, we will be testing if the CriminalList addCriminal, removeCriminal, getCriminal
 * and checkIds classes all work and function like they should be and showing confirmation that they are working.
 */
public class CriminalListTester {
    CriminalList criminals = CriminalList.getInstance();
    private String first = "Connor";
    private String last = "Shipman";
    private int age = 20;
    private String gender = "Male";
    private String occupation = "Student";
    private String phoneNum = "8643992562";
    private String description = "5'7, brown hair, blue eyes, roughly 140 lbs";
    private boolean isAlive = true;
    private boolean isInJail = false;
    private int numOfCrimes = 1;
    private String height = "5'7";
    private String weight = "140";
    private String hairColor = "brown";
    private String eyeColor = "blue";
    private String tattoo = "N/A";
    Criminal newCriminal = new Criminal(first,last,age,gender,occupation,phoneNum,description,isAlive,isInJail,numOfCrimes,height,weight,hairColor,eyeColor,tattoo);
    public static void main(String args[]) {
        CriminalListTester tester = new CriminalListTester();
        tester.addTester();
        tester.checkIdTester();
        tester.removeTester();
        tester.checkIdTester();
    }
    public void addTester() 
    {
        criminals.addCriminal(newCriminal); //This will add a new Criminal to the list of criminals
        System.out.println(criminals.getCriminal(newCriminal.getID())); //This prints out all the information I captured by using the getCriminal method to confirm that the Criminal method did add the new criminal
        //This also uses the getCriminal method that uses an ID, showing that it does get a criminal using their ID
    }
    public void removeTester()
    {
        System.out.println("");
        criminals.removeCriminal(newCriminal.getID()); //This should remove the new criminal we just established
    }
    public void checkIdTester()
    {
        int id;
        System.out.println("\nDoes the Criminal Exist: ");
        System.out.println(criminals.checkIds(newCriminal.getID())); //This should check for true or false whether the ID exists.  In this case, it should say both true and false
        // this will also test to see if the removeCriminal method worked by testing to see if it went from true to false
    }
}
