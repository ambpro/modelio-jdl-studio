package org.modelio.modelio_jdl_studio.handlers.propertypage.services;

import java.util.List;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.modelio_jdl_studio.api.jdl.standard.attribute.Field;
import org.modelio.modelio_jdl_studio.api.jdl.standard.class_.Entity;
import org.modelio.vcore.smkernel.mapi.MObject;


public class PropertyPageModelFactory {

    public static IPropertyPageModel getPropertyPageElement(List<MObject> elements) {
        if (elements.size() == 1 && elements.get(0) instanceof Attribute && ((Attribute) elements.get(0)).isStereotyped(IModelio_JDL_StudioPeerModule.MODULE_NAME, Field.STEREOTYPE_NAME)) {
            FieldPropertyPageModelImpl model = new FieldPropertyPageModelImpl();
            model.setElement(Field.instantiate((Attribute)elements.get(0)));
            return model;
        } else if (elements.size() == 1 && elements.get(0) instanceof Class && ((Class)elements.get(0)).isStereotyped(IModelio_JDL_StudioPeerModule.MODULE_NAME, Entity.STEREOTYPE_NAME)) {
            EntityPropertyPageModelImpl model = new EntityPropertyPageModelImpl();
            model.setElement(Entity.instantiate((Class) elements.get(0)));
            return model;
        } else if (elements.size() == 1 && elements.get(0) instanceof AssociationEnd) {
            AssociationEnd end = (AssociationEnd) elements.get(0);
            if(end.getTagValues(IModelio_JDL_StudioPeerModule.MODULE_NAME, "isSource") == null) {
               end = end.getOpposite();
            }
            AssociationPropertyPageModelImpl model = new AssociationPropertyPageModelImpl();
            model.setElement(end);
            return model;
        } else {
            ModelElementPropertyPageModelImpl model = new ModelElementPropertyPageModelImpl();
            model.setElement((ModelElement) elements.get(0));
            return model;
        }
    }

}
