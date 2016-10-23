package DAO;

import workers.Employee;
import workers.Leader;
import workers.Projects;

import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public interface IDaoEmployee {
    Employee GetEmployee(int id);
    void AddEmployee(Employee employee);
    void RemoveEmployee(int id);
    List<Employee> BadDep(String d);
    List<Employee> BadEmployee();
    List<Projects> findProjects(Employee e);
    List<Leader> findLeaders(Employee e);
    Employee findByName(String s);
    List<Employee> findSameEmployees(Employee e);
}
