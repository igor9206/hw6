import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val post = Post(ownerId = 1, fromId = 1, date = 22052023, text = "first", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val result = WallService.add(post)
        assertNotNull(result.id)
    }

    @Test
    fun updateCorrectId() {
        val post1 = Post(ownerId = 1, fromId = 1, date = 22052023, text = "first", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val post2 = Post(ownerId = 2, fromId = 2, date = 22052023, text = "second", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val post3 = Post(ownerId = 3, fromId = 3, date = 22052023, text = "thrid", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val newPost3 = Post(id = 3, ownerId = 3, fromId = 3, date = 22052023, text = "corrected post", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)

        val result = WallService.update(newPost3)
        assertTrue(result)
    }

    @Test
    fun updateUncorrectedId() {
        val post1 = Post(ownerId = 1, fromId = 1, date = 22052023, text = "first", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val post2 = Post(ownerId = 2, fromId = 2, date = 22052023, text = "second", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val post3 = Post(ownerId = 3, fromId = 3, date = 22052023, text = "thrid", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val newPost3 = Post(id = 4, ownerId = 3, fromId = 3, date = 22052023, text = "corrected post", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)

        val result = WallService.update(newPost3)
        assertFalse(result)
    }

    @Test
    fun createCommentCorrect() {
        val post1 = Post(ownerId = 1, fromId = 1, date = 22052023, text = "first", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val post2 = Post(ownerId = 2, fromId = 2, date = 22052023, text = "second", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val post3 = Post(ownerId = 3, fromId = 3, date = 22052023, text = "thrid", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())

        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)

        val comment = Comment(1, 3,5062023,"my comment1", 1, 3)
        val result = WallService.createComment(1, comment)

        assertEquals(comment,result)
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentUnCorrect() {
        val post1 = Post(ownerId = 1, fromId = 1, date = 22052023, text = "first", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val post2 = Post(ownerId = 2, fromId = 2, date = 22052023, text = "second", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())
        val post3 = Post(ownerId = 3, fromId = 3, date = 22052023, text = "thrid", likes = Likes(), comments = Comments(), geo = Geo(place = Place()),
            copyright = Copyright(), donut = Donut(placeholder = Placeholder()), postSource = PostSource(), repost = Repost(),
            views = Views())

        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)

        val comment = Comment(1, 3,5062023,"my comment1", 1, 3)
        val result = WallService.createComment(5, comment)

    }
}