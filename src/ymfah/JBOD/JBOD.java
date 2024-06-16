package ymfah.JBOD;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.impl.campaign.DeltaCampaignPluginImpl;

public class JBOD extends BaseModPlugin {
    @Override
    public void onApplicationLoad() throws Exception {
        super.onApplicationLoad();

        // Test that the .jar is loaded and working, using the most obnoxious way possible.
    }

    @Override
    public void onNewGame() {
        super.onNewGame();

    }

    public void onGameLoad(boolean wasEnabledBefore) {
        Global.getSector().registerPlugin(new DeltaCampaignPluginImpl());
    }
}
