import java.time.LocalDate;
import java.util.Date;

public class People{
	private int socialSecurityNumber;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dateOfBirth;
	private int phoneNumber;
	private String city;

	public People (int socialSecurityNumber, String firstName, String lastName, String email, LocalDate dateOfBirth, int phoneNumber, String city){
		this.socialSecurityNumber = socialSecurityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.city = city;
	}

	public int getSocialSecurityNumber() {
		return socialSecurityNumber;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public String getCity() {
		return city;
	}
}