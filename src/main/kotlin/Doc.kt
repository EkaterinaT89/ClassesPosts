class Doc (
    var id: Int? = null,
    var ownerId: Int? = null,
    var url: String? = null,
    var urlFool: String? = null
) {

    override fun toString(): String {
        return " id $id, ownerId $ownerId, url $url, urlFool $urlFool"
    }

}