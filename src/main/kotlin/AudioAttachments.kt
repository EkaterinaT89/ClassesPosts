class AudioAttachments(
    override var type: String,
    val audio: Audio = Audio()

    ): Attachments {

    override fun toString(): String {
        return "$type" + audio.toString()
    }
}