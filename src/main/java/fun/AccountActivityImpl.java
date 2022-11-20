package fun;

/**
 * @author: Brian
 * @date: 2022/10/31 10:07
 */
public class AccountActivityImpl implements AccountActivity {
    @Override
    public String notify(String accountId) {
        System.out.println(accountId + " notified...");
        return "notified...";
    }
}
