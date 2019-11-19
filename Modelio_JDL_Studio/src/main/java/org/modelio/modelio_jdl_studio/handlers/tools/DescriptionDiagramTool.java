package org.modelio.modelio_jdl_studio.handlers.tools;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink.LinkRouterKind;
import org.modelio.api.modelio.diagram.ILinkPath;
import org.modelio.api.modelio.diagram.tools.DefaultAttachedBoxTool;
import org.modelio.api.modelio.model.ITransaction;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Note;
import org.modelio.modelio_jdl_studio.impl.Modelio_JDL_StudioModule;

@objid ("569eec38-864f-4930-9d4c-50f6999eeb84")
public class DescriptionDiagramTool extends DefaultAttachedBoxTool {
    @objid ("d547e11d-3a0d-4c61-88b8-fd3a9a74aa41")
    @Override
    public boolean acceptElement(final IDiagramHandle diagramHandle, final IDiagramGraphic targetNode) {
        return true;
    }

    @objid ("b9b9822c-91aa-4549-bed8-7e9d4e0c90dc")
    @Override
    public void actionPerformed(final IDiagramHandle diagramHandle, final IDiagramGraphic originNode, final LinkRouterKind routerType, final ILinkPath path, final Point point) {
        ModelElement owner = (ModelElement) originNode.getElement();
        
        try (ITransaction tr = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().createTransaction("DescriptionDiagramTool")) {
        
            Note note = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createNote("ModelerModule", "description", owner, "");
            note.setMimeType("text/plain");
            diagramHandle.unmask(note, point.x, point.y);
            diagramHandle.save();
            tr.commit();
        }
    }

    @objid ("47237ade-b18f-459c-b133-fb3826652c24")
    @Override
    public void actionPerformedInDiagram(final IDiagramHandle diagramHandle, final Rectangle rect) {
        // TODO Auto-generated method stub
    }

}
