package org.modelio.modelio_jdl_studio.handlers.tools;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink.LinkRouterKind;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.ILinkPath;
import org.modelio.api.modelio.diagram.tools.DefaultLinkTool;
import org.modelio.api.modelio.model.ITransaction;
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.modelio_jdl_studio.impl.Modelio_JDL_StudioModule;

@objid ("0d496cc1-6985-4b21-89ff-09bebab51eaf")
public class JDLAssociationDiagramTool extends DefaultLinkTool {
    @objid ("a43b158c-5aca-4590-b304-9645e95f28d1")
    @Override
    public boolean acceptFirstElement(final IDiagramHandle diagramHandle, final IDiagramGraphic targetNode) {
        // TODO Auto-generated method stub
        return true;
    }

    @objid ("88960dc2-71e1-400c-9679-1769c2e0634b")
    @Override
    public boolean acceptSecondElement(final IDiagramHandle diagramHandle, final IDiagramGraphic originNode, final IDiagramGraphic targetNode) {
        // TODO Auto-generated method stub
        return true;
    }

    @objid ("f054defd-3d7f-49f4-855e-183e00c9fbf6")
    @Override
    public void actionPerformed(final IDiagramHandle diagramHandle, final IDiagramGraphic originNode, final IDiagramGraphic targetNode, final LinkRouterKind touterType, final ILinkPath path) {
        Class sourceElement = (Class) originNode.getElement();
        Class targetElement = (Class) targetNode.getElement();
        
        try (ITransaction tr = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().createTransaction("JDLAssociationDiagramTool")) {
            Association assoc = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createAssociation(sourceElement, targetElement, "");
            assoc.getEnd().get(1).putTagValue(IModelio_JDL_StudioPeerModule.MODULE_NAME, "isSource", "true");
            assoc.getEnd().get(1).setName(targetElement.getName().toLowerCase());
            assoc.getEnd().get(1).setMultiplicityMax("*");
            List<IDiagramGraphic>  graphs =  diagramHandle.unmask(assoc, 0, 0);
            IDiagramLink link = (IDiagramLink)graphs.get(0);
            link.setPath(path.getPoints());
            link.setRouterKind(touterType);
            diagramHandle.save();
            tr.commit();
        }
    }

}
