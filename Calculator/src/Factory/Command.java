package Factory;

import ExecutionContext.Context;

public interface Command {
    public void Do(Context con, String[] digits);
}
