package entity;

public class UserGroup {

    private int userGroupId;
    private String name;

    public int getuserGroupId() {
        return userGroupId;
    }

    public void setId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserGroup(int userGroupId, String name) {
        this.userGroupId = userGroupId;
        this.name = name;
    }

    public UserGroup() {
    }
}
