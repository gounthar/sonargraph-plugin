/*******************************************************************************
 * Jenkins Sonargraph Plugin
 * Copyright (C) 2009-2015 hello2morrow GmbH
 * mailto: info AT hello2morrow DOT com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *******************************************************************************/
package com.hello2morrow.sonargraph.jenkinsplugin.controller;

public enum ConfigParameters
{
    ACTION_URL_NAME("sonargraph"),
    SONARGRAPH_ICON("/plugin/sonargraph-plugin/icons/Sonargraph-Architect.png"),
    ACTION_DISPLAY_NAME("Sonargraph"),
    REPORT_BUILDER_DISPLAY_NAME("Sonargraph Report Generation & Analysis"),
    REPORT_ANALYZER_DISPLAY_NAME("Sonargraph Report Analysis"),
    JOB_FOLDER("job/"),
    HTML_REPORT_ACTION_URL("sonargraph-html-report"),
    METRIC_HISTORY_CSV_FILE_PATH("sonargraph.csv"),
    CHARTS_FOR_METRICS_CSV_FILE_PATH("charts_for_metrics.csv"),
    SONARGRAPH_HTML_REPORT_FILE_NAME("sonargraph-report.html"),
    REPORT_HISTORY_FOLDER("sonargraphReportHistory");

    private String m_value;

    private ConfigParameters(String value)
    {
        m_value = value;
    }

    public String getValue()
    {
        return m_value;
    }
}