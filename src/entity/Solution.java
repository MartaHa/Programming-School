package entity;

import java.sql.Date;

public class Solution {

    private int id;
    private Date created;
    private Date updated;
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Solution(int id, Date created, Date updated, String description) {
        this.id = id;
        this.created = created;
        this.updated = updated;
        this.description = description;
    }

    public Solution() {
    }
}
