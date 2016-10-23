package DAO;

import workers.Customer;
import workers.Employee;
import workers.Projects;

import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public interface IDaoCustomer {
    void  addCustomer(Customer customer);
    Customer findByName(String s);
    Customer getCustomer(int id);
    void removeCustomer(int id);
    List<Projects> ProjectListForCustomer(Customer c);
    List<Employee> EmployeeListForCustomer(Customer c);

}
