package com.gfb.ide.plugin.goland.execution;

import com.intellij.execution.configurations.GeneralCommandLine;
import org.jetbrains.annotations.NotNull;

/**
 * Created by SCherk01 on 01.09.17.
 */
public class BashWrapCommandLine extends GeneralCommandLine {
    public BashWrapCommandLine() {
        setExePath("bash");
        withEnvironment("GOROOT", "/usr/local/go"); // TODO: hardcode
        addParameters("-c");
    }

    @Override
    public void addParameters(@NotNull String... parameters) {
        for (String parameter : parameters) {
            if (getParametersList().getList().size() <= 1)
                getParametersList().add(parameter);
            else {
                String tmp = getParametersList().get(1);
                tmp += " && " + parameter;
                getParametersList().set(1, tmp);
            }
        }
    }
}
