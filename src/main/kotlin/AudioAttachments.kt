class AudioAttachments(
    val audio: Audio = Audio()

    ) : Attachments {

    override var type: String = "audio"
        set(value) {
            if (type == "audio") {
                type as Audio
            }
            field = value
        }
        get() = field


    override fun toString(): String {
        return "$type" + audio.toString()
    }
}