/*
 * WARNING: GENERATED FILE - DO NOT EDIT
 * Module: Modelio_JDL_Studio v1.0.00

 * This file was generated on 11/18/19 4:19 PM by Modelio Studio.
 */
package org.modelio.modelio_jdl_studio.api.jdl.standard.class_;

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
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.modelio_jdl_studio.api.Modelio_JDL_StudioProxyFactory;
import org.modelio.modelio_jdl_studio.impl.Modelio_JDL_StudioModule;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Proxy class to handle a {@link Class} with << Entity >> stereotype.
 * <p>Stereotype description:
 * <br/><i>null</i></p>
 */
@objid ("cd9997cb-4e47-4027-9079-c5489724706d")
public class Entity {
    @objid ("5744d0a0-55a4-4006-9a1a-e0bff10d7646")
    public static final String STEREOTYPE_NAME = "Entity";

    @objid ("4feb51d2-4008-4551-b145-571275885686")
    public static final String ANGULARSUFFIX_TAGTYPE = "angularSuffix";

    @objid ("701fc50c-c4ec-4951-aa21-22afa3c36e20")
    public static final String CLIENTROOTFOLDER_TAGTYPE = "clientRootFolder";

    @objid ("4f181191-4419-417a-9737-62db14a7a5d4")
    public static final String DTO_TAGTYPE = "dto";

    @objid ("74edf78c-8127-4657-a863-dda2216cc6ec")
    public static final String FILTER_TAGTYPE = "filter";

    @objid ("6bef83f5-4a15-4eee-a919-3ef0204d4d41")
    public static final String MICROSERVICE_TAGTYPE = "microservice";

    @objid ("f5d96918-7e24-4186-87f1-9fdf46f784c5")
    public static final String NOFLUENTMETHOD_TAGTYPE = "noFluentMethod";

    @objid ("ec67b66d-f395-4f38-83ea-bdea10e350da")
    public static final String PAGINATE_TAGTYPE = "paginate";

    @objid ("bbc519ec-c26c-467f-8413-218f4b4e63ed")
    public static final String READONLY_TAGTYPE = "readOnly";

    @objid ("53b3e67a-4f72-40c6-97d3-ffe5f7163818")
    public static final String SEARCH_TAGTYPE = "search";

    @objid ("987777bb-9c79-477e-b30d-b57414a0f95b")
    public static final String SERVICE_TAGTYPE = "service";

    @objid ("11c19653-f1c5-45d8-b3dd-49433dc9e12e")
    public static final String SKIPCLIENT_TAGTYPE = "skipClient";

    @objid ("c8367def-2f69-48cb-822b-270207203047")
    public static final String SKIPSERVER_TAGTYPE = "skipServer";

    /**
     * The underlying {@link Class} represented by this proxy, never null.
     */
    @objid ("fc696804-00a1-43c3-875a-132b0ab8ebce")
    protected final Class elt;

    /**
     * Tells whether a {@link Entity proxy} can be instantiated from a {@link MObject} checking it is a {@link Class} stereotyped << Entity >>. 
     * <p>
     * The method returns <i>false</i> if the instantiation cannot be carried out.
     * 
     * @param elt a model object
     * @return <i>true</i> if the instantiation can be carried out else <i>false</i>.
     */
    @objid ("c19667b2-cc36-4dab-8064-c7371bf4a350")
    public static boolean canInstantiate(final MObject elt) {
        return ((elt instanceof Class) && ((Class) elt).isStereotyped(IModelio_JDL_StudioPeerModule.MODULE_NAME, Entity.STEREOTYPE_NAME));
    }

    /**
     * Create a new {@link Class} stereotyped << Entity >> then instantiate a {@link Entity} proxy.
     * 
     * @return a {@link Entity} proxy on the created {@link Class}.
     */
    @objid ("1be0333a-8cd5-4a5d-929d-66bf9a965df7")
    public static Entity create() {
        ModelElement e = (ModelElement)Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createElement("Class");
        e.addStereotype(IModelio_JDL_StudioPeerModule.MODULE_NAME, Entity.STEREOTYPE_NAME);
        return Entity.instantiate((Class)e);
    }

