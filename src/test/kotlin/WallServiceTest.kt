import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {
    val service = WallService

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
        service.add(
            Post(
                1,
                3,
                1,
                1,
                1,
                "Текст поста!",
                2,
                1,
                true,
                comments,
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
                1
            )
        )
        service.add(
            Post(
                1,
                5,
                2,
                1,
                3,
                "Текст поста!",
                2,
                1,
                true,
                comments,
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
                1
            )
        )
        service.add(
            Post(
                1,
                3,
                1,
                1,
                1,
                "Текст поста!",
                2,
                1,
                true,
                comments,
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
                1
            )
        )

        val update = Post(
            2,
            3,
            1,
            1,
            1,
            "Текст поста!",
            2,
            1,
            true,
            comments,
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
            1
        )

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateExisting_False() {
        service.add(
            Post(
                1,
                3,
                1,
                1,
                1,
                "Текст поста!",
                2,
                1,
                true,
                comments,
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
                1
            )
        )
        service.add(
            Post(
                1,
                5,
                2,
                1,
                3,
                "Текст поста!",
                2,
                1,
                true,
                comments,
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
                1
            )
        )
        service.add(
            Post(
                1,
                3,
                1,
                1,
                1,
                "Текст поста!",
                2,
                1,
                true,
                comments,
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
                1
            )
        )
        val update = Post(
            45,
            3,
            1,
            1,
            1,
            "Текст поста!",
            2,
            1,
            true,
            comments,
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
            1
        )

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
        val comment = Comment(postId = 3)
        service.createComment(comment)

    }

}

