package DAO.TextDao;

import DAO.DaoFactory;
import DAO.IDaoLeader;
import workers.Employee;
import workers.Leader;
import workers.Projects;

import java.io.*;
import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public class TextDaoLeader implements IDaoLeader{
    public static String filename="C://Users//Zhenya//worksapce_NetCracker//Lab_3_Symon//TextBD/Leader.txt";
    @Override
    public Leader getLeader(int id) {
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
                        Leader newLeader = new Leader(entities[1]);
                        return newLeader;
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
    public void AddLeader(Leader leader) {
        File file = new File(filename);
        try {
            FileTools.exists(filename);
            FileWriter fr = new FileWriter(file, true);
            try {
                fr.write(leader.getLeaderID() + " ");
                fr.write(leader.getLeaderName() + "\r\n");

            } finally {
                fr.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Leader findByName(String name) {
        return null;
    }

    @Override
    public void RemoveLeader(int id) {
        FileTools.RemoveRow(id,filename);


    }

    @Override
    public List<Employee> EmployeeListForLeader(Leader l) {
        return null;
    }
}
