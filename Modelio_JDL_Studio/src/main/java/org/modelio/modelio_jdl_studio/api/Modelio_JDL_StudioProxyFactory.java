/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: Modelio_JDL_Studio v1.0.00

 * This file was generated on 11/18/19 4:19 PM by Modelio Studio.
 */
package org.modelio.modelio_jdl_studio.api;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.diagrams.ClassDiagram;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.metamodel.visitors.IDefaultModelVisitor;
import org.modelio.metamodel.visitors.IInfrastructureVisitor;

/**
 * Factory that instantiates the right proxy class for a model element stereotyped by a 'Modelio_JDL_Studio' module stereotype.
 * <h2>Module description:</h2>
 * <br/><i>Modelio JDL Studio is a Modelio module to generate a UML class diagram to a JDL file (JHipster Domain Language)</i></p>
 * <h2>Supported stereotypes:</h2>
 * <ul><li><< Entity >> on a {@link org.modelio.metamodel.uml.statik.Class}: instantiates a {@link Entity}
 * <li><< JDLModel >> on a {@link org.modelio.metamodel.uml.statik.Package}: instantiates a {@link JDLModel}
 * <li><< Field >> on a {@link org.modelio.metamodel.uml.statik.Attribute}: instantiates a {@link Field}
 * <li><< JDLEntityDiagram >> on a {@link org.modelio.metamodel.diagrams.ClassDiagram}: instantiates a {@link JDLEntityDiagram}
 * </ul>
 */
@objid ("fbaf77ef-585d-4f5b-9c6f-a4051505c093")
public class Modelio_JDL_StudioProxyFactory {
    @objid ("4a3d1a8e-5802-4ed0-ba23-2a1450a8c845")
    private static final InstantiateVisitor instantiateVisitor = new InstantiateVisitor();

    /**
     * Instantiates the right proxy class the given element.
     * <br/>The model element must be stereotyped by a 'Modelio_JDL_Studio' module stereotype.
     * <br/>In the other case the method will return <i>null</i>.
     * 
     * 
     * @param e A model element
     * @return the right proxy or <i>null</i>.
     */
    @objid ("863c98f0-007b-48fd-ba52-75f7c6e9ddb1")
    public static final Object instantiate(final ModelElement e) {
        for (Stereotype s : e.getExtension()) {
              if (s.getModule().getName().equals(IModelio_JDL_StudioPeerModule.MODULE_NAME)) {
                  return instantiate(e, s.getName());
              }
        }
        return null;
    }

    /**
     * Instantiates the right proxy class the given element with a stereotype name.
     * The stereotype must be one of the 'Modelio_JDL_Studio' module stereotypes.
     * In the other case the method will return <i>null</i>.
     * 
     * 
     * @param e A model element.
     * @param stName A stereotype name.
     * @return the right proxy or <i>null</i>.
     */
    @objid ("e6793f20-0733-4a8c-ab93-a3abe1b4bfa2")
    public static final Object instantiate(final Element e, final String stName) {
        instantiateVisitor.setStereotype(stName);
        return e.accept(instantiateVisitor);
    }

    @objid ("0dff33d2-ed06-4241-a835-67f915ec18e8")
    private static class InstantiateVisitor implements IDefaultModelVisitor {
        @objid ("b8c88ff2-03e1-4c97-b0b9-b0b5b7d85816")
        private String stName;

        @objid ("228c5630-a455-4abe-a280-acc49bf65d22")
        public final void setStereotype(final String stName) {
            this.stName = stName;
        }

        @objid ("543800c7-75b6-4082-a177-86e0c141c30c")
        @Override
        public final Object visitAttribute(Attribute obj) {
            switch (this.stName) {
            	case org.modelio.modelio_jdl_studio.api.jdl.standard.attribute.Field.STEREOTYPE_NAME: return org.modelio.modelio_jdl_studio.api.jdl.standard.attribute.Field.instantiate(obj);
            	default:
            		break;
            }
            
            return IDefaultModelVisitor.super.visitAttribute(obj);
        }

        @objid ("7224f828-9934-44fb-ae3e-5a9dd3f4840a")
        @Override
        public final Object visitClassDiagram(ClassDiagram obj) {
            switch (this.stName) {
            	case org.modelio.modelio_jdl_studio.api.jdl.standard.classdiagram.JDLEntityDiagram.STEREOTYPE_NAME: return org.modelio.modelio_jdl_studio.api.jdl.standard.classdiagram.JDLEntityDiagram.instantiate(obj);
            	default:
            		break;
            }
            
            return IDefaultModelVisitor.super.visitClassDiagram(obj);
        }

        @objid ("1737d846-05d5-43d1-a10d-7c37cb5d31d0")
        @Override
        public final Object visitPackage(Package obj) {
            switch (this.stName) {
            	case org.modelio.modelio_jdl_studio.api.jdl.standard.package_.JDLModel.STEREOTYPE_NAME: return org.modelio.modelio_jdl_studio.api.jdl.standard.package_.JDLModel.instantiate(obj);
            	default:
            		break;
            }
            
            return IDefaultModelVisitor.super.visitPackage(obj);
        }

        @objid ("f79b576c-333a-4e99-98dd-d0dd7848e308")
        @Override
        public final Object visitClass(Class obj) {
            switch (this.stName) {
            	case org.modelio.modelio_jdl_studio.api.jdl.standard.class_.Entity.STEREOTYPE_NAME: return org.modelio.modelio_jdl_studio.api.jdl.standard.class_.Entity.instantiate(obj);
            	default:
            		break;
            }
            
            return IDefaultModelVisitor.super.visitClass(obj);
        }

        /**
         * Get the visitor to delegate to when a {@link IInfrastructureVisitor} is needed.
         * <p>If null is returned the caller will return null.
         * @return the {@link IInfrastructureVisitor} visitor or <i>null</i>.
         */
        @objid ("9a3b81a0-f8c1-4ee1-b4ae-d297a46b4fcd")
        @Override
        public IInfrastructureVisitor getInfrastructureVisitor() {
            return null;
        }

    }

}
