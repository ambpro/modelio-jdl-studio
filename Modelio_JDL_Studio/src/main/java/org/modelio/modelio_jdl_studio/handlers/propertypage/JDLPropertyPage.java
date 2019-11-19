package org.modelio.modelio_jdl_studio.handlers.propertypage;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.module.IModule;
import org.modelio.api.module.propertiesPage.AbstractModulePropertyPage;
import org.modelio.api.module.propertiesPage.IModulePropertyTable;
import org.modelio.modelio_jdl_studio.handlers.propertypage.services.PropertyPageModelFactory;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("b3a6b297-d0fd-4bf1-9c06-029684a39e80")
public class JDLPropertyPage extends AbstractModulePropertyPage {
    @objid ("3f4853df-ff02-4edf-ad86-0f6e9bb857c4")
    public JDLPropertyPage(final IModule module, final String name, final String label, final String bitmap) {
        super(module, name, label, bitmap);
    }

    @objid ("a8d4add6-8694-4a66-97d0-17f9bffd6c9d")
    @Override
    public void update(final List<MObject> elements, final IModulePropertyTable table) {
        PropertyPageModelFactory.getPropertyPageElement(elements).update(table);
    }

    @objid ("b4b52c6d-035a-4832-8baa-c91bbb4f90e1")
    @Override
    public void changeProperty(final List<MObject> elements, final int row, final String value) {
        PropertyPageModelFactory.getPropertyPageElement(elements).changeProperty(row,value);
    }

}
