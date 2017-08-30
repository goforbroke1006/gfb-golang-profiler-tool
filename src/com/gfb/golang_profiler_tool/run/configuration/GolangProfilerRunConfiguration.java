package com.gfb.golang_profiler_tool.run.configuration;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.*;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by SCherk01 on 30.08.17.
 */
public class GolangProfilerRunConfiguration extends RunConfigurationBase {
    private String scriptFilename;

    public GolangProfilerRunConfiguration(Project project, GolangProfilerConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new GolangProfilerSettingsEditor(getProject());
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {

    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull final Executor executor, @NotNull final ExecutionEnvironment executionEnvironment) throws ExecutionException {
        final Runtime runtime = Runtime.getRuntime();

//            runtime.exec("go test -cpuprofile cpu.prof -memprofile mem.prof -bench " + project.getBaseDir().getCanonicalPath());

        Project project = executionEnvironment.getProject();
        String binFilename = scriptFilename.replace(".go", "");
        try {
            String buildBinCmd = "go build -o " + binFilename + " " + scriptFilename;
            Process p = runtime.exec(buildBinCmd);

            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            StringBuffer output = new StringBuffer();
            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }
            System.out.print(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return executionEnvironment.getState();
    }

    public String getScriptFilename() {
        return scriptFilename;
    }

    public void setScriptFilename(String scriptFilename) {
        this.scriptFilename = scriptFilename;
    }
}
