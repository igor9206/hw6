object WallService {
    private var posts = emptyArray<Post>()
    private var uniqueId: Int = 0

    fun add(post: Post): Post {
        uniqueId++
        posts += post.copy(id = uniqueId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postAr) in posts.withIndex()) {
            if (post.id == postAr.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun likeById(id: Int) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                val countLike = (posts[index].likes?.count ?: 0) + 1
                posts[index] = post.copy(likes = Likes(count = countLike))
            }
        }
    }

    fun printAr() {
        for (post in posts) {
            println(post)
        }
    }

    fun clear() {
        posts = emptyArray()
        uniqueId = 0
    }
}

data class Post(
    val id: Int = 0, // идентификатор записи
    val ownerId: Int = 1, // идентификатор владельца стены, на которой размещена запись
    val fromId: Int = 2, // идентификатор автора записи
    val createdBy: Int = 3, // идентификатор администратора который опубликовал запись
    val date: Int, // время публикации
    val text: String, // текст записи
    val replyOwnerId: Int = 4, // идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: Int = 5, // идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean = true, // tru, если запись создана с опцией "Только для друзей"
    val comments: Comments, // Информация о комментариях к записи
    val copyright: Copyright, // Источник материала
    val likes: Likes, // Информация о лайках к записи
    val repost: Repost?, // Информация о репостах записи («Рассказать друзьям»)
    val views: Views, // Информация о просмотрах записи
    val postType: String = "post", // Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val postSource: PostSource?, // Поле возвращается только для Standalone-приложений с ключом доступа, полученным в Implicit Flow.
    val geo: Geo, // Информация о местоположении
    val signerId: Int = 0, // идентификатор автора, если запись опубликована от сообщества и подписана пользователем
    val copyHistory: Any = 0, // Массив, содержащий историю репостов для записи. Возвращается только в том случае, если запись является репостом.
    val canPin: Boolean = true, // Информация о том, может ли текущий пользователь закрепить запись
    val canDelete: Boolean = false, // Информация о том, может ли текущий пользователь удалить запись
    val canEdit: Boolean = true, // Информация о том, может ли текущий пользователь редактировать запись
    val isPinned: Boolean = false, // информация о том, что запись закреплена
    val markedAsAds: Boolean = true, // информация о том, содержит ли запись отметку "реклама"
    val isFavorite: Boolean = true, // true, если объект добавлен в закладку у текущего пользователя
    val donut: Donut?, // Информация о записи VK Donut
    val postponedId: Boolean = false, // Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
    val attachment: Array<Attachment> = emptyArray()
)

data class Comments(
    val count: Int = 0, // количество комментариев
    val canPost: Boolean = true, // может ли текущий пользователь комментировать запись
    val groupsCanPost: Boolean = true, // могут ли сообщества комментировать запись
    val canClose: Boolean = false, // может ли текущий пользователь закрыть комментарии к записи
    val canOpen: Boolean = false// может ли текущий пользователь открыть комментарии к записи
)

data class Copyright( // источник материала, объект с полями
    val id: Int = 0,
    val link: String = "mysite.ru",
    val name: String = "test",
    val type: String = "test"
)

data class Likes(
    val count: Int = 0, // число лайков
    val userLikes: Boolean = true, // наличие отметки "Мне нравится" от текущего пользователя
    val canLike: Boolean = true, // может ли текущий пользователь поставить отметку "Мне нравится"
    val canPublish: Boolean = true // может ли текущий пользователь сделать репост записи
)

data class Repost(
    val count: Int = 0, // число пользователей скопировавших запись
    val userReposted: Boolean = false// наличие репоста от текущего пользователя
)

data class Views(
    val count: Int = 0 // число просмотров записи
)

data class PostSource(
    val type: String = "vk", // Тип источника. Возможные значения: vk, widget, API, rss, sms
    val platform: String = "android", // Название платформы, если оно доступно. Возможные значения: android, iphone, wphone
    val data: String = "profile_activity", // Тип действия (только для type = vk или widget). Возможные значения: profile_activity, profile_photo, comments, like, poll
    val url: String = "mysite.com", // URL ресурса, с которого была опубликована запись
)

data class Geo(
    val type: String = "city", // тип места
    val coordinates: String = "45645412", // координаты места
    val place: Place // описание места (если оно добавлено).
)

data class Place(
    val id: Int = 0, // идентификатор места
    val title: String = "Omsk", // название места
    val latitude: Int = 4564, // широта
    val longitude: Int = 5412, // долгота
    val created: Int = 24052023, // дата создания места
    val icon: String = "www.icon.com", // иконка места, URL изображения
    val checkins: Int = 0, // число отметок в этом месте
    val updated: Int = 24052023, // дата обновления места
    val type: Int = 1, // тип места
    val country: Int = 5, // идентификатор страны
    val city: Int = 55, // идентификатор города
    val address: String = "Lenin street)"// адрес места
)

data class Donut(
    val isDonut: Boolean = false, // запись доступна только платным подписчикам
    val paidDuration: Int = 60, // время, в течении которого запись будет доступна только платным подписчикам
    val placeholder: Placeholder, // заглушка для пользователей, которые не оформили подписку
    val canPublishFreeCopy: Boolean = false, // можно ли открыть запись для всех пользователей, а не только для подписчиков
    val editMode: String = "all" // какие значения VK Donut можно изменить в записи: all - всю, duration - время, в течении которого запись будет доступна только платным подписчикам
)

data class Placeholder(
    val msg: String = "Только для подписчиков"
)