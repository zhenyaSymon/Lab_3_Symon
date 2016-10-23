package DAO.CollectionsDao;

import DAO.IDaoCustomer;
import workers.Customer;
import workers.Employee;
import workers.Projects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public class CollDaoCustomer implements IDaoCustomer {
    ArrayList<Customer> customers;
    public CollDaoCustomer(ArrayList<Customer> customers){
        this.customers=customers;
    }
    public void addProject(){

    }




    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public Customer findByName(String s) {
            for(int i = 0;i<customers.size();i++){
                if(customers.get(i).getCustomerName().equals(s)){
                    return customers.get(i);
                }
            }
            return null;

    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public void removeCustomer(int id) {

    }



    @Override
    public List<Projects> ProjectListForCustomer(Customer c) {
        return c.getCustomerproject();
    }

    @Override
    public List<Employee> EmployeeListForCustomer(Customer c) {
       List<Employee> CustomerEmployees = new ArrayList<>();
        for(Projects p : c.getCustomerproject()){
            for(Employee e : p.getProjectEmployees()){
                if(CustomerEmployees.contains(e)){

                }
                else {
                    CustomerEmployees.add(e);
                }
            }
        }
        return  CustomerEmployees;
    }
}
