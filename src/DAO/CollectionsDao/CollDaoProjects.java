package DAO.CollectionsDao;

import DAO.IDaoProjects;
import workers.Employee;
import workers.Projects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public class CollDaoProjects implements IDaoProjects {
    ArrayList<Projects> projectses= new ArrayList<>();
    public CollDaoProjects(ArrayList<Projects> projectses){
        this.projectses=projectses;
    }



    @Override
    public Projects getProject(int id) {
        return null;
    }

    @Override
    public void addEmployee(Projects p, Employee employee) {
        p.getProjectEmployees().add(employee);
        employee.getWorkerProjects().add(p);
    }

    @Override
    public Projects findByName(String S) {
        for(int i = 0;i<projectses.size();i++){
            if(projectses.get(i).getProjectName().equals(S)){
                return projectses.get(i);
            }
        }
        return null;
    }

    @Override
    public void addProject(Projects projects) {

    }

    @Override
    public void removeProject(int id) {

    }



    @Override
    public List<Employee> ProjectEmployees(Projects p) {
        return p.getProjectEmployees();
    }
}
