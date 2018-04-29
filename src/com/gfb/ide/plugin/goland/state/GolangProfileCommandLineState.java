package com.gfb.ide.plugin.goland.state;

import com.gfb.ide.plugin.goland.run.configuration.RunConfiguration;
import com.gfb.ide.plugin.goland.execution.BashWrapCommandLine;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;

/**
 * Created by SCherk01 on 31.08.17.
 */
public class GolangProfileCommandLineState extends CommandLineState {
    private RunConfiguration configuration;

    public GolangProfileCommandLineState(@NotNull ExecutionEnvironment environment, RunConfiguration configuration) {
        super(environment);
        this.configuration = configuration;
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        System.getenv("GOROOT");
        String goExePath = "/usr/local/go/bin/go"; // TODO: workaround for first tests on IDEA under Centos

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
