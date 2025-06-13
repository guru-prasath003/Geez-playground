package testDataTypes;

//-----------------------------------testDataTypes.Customer.java-----------------------------------
public class Customer {

	public String firstName;
	public String lastName;
	public Integer age;
	public String emailAddress;
	public Address address;
	public PhoneNumber phoneNumber;

	// -----------------------------------testDataTypes.Address.java-----------------------------------
	public class Address {

		public String streetAddress;
		public String city;
		public String postCode;
		public String state;
		public String country;
		public String county;
	}

	// -----------------------------------testDataTypes.PhoneNumber.java-----------------------------------
	public class PhoneNumber {

		public String home;
		public String mob;

	}
}