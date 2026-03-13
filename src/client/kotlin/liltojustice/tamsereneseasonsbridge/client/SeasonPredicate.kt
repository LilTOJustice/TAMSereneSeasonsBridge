package liltojustice.tamsereneseasonsbridge.client

import liltojustice.trueadaptivemusic.client.trigger.predicate.MusicPredicate
import net.minecraft.client.MinecraftClient
import sereneseasons.api.season.Season
import sereneseasons.season.SeasonHandler

class SeasonPredicate(private val season: Season, private val subSeasons: List<Season.SubSeason>): MusicPredicate() {
    override fun test(): Boolean {
        val world = MinecraftClient.getInstance().world ?: return false
        val state = SeasonHandler().getClientSeasonState(world)

        return state.season == season && (subSeasons.isEmpty() || state.subSeason in subSeasons)
    }
}