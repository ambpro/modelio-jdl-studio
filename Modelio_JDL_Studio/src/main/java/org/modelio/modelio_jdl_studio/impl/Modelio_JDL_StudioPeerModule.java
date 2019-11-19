package org.modelio.modelio_jdl_studio.impl;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.module.context.configuration.IModuleAPIConfiguration;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.vbasic.version.Version;

@objid ("ffcb87ca-b14b-46eb-8769-90dbb4707b93")
public class Modelio_JDL_StudioPeerModule implements IModelio_JDL_StudioPeerModule {
    @objid ("948b7bd7-c362-4755-a44d-084f3f586d50")
    private Modelio_JDL_StudioModule module = null;

    @objid ("1558d0f1-5182-4a3b-aab8-b5372d196df5")
    private IModuleAPIConfiguration peerConfiguration;

    @objid ("28fbeab2-1395-4902-b0af-d8ae97f14559")
    public Modelio_JDL_StudioPeerModule(final Modelio_JDL_StudioModule module, final IModuleAPIConfiguration peerConfiguration) {
        this.module = module;
        this.peerConfiguration = peerConfiguration;
    }

    @objid ("f6186580-8b1a-4bcc-b0fa-54c12c92bc35")
    public IModuleAPIConfiguration getConfiguration() {
        return this.peerConfiguration;
    }

    @objid ("b9add744-1926-4fc5-b311-22cecfbeca07")
    public String getDescription() {
        return this.module.getDescription();
    }

    @objid ("5777c17f-b4d4-4595-82e2-3a72d9f0e562")
    public String getName() {
        return this.module.getName();
    }

    @objid ("212a5494-77c8-4d2f-bde0-089995c5f34d")
    public Version getVersion() {
        return this.module.getVersion();
    }

    @objid ("5f366191-4d67-4a49-85d0-42fe4172db34")
    void init() {
    }

}
