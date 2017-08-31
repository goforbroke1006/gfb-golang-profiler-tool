package com.gfb.golang_profiler_tool.run.configuration;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.ComponentWithBrowseButton;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by SCherk01 on 30.08.17.
 */
public class GolangProfilerSettingsEditor extends SettingsEditor<GolangProfilerRunConfiguration> {
    private Project project;
    private TextFieldWithBrowseButton fieldWithBrowseButton;

    public GolangProfilerSettingsEditor(Project project) {
        super();
        this.project = project;
    }

    @Override
    protected void resetEditorFrom(@NotNull GolangProfilerRunConfiguration golangProfilerRunConfiguration) {

    }

    @Override
    protected void applyEditorTo(@NotNull GolangProfilerRunConfiguration golangProfilerRunConfiguration) throws ConfigurationException {
        // TODO: I do not know how data applies from editor to configuration and vice versa
        if (!fieldWithBrowseButton.getText().equals("") && !fieldWithBrowseButton.getText().equals(golangProfilerRunConfiguration.getScriptFilename())) {
            golangProfilerRunConfiguration.setScriptFilename(fieldWithBrowseButton.getText());
        } else {
            fieldWithBrowseButton.setText(golangProfilerRunConfiguration.getScriptFilename());
        }
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        JPanel myPanel = new JPanel();

        LabeledComponent<ComponentWithBrowseButton> myMainClass = new LabeledComponent<ComponentWithBrowseButton>();

        FileChooserDescriptor descriptor = FileChooserDescriptorFactory
                .createSingleFileDescriptor();
        fieldWithBrowseButton = new TextFieldWithBrowseButton();
        fieldWithBrowseButton.addBrowseFolderListener("Choose golang script", "Choose file", project, descriptor);
        myMainClass.setComponent(fieldWithBrowseButton);

        myPanel.add(myMainClass);

        return myPanel;
    }
}
