package DAO;

import workers.Employee;
import workers.Projects;

import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public interface IDaoProjects {
    Projects getProject(int id);
    void addEmployee(Projects p , Employee employee);
    Projects findByName(String S);
    void addProject(Projects projects);
    void removeProject(int id);
    List<Employee> ProjectEmployees(Projects p);

}
