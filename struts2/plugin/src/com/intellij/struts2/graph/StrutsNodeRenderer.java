/*
 * Copyright 2008 The authors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.struts2.graph;

import com.intellij.openapi.graph.builder.GraphBuilder;
import com.intellij.openapi.graph.builder.renderer.BasicGraphNodeRenderer;
import com.intellij.psi.PsiManager;
import com.intellij.struts2.graph.beans.BasicStrutsEdge;
import com.intellij.struts2.graph.beans.BasicStrutsNode;

import javax.swing.*;

/**
 * @author Yann C&eacute;bron
 * @author Sergey Vasiliev
 */
public class StrutsNodeRenderer extends BasicGraphNodeRenderer<BasicStrutsNode, BasicStrutsEdge> {

  public StrutsNodeRenderer(final GraphBuilder<BasicStrutsNode, BasicStrutsEdge> graphBuilder) {
    super(graphBuilder, PsiManager.getInstance(graphBuilder.getProject()).getModificationTracker());
  }

  protected Icon getIcon(final BasicStrutsNode node) {
    return node.getIcon();
  }

  protected String getNodeName(final BasicStrutsNode node) {
    return node.getName();
  }

}