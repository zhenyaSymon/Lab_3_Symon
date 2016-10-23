package DAO.TextDao;

import java.io.*;

/**
 * Created by Zhenya on 23.03.2016.
 */
public class FileTools {
    protected static void exists(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                throw new FileNotFoundException(file.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    protected static void RemoveRow(int id,String filename){
        File file = new File(filename);
        File tempFile = new File(file.getAbsolutePath() + ".tmp");
        FileTools.exists(filename);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            try {
               PartofRemove(in,pw,id);
            } finally {
                in.close();
                pw.close();
            }
            if (!file.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            if (!tempFile.renameTo(file))
                System.out.println("Could not rename file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected static void PartofRemove(BufferedReader in,PrintWriter pw,int id) throws IOException {
        String s;
        String[] entity;
        while ((s = in.readLine()) != null) {
            entity = s.split("\\s+");
            if (!entity[0].equals(Integer.toString(id))) {
                pw.println(s);
                pw.flush();
            }
        }
    }
    protected static void RemovePorE(String FILE,String PEFILE,int id){
        File file = new File(FILE);
        File PEfile = new File(PEFILE);
        File tempFile = new File(file.getAbsolutePath() + ".tmp");
        File PEtempFile = new File(PEfile.getAbsolutePath() + ".tmp");
        FileTools.exists(FILE);
        FileTools.exists(PEFILE);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            BufferedReader pein = new BufferedReader(new FileReader(PEfile.getAbsoluteFile()));
            PrintWriter pepw = new PrintWriter(new FileWriter(PEtempFile));
            try {
                FileTools.PartofRemove(in,pw,id);
                FileTools.PartofRemove(pein,pepw,id);
            } finally {
                in.close();
                pein.close();
                pw.close();
                pepw.close();
            }
            if (!file.delete()||!PEfile.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            if (!tempFile.renameTo(file)||!PEtempFile.renameTo(PEfile))
                System.out.println("Could not rename file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
