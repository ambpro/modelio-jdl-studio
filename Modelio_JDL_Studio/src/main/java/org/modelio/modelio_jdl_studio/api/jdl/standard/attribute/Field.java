/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: Modelio_JDL_Studio v1.0.00

 * This file was generated on 11/18/19 4:19 PM by Modelio Studio.
 */
package org.modelio.modelio_jdl_studio.api.jdl.standard.attribute;

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
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.modelio_jdl_studio.api.Modelio_JDL_StudioProxyFactory;
import org.modelio.modelio_jdl_studio.impl.Modelio_JDL_StudioModule;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Proxy class to handle a {@link Attribute} with << Field >> stereotype.
 * <p>Stereotype description:
 * <br/><i>null</i></p>
 */
@objid ("1ef119e0-888d-4129-9540-b241cbd6645b")
public class Field {
    @objid ("9c92c4a9-a4c5-4eb5-9885-3ac9eca7ce69")
    public static final String STEREOTYPE_NAME = "Field";

    @objid ("6db52ed2-aa77-4117-bce8-8023e5481d7d")
    public static final String MAX_TAGTYPE = "max";

    @objid ("3b42d3bc-2c53-49d8-9183-740bc55d0238")
    public static final String MAXBYTES_TAGTYPE = "maxbytes";

    @objid ("ea94930b-10ed-42dc-a908-6eebc1f59351")
    public static final String MAXLENGTH_TAGTYPE = "maxlength";

    @objid ("8e432566-b3b3-421c-b318-8b23fff2d1a5")
    public static final String MIN_TAGTYPE = "min";

    @objid ("151adbc9-bc3e-423b-95a1-948506c79e3d")
    public static final String MINBYTES_TAGTYPE = "minbytes";

    @objid ("32176776-9064-4bc7-a606-de23e0aa1c27")
    public static final String MINLENGTH_TAGTYPE = "minlength";

    @objid ("e56e0cb1-fd9b-4040-b301-a2308312f294")
    public static final String PATTERN_TAGTYPE = "pattern";

    @objid ("3975cd2a-7f47-409c-bb49-0b3513005bf4")
    public static final String REQUIRED_TAGTYPE = "required";

    @objid ("8c356aa5-02c3-44fa-bab9-5d3fe02b829f")
    public static final String UNIQUE_TAGTYPE = "unique";

    /**
     * The underlying {@link Attribute} represented by this proxy, never null.
     */
    @objid ("5b771c88-d9bc-4066-accd-44af1e900aa9")
    protected final Attribute elt;

    /**
     * Tells whether a {@link Field proxy} can be instantiated from a {@link MObject} checking it is a {@link Attribute} stereotyped << Field >>. 
     * <p>
     * The method returns <i>false</i> if the instantiation cannot be carried out.
     * 
     * @param elt a model object
     * @return <i>true</i> if the instantiation can be carried out else <i>false</i>.
     */
    @objid ("fe965fb7-4017-492f-952d-f4615a3652ea")
    public static boolean canInstantiate(final MObject elt) {
        return ((elt instanceof Attribute) && ((Attribute) elt).isStereotyped(IModelio_JDL_StudioPeerModule.MODULE_NAME, Field.STEREOTYPE_NAME));
    }

    /**
     * Create a new {@link Attribute} stereotyped << Field >> then instantiate a {@link Field} proxy.
     * 
     * @return a {@link Field} proxy on the created {@link Attribute}.
     */
    @objid ("4671467b-077b-4404-9600-6994c8f5b71c")
    public static Field create() {
        ModelElement e = (ModelElement)Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createElement("Attribute");
        e.addStereotype(IModelio_JDL_StudioPeerModule.MODULE_NAME, Field.STEREOTYPE_NAME);
        return Field.instantiate((Attribute)e);
    }

    /**
     * Tries to instantiate a {@link Field} proxy from a {@link Attribute} stereotyped << Field >>checking its metaclass and its stereotype. 
     * <p>
     * The method returns <i>null</i> if the instantiation cannot be carried out.
     * @param obj a Attribute
     * @return a {@link Field} proxy or <i>null</i>.
     */
    @objid ("1485d62d-25b5-4b72-a089-011f406d45a0")
    public static Field instantiate(final Attribute obj) {
        return Field.canInstantiate(obj) ? new Field(obj) : null;
    }

