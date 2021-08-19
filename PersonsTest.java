//Darshan Patel
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonsTest {
	@BeforeEach
	public void setup() {
        
	}

	@AfterEach
	public void test() {
	}


	@Test
	void testPersons() {
        //using criminal as its called from persons
		Criminal test = new Criminal( "firstName",  "lastName", 0 ,  "occupation",  "gender",  "phoneNum",  "desc", true , true , 0 ,
         "height",  "weight",  "hairColor",  "eyeColor",  "tattoos");
		assertEquals(test.getFirstName(), "firstName");
	}

}