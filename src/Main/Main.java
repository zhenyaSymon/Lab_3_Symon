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

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhenya on 23.02.2016.
 */
public class Main {
    public static void main(String[] args) {
    /*  DaoFactory.getJdbcProjects().addEmployee(DaoFactory.getJdbcProjects().getProject(2),DaoFactory.getJdbcEmployee().GetEmployee(46));
      DaoFactory.getJdbcProjects().addEmployee(DaoFactory.getJdbcProjects().getProject(2),DaoFactory.getJdbcEmployee().GetEmployee(47));
      DaoFactory.getJdbcProjects().addEmployee(DaoFactory.getJdbcProjects().getProject(2),DaoFactory.getJdbcEmployee().GetEmployee(48));*/
    //  DaoFactory.getJdbcProjects().addEmployee(DaoFactory.getJdbcProjects().getProject(1),DaoFactory.getJdbcEmployee().GetEmployee(41));
//      DaoFactory.getJdbcProjects().addEmployee(DaoFactory.getJdbcProjects().getProject(1),DaoFactory.getJdbcEmployee().GetEmployee(42));
//      DaoFactory.getJdbcProjects().addEmployee(DaoFactory.getJdbcProjects().getProject(1),DaoFactory.getJdbcEmployee().GetEmployee(43));
//      DaoFactory.getJdbcProjects().addEmployee(DaoFactory.getJdbcProjects().getProject(1),DaoFactory.getJdbcEmployee().GetEmployee(44));
  //    DaoFactory.getJdbcProjects().addEmployee(DaoFactory.getJdbcProjects().getProject(3),DaoFactory.getJdbcEmployee().GetEmployee(45));
//      DaoFactory.getJdbcProjects().addEmployee(DaoFactory.getJdbcProjects().getProject(3),DaoFactory.getJdbcEmployee().GetEmployee(48));
  //    DaoFactory.getJdbcProjects().addEmployee(DaoFactory.getJdbcProjects().getProject(3),DaoFactory.getJdbcEmployee().GetEmployee(49));

//        DaoFactory.getJdbcProjects().addProject(1,1,"WEB");
//        DaoFactory.getJdbcProjects().addProject(2,2,"WEB");
//        DaoFactory.getJdbcProjects().addProject(3,3,"WEB");
//          DaoFactory.getJdbcLeader().AddLeader("Leader1");
//          DaoFactory.getJdbcLeader().AddLeader("Leader2");
//          DaoFactory.getJdbcLeader().AddLeader("Leader3");
//          DaoFactory.getJdbcLeader().AddLeader("Leader4");
//          DaoFactory.getJdbcLeader().AddLeader("Leader5");

//        DaoFactory.getJdbcEmployee().AddEmployee("zhora1","tyjetj1");
//        DaoFactory.getJdbcEmployee().AddEmployee("zhora2","tyjetj2");
//        DaoFactory.getJdbcEmployee().AddEmployee("zhora3","tyjetj2");
//        DaoFactory.getJdbcEmployee().AddEmployee("zhora4","tyjetj2");
//        DaoFactory.getJdbcEmployee().AddEmployee("zhora5","tyjetj3");
//        DaoFactory.getJdbcEmployee().AddEmployee("zhora6","tyjetj3");
//        DaoFactory.getJdbcEmployee().AddEmployee("zhora7","tyjetj3");
     /*   DaoFactory.getJdbcCustomer().addCustomer("Customer1");
        DaoFactory.getJdbcCustomer().addCustomer("Customer2");
        DaoFactory.getJdbcCustomer().addCustomer("Customer3");*/
        // DaoFactory.getJdbcEmployee().RemoveEmployee(23);
        //  DaoFactory.getJdbcEmployee().RemoveEmployee(24);

//        System.out.println(DaoFactory.getJdbcLeader().getLeader(1));
      //  System.out.println(DaoFactory.getJdbcEmployee().GetEmployee(45));
     /*   DaoFactory.getJdbcCustomer().EmployeeListForCustomer(DaoFactory.getJdbcCustomer().getCustomer(3));
        DaoFactory.getJdbcCustomer().ProjectListForCustomer(DaoFactory.getJdbcCustomer().getCustomer(2));
        DaoFactory.getJdbcEmployee().BadEmployee();
        DaoFactory.getJdbcEmployee().BadDep("tyjetj");
        DaoFactory.getJdbcEmployee().findProjects(DaoFactory.getJdbcEmployee().GetEmployee(45));
        DaoFactory.getJdbcEmployee().findLeaders(DaoFactory.getJdbcEmployee().GetEmployee(45));
        DaoFactory.getJdbcEmployee().findSameEmployees(DaoFactory.getJdbcEmployee().GetEmployee(45));
        DaoFactory.getJdbcLeader().EmployeeListForLeader(DaoFactory.getJdbcLeader().getLeader(3));

        DaoFactory.getJdbcProjects().ProjectEmployees(DaoFactory.getJdbcProjects().getProject(3));*/
      //  DataBaseTest.testJdbc();
        Customer customer2 = new Customer("Valera",new ArrayList<Projects>());
        Customer customer3 = new Customer("Valera1",new ArrayList<Projects>());
        DaoFactory.getTextCustomer().addCustomer(customer2);
        DaoFactory.getTextCustomer().addCustomer(customer3);
        DaoFactory.getTextCustomer().removeCustomer(1);

    }
}