    /**
     * Tries to instantiate a {@link Entity} proxy from a {@link Class} stereotyped << Entity >>checking its metaclass and its stereotype. 
     * <p>
     * The method returns <i>null</i> if the instantiation cannot be carried out.
     * @param obj a Class
     * @return a {@link Entity} proxy or <i>null</i>.
     */
    @objid ("393a93e9-62ac-4e76-a9b0-18108c1d5d79")
    public static Entity instantiate(final Class obj) {
        return Entity.canInstantiate(obj) ? new Entity(obj) : null;
    }

    /**
     * Tries to instantiate a {@link Entity} proxy from a {@link Class} stereotyped << Entity >> checking its metaclass and its stereotype. 
     * <p>
     * The method throws an {@link IllegalArgumentException} if the instantiation cannot be carried out.
     * @param obj a {@link Class}
     * @return a {@link Entity} proxy.
     * @throws IllegalArgumentException if the instantiation cannot be carried out.
     */
    @objid ("d247162f-3fe2-4579-8a1b-5efae3640d14")
    public static Entity safeInstantiate(final Class obj) throws IllegalArgumentException {
        if (Entity.canInstantiate(obj))
        	return new Entity(obj);
        else
        	throw new IllegalArgumentException("Entity: Cannot instantiate "+obj+": wrong element type or stereotype");
    }

