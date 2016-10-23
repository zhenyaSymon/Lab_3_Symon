package DAO;

import workers.Employee;
import workers.Leader;

import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public interface IDaoLeader {
    Leader getLeader(int id);
    void AddLeader(Leader leader);
    Leader findByName(String name);
    void RemoveLeader(int id);
    List<Employee> EmployeeListForLeader(Leader l);

}
