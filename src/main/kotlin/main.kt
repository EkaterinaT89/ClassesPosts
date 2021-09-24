import java.util.*

fun IntRange.random() =
    Random().nextInt((endInclusive + 1) - start) + start

var countRandom: Int = (0..1000).random()
var countCommentsRandom: Int = (0..500).random()
var paidDurationRandom: Int = (0..600).random()
var copyrightIdRandom: Int = (0..1000).random()
var countLikesRandom: Int = (0..5000).random()
val reportsRandom: Int = (0..400).random()

val comment = Comments(countCommentsRandom, true, true, false, true)
val views = Views(countRandom)
val donut = Donut(true, paidDurationRandom, "Заглушка", true, "Информация о донате")
val copyright = Copyright(copyrightIdRandom, "Ссылка", "John", "Close")
val likes = Likes(countLikesRandom, true, true, false)
val reports = Reports(reportsRandom, false)


fun main () {

    val myPost = Post(
        1,
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
        1
    )

    val myPost2 = Post(
        1,
        3,
        1,
        1,
        1,
        "Текст поста 2",
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
        1

    )

    val myPost3 = Post(
        1,
        3,
        1,
        1,
        1,
        "Текст поста 3",
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
        1

    )
    val myPost4 = Post(
        25,
        3,
        1,
        1,
        1,
        "Текст поста 4",
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
        1

    )

    val service = WallService
    service.add(myPost)
    service.add(myPost2)
    service.add(myPost3)

    service.print()

//    service.update(myPost4)


}

