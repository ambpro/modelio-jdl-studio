package org.modelio.modelio_jdl_studio.handlers.tools;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink.LinkRouterKind;
import org.modelio.api.modelio.diagram.ILinkPath;
import org.modelio.api.modelio.diagram.tools.DefaultAttachedBoxTool;
import org.modelio.api.modelio.model.ITransaction;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Note;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.modelio_jdl_studio.impl.Modelio_JDL_StudioModule;

@objid ("8c95adf2-b944-460b-80e7-23c34147a8f6")
public class JavaDocDiagramTool extends DefaultAttachedBoxTool {
    @objid ("ba1ea174-7968-498d-8baf-9ddc4fe553c6")
    @Override
    public boolean acceptElement(IDiagramHandle arg0, IDiagramGraphic arg1) {
        return true;
    }

    @objid ("22a97caf-9af0-44f9-a1bc-3b0c8081662c")
    @Override
    public void actionPerformed(final IDiagramHandle diagramHandle, final IDiagramGraphic originNode, final LinkRouterKind routerType, final ILinkPath path, final Point point) {
        ModelElement owner = (ModelElement) originNode.getElement();
        
        try (ITransaction tr = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().createTransaction("DescriptionDiagramTool")) {
        
            Note note = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createNote(IModelio_JDL_StudioPeerModule.MODULE_NAME, "JavaDoc", owner, "");
        
            diagramHandle.unmask(note, point.x, point.y);
            diagramHandle.save();
            tr.commit();
        }
    }

    @objid ("af73fbef-13b5-434b-84e1-ca8ef5973bf1")
    @Override
    public void actionPerformedInDiagram(final IDiagramHandle diagramHandle, final Rectangle rect) {
        MessageDialog.openInformation(Display.getDefault().getActiveShell(), "JavaDocDiagramTool", "ToolInDIagram not implemented!");
    }

}
