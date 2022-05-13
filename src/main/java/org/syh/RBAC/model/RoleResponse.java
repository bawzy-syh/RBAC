package org.syh.RBAC.model;

public class RoleResponse extends Role{
    private String privilegeName;

    public RoleResponse(Role role, String privilegeName){
        this.privilegeName = privilegeName;
        setRoleID(role.getRoleID());
        setComment(role.getComment());
        setRoleName(role.getRoleName());
        setRoleIdentifier(role.getRoleIdentifier());
        setCreateTime(role.getCreateTime());
    }

    public String getPrivilegeName() {
        return privilegeName;
    }
}
