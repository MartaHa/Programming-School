package entity;

import java.sql.Date;

public class Solution {

    private int solutionId;
    private Date created;
    private Date updated;
    private String description;


    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Solution(int solutionId, Date created, Date updated, String description) {
        this.solutionId = solutionId;
        this.created = created;
        this.updated = updated;
        this.description = description;
    }

    public Solution() {
    }
}
