package com.fs.starfarer.api.impl.campaign;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.AICoreOfficerPlugin;
import com.fs.starfarer.api.campaign.econ.CommoditySpecAPI;
import com.fs.starfarer.api.characters.FullName;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.impl.campaign.ids.Personalities;
import com.fs.starfarer.api.impl.campaign.ids.Ranks;
import com.fs.starfarer.api.ui.Alignment;
import com.fs.starfarer.api.ui.TooltipMakerAPI;
import com.fs.starfarer.api.util.Misc;

import java.awt.*;
import java.util.Random;

public class DeltaCoreOfficerPlugin extends BaseAICoreOfficerPluginImpl implements AICoreOfficerPlugin {

    public PersonAPI createPerson(String aiCoreId, String factionId, Random random) {
        if (random == null) {
            new Random();
        }
        PersonAPI person = Global.getFactory().createPerson();
        person.setFaction(factionId);
        person.setAICoreId(aiCoreId);
        boolean DeltaCore = "delta_core".equals(aiCoreId);
        CommoditySpecAPI spec = Global.getSettings().getCommoditySpec(aiCoreId);
        person.getStats().setSkipRefresh(true);
        person.setName(new FullName(spec.getName(), "", FullName.Gender.ANY));
        float mult = 0.000001F;
        if (DeltaCore) {
            person.getStats().setLevel(0);
            person.setPortraitSprite(Global.getSettings().getSpriteName("characters", "deltacore"));
        }
        person.getMemoryWithoutUpdate().set("$autoPointsMult", mult);
        if (DeltaCore) {
            person.setPersonality(Personalities.STEADY);
        }
        person.setRankId(Ranks.SPACE_CAPTAIN);
        person.setPostId((String) null);
        person.getStats().setSkipRefresh(false);
        return person;
    }

    @Override
    public void createPersonalitySection(PersonAPI person, TooltipMakerAPI tooltip) {
        float opad = 10.0F;
        Color text = person.getFaction().getBaseUIColor();
        Color bg = person.getFaction().getDarkUIColor();
        CommoditySpecAPI spec = Global.getSettings().getCommoditySpec(person.getAICoreId());
        if (spec.getId().equals("delta_core")) {
            tooltip.addSectionHeading("Personality: steady", text, bg, Alignment.MID, 20.0F);
            tooltip.addPara("In combat, the " + spec.getName() + " is ineffective, possessing absolutely no combat skills. " + "However, the AI core is well understood and easy to manage.", opad);
            tooltip.addPara("Automated Points Multiplier: 0x", 5.0f,
                    Misc.getTextColor(), Misc.getHighlightColor(), "Automated Points Multiplier");
        }
    }
}

