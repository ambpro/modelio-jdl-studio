package org.modelio.modelio_jdl_studio.handlers.propertypage.services;

import org.modelio.api.module.propertiesPage.IModulePropertyTable;
import org.modelio.modelio_jdl_studio.api.jdl.standard.class_.Entity;

public class EntityPropertyPageModelImpl implements IPropertyPageModel<Entity>{

    private Entity element;

    @Override
    public void update(IModulePropertyTable table) {
        table.addProperty("Name", this.element.getElement().getName());
        table.addProperty("skipClient", this.element.isSkipClient());
        table.addProperty("skipServer", this.element.isSkipServer());
        table.addProperty("noFluentMethod", this.element.isNoFluentMethod());
        table.addProperty("filter", this.element.isFilter());
        table.addProperty("readOnly", this.element.isReadOnly());
        String dtoValue = this.element.getDto() ;

        if (dtoValue == null || "".equals(dtoValue)) {
            dtoValue = "no";
        }
        table.addProperty("dto", dtoValue, new String[] { "mapstruct", "no" });

        String serviceValue = this.element.getService() ;
        if (serviceValue == null || "".equals(serviceValue)) {
            serviceValue = "no";
        }
        table.addProperty("service", serviceValue, new String[] { "serviceClass", "serviceImpl", "no" });

        String paginateValue = this.element.getPaginate() ;
        if (paginateValue == null || "".equals(paginateValue)) {
            paginateValue = "no";
        }
        table.addProperty("paginate", paginateValue, new String[] { "pagination", "infinite-scroll", "pager", "no" });
        String searchValue = this.element.getSearch() ;
        if (searchValue == null || "".equals(searchValue)) {
            searchValue = "no";
        }
        table.addProperty("search", searchValue, new String[] { "elasticsearch", "no" });
        table.addProperty("microservice", this.element.getMicroservice() != null ? this.element.getMicroservice() : "");
        table.addProperty("angularSuffix", this.element.getAngularSuffix() != null ? this.element.getAngularSuffix() : "");
        table.addProperty("clientRootFolder", this.element.getClientRootFolder() != null ? this.element.getClientRootFolder() : "");
    }

    @Override
    public void changeProperty(int row, String value) {
        switch (row) {
        case 1:
            this.element.getElement().setName(value);
            break;
        case 2:
            this.element.setSkipClient(!this.element.isSkipClient());
            break;
        case 3:
            this.element.setSkipServer(!this.element.isSkipServer());
            break;
        case 4:
            this.element.setNoFluentMethod(!this.element.isNoFluentMethod());
            break;
        case 5:
            this.element.setFilter(!this.element.isFilter());
            if (value.equals("true")) {
                if (this.element.getService() == null || this.element.getService().equals("no")) {
                    this.element.setService("serviceClass");
                }
            } else if (this.element.getService().equals("serviceClass")) {
                this.element.setService("no");
            }
            break;
        case 6:
            this.element.setReadOnly(!this.element.isReadOnly());
            break;
        case 7:
            this.element.setDto(value);
            if (!value.equals("no")) {
                if (this.element.getService() == null || this.element.getService().equals("no")) {
                    this.element.setService("serviceClass");
                }
            } else if (this.element.getService().equals("serviceClass")) {
                this.element.setService("no");
            }
            break;
        case 8:
            this.element.setService(value);
            break;
        case 9:
            this.element.setPaginate(value);
            break;
        case 10:
            this.element.setSearch(value);
            break;
        case 11:
            this.element.setMicroservice(value);
            break;
        case 12:
            this.element.setAngularSuffix(value);
            break;
        case 13:
            this.element.setClientRootFolder(value);
            break;
        default:
            break;
        }
    }

    @Override
    public void setElement(Entity element) {
       this.element = element;
    }

}
