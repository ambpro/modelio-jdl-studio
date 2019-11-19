package org.modelio.modelio_jdl_studio.handlers.commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.modelio.api.module.IModule;
import org.modelio.api.module.command.DefaultModuleCommandHandler;
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Enumeration;
import org.modelio.metamodel.uml.statik.EnumerationLiteral;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.modelio_jdl_studio.api.jdl.standard.attribute.Field;
import org.modelio.modelio_jdl_studio.api.jdl.standard.class_.Entity;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("75256268-9cc5-497f-9c84-b5044219f903")
public class JDLGenerator extends DefaultModuleCommandHandler {
    @objid ("bb09fb97-393c-44c0-a88b-6f04474eea7f")
    public static final String ONE_TO_ONE = "relationship OneToOne";

    @objid ("850e5691-e993-46b8-b31c-5a23cdd2acee")
    public static final String ONE_TO_MANY = "relationship OneToMany";

    @objid ("0778008b-d611-46c3-85d8-b3f74b99c191")
    public static final String MANY_TO_ONE = "relationship ManyToOne";

    @objid ("2fe62ae7-2e7a-4fdb-be61-6603f44bc820")
    public static final String MANY_TO_MANY = "relationship ManyToMany";

    @objid ("e766d5ac-c668-4cf6-9c42-26bec22211ca")
    @Override
    public void actionPerformed(final List<MObject> selectedElements, final IModule module) {
        // Module context is the link to many Modelio services
        // IModuleContext ctx = module.getModuleContext();
        
        // Initialize the dialog.
        DirectoryDialog dialog = new DirectoryDialog(Display.getDefault().getActiveShell());
        String selection = dialog.open();
        if (!selection.equals("")) {
            File jdlFile = new File(selection + "/jhipster-jdl.jh");
        
            // Generate JDL file
            try (FileWriter jdlWriter = new FileWriter(jdlFile); PrintWriter printWriter = new PrintWriter(jdlWriter);) {
                if (!jdlFile.exists()) {
                    jdlFile.createNewFile();
                }
                Package jdlModel = (Package) selectedElements.get(0);
        
                // generate entity
                generateEntity(jdlModel, printWriter);
        
                // generate enumeration
                generateEnum(jdlModel, printWriter);
        
                // generate relationships
                generateRelationship(jdlModel, printWriter);
        
                // generate options
                generateOptions(jdlModel, printWriter);
        
                printWriter.close();
        
            } catch (IOException e) {
                e.printStackTrace();
            }
            // TODO replace the following dumb code by the real implementation of the command
            MessageDialog.openInformation(Display.getDefault().getActiveShell(), "JDL Generator", "The JDL file has been generated!");
        }
    }

    @objid ("fb458da1-02cd-4edf-a3f0-1c03a9b92e1e")
    @Override
    public boolean accept(final List<MObject> selectedElements, final IModule module) {
        // Generated call to the super method will check the scope conditions defined in Studio.
        // DO NOT REMOVE this call unless you need to take full control on the checks to be carried out.
        // However you can safely extends the checked conditions by adding custom code.
        if (super.accept(selectedElements, module) == false) {
            return false;
        }
        return true;
    }

