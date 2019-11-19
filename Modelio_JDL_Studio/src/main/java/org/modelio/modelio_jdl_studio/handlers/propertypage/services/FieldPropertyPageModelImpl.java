package org.modelio.modelio_jdl_studio.handlers.propertypage.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.modelio.api.module.propertiesPage.IModulePropertyTable;
import org.modelio.metamodel.uml.statik.Enumeration;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.modelio_jdl_studio.api.jdl.standard.attribute.Field;
import org.modelio.modelio_jdl_studio.impl.Modelio_JDL_StudioModule;

public class FieldPropertyPageModelImpl implements IPropertyPageModel<Field> {

    private Field element;

    @Override
    public void update(IModulePropertyTable table) {
        table.addProperty("Name", this.element.getElement().getName());
        Package defaultPackageTypes = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().findElementById(Package.class, "cef40ef3-60fd-4178-a24a-de603af6ed39");
        List<String> types = defaultPackageTypes.getOwnedElement(GeneralClass.class).stream().map(GeneralClass::getName).collect(Collectors.toCollection(ArrayList::new));
        for(Enumeration enums : this.element.getElement().getOwner().getOwner().getOwnedElement(Enumeration.class)) {
               types.add(enums.getName());
        }
        table.addProperty("Type", this.element.getElement().getType().getName(), types.toArray(new String[types.size()]));
        switch (this.element.getElement().getType().getName()) {
        case "String":
            table.addProperty("Is Required", this.element.isRequired());
            table.addProperty("Is Unique", this.element.isUnique());
            table.addProperty("Minlength", this.element.getMinlength() != null ? this.element.getMinlength() : "");
            table.addProperty("Maxlength", this.element.getMaxlength() != null ? this.element.getMaxlength() : "");
            table.addProperty("Pattern", this.element.getPattern() != null ? this.element.getPattern() : "");
            break;
        case "Integer":
        case "Long":
        case "BigDecimal":
        case "Float":
        case "Double":
            table.addProperty("Is Required", this.element.isRequired());
            table.addProperty("Is Unique", this.element.isUnique());
            table.addProperty("Min", this.element.getMin() != null ? this.element.getMin() : "");
            table.addProperty("Max", this.element.getMax() != null ? this.element.getMax() : "");
            break;
        case "Enum":
        case "Boolean":
        case "LocalDate":
        case "Date":
        case "ZonedDateTime":
        case "Duration":
        case "UUID":
        case "TextBlob":
        case "Instant":
            table.addProperty("Is Required", this.element.isRequired());
            table.addProperty("Is Unique", this.element.isUnique());
            break;
        case "Blob":
        case "AnyBlob":
        case "ImageBlob":
            table.addProperty("Is Required", this.element.isRequired());
            table.addProperty("Is Unique", this.element.isUnique());
            table.addProperty("Minbytes", this.element.getMinbytes() != null ? this.element.getMinbytes() : "");
            table.addProperty("Maxbytes", this.element.getMaxbytes() != null ? this.element.getMaxbytes() : "");
            break;
        default:
            break;
        }
    }

    @Override
    public void changeProperty(int row, String value) {
        List<String> numbersType = Arrays.asList("Integer", "Long", "BigDecimal", "Float", "Double");
        List<String> imagesType = Arrays.asList("Blob", "AnyBlob", "ImageBlob", "Float", "Double");
        switch (row) {
        case 1:
            this.element.getElement().setName(value);
            break;
        case 2:
            Package defaultPackageType = Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().findElementById(Package.class, "cef40ef3-60fd-4178-a24a-de603af6ed39");
            for (GeneralClass generalClass : defaultPackageType.getOwnedElement(GeneralClass.class)) {
                if (generalClass.getName().equals(value)) {
                    this.element.getElement().setType(generalClass);
                    break;
                }
            }
            for(Enumeration enumeration : this.element.getElement().getOwner().getOwner().getOwnedElement(Enumeration.class)) {
                if (enumeration.getName().equals(value)) {
                    this.element.getElement().setType(enumeration);
                    break;
                }
            }
            break;
        case 3:
            this.element.setRequired(value.equals("true"));
            break;
        case 4:
            this.element.setUnique(value.equals("true"));
            break;
        case 5:
            if (this.element.getElement().getType().getName().equals("String")) {
                this.element.setMinlength(value);
            } else if (numbersType.contains(this.element.getElement().getType().getName())) {
                this.element.setMin(value);
            } else if (imagesType.contains(this.element.getElement().getType().getName())) {
                this.element.setMinbytes(value);
            }
            break;
        case 6:
            if (this.element.getElement().getType().getName().equals("String")) {
                this.element.setMaxlength(value);
            } else if (numbersType.contains(this.element.getElement().getType().getName())) {
                this.element.setMax(value);
            } else if (imagesType.contains(this.element.getElement().getType().getName())) {
                this.element.setMaxbytes(value);
            }
            break;
        case 7:
            if (this.element.getElement().getType().getName().equals("String")) {
                this.element.setPattern(value);
            }
            break;
        default:
            break;
        }
    }

    @Override
    public void setElement(Field element) {
        this.element = element;
    }

}
