package DAO.JdbcDAO;

import DAO.DaoFactory;
import DAO.IDaoEmployee;
import Main.Connect;
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
public class JdbcDaoEmployee implements IDaoEmployee {
    @Override
    public Employee GetEmployee(int id) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM EMPLOYEE c WHERE EMPLOYEEID= " + id);

                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        Employee tempObject = new Employee();
                        while (rs.next()) {

                            tempObject.setWorkerId(rs.getInt("EMPLOYEEID"));
                            tempObject.setWorkerName(rs.getString("EMPLOYEENAME"));
                            tempObject.setWorkerDep(rs.getString("EMPLOYEEDEP"));
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

        Employee tempObject = new Employee();
        return tempObject;


    }


    @Override
    public void AddEmployee(Employee employee) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("INSERT INTO Employee (EmployeeName,EmployeeDep) VALUES(?,?)");

                    st.setString(1, employee.getWorkerName());
                    st.setString(2, employee.getWorkerDep());


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
    public void RemoveEmployee(int e) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("DELETE FROM Employee WHERE EMPLOYEEID = " + e);
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
    public List<Employee> BadDep(String d) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT * FROM EMPLOYEE  e WHERE e.EMPLOYEEID=(Select EMPLOYEEID from EMPLOYEE minus SELECT EMPLOYEEID from PROJECTSEMPLOYEE) AND e.EMPLOYEEDEP='" + d + "'");

                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        ArrayList<Employee> entities = new ArrayList<Employee>();

                        while (rs.next()) {
                            Employee tempObject = new Employee();
                            tempObject.setWorkerId(rs.getInt("EMPLOYEEID"));
                            tempObject.setWorkerDep(rs.getString("EMPLOYEEDEP"));
                            tempObject.setWorkerName(rs.getString("EMPLOYEENAME"));
                            entities.add(tempObject);
                        }
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Employee> entities = new ArrayList<>();
        return entities;
    }


    @Override
    public List<Employee> BadEmployee() {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMPLOYEEID=( Select EMPLOYEEID from EMPLOYEE minus SELECT EMPLOYEEID from PROJECTSEMPLOYEE)");

                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        ArrayList<Employee> entities = new ArrayList<Employee>();

                        while (rs.next()) {
                            Employee tempObject = new Employee();
                            tempObject.setWorkerId(rs.getInt("EMPLOYEEID"));
                            tempObject.setWorkerDep(rs.getString("EMPLOYEEDEP"));
                            tempObject.setWorkerName(rs.getString("EMPLOYEENAME"));
                            entities.add(tempObject);
                        }
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Employee> entities = new ArrayList<>();
        return entities;
    }

    @Override
    public List<Projects> findProjects(Employee e) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM Projects p JOIN  PROJECTSEMPLOYEE e ON E.PROJECTID=P.PROJECTID AND e.EMPLOYEEID= " + e.getWorkerId());
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        ArrayList<Projects> entities = new ArrayList<>();
                        while (rs.next()) {
                            Projects tempObject = new Projects();
                            tempObject.setProjectId(rs.getInt("PROJECTID"));
                            tempObject.setProjectName(rs.getString("PROJECTNAME"));
                            tempObject.setProjectCustomer(DaoFactory.getJdbcCustomer().getCustomer(rs.getInt("CUSTOMERID")));
                            tempObject.setProjectLeader(DaoFactory.getJdbcLeader().getLeader(rs.getInt("LEADERID")));
                            entities.add(tempObject);
                        }
                        e.setWorkerProjects(entities);
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
        ArrayList<Projects> entities = new ArrayList<>();
        e.setWorkerProjects(entities);
        return entities;
    }


    @Override
    public List<Leader> findLeaders(Employee e) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM LEADER l JOIN  PROJECTS p ON l.LEADERID=p.LEADERID JOIN PROJECTSEMPLOYEE pe ON pe.PROJECTID=p.PROJECTID WHERE pe.EMPLOYEEID =" + e.getWorkerId());

                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        ArrayList<Leader> entities = new ArrayList<>();

                        while (rs.next()) {
                            Leader tempObject = new Leader();
                            tempObject.setLeaderID(rs.getInt("LEADERID"));
                            tempObject.setLeaderName(rs.getString("LEADERNAME"));
                            entities.add(tempObject);
                        }
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
        ArrayList<Leader> entities = new ArrayList<>();
        return entities;

    }

    @Override
    public Employee findByName(String s) {
        return null;
    }

    @Override
    public List<Employee> findSameEmployees(Employee e) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM EMPLOYEE e JOIN  PROJECTSEMPLOYEE pe ON e.EMPLOYEEID=pe.EMPLOYEEID AND PROJECTID =(SELECT PROJECTID FROM PROJECTSEMPLOYEE WHERE EMPLOYEEID=" + e.getWorkerId() + ")");
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
        return entities;

    }
}
