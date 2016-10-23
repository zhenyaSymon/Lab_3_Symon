package DAO.TextDao;

import DAO.DaoFactory;
import DAO.IDaoCustomer;
import workers.Customer;
import workers.Employee;
import workers.Projects;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public class TextDaoCustomer implements IDaoCustomer {
    private static String filename = "C://Users//Zhenya//worksapce_NetCracker//Lab_3_Symon//TextBD/Customers.txt";

    @Override
    public void addCustomer(Customer customer) {
        File file = new File(filename);
        try {
            if (!file.exists()) {
               // file.createNewFile();
            }
            FileWriter fr = new FileWriter(file, true);
            try {
                fr.write(customer.getCustomerID() + " ");
                fr.write(customer.getCustomerName() + "\r\n");

            } finally {
                fr.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Customer findByName(String s) {
        return null;
    }

    @Override
    public Customer getCustomer(int id) {
        File file = new File(filename);
        StringBuilder sb = new StringBuilder();
        FileTools.exists(filename);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                String[] customer;
                while ((s = in.readLine()) != null) {
                    customer = s.split("\\s+");
                    if (customer[0].equals(Integer.toString(id))) {
                        Customer newCustomer = new Customer(customer[1]);
                        return newCustomer;
                    } else {
                        System.out.println("Такого заказчика не найдено");
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
    public void removeCustomer(int id) {
        FileTools.RemoveRow(id, filename);
    }

    @Override
    public List<Projects> ProjectListForCustomer(Customer c) {
        File file = new File(filename);
        File projects = new File(TextDaoProjects.filename);
        FileTools.exists(filename);
        FileTools.exists(TextDaoProjects.filename);
        ArrayList<Projects> entities = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(projects.getAbsoluteFile()));

            try {
                String s;
                String[] project;

                while ((s = in.readLine()) != null) {
                    project = s.split("\\s+");

                    if (project[3].equals(c.getCustomerID())) {
                        Projects customerProject = new Projects(project[1],
                                DaoFactory.getTextLeader().getLeader(Integer.parseInt(project[2])),
                                DaoFactory.getTextCustomer().getCustomer(Integer.parseInt(project[3])));
                        customerProject.setProjectId(Integer.parseInt(project[0]));
                        entities.add(customerProject);

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

    @Override
    public List<Employee> EmployeeListForCustomer(Customer c) {
        return null;
    }


}
