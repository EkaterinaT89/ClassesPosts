
object WallService {

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comments>()

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

    fun createComment(comment: Comments): Comments {
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