class VideoAttachments (
    val video: Video = Video()

): Attachments {

    override var type: String = "video"
        set(value) {
            if (type == "video") {
                type as Video
            }
            field = value
        }
        get() = field

    override fun toString(): String {
        return "$type" + video.toString()
    }
}