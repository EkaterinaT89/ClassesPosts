import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

var service = WallService
    @Test
    fun addFunction() {
       

        service.add(Post(
            postId = 0,
            ownerId = 2004,
            fromId = 555,
            createdById = 85632,
            date = 20,
            replyOwnerId = 56326,
            replyPostId = 87459,
            signerId = 266498,
            postponedId = 589632,
            canDelete = true,
            canEdit = true,
            canPin = true,
            views = views,
            comments = comment,
            text = "Текст поста!",
            donut = donut,
            copyright = copyright,
            friendsOnly = false,
            isFavorite = true,
            isPinned = false,
            likes = likes,
            markedAsAds = true,
            postType = POST,
            reports = reports,
            attachments = null
        ))

        val result = Post(
            postId = 0,
            ownerId = 2004,
            fromId = 555,
            createdById = 85632,
            date = 20,
            replyOwnerId = 56326,
            replyPostId = 87459,
            signerId = 266498,
            postponedId = 589632,
            canDelete = true,
            canEdit = true,
            canPin = true,
            views = views,
            comments = comment,
            text = "Текст поста!",
            donut = donut,
            copyright = copyright,
            friendsOnly = false,
            isFavorite = true,
            isPinned = false,
            likes = likes,
            markedAsAds = true,
            postType = POST,
            reports = reports,
            attachments = null
        )

        assertEquals(Post(
            postId = 0,
            ownerId = 2004,
            fromId = 555,
            createdById = 85632,
            date = 20,
            replyOwnerId = 56326,
            replyPostId = 87459,
            signerId = 266498,
            postponedId = 589632,
            canDelete = true,
            canEdit = true,
            canPin = true,
            views = views,
            comments = comment,
            text = "Текст поста!",
            donut = donut,
            copyright = copyright,
            friendsOnly = false,
            isFavorite = true,
            isPinned = false,
            likes = likes,
            markedAsAds = true,
            postType = POST,
            reports = reports,
            attachments = null
        ), result)

    

    @Test
    fun addFunction() {
            val post = Post(postId = 1)
            val postIdExpected = 3
            service.add(post)
            val result = service.add(post).postId
            assertEquals(postIdExpected, result)

        }

        @Test
        fun updateExisting_True() {
            service.add(Post( 3,
                3,
                1,
                1,
                1,
                "Текст поста!",
                2,
                1,
                true,
                comment,
                copyright,
                likes,
                reports,
                views,
                POST,
                1,
                false,
                false,
                false,
                true,
                false,
                true,
                donut,
                1))
            service.add(Post( 2,
                5,
                2,
                1,
                3,
                "Текст поста!",
                2,
                1,
                true,
                comment,
                copyright,
                likes,
                reports,
                views,
                POST,
                1,
                false,
                false,
                false,
                true,
                false,
                true,
                donut,
                1))
            service.add(Post( 1,
                3,
                1,
                1,
                1,
                "Текст поста!",
                2,
                1,
                true,
                comment,
                copyright,
                likes,
                reports,
                views,
                POST,
                1,
                false,
                false,
                false,
                true,
                false,
                true,
                donut,
                1))

            val update = Post(2,
                3,
                1,
                1,
                1,
                "Текст поста!",
                2,
                1,
                true,
                comment,
                copyright,
                likes,
                reports,
                views,
                POST,
                1,
                false,
                false,
                false,
                true,
                false,
                true,
                donut,
                1)

            val result = service.update(update)

            assertTrue(result)
        }

    @Test
    fun updateExisting_False() {
        service.add(Post( 1,
            3,
            1,
            1,
            1,
            "Текст поста!",
            2,
            1,
            true,
            comment,
            copyright,
            likes,
            reports,
            views,
            POST,
            1,
            false,
            false,
            false,
            true,
            false,
            true,
            donut,
            1))
        service.add(Post( 1,
            5,
            2,
            1,
            3,
            "Текст поста!",
            2,
            1,
            true,
            comment,
            copyright,
            likes,
            reports,
            views,
            POST,
            1,
            false,
            false,
            false,
            true,
            false,
            true,
            donut,
            1))
        service.add(Post( 1,
            3,
            1,
            1,
            1,
            "Текст поста!",
            2,
            1,
            true,
            comment,
            copyright,
            likes,
            reports,
            views,
            POST,
            1,
            false,
            false,
            false,
            true,
            false,
            true,
            donut,
            1))

        val update = Post(45,
            3,
            1,
            1,
            1,
            "Текст поста!",
            2,
            1,
            true,
            comment,
            copyright,
            likes,
            reports,
            views,
            POST,
            1,
            false,
            false,
            false,
            true,
            false,
            true,
            donut,
            1)

        val result = service.update(update)

        assertFalse(result)
    }

    @Test
    fun commentAdded() {
        val post = Post(1)
        val comment = Comment(postId = 2, text = "Text")
        val textExpected = "Text"

        service.add(post)
        service.createComment(comment)

        val result = comment.text
        assertEquals(textExpected, result)

    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val comment = Comment(postId = 3458)
        service.createComment(comment)

    }


}
