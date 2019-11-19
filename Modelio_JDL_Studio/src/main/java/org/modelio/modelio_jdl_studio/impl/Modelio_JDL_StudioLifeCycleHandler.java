package org.modelio.modelio_jdl_studio.impl;

import java.nio.file.Path;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.module.lifecycle.DefaultModuleLifeCycleHandler;
import org.modelio.api.module.lifecycle.ModuleException;
import org.modelio.vbasic.version.Version;

@objid ("1a630512-90fe-47c8-9661-7e02dfea38bb")
public class Modelio_JDL_StudioLifeCycleHandler extends DefaultModuleLifeCycleHandler {
    @objid ("564db893-aa16-414b-a90a-f370656dcb31")
    public Modelio_JDL_StudioLifeCycleHandler(final Modelio_JDL_StudioModule module) {
        super(module);
    }

    @objid ("676a5633-9208-4143-bfdc-00cdff790a09")
    @Override
    public boolean start() throws ModuleException {
        if(Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelingSession().findElementById(org.modelio.metamodel.uml.statik.Package.class, "cef40ef3-60fd-4178-a24a-de603af6ed39") == null) {
            Path componentPath = Modelio_JDL_StudioModule.getInstance().getModuleContext().getConfiguration().getModuleResourcesPath().resolve("res").resolve("component").resolve("JDLTypes_1.0.0.ramc");
            Modelio_JDL_StudioModule.getInstance().getModuleContext().getModelioServices().getModelComponentService().deployModelComponent(componentPath.toFile(), null);
        }
        return super.start();
    }

    @objid ("d99ad2f6-5881-44e6-99b3-38b4efcf9ef0")
    @Override
    public void stop() throws ModuleException {
        super.stop();
    }

    /**
     * @return
     */
    @objid ("ab1fb2d8-fd4a-4f8d-9695-71ef26c32248")
    public static boolean install(final String modelioPath, final String mdaPath) throws ModuleException {
        return DefaultModuleLifeCycleHandler.install(modelioPath, mdaPath);
    }

    @objid ("b466b96b-9bfa-4c8a-a5e3-c2771b1ef8dd")
    @Override
    public boolean select() throws ModuleException {
        return super.select();
    }

    @objid ("c0fa20b7-01a1-4885-a915-f6a9bd329d52")
    @Override
    public void upgrade(final Version oldVersion, final Map<String, String> oldParameters) throws ModuleException {
        super.upgrade(oldVersion, oldParameters);
    }

    @objid ("ec712681-ce17-444f-911a-6292489ae27c")
    @Override
    public void unselect() throws ModuleException {
        super.unselect();
    }

}
