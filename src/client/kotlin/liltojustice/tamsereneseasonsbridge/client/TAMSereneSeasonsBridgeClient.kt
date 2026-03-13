package liltojustice.tamsereneseasonsbridge.client

import liltojustice.trueadaptivemusic.client.TAMClient
import net.fabricmc.api.ClientModInitializer

class TAMSereneSeasonsBridgeClient : ClientModInitializer {
    override fun onInitializeClient() {
        TAMClient.registerPredicate("season", SeasonPredicate::class)
    }
}
