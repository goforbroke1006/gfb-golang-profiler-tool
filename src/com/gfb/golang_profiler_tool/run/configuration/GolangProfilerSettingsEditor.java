package com.gfb.golang_profiler_tool.run.configuration;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.ComponentWithBrowseButton;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.apache.batik.util.gui.LanguageDialog;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by SCherk01 on 30.08.17.
 */
public class GolangProfilerSettingsEditor extends SettingsEditor<GolangProfilerRunConfiguration> {
    private JPanel myPanel;
    private LabeledComponent<ComponentWithBrowseButton> myMainClass;

    @Override
    protected void resetEditorFrom(@NotNull GolangProfilerRunConfiguration golangProfilerRunConfiguration) {

    }

    @Override
    protected void applyEditorTo(@NotNull GolangProfilerRunConfiguration golangProfilerRunConfiguration) throws ConfigurationException {

    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        myPanel = new JPanel();
        createUIComponents();
        return myPanel;
    }

    private void createUIComponents() {
        myMainClass = new LabeledComponent<ComponentWithBrowseButton>();
        myMainClass.setComponent(new TextFieldWithBrowseButton());
        myPanel.add(myMainClass);
    }
}
