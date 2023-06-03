package Factory;

import ExecutionContext.Context;

public interface Command {
    public int Do(Context con, String[] digits);
}
