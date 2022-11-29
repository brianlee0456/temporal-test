package com.decathlon.platform.infrastructure.workflow.notify;

/**
 * @author: Brian
 * @date: 2022/11/29 10:56
 */
public class Account {

    private String accountId;

    public static Account of(String accountId) {
        Account account = new Account();
        account.setAccountId(accountId);
        return account;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
