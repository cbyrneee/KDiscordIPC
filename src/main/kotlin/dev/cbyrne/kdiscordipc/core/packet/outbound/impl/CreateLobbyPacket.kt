package dev.cbyrne.kdiscordipc.core.packet.outbound.impl

import dev.cbyrne.kdiscordipc.core.packet.outbound.OutboundPacket
import kotlinx.serialization.Serializable

@Serializable
data class CreateLobbyPacket(
    override val opcode: Int = 0x01,
    override val cmd: String = "CREATE_LOBBY",
    override val args: Arguments? = null,
    override var nonce: String = "0"
) : OutboundPacket() {
    constructor(capacity: Int, locked: Boolean, metadata: Map<String, String> = mapOf()): this(args = Arguments(capacity, locked, metadata))

    @Serializable
    data class Arguments(
        val capacity: Int,
        val locked: Boolean,
        val metadata: Map<String, String>
    ): OutboundPacket.Arguments()
}