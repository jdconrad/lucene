/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.lucene.sandbox.queries.profile;

import java.util.List;

/**
 * This class acts as as storage for a profile tree. This class may be extended to define how the
 * profile contains and how it's broken into different pieces.
 */
public class AbstractProfiler<PB extends AbstractProfileBreakdown<?>, E> {

  protected final AbstractInternalProfileTree<PB, E> profileTree;

  public AbstractProfiler(AbstractInternalProfileTree<PB, E> profileTree) {
    this.profileTree = profileTree;
  }

  /**
   * Get the {@link AbstractProfileBreakdown} for the given element in the tree, potentially
   * creating it if it did not exist.
   */
  public PB getQueryBreakdown(E query) {
    return profileTree.getProfileBreakdown(query);
  }

  /** Removes the last (e.g. most recent) element on the stack. */
  public void pollLastElement() {
    profileTree.pollLast();
  }

  /** @return a hierarchical representation of the profiled tree */
  public List<ProfileResult> getTree() {
    return profileTree.getTree();
  }
}
