package org.modelio.modelio_jdl_studio.impl;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.module.AbstractJavaModule;
import org.modelio.api.module.context.IModuleContext;
import org.modelio.api.module.lifecycle.IModuleLifeCycleHandler;
import org.modelio.api.module.mda.IMdaExpert;
import org.modelio.api.module.parameter.IParameterEditionModel;
import org.modelio.metamodel.uml.infrastructure.Stereotype;

@objid ("5f75d588-4e9c-4c69-96aa-a534919c3bc9")
public class Modelio_JDL_StudioModule extends AbstractJavaModule {
    @objid ("f53e7f50-1411-4095-8327-1da04a4fa6da")
    private static final String MODULE_IMAGE = "/res/icon/module.png";

    @objid ("47f35571-62a0-42ff-9a3a-9b82caa4a551")
    private Modelio_JDL_StudioPeerModule peerModule = null;

    @objid ("93f144db-53db-4f25-8668-9fd898aa65aa")
    private Modelio_JDL_StudioLifeCycleHandler lifeCycleHandler = null;

    @objid ("c079abb2-0950-4933-84af-b9d815bc3cb3")
    private static Modelio_JDL_StudioModule instance;

    @objid ("17099e40-0a8b-4669-86eb-3d6f8b11be5e")
    public Modelio_JDL_StudioModule(final IModuleContext moduleContext) {
        super(moduleContext);
        
        Modelio_JDL_StudioModule.instance = this;
        
        this.lifeCycleHandler  = new Modelio_JDL_StudioLifeCycleHandler(this);
        this.peerModule = new Modelio_JDL_StudioPeerModule(this, moduleContext.getPeerConfiguration());
        init();
    }

    @objid ("95c92689-4609-4406-a3b4-59124bd91aa0")
    @Override
    public Modelio_JDL_StudioPeerModule getPeerModule() {
        return this.peerModule;
    }

    /**
     * Return the LifeCycleHandler  attached to the current module. This handler is used to manage the module lifecycle by declaring the desired implementation for the start, select... methods.
     */
    @objid ("e09531c9-5cf9-4cb7-9ceb-90ce87b61e70")
    @Override
    public IModuleLifeCycleHandler getLifeCycleHandler() {
        return this.lifeCycleHandler;
    }

    /**
     * Method automatically called just after the creation of the module. The module is automatically instanciated at the beginning
     * of the MDA lifecycle and constructor implementation is not accessible to the module developer. The <code>init</code> method
     * allows the developer to execute the desired initialization.
     */
    @objid ("fd5bd80b-5588-4efe-b8e8-cb47695a0127")
    @Override
    public IParameterEditionModel getParametersEditionModel() {
        return super.getParametersEditionModel();
    }

    @objid ("a43fbd66-1737-49a8-950e-98848b93039a")
    @Override
    public String getModuleImagePath() {
        return Modelio_JDL_StudioModule.MODULE_IMAGE;
    }

    @objid ("9d487436-8fc3-4e26-b1a5-4fd1207d8707")
    public static Modelio_JDL_StudioModule getInstance() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return instance;
    }

    @objid ("31ca9864-dacc-47cc-abe1-00113dbeafa1")
    @Override
    public IMdaExpert getMdaExpert(final Stereotype st) {
        // Generated code, please do not remove it
        IMdaExpert expert = getGeneratedMdaExpert(st);
        if (expert != null) {
            return expert;
        }// End generated code
        return null;
    }

    /**
     * Generated expert looking for a MDA expert in the generated MDA API.
     * 
     * @param st a stereotype owned by the current module.
     * @return a MDA expert belonging to the MDA API or <code>null</code>.
     */
    @objid ("a2a833f7-5735-417c-ae2f-37ec1d1eb65f")
    private IMdaExpert getGeneratedMdaExpert(final Stereotype st) {
        switch (st.getUuid()) {
        	default: return null;
        }
    }

}
