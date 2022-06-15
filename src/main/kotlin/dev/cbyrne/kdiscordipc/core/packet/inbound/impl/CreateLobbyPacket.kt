package dev.cbyrne.kdiscordipc.core.packet.inbound.impl

import dev.cbyrne.kdiscordipc.core.packet.inbound.CommandPacket
import dev.cbyrne.kdiscordipc.data.lobby.LobbyData
import kotlinx.serialization.Serializable

@Serializable
data class CreateLobbyPacket(
    override val data: LobbyData,
    override val cmd: String = "CREATE_LOBBY",
    override val opcode: Int = 0x01,
    override val nonce: String = "0"
) : CommandPacket()