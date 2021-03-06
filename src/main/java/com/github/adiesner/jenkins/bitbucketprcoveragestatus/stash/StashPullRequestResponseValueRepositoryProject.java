package com.github.adiesner.jenkins.bitbucketprcoveragestatus.stash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StashPullRequestResponseValueRepositoryProject {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}