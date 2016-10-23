package DAO.JdbcDAO;

import DAO.DaoFactory;
import DAO.IDaoCustomer;
import Main.Connect;
import workers.Customer;
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
public class JdbcDaoCustomer implements IDaoCustomer{

    @Override
    public void addCustomer(Customer customer) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("INSERT INTO Customer (CustomerName) VALUES(?)");

                    st.setString(1, customer.getCustomerName());


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
    public Customer findByName(String s) {
        return null;
    }

    @Override
    public Customer getCustomer(int id) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM Customer  WHERE CUSTOMERID= " + id);

                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        Customer tempObject = new Customer();
                        while (rs.next()) {

                            tempObject.setCustomerID(rs.getInt("CUSTOMERID"));
                            tempObject.setCustomerName(rs.getString("CUSTOMERNAME"));
                         //   tempObject.setCustomerproject(DaoFactory.getJdbcCustomer().ProjectListForCustomer(tempObject));

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

        Customer tempObject = new Customer();
        return tempObject;
            }

    @Override
    public void removeCustomer(int id) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("DELETE FROM Customer WHERE CUSTOMERID = " + id);
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
    public List<Projects> ProjectListForCustomer(Customer c) {
        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM Projects  WHERE CustomerID= " + c.getCustomerID());

                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        ArrayList<Projects> entities = new ArrayList<>();

                        while (rs.next()) {
                            Projects tempObject = new Projects();
                            tempObject.setProjectId(rs.getInt("PROJECTID"));// need to set customer and leader
                            tempObject.setProjectName(rs.getString("PROJECTNAME"));
                            tempObject.setProjectCustomer(c);
                            tempObject.setProjectLeader(DaoFactory.getJdbcLeader().getLeader(rs.getInt("LEADERID")));
                            entities.add(tempObject);
                        }
                        c.setCustomerproject(entities);
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
        c.setCustomerproject(entities);
        return entities;
    }

    @Override
    public List<Employee> EmployeeListForCustomer(Customer c) {

        try {
            Connection cn = null;
            Connect a = new Connect();
            try {
                cn = a.GetConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT* FROM Projects p WHERE CustomerID= " + c.getCustomerID());

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
                  //      c.setCustomerproject(entities);
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
        c.setCustomerproject(entities);
        return employees;
    }
}
