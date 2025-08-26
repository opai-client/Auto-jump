package today.opai.autojump.modules;

import today.opai.api.events.EventMotionUpdate;
import today.opai.api.features.ExtensionModule;
import today.opai.api.enums.EnumModuleCategory;
import today.opai.api.interfaces.EventHandler;
import today.opai.api.interfaces.modules.PresetModule;
import today.opai.autojump.Autojump;

/**
 * Minimal AutoJump:
 * - If onGround -> call localPlayer.jump()
 * - If a module named "Scaffold" is enabled, do nothing
 */
public class AutoJumpSpeed extends ExtensionModule {

    public AutoJumpSpeed() {
        super("AutoJump", "Automatically jump when on ground (disabled while Scaffold is on)", EnumModuleCategory.MOVEMENT);


        this.setEventHandler(new EventHandler() {
            @Override
            public void onMotionUpdate(EventMotionUpdate event) {

                if (!event.isGround()) return;


                try {
                    if (Autojump.openAPI != null && Autojump.openAPI.getModuleManager() != null) {
                        PresetModule scaffold = Autojump.openAPI.getModuleManager().getModule("Scaffold");
                        if (scaffold != null && scaffold.isEnabled()) return;
                    }
                } catch (Throwable ignored) {

                }


                try {
                    if (Autojump.openAPI != null && Autojump.openAPI.getLocalPlayer() != null) {
                        Autojump.openAPI.getLocalPlayer().jump();
                    }
                } catch (Throwable ignored) {

                }
            }
        });
    }
}
