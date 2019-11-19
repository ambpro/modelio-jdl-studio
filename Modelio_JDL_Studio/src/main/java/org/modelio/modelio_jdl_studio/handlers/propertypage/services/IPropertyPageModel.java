package org.modelio.modelio_jdl_studio.handlers.propertypage.services;

import org.modelio.api.module.propertiesPage.IModulePropertyTable;

public interface IPropertyPageModel<T> {

    public void update(final IModulePropertyTable table);
    public void changeProperty(final int row, final String value);
    public void setElement(T element);
}
