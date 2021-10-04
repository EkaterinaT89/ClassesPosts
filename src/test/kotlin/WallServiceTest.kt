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
        service.add(Post( 3))
        service.add(Post( 2))
        service.add(Post( 1))
        val update = Post(2)
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateExisting_False() {
        service.add(Post( 1))
        service.add(Post( 1))
        service.add(Post( 1))
        val update = Post(45)
        val result = service.update(update)
        assertFalse(result)
    }

    @Test
    fun commentAdded() {
        val post = Post(1)
        val comment = Comments(postId = 2, text = "Text")
        val textExpected = "Text"

        service.add(post)
        service.createComment(comment)

        val result = comment.text
        assertEquals(textExpected, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val comment = Comments(postId = 3458)
        service.createComment(comment)

    }


}