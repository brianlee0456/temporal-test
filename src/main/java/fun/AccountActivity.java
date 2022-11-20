package fun;

import io.temporal.activity.ActivityInterface;

/**
 * @author: Brian
 * @date: 2022/10/31 10:06
 */
@ActivityInterface
public interface AccountActivity {

    String notify(String accountId);

}
