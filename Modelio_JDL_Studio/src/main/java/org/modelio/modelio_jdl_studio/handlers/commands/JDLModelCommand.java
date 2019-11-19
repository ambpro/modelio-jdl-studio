package org.modelio.modelio_jdl_studio.handlers.commands;

import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.module.IModule;
import org.modelio.api.module.command.standard.ApplyPatternStandardHandler;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.modelio_jdl_studio.api.IModelio_JDL_StudioPeerModule;
import org.modelio.modelio_jdl_studio.api.jdl.standard.package_.JDLModel;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("d8e80ac9-1235-45cc-bce0-a87a3b2207c9")
public class JDLModelCommand extends ApplyPatternStandardHandler {
    @objid ("feae1428-da37-4350-98ef-fd0d17a9dbd2")
    @Override
    public boolean accept(final List<MObject> selectedElements, final IModule module) {
        // Generated call to the super method will check the scope conditions defined in Studio.
        // Do not remove this call unless you need to take full control on the checks to be carried out.
        // However you can safely extends the checked conditions by adding custom code.
        if (super.accept(selectedElements, module) == false) {
            return false;
        }
        
        if(selectedElements.get(0) instanceof ModelElement) {
            ModelElement elt = (ModelElement) selectedElements.get(0) ;
            if(elt.isStereotyped(IModelio_JDL_StudioPeerModule.MODULE_NAME, JDLModel.STEREOTYPE_NAME)) {
                return false;
            }
        }
        return true;
    }

    @objid ("7e5d9a79-396f-463c-8a3c-5bb3db88e77d")
    @Override
    protected void postConfigure(final List<MObject> selectedElements, final IModule module) {
        // This method is a hook called once the pattern is applied and before the transaction is committed.
        // The super method currently does nothing but should be called first in any case for future compatibility.
        // Sub classes may redefine this method to make additional modifications.
        
        // Call the super method
        super.postConfigure(selectedElements, module);
        
        // TODO Add additional behavior below
    }

    @objid ("b53cb943-1c88-444a-8763-558e2b0689b2")
    @Override
    protected Map<String, Object> configure(final List<MObject> selectedElements, final IModule module) {
        // This method is a hook to configure the parameters that will be used by the pattern, it is called by {@link
        // #actionPerformed(List, IModule)} before executing the pattern.
        // It returns the effective parameters the pattern will use.
        //
        // The super method copies all the command handler parameters and add the following ones:
        // - selection : the selectedElements selection
        // - module : the IModule.
        // The super method shall be called first in most cases.
        return super.configure(selectedElements, module);
    }

}
