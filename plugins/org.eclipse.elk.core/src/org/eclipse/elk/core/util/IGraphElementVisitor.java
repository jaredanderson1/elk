/*******************************************************************************
 * Copyright (c) 2015 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    spoenemann - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.core.util;

import org.eclipse.elk.graph.ElkGraphElement;

/**
 * A graph element visitor is applied to all elements of a graph.
 */
@FunctionalInterface
public interface IGraphElementVisitor {

    /**
     * Visit the given graph element.
     */
    void visit(ElkGraphElement element);

}
