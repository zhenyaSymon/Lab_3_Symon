package DAO.TextDao;

import DAO.DaoFactory;
import DAO.IDaoProjects;
import workers.Customer;
import workers.Employee;
import workers.Projects;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public class TextDaoProjects implements IDaoProjects {
    public static String filename="C://Users//Zhenya//worksapce_NetCracker//Lab_3_Symon//TextBD/Projects.txt";
    public static String PEfilename="C://Users//Zhenya//worksapce_NetCracker//Lab_3_Symon//TextBD/ProjectsEmployees.txt";
    @Override
    public Projects getProject(int id) {
        File file = new File(filename);
        StringBuilder sb = new StringBuilder();
        FileTools.exists(filename);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                String[] entities;
                while ((s = in.readLine()) != null) {
                    entities = s.split("\\s+");
                    if (entities[0].equals(Integer.toString(id))) {
                        Projects newProject = new Projects(entities[1],
                                DaoFactory.getTextLeader().getLeader(Integer.parseInt(entities[2])),
                                DaoFactory.getTextCustomer().getCustomer(Integer.parseInt(entities[3])));
                        return newProject;
                    } else {
                        System.out.println("Такого проекта не найдено");
                        return null;
                    }
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void addEmployee(Projects p, Employee employee) {
        File file = new File(PEfilename);
        try {
            FileTools.exists(PEfilename);
            FileWriter fr = new FileWriter(file, true);
            try {
                fr.write(p.getProjectId() + " ");
                fr.write(employee.getWorkerId() + "\r\n");

            } finally {
                fr.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Projects findByName(String S) {
        return null;
    }

    @Override
    public void addProject(Projects projects) {
        File file = new File(filename);
        try {
            FileTools.exists(filename);
            FileWriter fr = new FileWriter(file, true);
            try {
                fr.write(projects.getProjectId() + " ");
                fr.write(projects.getProjectName() + " ");
                fr.write(projects.getProjectLeader().getLeaderID() + " ");
                fr.write(projects.getProjectCustomer().getCustomerID() + "\r\n");
            } finally {
                fr.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void removeProject(int id) {
        FileTools.RemovePorE(filename,PEfilename,id);
    }
    @Override
    public List<Employee> ProjectEmployees(Projects p) {
        File file = new File(PEfilename);
        FileTools.exists(filename);

        File empfile = new File(TextDaoEmployee.filename);
        FileTools.exists(TextDaoEmployee.filename);
        ArrayList<Employee> entities = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            BufferedReader empin = new BufferedReader(new FileReader(empfile.getAbsoluteFile()));
            try {
                String s;
                String[] project;
                String[] employee;
                ArrayList<Integer> members = new ArrayList<>();
                while ((s = in.readLine()) != null) {
                    project = s.split("\\s+");
                    if (project[0].equals(p.getProjectId())) {
                        members.add(Integer.parseInt(project[1]));
//                        Employee ProjectEmployee = new Employee(project[1],
//                                DaoFactory.getTextLeader().getLeader(Integer.parseInt(project[2])),
//                                DaoFactory.getTextCustomer().getCustomer(Integer.parseInt(project[3])));
//                        customerProject.setProjectId(Integer.parseInt(project[0]));
//                        entities.add(customerProject);
                    }

                }
                while (((s=empin.readLine())!=null)){
                    employee = s.split("\\s+");
                    for(int i = 0;i<members.size();i++){
                        if(members.get(i)==Integer.parseInt(employee[0])){
                            Employee newEmployee = new Employee(employee[1],employee[2]);
                            newEmployee.setWorkerId(Integer.parseInt(employee[0]));
                            entities.add(newEmployee);
                        }
                    }

                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }
}