    /**
     * Tries to instantiate a {@link Field} proxy from a {@link Attribute} stereotyped << Field >> checking its metaclass and its stereotype. 
     * <p>
     * The method throws an {@link IllegalArgumentException} if the instantiation cannot be carried out.
     * @param obj a {@link Attribute}
     * @return a {@link Field} proxy.
     * @throws IllegalArgumentException if the instantiation cannot be carried out.
     */
    @objid ("98c0dfb4-093f-4aa5-9fc2-9585ff84513e")
    public static Field safeInstantiate(final Attribute obj) throws IllegalArgumentException {
        if (Field.canInstantiate(obj))
        	return new Field(obj);
        else
        	throw new IllegalArgumentException("Field: Cannot instantiate "+obj+": wrong element type or stereotype");
    }

    @objid ("93a401c2-d0c5-4353-b64b-7ce86ecd58b9")
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
        Field other = (Field) obj;
        return java.util.Objects.equals(getElement(), other.getElement());
    }

    /**
     * Get the underlying {@link Attribute}. 
     * @return the Attribute represented by this proxy, never null.
     */
    @objid ("de763f75-5485-45e3-a0a9-505aa57e741d")
    public Attribute getElement() {
        return this.elt;
    }

    /**
     * Getter for string property 'max'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("6827dfb7-54d5-4d0f-8a60-f3ccc6b1c546")
    public String getMax() {
        return this.elt.getTagValue(Field.MdaTypes.MAX_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'maxbytes'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("05ab2f95-e5ff-4ba5-bf45-f25dd9a60bd2")
    public String getMaxbytes() {
        return this.elt.getTagValue(Field.MdaTypes.MAXBYTES_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'maxlength'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("887c0bbb-e034-42c3-86ad-69efef5340ba")
    public String getMaxlength() {
        return this.elt.getTagValue(Field.MdaTypes.MAXLENGTH_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'min'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("624b5d9b-f62e-4000-b28a-f4d07848fbf8")
    public String getMin() {
        return this.elt.getTagValue(Field.MdaTypes.MIN_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'minbytes'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("e074ce52-355d-41b0-bc56-8e19f91e8ae0")
    public String getMinbytes() {
        return this.elt.getTagValue(Field.MdaTypes.MINBYTES_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'minlength'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("55d9054b-bd43-4851-a36a-2a1676f0931d")
    public String getMinlength() {
        return this.elt.getTagValue(Field.MdaTypes.MINLENGTH_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'pattern'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("5bc79e4d-6f4a-4b4f-bf7f-638c82591c97")
    public String getPattern() {
        return this.elt.getTagValue(Field.MdaTypes.PATTERN_TAGTYPE_ELT);
    }

    @objid ("7f3d5864-9c34-4c9f-9280-a7fab1893cde")
    @Override
    public int hashCode() {
        return 23 + ((this.elt == null) ? 0 : this.elt.hashCode());
    }

    /**
     * Getter for boolean property 'required'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("d2dcb25b-ec1f-4fbd-9662-4347b632c76d")
    public boolean isRequired() {
        return this.elt.isTagged(Field.MdaTypes.REQUIRED_TAGTYPE_ELT);
    }

    /**
     * Getter for boolean property 'unique'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("a798d356-d943-4896-8e26-26414af20027")
    public boolean isUnique() {
        return this.elt.isTagged(Field.MdaTypes.UNIQUE_TAGTYPE_ELT);
    }

    /**
     * Setter for string property 'max'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("171b47ab-0750-4b25-89c3-d20e35d96420")
    public void setMax(final String value) {
        this.elt.putTagValue(Field.MdaTypes.MAX_TAGTYPE_ELT, value);
    }

    /**
     * Setter for string property 'maxbytes'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("f45aebd9-cf61-4ca9-b664-58bb9f4fae9e")
    public void setMaxbytes(final String value) {
        this.elt.putTagValue(Field.MdaTypes.MAXBYTES_TAGTYPE_ELT, value);
    }

    /**
     * Setter for string property 'maxlength'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("bd7983ac-9d33-412d-8222-f74e0a87523a")
    public void setMaxlength(final String value) {
        this.elt.putTagValue(Field.MdaTypes.MAXLENGTH_TAGTYPE_ELT, value);
    }

    /**
     * Setter for string property 'min'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("adb89795-6c40-4bf8-a8e2-109395702209")
    public void setMin(final String value) {
        this.elt.putTagValue(Field.MdaTypes.MIN_TAGTYPE_ELT, value);
    }

    /**
     * Setter for string property 'minbytes'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("a440dfff-1681-4c6a-a8f3-acfdd6c4aa97")
    public void setMinbytes(final String value) {
        this.elt.putTagValue(Field.MdaTypes.MINBYTES_TAGTYPE_ELT, value);
    }

    /**
     * Setter for string property 'minlength'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("02d7b71d-85a9-4a75-b660-2345f38596d8")
    public void setMinlength(final String value) {
        this.elt.putTagValue(Field.MdaTypes.MINLENGTH_TAGTYPE_ELT, value);
    }

    /**
     * Setter for string property 'pattern'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("a7d3d943-e6df-445c-af21-a96e82a6e581")
    public void setPattern(final String value) {
        this.elt.putTagValue(Field.MdaTypes.PATTERN_TAGTYPE_ELT, value);
    }

    /**
     * Setter for boolean property 'required'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("e444725a-69b9-4a8f-9a7d-36e774ace105")
    public void setRequired(final boolean value) {
        if (value)
          Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createTaggedValue(Field.MdaTypes.REQUIRED_TAGTYPE_ELT, this.elt);
        else
          this.elt.removeTags(Field.MdaTypes.REQUIRED_TAGTYPE_ELT);
    }

    /**
     * Setter for boolean property 'unique'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("65768e06-97b8-4063-a052-35ce6b636db7")
    public void setUnique(final boolean value) {
        if (value)
          Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createTaggedValue(Field.MdaTypes.UNIQUE_TAGTYPE_ELT, this.elt);
        else
          this.elt.removeTags(Field.MdaTypes.UNIQUE_TAGTYPE_ELT);
    }

    @objid ("21525502-6664-4002-951b-d9f91ed466e7")
    protected Field(final Attribute elt) {
        this.elt = elt;
    }

    @objid ("ee3c9b9b-c5a8-4708-9f7b-22ab0684fb5f")
    public static final class MdaTypes {
        @objid ("72abbebd-fdd8-4a18-8e50-6431cdc97c20")
        public static Stereotype STEREOTYPE_ELT;

        @objid ("bcd5361e-0e21-4e02-8885-d6be910b88c3")
        public static TagType REQUIRED_TAGTYPE_ELT;

        @objid ("82d73080-dde2-464e-9de2-8a44fc306802")
        public static TagType MINLENGTH_TAGTYPE_ELT;

        @objid ("cf0102dc-45d7-450b-850d-c1a8dd34ca36")
        public static TagType MAXLENGTH_TAGTYPE_ELT;

        @objid ("1e43da8f-c0a9-4139-ba92-0348b2f2401a")
        public static TagType UNIQUE_TAGTYPE_ELT;

        @objid ("8a3850a9-a030-4eb0-9d7c-6529f5a92c0b")
        public static TagType PATTERN_TAGTYPE_ELT;

        @objid ("ee863361-6864-406c-b13a-be631691555c")
        public static TagType MIN_TAGTYPE_ELT;

        @objid ("a17f7399-5aea-46b3-88b9-5c88507e24b3")
        public static TagType MAX_TAGTYPE_ELT;

        @objid ("b359a62c-0a08-4b4a-8f25-36d6356413bb")
        public static TagType MINBYTES_TAGTYPE_ELT;

        @objid ("0599146d-b703-4700-b6ee-ce3b5db03107")
        public static TagType MAXBYTES_TAGTYPE_ELT;

        @objid ("3ab2f71f-785f-409f-8328-f0c62bf0bebe")
        private static Stereotype MDAASSOCDEP;

        @objid ("e045566d-501e-42ed-a8ed-3e8c4ee0e5f3")
        private static TagType MDAASSOCDEP_ROLE;

        @objid ("baa779da-282e-43a0-a55f-eefa454b458d")
        public static void init(final IModuleContext ctx) {
            STEREOTYPE_ELT = ctx.getModelingSession().findElementById(Stereotype.class, "31faedec-f3cd-4cf2-b8b4-3413e0dde642");
            REQUIRED_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "7569340b-8779-4d59-a716-4a38bdcb8049");
            MINLENGTH_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "ff72f937-430e-4f86-964b-2c2289fa91b1");
            MAXLENGTH_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "66ba2181-8c6b-4fb1-a2a3-89328b674bc9");
            UNIQUE_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "1ba446e2-ff49-4250-973c-db24d5e68318");
            PATTERN_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "db7209e3-5e28-4bf7-b573-e9aed67a2c72");
            MIN_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "2e9824c0-ee59-4899-b6a3-7e8f16d5ba4c");
            MAX_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "dc72690e-1309-41bb-bed5-8be9ced70cbc");
            MINBYTES_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "932d22e6-1b3a-43b3-ba53-1497800bcc13");
            MAXBYTES_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "c18641f4-eb11-49a3-9b4d-8e1cdbcd68af");
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
