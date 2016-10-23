package workers;

import java.util.List;

/**
 * Created by Zhenya on 17.02.2016.
 */
public class Projects {
    private static int intinc=0;
    public int ProjectId;
    public String ProjectName;
    public Leader ProjectLeader;
    public Customer ProjectCustomer;
    public List<Employee> ProjectEmployees;


    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public List<Employee> getProjectEmployees() {
        return ProjectEmployees;
    }

    public void setProjectEmployees(List<Employee> projectEmployees) {
        ProjectEmployees = projectEmployees;
    }

    public Customer getProjectCustomer() {
        return ProjectCustomer;
    }

    public void setProjectCustomer(Customer projectCustomer) {
        ProjectCustomer = projectCustomer;
    }

    public Leader getProjectLeader() {
        return ProjectLeader;
    }

    public void setProjectLeader(Leader projectLeader) {
        ProjectLeader = projectLeader;
    }
    public Projects(){

    }
    public Projects(String ProjectName,Leader ProjectLeader,Customer ProjectCustomer,List<Employee> ProjectEmployees){
        ++intinc;
        this.ProjectId=intinc;
        this.ProjectName=ProjectName;
        this.ProjectLeader=ProjectLeader;
        ProjectLeader.getLeaderProject().add(this);
        this.ProjectCustomer=ProjectCustomer;
        ProjectCustomer.getCustomerproject().add(this);
        this.ProjectEmployees=ProjectEmployees;

    }
    public Projects(String ProjectName,Leader ProjectLeader,Customer ProjectCustomer){
        ++intinc;
        this.ProjectId=intinc;
        this.ProjectName=ProjectName;
        this.ProjectLeader=ProjectLeader;
      //  ProjectLeader.getLeaderProject().add(this);
        this.ProjectCustomer=ProjectCustomer;
      //  ProjectCustomer.getCustomerproject().add(this);
       // this.ProjectEmployees=ProjectEmployees;

    }
    @Override
    public String toString() {
        return "Projects{" +
                "ID = "+ProjectId+
                ", ProjectName='" + ProjectName + '\''+
             ", ProjectLeader=" + ProjectLeader.getLeaderName() +
                ", ProjectCustomer=" + ProjectCustomer.getCustomerName() /*+
             /*   ", ProjectEmployers=" + this.getProjectEmployees() +
                '}'*/;
    }
}
