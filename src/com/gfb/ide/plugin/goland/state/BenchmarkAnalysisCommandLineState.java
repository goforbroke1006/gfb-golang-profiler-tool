package com.gfb.ide.plugin.goland.state;

import com.gfb.ide.plugin.goland.run.configuration.RunConfiguration;
import com.gfb.ide.plugin.goland.execution.BashWrapCommandLine;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;

public class BenchmarkAnalysisCommandLineState extends CommandLineState {
    private RunConfiguration configuration;

    public BenchmarkAnalysisCommandLineState(@NotNull ExecutionEnvironment environment, RunConfiguration configuration) {
        super(environment);
        this.configuration = configuration;
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        String goroot = System.getenv("GOROOT");
        if (goroot.isEmpty()) throw new RuntimeException("GOROOT environment variable should be defined!");
        String goExePath = goroot + "/bin/go";

        String scriptFilename = configuration.getScriptFilename();
        final String binFilename = scriptFilename.replace(".go", "");
        String profCpuFile = binFilename + "-cpu.prof";

        BashWrapCommandLine farsh = new BashWrapCommandLine(); // TODO: workaround for running several commands in shell

        farsh.addParameters(goExePath + " build -o " + binFilename + " " + scriptFilename);
        farsh.addParameters(binFilename + " -cpuprofile=" + profCpuFile + " " + configuration.getProgramRunParameters());
        farsh.addParameters("echo \"list main.main\" | " + goExePath + " tool pprof " + profCpuFile + " >> " + binFilename + "-cpu.out");

        final OSProcessHandler osph = new ColoredProcessHandler(farsh);
        ProcessTerminatedListener.attach(osph);
        return osph;
    }
}
