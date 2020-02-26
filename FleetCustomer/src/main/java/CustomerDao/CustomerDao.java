package CustomerDao;

import java.util.List;
import java.util.Map;

import com.project.fleet.Customer;

public interface CustomerDao {
	
	   public List<Customer> getAllCustomers();
	   public Customer getCustomer(int customerId);
//	   public void updateCustomer(Customer customer);
//	   public void deleteCustomer(Customer customer);
	}


