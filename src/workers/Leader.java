package workers;

import java.util.List;

/**
 * Created by Zhenya on 17.02.2016.
 */
public class Leader {
    private int idinc = 0;
    private int jdbcidinc = 0;
    public int LeaderID;
    public String LeaderName;
    public List<Projects> LeaderProject;

    public int getLeaderID() {
        return LeaderID;
    }

    public void setLeaderID(int leaderID) {
        LeaderID = leaderID;
    }

    public List<Projects> getLeaderProject() {
        return LeaderProject;
    }

    public void setLeaderProject(List<Projects> leaderProject) {
        LeaderProject = leaderProject;
    }

    public String getLeaderName() {
        return LeaderName;
    }

    public void setLeaderName(String leaderName) {
        LeaderName = leaderName;
    }

    public Leader(){

    }
    public Leader(String LeaderName,List<Projects> LeaderProjects){
        ++idinc;
        this.LeaderID=idinc;
        this.LeaderName=LeaderName;
        this.LeaderProject=LeaderProjects;
    }
    public Leader(String LeaderName){
        ++idinc;
        this.LeaderID=jdbcidinc;
        this.LeaderName=LeaderName;
    }
    @Override
    public String toString() {
        return "Leader{" +
                "LeaderID=" + LeaderID +
                ", LeaderName='" + LeaderName + '\''/* +
                ", LeaderProject=" + LeaderProject +
                '}'*/;
    }

}
