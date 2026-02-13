package common;

import java.io.Serializable;

public class BuildMessage implements Serializable {
    public String jobName;
    public String command;

    public BuildMessage(String jobName, String command) {
        this.jobName = jobName;
        this.command = command;
    }
}
