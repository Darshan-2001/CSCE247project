/*
 * Made by Connor Shipman
 * In this tester class, we will be testing if the SuspectList addSuspect, removeSuspect, getSuspect
 * and checkIds classes all work and function like they should be and showing confirmation that they are working.
 */
public class SuspectListTester {
    SuspectList suspects = SuspectList.getInstance();
    private String first = "Connor";
    private String last = "Shipman";
    private int age = 20;
    private String gender = "Male";
    private String occupation = "Student";
    private String phoneNum = "8643992562";
    private String description = "5'7, brown hair, blue eyes, roughly 140 lbs";
    private boolean isAlive = true;
    private int numOfCrimes = 0;
    private String height = "5'7";
    private String weight = "140";
    private String hairColor = "brown";
    private String eyeColor = "blue";
    private String tattoo = "N/A";
    Suspect newSuspect = new Suspect(first,last,age,gender,occupation,phoneNum,description,isAlive,numOfCrimes,height,weight,hairColor,eyeColor,tattoo);
    public static void main(String args[]) {
        SuspectListTester tester = new SuspectListTester();
        tester.addTester();
        tester.checkIdTester();
        tester.removeTester();
        tester.checkIdTester();
    }
    public void addTester() 
    {
        suspects.addSuspect(newSuspect); //This will add a new suspect to the list of suspects
        System.out.println(suspects.getSuspect(newSuspect.getID())); //This prints out all the information I captured by using the getSuspect method to confirm that the Suspect method did add the new suspect
        //This also uses the getSuspect method that uses an ID, showing that it does get a suspect using their ID
    }
    public void removeTester()
    {
        System.out.println("");
        suspects.removeSuspect(newSuspect.getID()); //This should remove the new suspect we just established
    }
    public void checkIdTester()
    {
        int id;
        System.out.println("\nDoes the Suspect Exist: ");
        System.out.println(suspects.checkIds(newSuspect.getID())); //This should check for true or false whether the ID exists.  In this case, it should say both true and false
        // this will also test to see if the removeSuspects method worked by testing to see if it went from true to false
    }
}
