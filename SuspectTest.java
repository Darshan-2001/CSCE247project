//Darshan Patel
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SuspectTest {
	@BeforeEach
	public void setup() {
	}

	@AfterEach
	public void test() {
	}


	@Test
	void testSuspect() {
		Suspect test = new Suspect( "firstName",  "lastName", 1,  "occupation",  "gender",  "phoneNum",  "desc",true, 1,
         "height",  "weight",  "hairColor",  "eyeColor",  "tattoos");
		assertEquals(test.getNumCrimes(), 1);
	}

	@Test
	void testToString() {
		Suspect test = new Suspect("firstName",  "lastName", 1,  "occupation",  "gender",  "phoneNum",  "desc",true, 1,
        "height",  "weight",  "hairColor",  "eyeColor",  "tattoos");
        assertEquals(test.getAliveStatus(), true);
    }
}