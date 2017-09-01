package com.gfb.golang_profiler_tool.run.configuration;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.*;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by SCherk01 on 30.08.17.
 */
public class GolangProfilerRunConfiguration extends RunConfigurationBase {
    private String scriptFilename = "/home/SCherk01/projects/go-learn/monolog_analyzer.go";
    private String programRunParameters = "-file=/home/SCherk01/test.log";

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
        return new GolangProfileCommandLineState(executionEnvironment, this);
    }

    public String getScriptFilename() {
        return scriptFilename;
    }

    public void setScriptFilename(String scriptFilename) {
        this.scriptFilename = scriptFilename;
    }

    public String getProgramRunParameters() {
        return programRunParameters;
    }

    public void setProgramRunParameters(String programRunParameters) {
        this.programRunParameters = programRunParameters;
    }
}
