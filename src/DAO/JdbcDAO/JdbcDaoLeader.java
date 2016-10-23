package DAO.JdbcDAO;

import DAO.DaoFactory;
import DAO.IDaoLeader;
import Main.Connect;
import workers.Customer;
import workers.Employee;
import workers.Leader;
import workers.Projects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhenya on 20.02.2016.
 */
public class JdbcDaoLeader implements IDaoLeader {
    @Override
    public Leader getLeader(int id) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM Leader c WHERE LEADERID= " + id);

                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        Leader tempObject = new Leader();
                        while (rs.next()) {

                            tempObject.setLeaderID(rs.getInt("LEADERID"));
                            tempObject.setLeaderName(rs.getString("LEADERNAME"));
                            //   tempObject.setLeaderProject(DaoFactory.getJdbcLeader());

                        }

                        return tempObject;
                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        Leader tempObject = new Leader();
        return tempObject;


    }

    @Override
    public void AddLeader(Leader leader) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("INSERT INTO Leader (LeaderName) VALUES(?)");

                    st.setString(1, leader.getLeaderName());


                    try {
                        st.executeUpdate();
                    } finally {
                    }

                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Leader findByName(String name) {
        return null;
    }

    @Override
    public void RemoveLeader(int id) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("DELETE FROM Leader WHERE LEADERID = " + id);
                    try {
                        st.executeUpdate();
                    } finally {
                    }

                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Employee> EmployeeListForLeader(Leader l) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM Projects p WHERE LeaderID= " + l.getLeaderID());

                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        ArrayList<Projects> entities = new ArrayList<>();
                        ArrayList<Employee> employees = new ArrayList<>();

                        while (rs.next()) {
                            Projects tempObject = new Projects();
                            tempObject.setProjectId(rs.getInt("PROJECTID"));
                            tempObject.setProjectName(rs.getString("PROJECTNAME"));
                            tempObject.setProjectEmployees(DaoFactory.getJdbcProjects().ProjectEmployees(tempObject));
                            employees.addAll(DaoFactory.getJdbcProjects().ProjectEmployees(tempObject));
                            //    tempObject.setProjectCustomer(rs.getString("C"));
                            // getCustomer?
                            entities.add(tempObject);
                        }
                        l.setLeaderProject(entities);
                        System.out.println(employees);
                        return employees;
                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ArrayList<Projects> entities = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        l.setLeaderProject(entities);
        return employees;
    }
}