    @objid ("faa59d2a-b3a3-495e-be7d-c490ee622000")
    private void generateEntity(Package jdlModel, PrintWriter printWriter) {
        jdlModel.getOwnedElement(Class.class).stream().forEach(classEntity -> {
            classEntity.getDescriptor().forEach(desc -> {
                if (desc.getModel().getName().equals("JavaDoc")) {
                    printWriter.println("/** " + desc.getContent() + " */");
                } else {
                    printWriter.println("// " + desc.getContent());
                }
            });
        
            printWriter.println("entity " + classEntity.getName() + " {");
            IntStream.range(0, classEntity.getOwnedAttribute().size()).forEach((attrIndex) -> {
                // generate attribute
                Attribute attr = classEntity.getOwnedAttribute().get(attrIndex);
                printWriter.print("\t" + attr.getName() + " " + attr.getType().getName());
                if (attr.isStereotyped(IModelio_JDL_StudioPeerModule.MODULE_NAME, Field.STEREOTYPE_NAME)) {
                    Field field = Field.safeInstantiate(attr);
                    if (field.isRequired()) {
                        printWriter.print(" " + Field.REQUIRED_TAGTYPE);
                    }
                    if (field.isUnique()) {
                        printWriter.print(" " + Field.UNIQUE_TAGTYPE);
                    }
                    switch (attr.getType().getName()) {
                    case "String": {
                        if (field.getMinlength() != null) {
                            printWriter.print(" " + Field.MINLENGTH_TAGTYPE + "(" + field.getMinlength() + ")");
                        }
                        if (field.getMaxlength() != null) {
                            printWriter.print(" " + Field.MAXLENGTH_TAGTYPE + "(" + field.getMaxlength() + ")");
                        }
                        if (field.getPattern() != null) {
                            if (!field.getPattern().startsWith("/") && !field.getPattern().endsWith("/"))
                                printWriter.print(" " + Field.PATTERN_TAGTYPE + "(/" + field.getPattern() + "/)");
                            else
                                printWriter.print(" " + Field.PATTERN_TAGTYPE + "(" + field.getPattern() + ")");
                        }
                        break;
                    }
                    case "Integer":
                    case "Long":
                    case "BigDecimal":
                    case "Float":
                    case "Double": {
                        if (field.getMin() != null) {
                            printWriter.print(" " + Field.MIN_TAGTYPE + "(" + field.getMin() + ")");
                        }
                        if (field.getMax() != null) {
                            printWriter.print(" " + Field.MAX_TAGTYPE + "(" + field.getMax() + ")");
                        }
                        break;
                    }
                    case "Blob":
                    case "AnyBlob":
                    case "ImageBlob": {
                        if (field.getMinbytes() != null) {
                            printWriter.print(" " + Field.MINBYTES_TAGTYPE + "(" + field.getMinbytes() + ")");
                        }
                        if (field.getMaxbytes() != null) {
                            printWriter.print(" " + Field.MAXBYTES_TAGTYPE + "(" + field.getMaxbytes() + ")");
                        }
                        break;
                    }
                    default:
                        break;
                    }
                    attr.getDescriptor().forEach(desc -> {
                        if (desc.getModel().getName().equals("JavaDoc")) {
                            printWriter.print(" /** " + desc.getContent() + " */");
                        } else {
                            printWriter.print(" // " + desc.getContent());
                        }
                    });
                    printWriter.print("\n");
                }
        
            });
            printWriter.println("}\n");
        });
    }

    @objid ("4cd2c881-c7a0-41c7-a88c-feba57667bad")
    private void generateEnum(Package jdlModel, PrintWriter printWriter) {
        jdlModel.getOwnedElement(Enumeration.class).stream().forEach(enumeration -> {
            enumeration.getDescriptor().forEach(desc -> {
                if (desc.getModel().getName().equals("JavaDoc")) {
                    printWriter.println("/** " + desc.getContent() + " */");
                } else {
                    printWriter.println("// " + desc.getContent());
                }
            });
        
            printWriter.println("enum " + enumeration.getName() + " {");
            IntStream.range(0, enumeration.getValue().size()).forEach((attrIndex) -> {
                // generate enumeration-literals
                EnumerationLiteral literal = enumeration.getValue().get(attrIndex);
                literal.getDescriptor().forEach(desc -> {
                    if (desc.getModel().getName().equals("JavaDoc")) {
                        printWriter.println("\t" + "/** " + desc.getContent() + " */");
                    } else {
                        printWriter.println("\t" + "// " + desc.getContent());
                    }
                });
                if (enumeration.getValue().indexOf(literal) != (enumeration.getValue().size() - 1)) {
                    printWriter.println("\t" + literal.getName().toUpperCase() + ",");
                } else {
                    printWriter.println("\t" + literal.getName().toUpperCase());
                }
            });
            printWriter.println("}\n");
        });
    }

    @objid ("381abfeb-08b8-4036-90a1-635a44cfe79b")
    private void generateRelationship(Package jdlModel, PrintWriter printWriter) {
        Set<Association> genetatedAssoc = new HashSet<Association>();
        for (Class classEntity : jdlModel.getOwnedElement(Class.class)) {
            for (AssociationEnd sourceEnd : classEntity.getOwnedEnd()) {
                if (!genetatedAssoc.contains(sourceEnd.getAssociation())) {
                    if (!sourceEnd.isTagged(IModelio_JDL_StudioPeerModule.MODULE_NAME, AssociationEnd.class.getName(), "isSource")) {
                        sourceEnd = sourceEnd.getOpposite();
                    }
                    String relationType = getRelationType(sourceEnd);
                    generateRelationshipContent(sourceEnd, relationType, printWriter);
                    genetatedAssoc.add(sourceEnd.getAssociation());
                }
            }
        }
    }

