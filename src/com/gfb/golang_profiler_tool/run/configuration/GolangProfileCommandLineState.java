package com.gfb.golang_profiler_tool.run.configuration;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;

/**
 * Created by SCherk01 on 31.08.17.
 */
public class GolangProfileCommandLineState extends CommandLineState {
    private GolangProfilerRunConfiguration configuration;

    protected GolangProfileCommandLineState(@NotNull ExecutionEnvironment environment, GolangProfilerRunConfiguration configuration) {
        super(environment);
        this.configuration = configuration;
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        GeneralCommandLine commandLine = new PtyCommandLine();
        commandLine.setExePath("/usr/local/go/bin/go"); // TODO: workaround for first tests on IDEA under Centos
        commandLine.setWorkDirectory(getEnvironment().getProject().getBasePath());


        String scriptFilename = configuration.getScriptFilename();
        String binFilename = scriptFilename.replace(".go", "");
        commandLine.addParameters("build", "-o", binFilename, scriptFilename);

        return JavaCommandLineStateUtil.startProcess(commandLine, true);
    }
}
