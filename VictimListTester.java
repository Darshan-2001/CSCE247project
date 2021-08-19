/*
 * Made by Connor Shipman
 * In this tester class, we will be testing if the VictimList addVictim, removeVictim, getVictim
 * and checkIds classes all work and function like they should be and showing confirmation that they are working.
 */
public class VictimListTester {
    VictimList victims = VictimList.getInstance();
    private String first = "Connor";
    private String last = "Shipman";
    private int age = 20;
    private String gender = "Male";
    private String occupation = "Student";
    private String phoneNum = "8643992562";
    private String description = "5'7, brown hair, blue eyes, roughly 140 lbs";
    private boolean isAlive = true;
    Victim newVictim = new Victim(first,last,age,gender,occupation,phoneNum,description,isAlive);
    public static void main(String args[]) {
        VictimListTester tester = new VictimListTester();
        tester.addTester();
        tester.checkIdTester();
        tester.removeTester();
        tester.checkIdTester();
    }
    public void addTester() 
    {
        victims.addVictim(newVictim); //This will add a new victim to the list of victims
        System.out.println(victims.getVictim(newVictim.getID())); //This prints out all the information I captured by using the getVictim method to confirm that the Victim method did add the new victim
        //This also uses the getVictim method that uses an ID, showing that it does get a victim using their ID
    }
    public void removeTester()
    {
        System.out.println("");
        victims.removeVictim(newVictim.getID()); //This should remove the new victim we just established
    }
    public void checkIdTester()
    {
        int id;
        System.out.println("\nDoes the Victim Exist: ");
        System.out.println(victims.checkIds(newVictim.getID())); //This should check for true or false whether the ID exists.  In this case, it should say both true and false
        // this will also test to see if the removeVictim method worked by testing to see if it went from true to false
    }
}
