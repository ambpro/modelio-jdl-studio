/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: Modelio_JDL_Studio v1.0.00

 * This file was generated on 11/18/19 4:19 PM by Modelio Studio.
 */
package org.modelio.modelio_jdl_studio.api.jdl.standard.package_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.model.IModelingSession;
import org.modelio.api.modelio.model.PropertyConverter;
import org.modelio.api.module.context.IModuleContext;
import org.modelio.metamodel.mmextensions.infrastructure.ExtensionNotFoundException;
import org.modelio.metamodel.uml.infrastructure.Dependency;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.metamodel.uml.infrastructure.TagType;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.modelio_jdl_studio.api.Modelio_JDL_StudioProxyFactory;
import org.modelio.modelio_jdl_studio.impl.Modelio_JDL_StudioModule;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Proxy class to handle a {@link Package} with << JDLModel >> stereotype.
 * <p>Stereotype description:
 * <br/><i>null</i></p>
 */
@objid ("1c237dd4-751f-44e6-903a-ea9cc9e38311")
public class JDLModel {
    @objid ("8f785d51-3844-451b-a5ed-62135d4831ac")
    public static final String STEREOTYPE_NAME = "JDLModel";

    /**
     * The underlying {@link Package} represented by this proxy, never null.
     */
    @objid ("f59c183e-2cf4-451a-979b-5057a532aa70")
    protected final Package elt;

    /**
     * Tells whether a {@link JDLModel proxy} can be instantiated from a {@link MObject} checking it is a {@link Package} stereotyped << JDLModel >>. 
     * <p>
     * The method returns <i>false</i> if the instantiation cannot be carried out.
     * 
     * @param elt a model object
     * @return <i>true</i> if the instantiation can be carried out else <i>false</i>.
     */
    @objid ("288d3aef-6885-4488-b17b-f3a96999a41d")
    public static boolean canInstantiate(final MObject elt) {
        return ((elt instanceof Package) && ((Package) elt).isStereotyped(IModelio_JDL_StudioPeerModule.MODULE_NAME, JDLModel.STEREOTYPE_NAME));
    }

    /**
     * Create a new {@link Package} stereotyped << JDLModel >> then instantiate a {@link JDLModel} proxy.
     * 
     * @return a {@link JDLModel} proxy on the created {@link Package}.
     */
    @objid ("46f2e345-b5a2-4201-b8e5-505159d16ab6")
    public static JDLModel create() {
        ModelElement e = (ModelElement)Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createElement("Package");
        e.addStereotype(IModelio_JDL_StudioPeerModule.MODULE_NAME, JDLModel.STEREOTYPE_NAME);
        return JDLModel.instantiate((Package)e);
    }

    /**
     * Tries to instantiate a {@link JDLModel} proxy from a {@link Package} stereotyped << JDLModel >>checking its metaclass and its stereotype. 
     * <p>
     * The method returns <i>null</i> if the instantiation cannot be carried out.
     * @param obj a Package
     * @return a {@link JDLModel} proxy or <i>null</i>.
     */
    @objid ("4c3129e5-8472-43d0-a343-052a0b0d7881")
    public static JDLModel instantiate(final Package obj) {
        return JDLModel.canInstantiate(obj) ? new JDLModel(obj) : null;
    }

    /**
     * Tries to instantiate a {@link JDLModel} proxy from a {@link Package} stereotyped << JDLModel >> checking its metaclass and its stereotype. 
     * <p>
     * The method throws an {@link IllegalArgumentException} if the instantiation cannot be carried out.
     * @param obj a {@link Package}
     * @return a {@link JDLModel} proxy.
     * @throws IllegalArgumentException if the instantiation cannot be carried out.
     */
    @objid ("ee7a44cd-3ffe-48e9-bb52-d556defb8cac")
    public static JDLModel safeInstantiate(final Package obj) throws IllegalArgumentException {
        if (JDLModel.canInstantiate(obj))
        	return new JDLModel(obj);
        else
        	throw new IllegalArgumentException("JDLModel: Cannot instantiate "+obj+": wrong element type or stereotype");
    }

    @objid ("7219bd00-b1be-4cc0-a735-4511f9f564f5")
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
        JDLModel other = (JDLModel) obj;
        return java.util.Objects.equals(getElement(), other.getElement());
    }

    /**
     * Get the underlying {@link Package}. 
     * @return the Package represented by this proxy, never null.
     */
    @objid ("0a835500-2dc3-4041-b98e-a3c0a0c6a8f0")
    public Package getElement() {
        return this.elt;
    }

    @objid ("709c2545-0279-443a-843b-f5c45cee9c05")
    @Override
    public int hashCode() {
        return 23 + ((this.elt == null) ? 0 : this.elt.hashCode());
    }

    @objid ("109ae08a-0092-4314-a22f-469b0fa8ad0c")
    protected JDLModel(final Package elt) {
        this.elt = elt;
    }

    @objid ("2ff6bfe6-6c46-4351-9bf0-6f1bc450fff5")
    public static final class MdaTypes {
        @objid ("54b1049f-7c18-4046-8f6b-6c5d898246de")
        public static Stereotype STEREOTYPE_ELT;

        @objid ("8c2e42af-50f9-4beb-a59b-ce8bf5a6caa3")
        private static Stereotype MDAASSOCDEP;

        @objid ("4518c80e-b58a-4fc8-a67e-d15e370bb1a8")
        private static TagType MDAASSOCDEP_ROLE;

        @objid ("f67e6760-e393-4cb5-93b1-87c9fa1e0e45")
        public static void init(final IModuleContext ctx) {
            STEREOTYPE_ELT = ctx.getModelingSession().findElementById(Stereotype.class, "e276a6e5-720b-4e18-a360-b603a5176b7f");
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
