package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.FileManager;
import testDataTypes.Customer;

public class jsonDataReader {

	private final String customerFilePath = FileManager.getInstance().getConfigFileReader().getTestDataPath()
			+ "Customer.json";
	private List<Customer> customerList;

	public jsonDataReader() {
		customerList = getCustomerData();
	}

	public List<Customer> getCustomerData() {
		Gson gson = new Gson();
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(customerFilePath));
			Customer[] cust = gson.fromJson(buffer, Customer[].class);
			return Arrays.asList(cust);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);

		}
	}

	public Customer getCustomerDataByName(String custName) {
		// return customerList.stream().filter(x ->
		// x.firstName.equalsIgnoreCase(custName)).findAny().get();// can also be
		// filtered like this
		for (Customer customer : customerList) {
			if (customer.firstName.equalsIgnoreCase(custName)) {
				return customer;
			}
		}
		return null;
	}

}
