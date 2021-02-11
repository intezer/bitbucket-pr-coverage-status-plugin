/*

    Copyright 2015-2016 Artem Stasiuk

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/
package com.github.adiesner.jenkins.bitbucketprcoveragestatus;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CoveragePyParserTest {

    @Test
    public void extractCoverageFromCoveragePyReport() throws IOException {
        String filePath = CoveragePyParserTest.class.getResource(
            "/com/github/adiesner/jenkins/bitbucketprcoveragestatus/CoveragePyParserTest/coverage.xml").getFile();

        Assert.assertEquals(0.6723, new CoveragePyParser().get(filePath), 0.1);
    }

}
