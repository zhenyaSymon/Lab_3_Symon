package DAO.JdbcDAO;

import DAO.DaoFactory;
import DAO.IDaoProjects;
import Main.Connect;
import workers.Employee;
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
public class JdbcDaoProjects implements IDaoProjects {

    @Override
    public Projects getProject(int id) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM Projects  WHERE ProjectID= " + id);
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        Projects tempObject = new Projects();
                        while (rs.next()) {
                            tempObject.setProjectId(rs.getInt("PROJECTID"));
                            tempObject.setProjectName(rs.getString("PROJECTNAME"));
                            tempObject.setProjectLeader(DaoFactory.getJdbcLeader().getLeader(rs.getInt("LEADERID")));
                            tempObject.setProjectCustomer(DaoFactory.getJdbcCustomer().getCustomer(rs.getInt("CUSTOMERID")));
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

        Projects tempObject = new Projects();
        return tempObject;

    }

    @Override
    public void addEmployee(Projects p, Employee employee) {
        try {
            Connection cn = null;
            Connection cn2 = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();

                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("INSERT INTO ProjectsEMPLOYEE (EmployeeID,ProjectID) VALUES(?,?)");
                    //  st = cn.prepareStatement("INSERT INTO Projects (LeaderID,CustomerID,ProjectName) VALUES(?,?,?)");
                    //   st2=cn.prepareStatement("INSERT INTO Employee (EmployeeName,EmployeeDep) VALUES(?,?)");


                  /*  st2.setString(1, employee.getWorkerName());
                    st2.setString(2, employee.getWorkerDep());

                    st.setInt(1, p.getProjectId());
                    st.setInt(2, p.getProjectCustomer().getCustomerID());
                    st.setInt(3, p.getProjectLeader().getLeaderID());*/
                    st.setInt(1, employee.getWorkerId());
                    st.setInt(2, p.getProjectId());

               /*     this.ProjectEmployees(p);
                    p.getProjectEmployees().add(employee);
                    DaoFactory.getJdbcEmployee().findProjects(employee);
                    employee.getWorkerProjects().add(p);*/


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
    public Projects findByName(String S) {
        return null;
    }

    @Override
    public void addProject(Projects projects) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("INSERT INTO Projects (LeaderID,CustomerID,ProjectName) VALUES(?,?,?)");

                    st.setInt(1, projects.ProjectLeader.getLeaderID());
                    st.setInt(2, projects.ProjectCustomer.getCustomerID());
                    st.setString(3, projects.getProjectName());


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
    public void removeProject(int id) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("DELETE FROM Project WHERE PROJECTID = " + id);
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
    public List<Employee> ProjectEmployees(Projects p) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM Employee e JOIN  PROJECTSEMPLOYEE pe ON e.EMPLOYEEID=pe.EMPLOYEEID AND pe.PROJECTID= " + p.getProjectId());

                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        ArrayList<Employee> entities = new ArrayList<>();

                        while (rs.next()) {
                            Employee tempObject = new Employee();
                            tempObject.setWorkerId(rs.getInt("EMPLOYEEID"));
                            tempObject.setWorkerName(rs.getString("EMPLOYEENAME"));
                            tempObject.setWorkerDep(rs.getString("EMPLOYEEDEP"));
                            entities.add(tempObject);
                        }
                        p.setProjectEmployees(entities);
                        System.out.println(entities);
                        return entities;
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
        ArrayList<Employee> entities = new ArrayList<>();
        p.setProjectEmployees(entities);
        return entities;
    }
}
