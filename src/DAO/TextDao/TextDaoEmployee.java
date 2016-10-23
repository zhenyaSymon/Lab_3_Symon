package DAO.TextDao;

import DAO.IDaoEmployee;
import workers.Employee;
import workers.Leader;
import workers.Projects;

import java.io.*;
import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public class TextDaoEmployee implements IDaoEmployee {
    public static String filename = "C://Users//Zhenya//worksapce_NetCracker//Lab_3_Symon//TextBD/Employee.txt";
    @Override
    public Employee GetEmployee(int id) {
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
                        Employee newEmployee = new Employee(entities[1],entities[2]);
                        return newEmployee;
                    } else {
                        System.out.println("Такого лидера не найдено");
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
    public void AddEmployee(Employee employee) {
        File file = new File(filename);
        try {
            FileTools.exists(filename);
            FileWriter fr = new FileWriter(file, true);
            try {
                fr.write(employee.getWorkerId() + " ");
                fr.write(employee.getWorkerName() + " ");
                fr.write(employee.getWorkerDep() + "\r\n");
            } finally {
                fr.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void RemoveEmployee(int id) {
        FileTools.RemovePorE(filename,TextDaoProjects.PEfilename,id);
    }

    @Override
    public List<Employee> BadDep(String d) {
        return null;
    }

    @Override
    public List<Employee> BadEmployee() {
        return null;
    }

    @Override
    public List<Projects> findProjects(Employee e) {
        return null;
    }

    @Override
    public List<Leader> findLeaders(Employee e) {
        return null;
    }

    @Override
    public Employee findByName(String s) {
        return null;
    }

    @Override
    public List<Employee> findSameEmployees(Employee e) {
        return null;
    }
}
