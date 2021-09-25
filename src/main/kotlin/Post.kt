const val POST = "post"
const val COPY = "copy"
const val REPLY = "reply"
const val POSTPONE = "postpone"
const val SUGGEST = "suggest"

val funPosts = FunPosts()

data class Post(
    var postId: Int = 0, /* идентификатор записи */
    var ownerId: Int, /* идентификатор владельца стены, на которой размещена запись */
    var fromId: Int, /* идентификатор автора записи */
    var createdById: Int, /* идентификатор администратора, который опубликовал запись СМ НИЖЕ!!!*/
    var date: Int, /* время публикации записи */
    val text: String, /* текст записи */
    var replyOwnerId: Int?, /* идентификатор владельца записи, в ответ на которую была оставлена текущая. */
    var replyPostId: Int, /* идентификатор записи, в ответ на которую была оставлена текущая */
    val friendsOnly: Boolean, /* true если запись была создана с опцией «Только для друзей» */
    val comments: Comments, /*  информация о комментариях к записи */
    val copyright: Copyright, /* источник материала */
    val likes: Likes, /* информация о лайках к записи */
    val reports: Reports, /* информация о репостах записи */
    val views: Views, /* информация о просмотрах записи */
    val postType: String, /* тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest. */
    var signerId: Int, /* идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;*/
    val canPin: Boolean, /* информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).*/
    val canDelete: Boolean, /* информация о том, может ли текущий пользователь удалить запись */
    val canEdit: Boolean, /* информация о том, может ли текущий пользователь редактировать запись */
    val isPinned: Boolean, /* информация о том, что запись закреплена. */
    val markedAsAds: Boolean, /* информация о том, содержит ли запись отметку "реклама" */
    val isFavorite: Boolean, /* true, если объект добавлен в закладки у текущего пользователя */
    val donut: Donut, /* информация о записи VK Donut: */
    var postponedId: Int, /* идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.*/
    var attachments: Array<String>? = emptyArray()

) {

    fun administrationId(date: Int): String {
        when (date) {
            in 0..24 -> return createdById.toString()
            else -> return " "
        }
    }

    override fun toString(): String {
        return "$text \n $postId, ID владельца стены - $ownerId, ID автора поста - $fromId, ID администратора - $createdById, " +
                "Создан - " + "Запись опубликована администратором " + administrationId(date) + " $date ч. назад \n" +
                " Ответ на ID - $replyOwnerId, Ответ на запись ID $replyPostId, \n" +
                funPosts.friendsOnly(friendsOnly) + "\n" +
                comments.toString() + "\n" +
                copyright.toString() + "\n" +
                likes.toString() + "\n" +
                reports.toString() + "\n" +
                views.toString() + "\n" +
                "Тип поста '$postType', Подписано $signerId" + funPosts.canPin(canPin) +
                funPosts.canDelete(canDelete) +
                funPosts.canEdit(canEdit) +
                funPosts.isPinned(isPinned) + "\n" +
                funPosts.markedAsAds(markedAsAds) + funPosts.isFavorite(isFavorite) +
                donut.toString() + " ID отложенной записи - $postponedId"

    }


}


