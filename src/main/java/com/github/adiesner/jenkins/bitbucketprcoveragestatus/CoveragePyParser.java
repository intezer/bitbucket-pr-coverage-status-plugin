package com.github.adiesner.jenkins.bitbucketprcoveragestatus;

import com.jayway.jsonpath.JsonPathException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * <a href="https://github.com/nedbat/coveragepy">coverage.py</a>
 */
public class CoveragePyParser implements CoverageReportParser {

    private static final String METRIC_PATH_XPATH = "/coverage/@line-rate";

    private float getByXpath(final String filePath, final String content, final String xpath) {
        try {
            return Float.parseFloat(XmlUtils.findInXml(content, xpath));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Strange coverage.py report!\n" +
                            "File path: " + filePath + "\n" +
                            "Can't extract float value by XPath: " + xpath + "\n" +
                            "from:\n" + content, e);
        }
    }

    @Override
    public float get(final String cloverFilePath) {
        final String content;
        try {
            content = FileUtils.readFileToString(new File(cloverFilePath));
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Can't read coverage.py report by path: " + cloverFilePath);
        }

        return getByXpath(cloverFilePath, content, METRIC_PATH_XPATH);
    }
}
