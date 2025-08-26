package today.opai.autojump;

import today.opai.api.Extension;
import today.opai.api.OpenAPI;
import today.opai.api.annotations.ExtensionInfo;
import today.opai.autojump.modules.AutoJumpSpeed;

@ExtensionInfo(name = "Autojump", author = "Zambos", version = "1.0")
public class Autojump extends Extension {
    public static OpenAPI openAPI;

    @Override
    public void initialize(OpenAPI openAPI) {
        Autojump.openAPI = openAPI;


        openAPI.registerFeature(new AutoJumpSpeed());
    }
}
