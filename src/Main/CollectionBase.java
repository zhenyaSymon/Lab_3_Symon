package Main;

import DAO.CollectionsDao.CollDaoCustomer;
import DAO.CollectionsDao.CollDaoEmployee;
import DAO.CollectionsDao.CollDaoLeader;
import DAO.CollectionsDao.CollDaoProjects;
import DAO.DaoFactory;
import workers.Customer;
import workers.Employee;
import workers.Leader;
import workers.Projects;

import java.util.ArrayList;

/**
 * Created by Zhenya on 24.02.2016.
 */
public class CollectionBase {
    ArrayList<Customer> customers=new ArrayList<>();
    ArrayList<Employee> employees=new ArrayList<>();
    ArrayList<Projects> projects=new ArrayList<>();
    ArrayList<Leader> leaders=new ArrayList<>();
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    public ArrayList<Projects> getProjects() {
        return projects;
    }
    public void setProjects(ArrayList<Projects> projects) {
        this.projects = projects;
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    public ArrayList<Leader> getLeaders() {
        return leaders;
    }
    public void setLeaders(ArrayList<Leader> leaders) {
        this.leaders = leaders;
    }
    public void printEmployees(){
        for(int i=0; i<this.getEmployees().size();i++){
            System.out.println(this.getEmployees().get(i));
        }
    }
    public void printCustomers(){
        for(int i=0; i<this.getCustomers().size();i++){
            System.out.println(this.getCustomers().get(i));
        }
    }
    public void printLeaders(){
        for(int i=0; i<this.getLeaders().size();i++){
            System.out.println(this.getLeaders().get(i));
        }
    }
    public void printProjects(){
        for(int i=0; i<this.getProjects().size();i++){
            System.out.println(this.getProjects().get(i));
        }
    }
    public void StartBase(){
        CollDaoEmployee employee = new CollDaoEmployee(employees);
        CollDaoProjects p = new CollDaoProjects(projects);
        Customer customer1 = new Customer("Anton",new ArrayList<Projects>());
        Customer customer2 = new Customer("Valera",new ArrayList<Projects>());
        Leader leader1 = new Leader("KOLOS",new ArrayList<Projects>());
        Leader leader2 = new Leader("ROGOVOI",new ArrayList<Projects>());
        Projects projects1 = new Projects("Website",leader1,customer1,new ArrayList<Employee>());
        Projects projects2 = new Projects("Database",leader2,customer2,new ArrayList<Employee>());
        Projects projects3 = new Projects("Coursework",leader1,customer1,new ArrayList<Employee>());
        Employee employee1 = new Employee("Kostya","java",new ArrayList<Projects>());
        Employee employee2 = new Employee("Sanya1","python", new ArrayList<Projects>());
        Employee employee3 = new Employee("Sanya2","java", new ArrayList<Projects>());
        Employee employee4 = new Employee("Sanya3","python", new ArrayList<Projects>());
        Employee employee5 = new Employee("Sanya4","JS", new ArrayList<Projects>());
        Employee employee6 = new Employee("Sanya5","JS", new ArrayList<Projects>());
        p.addEmployee(projects1,employee1);
        p.addEmployee(projects1,employee6);
        p.addEmployee(projects1,employee2);
        p.addEmployee(projects2,employee3);
        p.addEmployee(projects2,employee5);
        p.addEmployee(projects3,employee6);
         p.addEmployee(projects3,employee2);
        p.addEmployee(projects3,employee3);
        customers.add(customer1);
        customers.add(customer2);
        leaders.add(leader1);
        leaders.add(leader2);
        projects.add(projects1);
        projects.add(projects2);
        projects.add(projects3);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
    }
    public static void TestCollectionBase(){
        CollectionBase collectionBase = new CollectionBase();
        collectionBase.StartBase();
        CollDaoCustomer collDaoCustomer = new CollDaoCustomer(collectionBase.getCustomers());
        CollDaoEmployee collDaoEmployee = new CollDaoEmployee(collectionBase.getEmployees());
        CollDaoLeader collDaoLeader = new CollDaoLeader(collectionBase.getLeaders());
        CollDaoProjects collDaoProjects = new CollDaoProjects(collectionBase.getProjects());

        //Employee methods
        System.out.println(collDaoEmployee.BadEmployee());
        System.out.println(collDaoEmployee.BadDep("JS"));
        System.out.println(collectionBase.getEmployees().get(3).getWorkerProjects().size());
        System.out.println(collDaoEmployee.findProjects(collDaoEmployee.findByName("Sanya1")));
        System.out.println(collDaoEmployee.findLeaders(collDaoEmployee.findByName("Sanya1")));
        System.out.println(collDaoEmployee.findSameEmployees(collDaoEmployee.findByName("Sanya1")));
        System.out.println("___________________________________________________________");

        //Customer Methods

        System.out.println(collDaoCustomer.ProjectListForCustomer(collDaoCustomer.findByName("Anton")));
        System.out.println(collDaoCustomer.EmployeeListForCustomer(collDaoCustomer.findByName("Anton")));
        System.out.println("___________________________________________________________");

        //Projects methods

        System.out.println(collDaoProjects.ProjectEmployees(collDaoProjects.findByName("Website")));
        System.out.println("___________________________________________________________");

        //Leader's methods

        System.out.println(collDaoLeader.EmployeeListForLeader(collDaoLeader.findByName("ROGOVOI")));

    }
}
