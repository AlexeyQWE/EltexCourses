package eltex.tasks;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

 public class User implements JSON {

 	private ObjectMapper mapper = new ObjectMapper();
 	private String firstName;
 	private String lastName;

 	User () {}

 	User (String firstName, String lastName) {

 		this.firstName = firstName;
 		this.lastName = lastName;
 	}

	public void setfirstName(String firstName){

		this.firstName = firstName;
	}

	public void setlastName(String lastName){

		this.lastName = lastName;
	}

	public String getfirstName () {

		return this.firstName;
	}

	public String getlastName () {

		return this.lastName;
	}

	public String toJSON () {

		try {
			User u1 = new User(this.firstName, this.lastName);	
			return mapper.writeValueAsString(u1);
		}
		 catch (IOException error) {
            System.err.print(error.getMessage()); 
            return null;
		}

	} 

	public void fromJSON (String str) {

		try {
			User u2 = mapper.readValue(str, User.class);
			setfirstName(u2.getfirstName());
			setlastName(u2.getlastName());
		}
		catch (IOException error) {
            System.err.print(error.getMessage()); 
		}

	}
}