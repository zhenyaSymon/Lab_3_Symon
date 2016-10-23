package DAO.CollectionsDao;

import DAO.IDaoEmployee;
import workers.Employee;
import workers.Leader;
import workers.Projects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public class CollDaoEmployee implements IDaoEmployee {
    ArrayList<Employee> employees = new ArrayList<>();
    public CollDaoEmployee(ArrayList<Employee> employees){
        this.employees=employees;
    }
    @Override
    public Employee GetEmployee(int id) {
        return null;
    }

    @Override
    public void AddEmployee(Employee employee) {

    }



    @Override
    public void RemoveEmployee(int id) {

    }

    @Override
    public List<Employee> BadDep( String d) {
        List<Employee> badGuys = new ArrayList<>();
        for(Employee e : this.employees){
            if((e.getWorkerProjects().size()==0)&&(e.getWorkerDep().equals(d))){
                badGuys.add(e);
            }
        }
        return badGuys;
    }

    @Override
    public List<Employee> BadEmployee() {
        List<Employee> badGuys = new ArrayList<>();
        for(Employee e : this.employees){
            if(e.getWorkerProjects().size()==0){
                badGuys.add(e);
            }
        }
        return badGuys;
    }

    @Override
    public List<Projects> findProjects(Employee e) {

        return e.getWorkerProjects();
    }

    @Override
    public List<Leader> findLeaders(Employee e) {
        List<Leader> leaders = new ArrayList<>();
        for (Projects p : e.getWorkerProjects()) {
            leaders.add(p.getProjectLeader());
        }
        return leaders;
    }

    @Override
    public Employee findByName(String s) {
        for(int i = 0;i<employees.size();i++){
            if(employees.get(i).getWorkerName().equals(s)){
                return employees.get(i);
            }
        }
        return null;
    }


    @Override
    public List<Employee> findSameEmployees(Employee e) {
        List<Employee> sameEmployees = new ArrayList<>();

        for (Projects projects : e.getWorkerProjects()) {
            for (int i = 0; i < projects.getProjectEmployees().size(); i++) {
                if ((projects.getProjectEmployees().get(i).getWorkerProjects().equals(e.getWorkerProjects()))&&(projects.getProjectEmployees().get(i)!=e)) {
                    if(sameEmployees.contains(projects.getProjectEmployees().get(i))){

                    }
                    else {
                        sameEmployees.add(projects.getProjectEmployees().get(i));
                    }
                }
            }

        }
        return sameEmployees;
    }
}
