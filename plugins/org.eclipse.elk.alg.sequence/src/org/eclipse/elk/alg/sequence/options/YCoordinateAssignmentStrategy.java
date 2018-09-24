/*******************************************************************************
 * Copyright (c) 2018 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.alg.sequence.options;

import org.eclipse.elk.alg.sequence.SequencePhases;
import org.eclipse.elk.alg.sequence.graph.LayoutContext;
import org.eclipse.elk.alg.sequence.p6ycoordinates.YCoordinateCalculator;
import org.eclipse.elk.core.alg.ILayoutPhase;
import org.eclipse.elk.core.alg.ILayoutPhaseFactory;

/**
 * Definition of available y coordinate assignment strategies for the sequence diagram layouter.
 */
public enum YCoordinateAssignmentStrategy implements ILayoutPhaseFactory<SequencePhases, LayoutContext> {

    /** The only y coordinate assignment implementation. */
    DEFAULT;

    
    @Override
    public ILayoutPhase<SequencePhases, LayoutContext> create() {
        switch (this) {
        case DEFAULT:
            return new YCoordinateCalculator();
            
        default:
            throw new IllegalArgumentException(
                    "No implementation is available for the y coordinate assigner " + this.toString());
        }
    }
    
}
