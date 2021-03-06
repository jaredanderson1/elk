/*******************************************************************************
 * Copyright (c) 2011, 2015 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.alg.force;

import org.eclipse.elk.alg.force.graph.FGraph;

/**
 * Interface for importer classes for the force graph structure.
 *
 * @param <T> the type of graph that this importer can transform into a force graph.
 * @author msp
 */
public interface IGraphImporter<T> {
    
    /**
     * Create a force graph from the given graph.
     * 
     * @param graph the graph to turn into a force graph
     * @return a force graph, or {@code null} if the input was not recognized
     */
    FGraph importGraph(T graph);
    
    /**
     * Apply the computed layout of a force graph to the original graph.
     * 
     * @param forceGraph the graph for which layout is applied
     */
    void applyLayout(FGraph forceGraph);

}
