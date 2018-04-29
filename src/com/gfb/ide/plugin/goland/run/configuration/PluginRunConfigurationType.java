package com.gfb.ide.plugin.goland.run.configuration;

import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by SCherk01 on 30.08.17.
 */
public class PluginRunConfigurationType implements ConfigurationType {
    @Override
    public String getDisplayName() {
        return "GFB Golang Tool";
    }

    @Override
    public String getConfigurationTypeDescription() {
        return getDisplayName() + " Configuration Type";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.General.Information;
    }

    @NotNull
    @Override
    public String getId() {
        return "GFB_GOLANG_TOOL_RUN_CONFIGURATION";
    }

    @Override
    public com.intellij.execution.configurations.ConfigurationFactory[] getConfigurationFactories() {
        return new com.intellij.execution.configurations.ConfigurationFactory[]{
                new ConfigurationFactory(this),
        };
    }
}
