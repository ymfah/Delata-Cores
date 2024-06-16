package com.fs.starfarer.api.impl.campaign;

import com.fs.starfarer.api.PluginPick;
import com.fs.starfarer.api.campaign.AICoreAdminPlugin;
import com.fs.starfarer.api.campaign.AICoreOfficerPlugin;
import com.fs.starfarer.api.campaign.BaseCampaignPlugin;

public class DeltaCampaignPluginImpl extends BaseCampaignPlugin {
    public PluginPick<AICoreOfficerPlugin> pickAICoreOfficerPlugin(String commodityId) {
        if ("delta_core".equals(commodityId)) {
            return new PluginPick<AICoreOfficerPlugin>(new DeltaCoreOfficerPlugin(), PickPriority.MOD_SET);
        }
        else{
            return null;
        }
    }

}
