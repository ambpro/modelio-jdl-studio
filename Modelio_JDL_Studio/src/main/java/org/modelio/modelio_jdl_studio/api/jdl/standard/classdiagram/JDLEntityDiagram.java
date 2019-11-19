/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: Modelio_JDL_Studio v1.0.00

 * This file was generated on 11/18/19 4:19 PM by Modelio Studio.
 */
package org.modelio.modelio_jdl_studio.api.jdl.standard.classdiagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.model.IModelingSession;
import org.modelio.api.modelio.model.PropertyConverter;
import org.modelio.api.module.context.IModuleContext;
import org.modelio.metamodel.diagrams.ClassDiagram;
import org.modelio.metamodel.mmextensions.infrastructure.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.metamodel.uml.infrastructure.TagType;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.modelio_jdl_studio.api.Modelio_JDL_StudioProxyFactory;
import org.modelio.modelio_jdl_studio.impl.Modelio_JDL_StudioModule;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Proxy class to handle a {@link ClassDiagram} with << JDLEntityDiagram >> stereotype.
 * <p>Stereotype description:
 * <br/><i>null</i></p>
 */
@objid ("102179dc-797d-4c6e-940e-c45ebb45069e")
public class JDLEntityDiagram {
    @objid ("5b21a733-975f-4b2f-9058-6e2f63993d23")
    public static final String STEREOTYPE_NAME = "JDLEntityDiagram";

    /**
     * The underlying {@link ClassDiagram} represented by this proxy, never null.
     */
    @objid ("2b54854b-6d51-45ed-ab95-801fd4d88f12")
    protected final ClassDiagram elt;

    /**
     * Tells whether a {@link JDLEntityDiagram proxy} can be instantiated from a {@link MObject} checking it is a {@link ClassDiagram} stereotyped << JDLEntityDiagram >>. 
     * <p>
     * The method returns <i>false</i> if the instantiation cannot be carried out.
     * 
     * @param elt a model object
     * @return <i>true</i> if the instantiation can be carried out else <i>false</i>.
     */
    @objid ("36fe6ca0-4629-479a-88f5-7896fafd9dae")
    public static boolean canInstantiate(final MObject elt) {
        return ((elt instanceof ClassDiagram) && ((ClassDiagram) elt).isStereotyped(IModelio_JDL_StudioPeerModule.MODULE_NAME, JDLEntityDiagram.STEREOTYPE_NAME));
    }

    /**
     * Create a new {@link ClassDiagram} stereotyped << JDLEntityDiagram >> then instantiate a {@link JDLEntityDiagram} proxy.
     * 
     * @return a {@link JDLEntityDiagram} proxy on the created {@link ClassDiagram}.
     */
    @objid ("406f7cce-7570-4d9e-84b8-4f45533acd5f")
    public static JDLEntityDiagram create() {
        ModelElement e = (ModelElement)Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createElement("ClassDiagram");
        e.addStereotype(IModelio_JDL_StudioPeerModule.MODULE_NAME, JDLEntityDiagram.STEREOTYPE_NAME);
        return JDLEntityDiagram.instantiate((ClassDiagram)e);
    }

    /**
     * Tries to instantiate a {@link JDLEntityDiagram} proxy from a {@link ClassDiagram} stereotyped << JDLEntityDiagram >>checking its metaclass and its stereotype. 
     * <p>
     * The method returns <i>null</i> if the instantiation cannot be carried out.
     * @param obj a ClassDiagram
     * @return a {@link JDLEntityDiagram} proxy or <i>null</i>.
     */
    @objid ("6b6b8845-27fd-4e6a-a172-d5452d168a64")
    public static JDLEntityDiagram instantiate(final ClassDiagram obj) {
        return JDLEntityDiagram.canInstantiate(obj) ? new JDLEntityDiagram(obj) : null;
    }

    /**
     * Tries to instantiate a {@link JDLEntityDiagram} proxy from a {@link ClassDiagram} stereotyped << JDLEntityDiagram >> checking its metaclass and its stereotype. 
     * <p>
     * The method throws an {@link IllegalArgumentException} if the instantiation cannot be carried out.
     * @param obj a {@link ClassDiagram}
     * @return a {@link JDLEntityDiagram} proxy.
     * @throws IllegalArgumentException if the instantiation cannot be carried out.
     */
    @objid ("e421c52e-428d-4bbf-9862-01a0b1172ea5")
    public static JDLEntityDiagram safeInstantiate(final ClassDiagram obj) throws IllegalArgumentException {
        if (JDLEntityDiagram.canInstantiate(obj))
        	return new JDLEntityDiagram(obj);
        else
        	throw new IllegalArgumentException("JDLEntityDiagram: Cannot instantiate "+obj+": wrong element type or stereotype");
    }

    @objid ("da5de25e-bd46-459c-bb4a-5ef38c84c1e0")
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        JDLEntityDiagram other = (JDLEntityDiagram) obj;
        return java.util.Objects.equals(getElement(), other.getElement());
    }

    /**
     * Get the underlying {@link ClassDiagram}. 
     * @return the ClassDiagram represented by this proxy, never null.
     */
    @objid ("756076d0-5052-42ac-8c45-ff5a4ea512f0")
    public ClassDiagram getElement() {
        return this.elt;
    }

    @objid ("7e526ff7-7991-490a-962c-82c35ecb28a1")
    @Override
    public int hashCode() {
        return 23 + ((this.elt == null) ? 0 : this.elt.hashCode());
    }

    @objid ("b6445b79-3048-4839-8bb5-60553fda27c0")
    protected JDLEntityDiagram(final ClassDiagram elt) {
        this.elt = elt;
    }

    @objid ("4e95436e-90cd-43f4-81c6-130926b550de")
    public static final class MdaTypes {
        @objid ("efe92811-8629-437f-a70f-5ea7f9a98011")
        public static Stereotype STEREOTYPE_ELT;

        @objid ("f2ffd6f9-b660-419d-8789-ff9b52d6dfc6")
        private static Stereotype MDAASSOCDEP;

        @objid ("e633b01c-2cee-4f49-9da2-73bd3def19b6")
        private static TagType MDAASSOCDEP_ROLE;

        @objid ("092ce3af-9717-4421-9c70-8b8f4a044288")
        public static void init(final IModuleContext ctx) {
            STEREOTYPE_ELT = ctx.getModelingSession().findElementById(Stereotype.class, "a9451289-57ab-4996-94fd-b3dfd7a68a75");
            MDAASSOCDEP = ctx.getModelingSession().findElementById(Stereotype.class, "94b7efa5-f94c-4d1d-896f-f103e56a8e2e");
            MDAASSOCDEP_ROLE = ctx.getModelingSession().findElementById(TagType.class, "7637f2fd-b750-43c1-a15c-5d0b084ca1cd");
        }


	static {
		if(Modelio_JDL_StudioModule.getInstance() != null) {
			init(Modelio_JDL_StudioModule.getInstance().getModuleContext());
		}
	}
    }

}
