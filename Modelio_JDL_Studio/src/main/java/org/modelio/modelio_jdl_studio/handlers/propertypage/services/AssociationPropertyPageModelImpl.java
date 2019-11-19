package org.modelio.modelio_jdl_studio.handlers.propertypage.services;

import org.modelio.api.module.propertiesPage.IModulePropertyTable;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;

public class AssociationPropertyPageModelImpl implements IPropertyPageModel<AssociationEnd> {

    private AssociationEnd element;

    @Override
    public void update(IModulePropertyTable table) {

        String sourceNode = this.element.getOwner().getName();
        String targetNode = this.element.getOppositeOwner().getOwner().getName();
        table.addProperty("Orientation", sourceNode + " -> " + targetNode, new String[] { sourceNode + " -> " + targetNode, targetNode + " -> " + sourceNode });

        String relationshipType = "OneToMany";
        if (this.element.getMultiplicityMax().equals("1") && this.element.getOppositeOwner().getMultiplicityMax().equals("1")) {
            relationshipType = "OneToOne";
        }
        if (this.element.getMultiplicityMax().equals("*") && this.element.getOppositeOwner().getMultiplicityMax().equals("1")) {
            relationshipType = "OneToMany";
        }
        if (this.element.getMultiplicityMax().equals("1") && this.element.getOppositeOwner().getMultiplicityMax().equals("*")) {
            relationshipType = "ManyToOne";
        }
        if (this.element.getMultiplicityMax().equals("*") && this.element.getOppositeOwner().getMultiplicityMax().equals("*")) {
            relationshipType = "ManyToMany";
        }
        table.addProperty("Relationship", relationshipType, new String[] { "OneToOne", "OneToMany", "ManyToOne", "ManyToMany" });
        boolean isBidirectional = this.element.isNavigable() && this.element.getOppositeOwner().isNavigable();
        table.addProperty("Is Bidirectional", isBidirectional);
        if (isBidirectional) {
            table.addProperty("Target Role", this.element.getName());
            table.addProperty("Source Role", this.element.getOppositeOwner().getName());
        } else {
            table.addProperty("Role", this.element.getName());
        }
        if (isBidirectional) {
            table.addProperty("Is Target Required", this.element.getMultiplicityMin().equals("1"));
            table.addProperty("Is Source Required", this.element.getOppositeOwner().getMultiplicityMin().equals("1"));
        }else {
            table.addProperty("Is Required", this.element.getMultiplicityMin().equals("1"));
        }
    }

    @Override
    public void changeProperty(int row, String value) {
        switch (row) {
        case 1:
            String sourceNode = this.element.getOwner().getName();
            String targetNode = this.element.getOppositeOwner().getOwner().getName();
            if (!value.equals(sourceNode + " -> " + targetNode)) {
                this.element.getOppositeOwner().putTagValue(IModelio_JDL_StudioPeerModule.MODULE_NAME, "isSource", "true");
                this.element.removeTags(IModelio_JDL_StudioPeerModule.MODULE_NAME, "isSource");

                if(this.element.getOppositeOwner().getName().equals("")) {
                    this.element.getOppositeOwner().setName(this.element.getOwner().getName().toLowerCase());
                }
                if(!this.element.getOppositeOwner().isNavigable()) {
                    this.element.getOppositeOwner().setNavigable(true);
                    this.element.setNavigable(false);
                }
            }
            break;
        case 2:
            switch (value) {
            case "OneToOne":
                this.element.setMultiplicityMax("1");
                this.element.getOppositeOwner().setMultiplicityMax("1");
                break;
            case "OneToMany":
                this.element.setMultiplicityMax("*");
                this.element.getOppositeOwner().setMultiplicityMax("1");
                break;
            case "ManyToOne":
                this.element.setMultiplicityMax("1");
                this.element.getOppositeOwner().setMultiplicityMax("*");
                break;
            case "ManyToMany":
                this.element.setMultiplicityMax("*");
                this.element.getOppositeOwner().setMultiplicityMax("*");
                break;
            default:
                break;
            }
            break;
        case 3:
            if (value.equals("true")) {
                this.element.getOppositeOwner().setNavigable(true);
                if(this.element.getOppositeOwner().getName().equals("")) {
                    this.element.getOppositeOwner().setName(this.element.getOwner().getName().toLowerCase());
                }
            } else {
                this.element.getOppositeOwner().setNavigable(false);
            }
            break;
        case 4:
            this.element.setName(value);
            break;
        case 5:
            if (this.element.isNavigable() && this.element.getOppositeOwner().isNavigable()) {
                this.element.getOppositeOwner().setName(value);
            } else {
                if (value.equals("true")) {
                    this.element.setMultiplicityMin("1");
                } else {
                    this.element.setMultiplicityMin("0");
                }
            }
            break;
        case 6:
            if (this.element.isNavigable() && this.element.getOppositeOwner().isNavigable()) {
                if (value.equals("true")) {
                    this.element.setMultiplicityMin("1");
                } else {
                    this.element.setMultiplicityMin("0");
                }
            }
            break;
        case 7:
            if (this.element.isNavigable() && this.element.getOppositeOwner().isNavigable()) {
                if (value.equals("true")) {
                    this.element.getOppositeOwner().setMultiplicityMin("1");
                } else {
                    this.element.getOppositeOwner().setMultiplicityMin("0");
                }
            } else {
                if (value.equals("true")) {
                    this.element.setMultiplicityMin("1");
                } else {
                    this.element.setMultiplicityMin("0");
                }
            }
            break;
        default:
            break;
        }
    }

    @Override
    public void setElement(AssociationEnd element) {
        this.element = element;
    }

}
