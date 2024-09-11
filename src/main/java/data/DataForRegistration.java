package data;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import utils.ConfigReader;

public class DataForRegistration {
	// bind Keys of JASON file to fields of JAVA by annotations
	@JsonProperty("FirstName")
	private String firstName;

	@JsonProperty("LastName")
	private String lastName;

	@JsonProperty("Email")
	private String email;

	@JsonProperty("Password")
	private String password;
	static String filePath = ConfigReader.getJsonFile();

	public static DataForRegistration loadData() {
		ObjectMapper mapper = new ObjectMapper();// convert JsonFile to JavaObject and vice versa

		try {
			return mapper.readValue(new File(filePath), DataForRegistration.class);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}

	}

	public String getFirstName() {
		return firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
