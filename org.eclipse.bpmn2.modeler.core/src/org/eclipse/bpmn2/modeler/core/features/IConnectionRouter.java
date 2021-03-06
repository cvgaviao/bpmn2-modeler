/*******************************************************************************
 * Copyright (c) 2011, 2012, 2013 Red Hat, Inc.
 * All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.eclipse.bpmn2.modeler.core.features;
import org.eclipse.graphiti.mm.pictograms.Connection;

public interface IConnectionRouter {
	
	// this is a way to pass additional info to the connection router in the form of a string;
	// the info is attached to the Connection as a Property.
	// see Graphiti.getPeService().setPropertyValue()
	public static final String ROUTING_INFO = "routing.info"; //$NON-NLS-1$
	public static final String ROUTING_INFO_FORCE = "force"; //$NON-NLS-1$
	public static final String ROUTING_INFO_BENDPOINT = "bendpoint"; //$NON-NLS-1$
	
	public boolean route(Connection connection);
	public void dispose();
}
