
object WallService {


    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

//    fun add(post: Post): Post {
//        for ((index, item) in posts.withIndex()) {
//            posts.copyOf().set(
//                index, Post(
//                    postId = item.postId,
//                    ownerId = item.ownerId,
//                    fromId = item.fromId,
//                    createdById = item.createdById,
//                    date = item.date,
//                    text = item.text,
//                    replyOwnerId = item.replyOwnerId,
//                    replyPostId = item.replyPostId,
//                    friendsOnly = item.friendsOnly,
//                    comments = item.comments,
//                    copyright = item.copyright,
//                    likes = item.likes,
//                    reports = item.reports,
//                    views = item.views,
//                    postType = item.postType,
//                    signerId = item.signerId,
//                    canPin = item.canPin,
//                    canDelete = item.canDelete,
//                    canEdit = item.canEdit,
//                    isPinned = item.isPinned,
//                    markedAsAds = item.markedAsAds,
//                    isFavorite = item.isFavorite,
//                    donut = item.donut,
//                    postponedId = item.postponedId
//                )
//            )
//            posts.get(index)
//        }
//        for (post in posts) {
//            if (posts.isNotEmpty()) posts.last().postId++ else 0
//        }
//        return posts.last()
//    }

    private val posts:MutableList<Post> = mutableListOf()


    fun add(post: Post): Post {
          posts += post
            post.copy(
                postId = if (posts.isNotEmpty()) posts.last().postId ++ else 0
            )
        return posts.last()
    }

    fun print() {
        println(posts.last().toString())
    }

    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (item.postId == post.postId) {
                posts[index] = post.copy(postId = item.postId, date = item.date)
                return true
            }
        }
        return false
    }


    fun addAttachment(attachments: Attachments, post: Post) {
        post.attachments = post.attachments?.plus(attachments)

    }

    fun createComment(comment: Comment): Comment {
        for (post in posts) {
            if (post.postId == comment.postId) {
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("Пост с таким ID не найден!")
    }

    fun printCom() {
        println(comments.contentToString())
    }


}

// Если свойства val:
//
// fun add(post: Post): Post {
//    posts += post
//    val newPost = post.copy(
//        postId = post.postId + 1,
//        ownerId = post.ownerId + 1,
//        fromId = post.fromId + 1,
//        createdById = post.createdById + 1,
//        date = post.date + 1,
//        replyOwnerId = post.replyOwnerId + 1,
//        replyPostId = post.replyPostId + 1,
//        postponedId = post.postponedId + 1
//    )
//
//    println(post.toString() + "\n" + newPost)
//    return post
//}


//val postId: Int, /* идентификатор записи */
//val ownerId: Int, /* идентификатор владельца стены, на которой размещена запись */
//val fromId: Int, /* идентификатор автора записи */
//val createdById: Int, /* идентификатор администратора, который опубликовал запись СМ НИЖЕ!!!*/
//val date: Int, /* время публикации записи */
//val text: String, /* текст записи */
//val replyOwnerId: Int, /* идентификатор владельца записи, в ответ на которую была оставлена текущая. */
//val replyPostId: Int, /* идентификатор записи, в ответ на которую была оставлена текущая */
//val friendsOnly: Boolean, /* true если запись была создана с опцией «Только для друзей» */
//val comments: Comments, /*  информация о комментариях к записи */
//val copyright: Copyright, /* источник материала */
//val likes: Likes, /* информация о лайках к записи */
//val reports: Reports, /* информация о репостах записи */
//val views: Views, /* информация о просмотрах записи */
//val postType: String, /* тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest. */
//val signerId: Int, /* идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;*/
//val canPin: Boolean, /* информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).*/
//val canDelete: Boolean, /* информация о том, может ли текущий пользователь удалить запись */
//val canEdit: Boolean, /* информация о том, может ли текущий пользователь редактировать запись */
//val isPinned: Boolean, /* информация о том, что запись закреплена. */
//val markedAsAds: Boolean, /* информация о том, содержит ли запись отметку "реклама" */
//val isFavorite: Boolean, /* true, если объект добавлен в закладки у текущего пользователя */
//val donut: Donut, /* информация о записи VK Donut: */
//val postponedId: Int, /* идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.*/

}

