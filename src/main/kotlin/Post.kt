
const val POST = "post"
const val COPY = "copy"
const val REPLY = "reply"
const val POSTPONE = "postpone"
const val SUGGEST = "suggest"

val funPosts = FunPosts()

data class Post(
    var postId: Int, /* идентификатор записи */
    var ownerId: Int? = null, /* идентификатор владельца стены, на которой размещена запись */
    var fromId: Int? = null, /* идентификатор автора записи */
    var createdById: Int? = null, /* идентификатор администратора, который опубликовал запись СМ НИЖЕ!!!*/
    var date: Int? = null, /* время публикации записи */
    val text: String? = null, /* текст записи */
    var replyOwnerId: Int? = null, /* идентификатор владельца записи, в ответ на которую была оставлена текущая. */
    var replyPostId: Int? = null, /* идентификатор записи, в ответ на которую была оставлена текущая */
    val friendsOnly: Boolean? = null, /* true если запись была создана с опцией «Только для друзей» */
    val comments: Comments? = null, /*  информация о комментариях к записи */
    val copyright: Copyright? = null, /* источник материала */
    val likes: Likes? = null, /* информация о лайках к записи */
    val reports: Reports? = null, /* информация о репостах записи */
    val views: Views? = null, /* информация о просмотрах записи */
    val postType: String? = null, /* тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest. */
    var signerId: Int? = null, /* идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;*/
    val canPin: Boolean? = null, /* информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).*/
    val canDelete: Boolean? = null, /* информация о том, может ли текущий пользователь удалить запись */
    val canEdit: Boolean? = null, /* информация о том, может ли текущий пользователь редактировать запись */
    val isPinned: Boolean? = null, /* информация о том, что запись закреплена. */
    val markedAsAds: Boolean? = null, /* информация о том, содержит ли запись отметку "реклама" */
    val isFavorite: Boolean? = null, /* true, если объект добавлен в закладки у текущего пользователя */
    val donut: Donut? = null, /* информация о записи VK Donut: */
    var postponedId: Int? = null, /* идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.*/
    var attachments: Array<Attachments>? = emptyArray()
) {

    fun administrationId(date: Int): String {
        when (date) {
            in 0..24 -> return createdById.toString()
            else -> return " "
        }
    }

    override fun toString(): String {
        return "$text \n $postId, ID владельца стены - $ownerId, ID автора поста - $fromId, ID администратора - $createdById, " +
                "Создан - " + "Запись опубликована администратором " + date?.let { administrationId(it) } +  " $date ч. назад \n" +
                " Ответ на ID - $replyOwnerId, Ответ на запись ID $replyPostId, \n" +
                friendsOnly?.let { funPosts.friendsOnly(it) } +"\n" +
                comments.toString() +"\n" +
                copyright.toString() +"\n" +
                likes.toString() +"\n" +
                reports.toString() +"\n" +
                views.toString() +"\n" +
                "Тип поста '$postType', Подписано $signerId" + canPin?.let { funPosts.canPin(it) } +
                canDelete?.let { funPosts.canDelete(it) } +
                canEdit?.let { funPosts.canEdit(it) } +
                isPinned?.let { funPosts.isPinned(it) } +"\n" +
                markedAsAds?.let { funPosts.markedAsAds(it) } + isFavorite?.let { funPosts.isFavorite(it) } +
               donut.toString() + " ID отложенной записи - $postponedId " + attachments.contentToString()
    }


}


