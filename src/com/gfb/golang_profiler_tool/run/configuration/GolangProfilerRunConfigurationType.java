package com.gfb.golang_profiler_tool.run.configuration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by SCherk01 on 30.08.17.
 */
public class GolangProfilerRunConfigurationType implements ConfigurationType {
    @Override
    public String getDisplayName() {
        return "Golang Profiler";
    }

    @Override
    public String getConfigurationTypeDescription() {
        return "Golang Profiler Configuration Type";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.General.Information;
    }

    @NotNull
    @Override
    public String getId() {
        return "GOLANG_PROFILER_RUN_CONFIGURATION";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{new GolangProfilerConfigurationFactory(this)};
    }
}
