package workers;

import java.util.List;

/**
 * Created by Zhenya on 16.02.2016.
 */
public class Employee {
    private static int idinc=0;
    public int workerId;
    public String workerName;
    public String workerDep;
    public List<Projects> workerProjects;

    public String getWorkerDep() {
        return workerDep;
    }

    public void setWorkerDep(String workerDep) {
        this.workerDep = workerDep;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public List<Projects> getWorkerProjects() {
        return workerProjects;
    }

    public void setWorkerProjects(List<Projects> workerProjects) {
        this.workerProjects = workerProjects;
    }
    public Employee(){

    }
    public Employee(String workerName,String workerDep, List<Projects> workerProjects){

        this.workerDep=workerDep;
        this.workerName=workerName;
        this.workerProjects=workerProjects;
    }
    public Employee(String workerName,String workerDep){
        this.workerDep=workerDep;
        this.workerName=workerName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "workerID='" + workerId + '\''+
                "workerName='" + workerName + '\''/* +
                ", workerDep='" + workerDep + '\'' +
                ", projectList='" + this.getWorkerProjects() + '\'' */+
                '}';
    }
}
