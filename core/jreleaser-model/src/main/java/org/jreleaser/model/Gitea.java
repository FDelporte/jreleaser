/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020-2021 The JReleaser authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jreleaser.model;

import java.util.Map;

/**
 * @author Andres Almiray
 * @since 0.1.0
 */
public class Gitea extends GitService {
    public static final String NAME = "gitea";

    private final Prerelease prerelease = new Prerelease();
    private Boolean draft;

    public Gitea() {
        this(NAME);
    }

    Gitea(String name) {
        super(name, true);
        setRepoUrl("https://{{repoHost}}/{{repoOwner}}/{{repoName}}");
        setRepoCloneUrl("https://{{repoHost}}/{{repoOwner}}/{{repoName}}.git");
        setCommitUrl("https://{{repoHost}}/{{repoOwner}}/{{repoName}}/commits");
        setSrcUrl("https://{{repoHost}}/{{repoOwner}}/{{repoName}}/src/{{repoBranch}}");
        setDownloadUrl("https://{{repoHost}}/{{repoOwner}}/{{repoName}}/releases/download/{{tagName}}/{{artifactFileName}}");
        setReleaseNotesUrl("https://{{repoHost}}/{{repoOwner}}/{{repoName}}/releases/tag/{{tagName}}");
        setLatestReleaseUrl("https://{{repoHost}}/{{repoOwner}}/{{repoName}}/releases/latest");
        setIssueTrackerUrl("https://{{repoHost}}/{{repoOwner}}/{{repoName}}/issues");
    }

    void setAll(Gitea service) {
        super.setAll(service);
        this.draft = service.draft;
        setPrerelease(service.prerelease);
    }

    public boolean isDraft() {
        return draft != null && draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public boolean isDraftSet() {
        return draft != null;
    }

    public Prerelease getPrerelease() {
        return prerelease;
    }

    public void setPrerelease(Prerelease prerelease) {
        this.prerelease.setAll(prerelease);
    }

    @Override
    public String getReverseRepoHost() {
        return null;
    }

    @Override
    public Map<String, Object> asMap(boolean full) {
        Map<String, Object> map = super.asMap(full);
        map.put("draft", isDraft());
        map.put("prerelease", prerelease.asMap(full));
        return map;
    }
}
