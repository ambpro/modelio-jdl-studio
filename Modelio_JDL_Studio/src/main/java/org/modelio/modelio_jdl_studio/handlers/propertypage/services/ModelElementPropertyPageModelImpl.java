package org.modelio.modelio_jdl_studio.handlers.propertypage.services;

import org.modelio.api.module.propertiesPage.IModulePropertyTable;
import org.modelio.metamodel.uml.infrastructure.ModelElement;

public class ModelElementPropertyPageModelImpl implements IPropertyPageModel<ModelElement>{

    private ModelElement element;
    @Override
    public void update(IModulePropertyTable table) {
        table.addProperty("Name", this.element.getName());
    }

    @Override
    public void changeProperty(int row, String value) {
        switch (row) {
        case 1:
            this.element.setName(value);
            break;
        default:
            break;
        }
    }

    @Override
    public void setElement(ModelElement element) {
        this.element = element;
    }

}
