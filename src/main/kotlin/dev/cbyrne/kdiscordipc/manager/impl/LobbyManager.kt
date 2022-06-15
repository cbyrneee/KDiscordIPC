package dev.cbyrne.kdiscordipc.manager.impl

import dev.cbyrne.kdiscordipc.KDiscordIPC
import dev.cbyrne.kdiscordipc.core.packet.outbound.impl.CreateLobbyPacket
import dev.cbyrne.kdiscordipc.data.lobby.LobbyData
import dev.cbyrne.kdiscordipc.manager.Manager
import dev.cbyrne.kdiscordipc.core.packet.inbound.impl.CreateLobbyPacket as InboundCreateLobbyPacket

class LobbyManager(override val ipc: KDiscordIPC) : Manager() {
    suspend fun createLobby(capacity: Int = 16, locked: Boolean = false): LobbyData {
        return ipc.sendPacket<InboundCreateLobbyPacket>(CreateLobbyPacket(capacity, locked)).data
    }
}