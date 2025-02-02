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
 * @since 0.6.0
 */
public class DockerRepository extends AbstractRepositoryTap {
    private Boolean versionedSubfolders;

    public DockerRepository() {
        super("docker", "docker");
    }

    @Override
    void setAll(AbstractRepositoryTap tap) {
        super.setAll(tap);
        this.versionedSubfolders = ((DockerRepository) tap).versionedSubfolders;
    }

    public boolean isVersionedSubfolders() {
        return versionedSubfolders != null && versionedSubfolders;
    }

    public void setVersionedSubfolders(Boolean versionedSubfolders) {
        this.versionedSubfolders = versionedSubfolders;
    }

    public boolean isVersionedSubfoldersSet() {
        return versionedSubfolders != null;
    }

    @Override
    public Map<String, Object> asMap(boolean full) {
        Map<String, Object> map = super.asMap(full);
        map.put("versionedSubfolders", isVersionedSubfolders());
        return map;
    }
}
