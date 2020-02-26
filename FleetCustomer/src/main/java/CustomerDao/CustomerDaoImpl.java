package CustomerDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.project.db.datasource.DataBaseFactory;
import com.project.fleet.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	// list is working as a database
	@Autowired
	private DataSource mySQLDatasource;
	private JdbcTemplate jdbcTemplate ;
	
	List<Customer> customers;

	@PostConstruct
	public void afterPropertiesSet() throws Exception{
		System.out.println("**********************************In Post construct*******************************");
		this.jdbcTemplate = new JdbcTemplate(mySQLDatasource);
		
	}
	public CustomerDaoImpl() {
		}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		if(mySQLDatasource == null )
			mySQLDatasource = DataBaseFactory.getDataSource("mysql");
		this.jdbcTemplate = new JdbcTemplate(mySQLDatasource);
		String sql = "Select * from mydb.customers";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class));
		
	}

	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}


}
