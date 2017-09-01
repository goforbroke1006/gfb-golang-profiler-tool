package com.gfb.golang_profiler_tool.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

import java.io.IOException;

public class ReloadAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        // TODO: insert action logic here

        Project project = event.getData(PlatformDataKeys.PROJECT);
        String scriptFilename = Messages.showInputDialog(project, "Filename", "Input script name", Messages.getQuestionIcon());
//        Messages.showMessageDialog(project, "Hello, " + txt + "!\n I am glad to see you.", "Information", Messages.getInformationIcon());

        if (project == null || scriptFilename == null) {
            return;
        }

        try {
            final Runtime runtime = Runtime.getRuntime();

//            runtime.exec("go test -cpuprofile cpu.prof -memprofile mem.prof -bench " + project.getBaseDir().getCanonicalPath());

            runtime.exec("cd "+ project.getBaseDir().getCanonicalPath() + " && go build -o ./gfb-prof-build/" + scriptFilename.replace(".go",""));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
