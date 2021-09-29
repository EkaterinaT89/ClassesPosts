
object WallService {

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

}