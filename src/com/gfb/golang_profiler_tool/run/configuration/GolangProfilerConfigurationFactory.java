package com.gfb.golang_profiler_tool.run.configuration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Created by SCherk01 on 30.08.17.
 */
public class GolangProfilerConfigurationFactory extends ConfigurationFactory {
    private static final String FACTORY_NAME = "Golang Profiler configuration factory";

    public GolangProfilerConfigurationFactory(GolangProfilerRunConfigurationType type) {
        super(type);
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new GolangProfilerRunConfiguration(project, this, "Golang Profiler");
    }

    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