    @objid ("a89f2712-dfb5-4b73-8caf-a34cb4a14d88")
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
        Entity other = (Entity) obj;
        return java.util.Objects.equals(getElement(), other.getElement());
    }

    /**
     * Getter for string property 'angularSuffix'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("047857e5-4a7e-4d41-b55f-b1886f015a61")
    public String getAngularSuffix() {
        return this.elt.getTagValue(Entity.MdaTypes.ANGULARSUFFIX_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'clientRootFolder'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("0b22c8d7-4d1e-40da-96fb-c223353164fa")
    public String getClientRootFolder() {
        return this.elt.getTagValue(Entity.MdaTypes.CLIENTROOTFOLDER_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'dto'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("6cd569b2-cebd-4bdd-9d51-e717699e719e")
    public String getDto() {
        return this.elt.getTagValue(Entity.MdaTypes.DTO_TAGTYPE_ELT);
    }

    /**
     * Get the underlying {@link Class}. 
     * @return the Class represented by this proxy, never null.
     */
    @objid ("8f241a3c-c3f9-44e4-b016-4fe2a2ddc43b")
    public Class getElement() {
        return this.elt;
    }

    /**
     * Getter for string property 'microservice'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("dfd78228-8497-48bf-8df8-ab4b659cf172")
    public String getMicroservice() {
        return this.elt.getTagValue(Entity.MdaTypes.MICROSERVICE_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'paginate'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("07c62511-73cc-4fe1-951a-3ee50ab8c105")
    public String getPaginate() {
        return this.elt.getTagValue(Entity.MdaTypes.PAGINATE_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'search'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("fc1c3322-3ce6-45cb-b9db-e827da400641")
    public String getSearch() {
        return this.elt.getTagValue(Entity.MdaTypes.SEARCH_TAGTYPE_ELT);
    }

    /**
     * Getter for string property 'service'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("b617995f-1aa6-4532-8f93-c2ae032faf6f")
    public String getService() {
        return this.elt.getTagValue(Entity.MdaTypes.SERVICE_TAGTYPE_ELT);
    }

    @objid ("8b6b88a1-b1a0-44c2-852e-aa0ac0e98a55")
    @Override
    public int hashCode() {
        return 23 + ((this.elt == null) ? 0 : this.elt.hashCode());
    }

    /**
     * Getter for boolean property 'filter'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("bf9ba181-9566-4885-911f-deeef9e970be")
    public boolean isFilter() {
        return this.elt.isTagged(Entity.MdaTypes.FILTER_TAGTYPE_ELT);
    }

    /**
     * Getter for boolean property 'noFluentMethod'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("5af1d645-6736-4b59-91c8-d1be35b185fc")
    public boolean isNoFluentMethod() {
        return this.elt.isTagged(Entity.MdaTypes.NOFLUENTMETHOD_TAGTYPE_ELT);
    }

    /**
     * Getter for boolean property 'readOnly'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("1412e6a8-297c-455f-b06f-da03015cb76f")
    public boolean isReadOnly() {
        return this.elt.isTagged(Entity.MdaTypes.READONLY_TAGTYPE_ELT);
    }

    /**
     * Getter for boolean property 'skipClient'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("6f89f6e5-810d-4da7-8a35-5d8478e9b2c6")
    public boolean isSkipClient() {
        return this.elt.isTagged(Entity.MdaTypes.SKIPCLIENT_TAGTYPE_ELT);
    }

    /**
     * Getter for boolean property 'skipServer'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("8e2ecfba-01e4-4423-ac9a-96277a1a0f01")
    public boolean isSkipServer() {
        return this.elt.isTagged(Entity.MdaTypes.SKIPSERVER_TAGTYPE_ELT);
    }

    /**
     * Setter for string property 'angularSuffix'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("7e660bc1-dcec-448d-a377-9ccb970552e7")
    public void setAngularSuffix(final String value) {
        this.elt.putTagValue(Entity.MdaTypes.ANGULARSUFFIX_TAGTYPE_ELT, value);
    }

    /**
     * Setter for string property 'clientRootFolder'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("b2a64da5-4947-4597-88a6-7e1359c2643b")
    public void setClientRootFolder(final String value) {
        this.elt.putTagValue(Entity.MdaTypes.CLIENTROOTFOLDER_TAGTYPE_ELT, value);
    }

    /**
     * Setter for string property 'dto'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("a2c80161-ef00-4e8b-bc6c-2d9101332151")
    public void setDto(final String value) {
        this.elt.putTagValue(Entity.MdaTypes.DTO_TAGTYPE_ELT, value);
    }

    /**
     * Setter for boolean property 'filter'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("bfc8df91-6dce-455c-9367-12b5b6e8ade5")
    public void setFilter(final boolean value) {
        if (value)
          Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createTaggedValue(Entity.MdaTypes.FILTER_TAGTYPE_ELT, this.elt);
        else
          this.elt.removeTags(Entity.MdaTypes.FILTER_TAGTYPE_ELT);
    }

    /**
     * Setter for string property 'microservice'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("020cf55f-b2e8-47d8-b468-562f3910379d")
    public void setMicroservice(final String value) {
        this.elt.putTagValue(Entity.MdaTypes.MICROSERVICE_TAGTYPE_ELT, value);
    }

    /**
     * Setter for boolean property 'noFluentMethod'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("d8941df8-8cb6-4935-aab9-10d4f721de25")
    public void setNoFluentMethod(final boolean value) {
        if (value)
          Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createTaggedValue(Entity.MdaTypes.NOFLUENTMETHOD_TAGTYPE_ELT, this.elt);
        else
          this.elt.removeTags(Entity.MdaTypes.NOFLUENTMETHOD_TAGTYPE_ELT);
    }

    /**
     * Setter for string property 'paginate'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("5a03c61c-2441-466b-81f0-421d6bfe5730")
    public void setPaginate(final String value) {
        this.elt.putTagValue(Entity.MdaTypes.PAGINATE_TAGTYPE_ELT, value);
    }

    /**
     * Setter for boolean property 'readOnly'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("3b57d58d-498e-41c0-b4e6-6ae51dd87c4c")
    public void setReadOnly(final boolean value) {
        if (value)
          Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createTaggedValue(Entity.MdaTypes.READONLY_TAGTYPE_ELT, this.elt);
        else
          this.elt.removeTags(Entity.MdaTypes.READONLY_TAGTYPE_ELT);
    }

    /**
     * Setter for string property 'search'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("b0f6a14f-c882-41e8-80e9-5ded9138e9cf")
    public void setSearch(final String value) {
        this.elt.putTagValue(Entity.MdaTypes.SEARCH_TAGTYPE_ELT, value);
    }

    /**
     * Setter for string property 'service'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("10cf6f76-de6b-4883-8644-2bb9c3d1313a")
    public void setService(final String value) {
        this.elt.putTagValue(Entity.MdaTypes.SERVICE_TAGTYPE_ELT, value);
    }

    /**
     * Setter for boolean property 'skipClient'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("fba1c124-782d-4ec0-94c1-670154b60109")
    public void setSkipClient(final boolean value) {
        if (value)
          Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createTaggedValue(Entity.MdaTypes.SKIPCLIENT_TAGTYPE_ELT, this.elt);
        else
          this.elt.removeTags(Entity.MdaTypes.SKIPCLIENT_TAGTYPE_ELT);
    }

    /**
     * Setter for boolean property 'skipServer'
     * <p>Property description:
     * <br/><i>null</i></p>
     */
    @objid ("fc92df4b-53f4-4196-89d7-c492e2164557")
    public void setSkipServer(final boolean value) {
        if (value)
          Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().getModel().createTaggedValue(Entity.MdaTypes.SKIPSERVER_TAGTYPE_ELT, this.elt);
        else
          this.elt.removeTags(Entity.MdaTypes.SKIPSERVER_TAGTYPE_ELT);
    }

    @objid ("39d0187b-0f24-4cd8-b289-5281de7d14a2")
    protected Entity(final Class elt) {
        this.elt = elt;
    }

    @objid ("37f31199-f4e0-4944-ab57-a515f0ac16e0")
    public static final class MdaTypes {
        @objid ("edecc9d9-d411-41fa-8341-7e9f9baaac77")
        public static Stereotype STEREOTYPE_ELT;

        @objid ("07d2032c-63f3-4a75-94e0-fb83f36761dd")
        public static TagType SKIPCLIENT_TAGTYPE_ELT;

        @objid ("82d4e340-2cda-4b81-bd07-07072343767f")
        public static TagType SKIPSERVER_TAGTYPE_ELT;

        @objid ("f4322b42-3c87-4b82-8f09-5ece7b3101c3")
        public static TagType NOFLUENTMETHOD_TAGTYPE_ELT;

        @objid ("b0822baa-dff6-4594-aa1c-a6b966d8b731")
        public static TagType FILTER_TAGTYPE_ELT;

        @objid ("ecb722b6-bfe4-48e3-93ee-ece5dfc112fc")
        public static TagType READONLY_TAGTYPE_ELT;

        @objid ("6954900e-bbbf-4a06-af0f-c12dbeae99f2")
        public static TagType DTO_TAGTYPE_ELT;

        @objid ("e6393c52-1477-4625-bca6-63bdb1ea8d09")
        public static TagType SERVICE_TAGTYPE_ELT;

        @objid ("025f7c28-47a8-4cda-ba6f-6bf04defb486")
        public static TagType PAGINATE_TAGTYPE_ELT;

        @objid ("0bb49199-fd7b-40b0-8b01-a3cd182f1fe1")
        public static TagType SEARCH_TAGTYPE_ELT;

        @objid ("58e2611a-ee3a-42fc-a56c-51775c7e8f83")
        public static TagType MICROSERVICE_TAGTYPE_ELT;

        @objid ("30123e5f-1478-481e-b206-d3e84c1463ff")
        public static TagType ANGULARSUFFIX_TAGTYPE_ELT;

        @objid ("c5657685-5cb4-473f-bbd2-ccf76cf977c6")
        public static TagType CLIENTROOTFOLDER_TAGTYPE_ELT;

        @objid ("4f1dcd85-5742-4d12-9e49-a9e56710905d")
        private static Stereotype MDAASSOCDEP;

        @objid ("4e61c94f-f2b5-4fac-8825-d42806b7c536")
        private static TagType MDAASSOCDEP_ROLE;

        @objid ("1f3151db-f3b0-40a1-ae05-78329a98aaf4")
        public static void init(final IModuleContext ctx) {
            STEREOTYPE_ELT = ctx.getModelingSession().findElementById(Stereotype.class, "7a4999c5-9dce-4679-ba16-202d7ed3a552");
            SKIPCLIENT_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "50ae2e79-471c-430f-afb9-aa835c1bd45a");
            SKIPSERVER_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "11c39ad8-d38a-42db-a7b9-7e156793e9fc");
            NOFLUENTMETHOD_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "556e414c-7d70-44e1-94b9-8296c285c252");
            FILTER_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "cfc6d515-306e-4262-905c-b18f052225f6");
            READONLY_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "c1f787b1-9d58-4875-8a9f-35f1958d7791");
            DTO_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "8c964ceb-084b-4206-ba00-2300aef08bc7");
            SERVICE_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "c5907fb8-0940-467a-841c-635ba6fbf188");
            PAGINATE_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "9c6b6303-d8a5-4d88-9d92-358b7daf21ee");
            SEARCH_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "3cfc4c92-c1b5-4895-8079-0490d3783a39");
            MICROSERVICE_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "070f6515-9224-4fde-97a2-681343791202");
            ANGULARSUFFIX_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "85a14cc3-38ea-423b-834f-e8c5d95ce364");
            CLIENTROOTFOLDER_TAGTYPE_ELT = ctx.getModelingSession().findElementById(TagType.class, "092c52d1-1fe8-469d-b24d-f4ae1b9a1a57");
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
