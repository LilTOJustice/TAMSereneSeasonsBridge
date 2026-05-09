package liltojustice.tamsereneseasonsbridge.client

import liltojustice.trueadaptivemusicapi.TAMAPI
import net.fabricmc.api.ClientModInitializer

class TAMSereneSeasonsBridgeClient: ClientModInitializer {
    override fun onInitializeClient() {
        TAMAPI.registerPredicateType(SeasonPredicate)
    }
}
