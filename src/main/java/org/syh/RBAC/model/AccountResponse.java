package org.syh.RBAC.model;

public class AccountResponse extends Account{
    private String roleName;

    public AccountResponse(Account account,String roleName) {
        this.roleName = roleName;
        setUid(account.getUid());
        setPassword(account.getPassword());
        setUsername(account.getUsername());
        setCreateTime(account.getCreateTime());
        setEmail(account.getEmail());
    }

    public String getRoleName() {
        return roleName;
    }
}
