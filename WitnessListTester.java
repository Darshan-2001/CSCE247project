/*
 * Made by Connor Shipman
 * In this tester class, we will be testing if the WitnessList addWitness, removeWitness, getWitness
 * and checkIds classes all work and function like they should be and showing confirmation that they are working.
 */
public class WitnessListTester {
    WitnessList witnesses = WitnessList.getInstance();
    private String first = "Connor";
    private String last = "Shipman";
    private int age = 20;
    private String gender = "Male";
    private String occupation = "Student";
    private String phoneNum = "8643992562";
    private String address = "35 exmoor court";
    private String story = "He looks kinda sus";
    Witness newWitness = new Witness(first,last,age,gender,occupation,phoneNum,address,story);
    public static void main(String args[]) {
        WitnessListTester tester = new WitnessListTester();
        tester.addTester();
        tester.checkIdTester();
        tester.removeTester();
        tester.checkIdTester();
    }
    public void addTester() 
    {
        witnesses.addWitness(newWitness); //This will add a new witness to the list of witnesses
        System.out.println(witnesses.getWitness(newWitness.getID())); //This prints out all the information I captured by using the getWitness method to confirm that the Witness method did add the new witness
        //This also uses the getWitness method that uses an ID, showing that it does get a witness using their ID
    }
    public void removeTester()
    {
        System.out.println("");
        witnesses.removeWitness(newWitness.getID()); //This should remove the new witness we just established
    }
    public void checkIdTester()
    {
        int id;
        System.out.println("\nDoes the Witness Exist: ");
        System.out.println(witnesses.checkIds(newWitness.getID())); //This should check for true or false whether the ID exists.  In this case, it should say both true and false
        // this will also test to see if the removeWitness method worked by testing to see if it went from true to false
    }
}
