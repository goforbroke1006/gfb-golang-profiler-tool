package com.gfb.ide.plugin.goland.run.configuration;

import com.gfb.ide.plugin.goland.settings.MainViewSettingsEditor;
import com.gfb.ide.plugin.goland.state.GolangProfileCommandLineState;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.*;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RunConfiguration extends RunConfigurationBase {
    private String scriptFilename = "/home/SCherk01/projects/go-learn/monolog_analyzer.go";
    private String programRunParameters = "-file=/home/SCherk01/test.log";

    public RunConfiguration(Project project, ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @NotNull
    @Override
    public SettingsEditor<? extends com.intellij.execution.configurations.RunConfiguration> getConfigurationEditor() {
        return new MainViewSettingsEditor(getProject());
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
