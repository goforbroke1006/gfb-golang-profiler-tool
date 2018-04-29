package com.gfb.ide.plugin.goland.run.configuration;

import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Created by SCherk01 on 30.08.17.
 */
public class ConfigurationFactory extends com.intellij.execution.configurations.ConfigurationFactory {
    private static final String FACTORY_NAME = "GFB Golang Tool configuration factory";

    public ConfigurationFactory(PluginRunConfigurationType type) {
        super(type);
    }

    @NotNull
    @Override
    public com.intellij.execution.configurations.RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new RunConfiguration(project, this, "GFB Golang Tool");
    }

    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
