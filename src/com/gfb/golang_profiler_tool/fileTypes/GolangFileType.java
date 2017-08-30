package com.gfb.golang_profiler_tool.fileTypes;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by SCherk01 on 30.08.17.
 */
public class GolangFileType extends LanguageFileType {
    public static final GolangFileType INSTANCE = new GolangFileType();

    private GolangFileType() {
        super(PlainTextLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "GOLANG_SCRIPT";
    }

    @NotNull
    @Override
    public String getDescription() {
        return null;
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "go";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Text;
    }
}
