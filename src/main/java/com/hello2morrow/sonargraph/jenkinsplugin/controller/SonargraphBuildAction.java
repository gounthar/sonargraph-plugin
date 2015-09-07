package com.hello2morrow.sonargraph.jenkinsplugin.controller;

import hudson.FilePath;
import hudson.model.AbstractBuild;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import com.hello2morrow.sonargraph.jenkinsplugin.foundation.StringUtility;

public class SonargraphBuildAction extends AbstractHTMLAction
{
    private AbstractBuild<?, ?> build;

    /**
     * Recorder seems to be needed to provide the link between the recorder and action.
     * TODO: Verify this assumption
     */
    private AbstractSonargraphRecorder recorder;

    public SonargraphBuildAction(AbstractBuild<?, ?> build, AbstractSonargraphRecorder recorder)
    {
        this.build = build;
        this.recorder = recorder;
    }

    @Override
    public void doDynamic(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException
    {
        FilePath reportHistoryDir = new FilePath(new FilePath(build.getProject().getRootDir()), ConfigParameters.REPORT_HISTORY_FOLDER.getValue());
        enableDirectoryBrowserSupport(req, rsp, new FilePath(reportHistoryDir, "sonargraph-report-build-" + build.getNumber()));
    }

    public AbstractBuild<?, ?> getBuild()
    {
        return build;
    }

    public String getIconFileName()
    {
        return ConfigParameters.SONARGRAPH_ICON.getValue();
    }

    public String getDisplayName()
    {
        return ConfigParameters.ACTION_DISPLAY_NAME.getValue();
    }

    public String getUrlName()
    {
        return "html-report";
    }

    @Override
    public String getHTMLReport() throws IOException, InterruptedException
    {
        File projectRootFolder = build.getProject().getRootDir();
        File reportHistoryFolder = new File(projectRootFolder, ConfigParameters.REPORT_HISTORY_FOLDER.getValue());
        File reportBuildFolder = new File(reportHistoryFolder, "sonargraph-report-build-" + build.getNumber());
        String reportFileName = recorder instanceof SonargraphReportAnalyzer ? ((SonargraphReportAnalyzer) recorder).getReportName()
                : ConfigParameters.SONARGRAPH_HTML_REPORT_FILE_NAME.getValue();
        File reportFile = new File(reportBuildFolder, StringUtility.replaceXMLWithHTMLExtension(reportFileName));
        return readHTMLReport(new FilePath(reportFile));
    }
}
