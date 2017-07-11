/*******************************************************************************
 * Copyright (c) 2016 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.alg.layered.options;

/**
 * Specifies the desired strategy to wrap graphs in order to improve their presentation within a drawing area of 
 * a certain aspect ratio. I.e. the graph is split into several chunks to better utilize the given area.
 */
public enum WrappingStrategy {

    /** Off. */
    OFF,
    /**
     * At each cut point, only a single edge may wrap backwards. Consequently it is only possible 
     * to cut between pairs of layers that are connected (and spanned) by a single edge. 
     */
    SINGLE_EDGE,
    /**
     * It is allowed that multiple edges wrap backwards at a cut point. An additional objective is thus to keep the
     * number of edges wrapping backwards small.
     */
    MULTI_EDGE,
    
}
