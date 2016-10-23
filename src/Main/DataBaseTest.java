package Main;

import DAO.DaoFactory;

/**
 * Created by Zhenya on 02.03.2016.
 */
public class DataBaseTest {
    public static void TestJdbcCustomer(){
        System.out.println("_________________________________________________________________________________________________");
        DaoFactory.getJdbcCustomer().EmployeeListForCustomer(DaoFactory.getJdbcCustomer().getCustomer(3));
        DaoFactory.getJdbcCustomer().ProjectListForCustomer(DaoFactory.getJdbcCustomer().getCustomer(2));
        System.out.println("_________________________________________________________________________________________________");

    }
    public static  void TestJdbcLeader(){
        System.out.println("_________________________________________________________________________________________________");
        DaoFactory.getJdbcLeader().EmployeeListForLeader(DaoFactory.getJdbcLeader().getLeader(3));
        System.out.println("_________________________________________________________________________________________________");

    }
    public static  void TestJdbcEmployee(){
        System.out.println("_________________________________________________________________________________________________");
        DaoFactory.getJdbcEmployee().BadEmployee();
        DaoFactory.getJdbcEmployee().BadDep("tyjetj");
        DaoFactory.getJdbcEmployee().findProjects(DaoFactory.getJdbcEmployee().GetEmployee(45));
        DaoFactory.getJdbcEmployee().findLeaders(DaoFactory.getJdbcEmployee().GetEmployee(45));
        DaoFactory.getJdbcEmployee().findSameEmployees(DaoFactory.getJdbcEmployee().GetEmployee(45));
        System.out.println("_________________________________________________________________________________________________");

    }
    public static void  TestJdbcProject(){
        System.out.println("_________________________________________________________________________________________________");
        DaoFactory.getJdbcProjects().ProjectEmployees(DaoFactory.getJdbcProjects().getProject(3));
        System.out.println("_________________________________________________________________________________________________");
    }
    public static void  testJdbc(){
        TestJdbcCustomer();
        TestJdbcLeader();
        TestJdbcLeader();
        TestJdbcEmployee();
    }
}
