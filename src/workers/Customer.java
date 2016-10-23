package workers;

import java.util.List;

/**
 * Created by Zhenya on 17.02.2016.
 */
public class Customer {
    private static int idinc=0;
    public int CustomerID;
    public String CustomerName;
    public List<Projects> Customerproject;

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID=" + CustomerID +
                ", CustomerName='" + CustomerName + '\''/* +
                ", Customerproject=" + Customerproject +
                '}'*/;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public List<Projects> getCustomerproject() {
        return Customerproject;
    }

    public void setCustomerproject(List<Projects> customerproject) {
        Customerproject = customerproject;
    }

    public Customer(){

    }
    public Customer(String CustomerName,List<Projects> CustomerProject){
        ++idinc;
        this.CustomerID=idinc;
        this.CustomerName=CustomerName;
        this.Customerproject=CustomerProject;
    }
    public Customer(String CustomerName){
        ++idinc;
        this.CustomerID=idinc;
        this.CustomerName=CustomerName;
    }

}
