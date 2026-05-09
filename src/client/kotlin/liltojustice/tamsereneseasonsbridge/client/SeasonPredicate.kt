package liltojustice.tamsereneseasonsbridge.client

import liltojustice.trueadaptivemusicapi.trigger.arguments.TriggerArguments
import liltojustice.trueadaptivemusicapi.trigger.predicate.type.StaticPredicateType
import net.minecraft.client.MinecraftClient
import sereneseasons.api.season.Season
import sereneseasons.season.SeasonHandler
import kotlin.reflect.typeOf

object SeasonPredicate: StaticPredicateType<SeasonPredicate.Arguments>(
    "season", typeOf<Arguments>()
) {
    data class Arguments(val season: Season, val subSeasons: List<Season.SubSeason>): TriggerArguments()

    override fun test(arguments: Arguments): Boolean {
        val world = MinecraftClient.getInstance().world ?: return false
        val state = SeasonHandler().getClientSeasonState(world)

        return state.season == arguments.season &&
                (arguments.subSeasons.isEmpty() || state.subSeason in arguments.subSeasons)
    }
}