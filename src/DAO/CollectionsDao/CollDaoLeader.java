package DAO.CollectionsDao;

import DAO.IDaoLeader;
import workers.Employee;
import workers.Leader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public class CollDaoLeader implements IDaoLeader{
    ArrayList<Leader> leaders = new ArrayList<>();
    public CollDaoLeader(ArrayList<Leader> leaders){
        this.leaders = leaders;
    }

    @Override
    public Leader getLeader(int id) {
        return null;
    }

    @Override
    public void AddLeader(Leader leader) {

    }

    @Override
    public Leader findByName(String name) {
        for(int i = 0;i<leaders.size();i++){
            if(leaders.get(i).getLeaderName().equals(name)){
                return leaders.get(i);
            }
        }

        return null;
    }

    @Override
    public void RemoveLeader(int id) {

    }

    @Override
    public List<Employee> EmployeeListForLeader(Leader l) {
        ArrayList<Employee> EmplyeesForLeader= new ArrayList<Employee>();
        for(int i = 0;i<l.getLeaderProject().size();i++) {

        EmplyeesForLeader.addAll(l.getLeaderProject().get(i).getProjectEmployees());

        }
        return EmplyeesForLeader;
    }
}
