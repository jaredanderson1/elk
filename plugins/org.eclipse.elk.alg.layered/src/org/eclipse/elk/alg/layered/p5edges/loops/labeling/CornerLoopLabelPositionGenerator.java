/*******************************************************************************
 * Copyright (c) 2018 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.elk.alg.layered.p5edges.loops.labeling;

import java.util.List;

import org.eclipse.elk.alg.layered.p5edges.loops.SelfLoopComponent;
import org.eclipse.elk.alg.layered.p5edges.loops.SelfLoopLabel;
import org.eclipse.elk.alg.layered.p5edges.loops.SelfLoopLabelPosition;
import org.eclipse.elk.alg.layered.p5edges.loops.SelfLoopNode;
import org.eclipse.elk.alg.layered.p5edges.loops.SelfLoopPort;
import org.eclipse.elk.alg.layered.p5edges.loops.util.SelfLoopBendpointCalculationUtil;
import org.eclipse.elk.alg.layered.p5edges.splines.SplinesMath;
import org.eclipse.elk.core.math.KVector;

/**
 * Generates self loop label positions for corner self loops.
 */
public class CornerLoopLabelPositionGenerator extends AbstractSelfLoopLabelPositionGenerator {

    /**
     * Creates a new instance for the given node.
     */
    public CornerLoopLabelPositionGenerator(final SelfLoopNode slNode) {
        super(slNode);
    }
    

    @Override
    public void generatePositions(final SelfLoopComponent component) {
        List<SelfLoopPort> ports = component.getPorts();
        SelfLoopPort startPort = ports.get(0);
        SelfLoopPort endPort = ports.get(ports.size() - 1);
        
        // Retrieve the spacings active for this node
        double edgeEdgeSpacing = getEdgeEdgeSpacing();
        double edgeLabelSpacing = getEdgeLabelSpacing();
        
        KVector startPosition = startPort.getLPort().getPosition().clone().add(startPort.getLPort().getAnchor());
        KVector endPosition = endPort.getLPort().getPosition().clone().add(endPort.getLPort().getAnchor());

        double directionStart = SplinesMath.portSideToDirection(startPort.getPortSide());
        KVector dirVectorStart = new KVector(directionStart);
        
        double directionEnd = SplinesMath.portSideToDirection(endPort.getPortSide());
        KVector dirVectorEnd = new KVector(directionEnd);
        
        KVector firstBend = startPosition.clone().add(
                dirVectorStart.clone().scale((startPort.getMaximumLevel() * edgeEdgeSpacing) + edgeLabelSpacing));
        KVector secondBend = endPosition.clone().add(
                dirVectorEnd.clone().scale((endPort.getMaximumLevel() * edgeEdgeSpacing) + edgeLabelSpacing));

        KVector cornerBend = SelfLoopBendpointCalculationUtil.calculateCornerBendPoint(
                firstBend, startPort.getPortSide(), secondBend, endPort.getPortSide());
        
        SelfLoopLabel label = component.getSelfLoopLabel();
        List<SelfLoopLabelPosition> positions = label.getCandidatePositions();
        
        // Start segment
        positions.add(shortSegmentPosition(label, startPort, firstBend, cornerBend, Alignment.CENTERED, false));
        positions.add(shortSegmentPosition(label, startPort, firstBend, cornerBend, Alignment.LEFT_OR_TOP, false));
        positions.add(shortSegmentPosition(label, startPort, firstBend, cornerBend, Alignment.RIGHT_OR_BOTTOM, false));
        
        // End segment
        positions.add(shortSegmentPosition(label, endPort, secondBend, cornerBend, Alignment.CENTERED, false));
        positions.add(shortSegmentPosition(label, endPort, secondBend, cornerBend, Alignment.LEFT_OR_TOP, false));
        positions.add(shortSegmentPosition(label, endPort, secondBend, cornerBend, Alignment.RIGHT_OR_BOTTOM, false));
    }

}
