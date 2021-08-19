//Darshan Patel
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WitnessTest {
	@BeforeEach
	public void setup() {
	}

	@AfterEach
	public void test() {
	}


	@Test
	void testWitness() {
		Witness test = new Witness("firstName",  "lastName", 1,  "gender",  "occupation",  "phoneNum",  "address",  "story");
		assertEquals(test.getFirstName(), "firstName");
	}

	@Test
	void testToString() {
		Witness test = new Witness( "firstName",  "lastName", 1,  "gender",  "occupation",  "phoneNum",  "address",  "story");
        assertEquals(test.getStory(), "story");
    }
}