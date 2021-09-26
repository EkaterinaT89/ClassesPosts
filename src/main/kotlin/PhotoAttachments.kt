class PhotoAttachments (
    override var type: String,
    var photo: Photo = Photo()

): Attachments {

    fun photo(post: Post) {
        val photo = type ?: type as Photo
    }

}