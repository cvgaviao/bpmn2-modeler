/*******************************************************************************
 * Copyright (c) 2011, 2012 Red Hat, Inc. 
 * All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 *
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 *******************************************************************************/
package org.eclipse.bpmn2.modeler.ui.property.diagrams;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.di.BPMNDiagram;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractBpmn2PropertySection;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.AbstractDetailComposite;
import org.eclipse.bpmn2.modeler.core.merrimac.clad.PropertiesCompositeFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.widgets.Composite;

public class ProcessDiagramPropertySection extends AbstractBpmn2PropertySection {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.bpmn2.modeler.ui.property.AbstractBpmn2PropertySection#
	 * createSectionRoot()
	 */
	@Override
	protected AbstractDetailComposite createSectionRoot() {
		return new ProcessDiagramPropertyComposite(this);
	}

	@Override
	public AbstractDetailComposite createSectionRoot(Composite parent, int style) {
		return new ProcessDiagramPropertyComposite(parent,style);
	}

	@Override
	protected EObject getBusinessObjectForPictogramElement(PictogramElement pe) {
		EObject bo = super.getBusinessObjectForPictogramElement(pe);
		if (bo instanceof Participant) {
			return ((Participant) bo).getProcessRef();
		} else if (bo instanceof BPMNDiagram) {
			BaseElement be = ((BPMNDiagram)bo).getPlane().getBpmnElement();
			if (be instanceof Process)
				return be;
		}
		
		return null;
	}
}
