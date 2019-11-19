package org.modelio.modelio_jdl_studio.handlers.tools;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Rectangle;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.tools.DefaultBoxTool;
import org.modelio.api.modelio.model.ITransaction;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.DataType;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.modelio_jdl_studio.api.jdl.standard.attribute.Field;
import org.modelio.modelio_jdl_studio.impl.Modelio_JDL_StudioModule;

@objid ("1924577d-55bb-48cb-a220-8f98052e2af0")
public class FieldDiagramCommand extends DefaultBoxTool {
    @objid ("be25716d-08f9-41d4-8a5e-7e17ba13c21e")
    @Override
    public boolean acceptElement(final IDiagramHandle diagramHandle, final IDiagramGraphic targetNode) {
        // TODO Auto-generated method stub
        if(targetNode.getElement() instanceof ModelElement) {
            ModelElement element = (ModelElement) targetNode.getElement();
            if(element.isStereotyped("Modelio_JDL_Studio", "Entity"))
                return true;
        }
        return false;
    }

    @objid ("7eaebf71-ed99-446c-9346-a755cf39e694")
    @Override
    public void actionPerformed(final IDiagramHandle diagramHandle, final IDiagramGraphic parent, final Rectangle rect) {
        Class entity = (Class) parent.getElement();
        
        try (ITransaction tr = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().createTransaction("FieldDiagramCommand")) {
            DataType defaultType = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().findElementById(DataType.class, "ef792ee3-3c85-413c-9334-37f79c4dfb9c");
            Attribute field = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createAttribute("field", defaultType, entity, IModelio_JDL_StudioPeerModule.MODULE_NAME, Field.STEREOTYPE_NAME);
        
            diagramHandle.unmask(field, rect.x, rect.y);
            diagramHandle.save();
            tr.commit();
        }
    }

}