    @objid ("67705587-ff0e-44e4-8588-76f61247023d")
    private void generateRelationshipContent(AssociationEnd sourceEnd, String relationshipType, PrintWriter printWriter) {
        AssociationEnd targetEnd = sourceEnd.getOpposite();
        printWriter.println("relationship" + " " + relationshipType + " {");
        if (sourceEnd.isNavigable() && targetEnd.isNavigable()) {
            if (sourceEnd.getMultiplicityMin().equals("1")) {
                printWriter.println("\t" + sourceEnd.getOwner().getName() + "{" + sourceEnd.getName() + " " + Field.REQUIRED_TAGTYPE + "}" + " to " + targetEnd.getOwner().getName() + "{" + targetEnd.getName() + " " + Field.REQUIRED_TAGTYPE + "}");
            } else {
                printWriter.println("\t" + sourceEnd.getOwner().getName() + "{" + sourceEnd.getName() + "}" + " to " + targetEnd.getOwner().getName() + "{" + targetEnd.getName() + "}");
            }
        } else if (sourceEnd.isNavigable() && !targetEnd.isNavigable()) {
            if (sourceEnd.getMultiplicityMin().equals("1")) {
                printWriter.println("\t" + sourceEnd.getOwner().getName() + "{" + sourceEnd.getName() + " " + Field.REQUIRED_TAGTYPE + "}" + " to " + targetEnd.getOwner().getName());
            } else {
                printWriter.println("\t" + sourceEnd.getOwner().getName() + "{" + sourceEnd.getName() + "}" + " to " + targetEnd.getOwner().getName());
            }
        } else if (!sourceEnd.isNavigable() && targetEnd.isNavigable()) {
            if (targetEnd.getMultiplicityMin().equals("1")) {
                printWriter.println("\t" + sourceEnd.getOwner().getName() + " to " + sourceEnd.getOwner().getName() + "{" + targetEnd.getName() + " " + Field.REQUIRED_TAGTYPE + "}");
            } else {
                printWriter.println("\t" + sourceEnd.getOwner().getName() + " to " + sourceEnd.getOwner().getName() + "{" + targetEnd.getName() + "}");
            }
        } else {
            printWriter.println("\t" + sourceEnd.getOwner().getName() + " to " + targetEnd.getOwner().getName());
        }
        printWriter.println("}\n");
    }

    @objid ("aedcbccf-ca56-4b0d-8af8-e114b41862b3")
    private void generateOptions(Package jdlModel, PrintWriter printWriter) {
        jdlModel.getOwnedElement(Class.class).stream().forEach(classEntity -> {
            Entity entity = Entity.safeInstantiate(classEntity);
            if (entity.isSkipClient()) {
                printWriter.print("skipClient " + classEntity.getName() + "\n");
            }
            if (entity.isSkipServer()) {
                printWriter.print("skipServer " + classEntity.getName() + "\n");
            }
            if (entity.isNoFluentMethod()) {
                printWriter.print("noFluentMethod " + classEntity.getName() + "\n");
            }
            if (entity.isFilter()) {
                printWriter.print("filter " + classEntity.getName() + "\n");
            }
            if (entity.isReadOnly()) {
                printWriter.print("readOnly " + classEntity.getName() + "\n");
            }
            if (entity.getDto() != null && !entity.getDto().equals("no")) {
                printWriter.print("dto " + classEntity.getName() + " with " + entity.getDto() + "\n");
            }
            if (entity.getService() != null && !entity.getService().equals("no")) {
                printWriter.print("service " + classEntity.getName() + " with " + entity.getService() + "\n");
            }
            if (entity.getPaginate() != null && !entity.getPaginate().equals("no")) {
                printWriter.print("paginate " + classEntity.getName() + " with " + entity.getPaginate() + "\n");
            }
            if (entity.getSearch() != null && !entity.getSearch().equals("no")) {
                printWriter.print("search " + classEntity.getName() + " with " + entity.getSearch() + "\n");
            }
            if (entity.getMicroservice() != null && !entity.getMicroservice().equals("")) {
                printWriter.print("microservice " + classEntity.getName() + " with " + entity.getMicroservice() + "\n");
            }
            if (entity.getAngularSuffix() != null && !entity.getAngularSuffix().equals("")) {
                printWriter.print("angularSuffix " + classEntity.getName() + " with " + entity.getAngularSuffix() + "\n");
            }
            if (entity.getClientRootFolder() != null && !entity.getClientRootFolder().equals("")) {
                printWriter.print("clientRootFolder " + classEntity.getName() + " with " + entity.getClientRootFolder() + "\n");
            }
        });
    }

    @objid ("6e2cec42-744d-4cf1-8c90-943b05293ae2")
    private String getRelationType(AssociationEnd sourceEnd) {
        AssociationEnd targetEnd = sourceEnd.getOpposite();
        if (sourceEnd.getMultiplicityMax().equals("1") && targetEnd.getMultiplicityMax().equals("1")) {
            return "OneToOne";
        }
        if (sourceEnd.getMultiplicityMax().equals("*") && targetEnd.getMultiplicityMax().equals("1")) {
            return "OneToMany";
        }
        if (sourceEnd.getMultiplicityMax().equals("1") && targetEnd.getMultiplicityMax().equals("*")) {
            return "ManyToOne";
        }
        if (sourceEnd.getMultiplicityMax().equals("*") && targetEnd.getMultiplicityMax().equals("*")) {
            return "ManyToMany";
        }
        return null;
    }

}
