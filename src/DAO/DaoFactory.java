package DAO;

import DAO.CollectionsDao.CollDaoCustomer;
import DAO.CollectionsDao.CollDaoEmployee;
import DAO.CollectionsDao.CollDaoLeader;
import DAO.CollectionsDao.CollDaoProjects;
import DAO.JdbcDAO.JdbcDaoCustomer;
import DAO.JdbcDAO.JdbcDaoEmployee;
import DAO.JdbcDAO.JdbcDaoLeader;
import DAO.JdbcDAO.JdbcDaoProjects;
import DAO.TextDao.TextDaoCustomer;
import DAO.TextDao.TextDaoEmployee;
import DAO.TextDao.TextDaoLeader;
import DAO.TextDao.TextDaoProjects;
import DAO.XmlDao.XmlDaoCustomer;
import DAO.XmlDao.XmlDaoEmployee;
import DAO.XmlDao.XmlDaoLeader;
import DAO.XmlDao.XmlDaoProjects;

/**
 * Created by Zhenya on 20.02.2016.
 */
public class DaoFactory {
    /*
    public static CollDaoCustomer getCollCustomer(){return new CollDaoCustomer();}
    public static CollDaoEmployee getCollEmployee(){return new CollDaoEmployee();}
    public static CollDaoLeader getCollLeader(){return new CollDaoLeader();}
    public static CollDaoProjects getCollProjects(){return new CollDaoProjects();}
    */

    public static JdbcDaoCustomer getJdbcCustomer(){return new JdbcDaoCustomer();}
    public static JdbcDaoEmployee getJdbcEmployee(){return new JdbcDaoEmployee();}
    public static JdbcDaoLeader getJdbcLeader(){return new JdbcDaoLeader();}
    public static JdbcDaoProjects getJdbcProjects(){return new JdbcDaoProjects();}

    public static TextDaoCustomer getTextCustomer(){return new TextDaoCustomer();}
    public static TextDaoEmployee getTextEmployee(){return new TextDaoEmployee();}
    public static TextDaoLeader getTextLeader(){return new TextDaoLeader();}
    public static TextDaoProjects getTextProjects(){return new TextDaoProjects();}

    public static XmlDaoCustomer getXmlCustomer(){return new XmlDaoCustomer();}
    public static XmlDaoEmployee getXmlEmployee(){return new XmlDaoEmployee();}
    public static XmlDaoLeader getXmlLeader(){return new XmlDaoLeader();}
    public static XmlDaoProjects getXmlProjects(){return new XmlDaoProjects();}


}
