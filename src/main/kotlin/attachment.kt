interface Attachment {
    val type: String
}

class PhotoAttachment(
    override val type: String = "Photo",
    val photo: Photo
) : Attachment {

}

class AudioAttachment(
    override val type: String = "Audio",
    val audio: Audio
) : Attachment {

}

class VideoAttachment(
    override val type: String = "Video",
    val video: Video
) : Attachment {

}

class FileAttachment(
    override val type: String = "File",
    val file: File
) : Attachment {

}

class PresentAttachment(
    override val type: String = "Present",
    val present: Present
) : Attachment {

}

class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<Any>,
    val width: Int,
    val height: Int
)

class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val date: Int,
    val noSearch: Boolean,
    val isHq: Boolean
)

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val image: Array<Any>,
    val firstFrame: Array<Any>,
    val date: Int,
    val addingDate: Int,
    val views: Int,
    val localViews: Int,
    val comments: String,
    val player: String,
    val platform: String,
    val canAdd: Boolean,
    val isPrivate: Boolean,
    val accessKey: String,
    val processing: Boolean,
    val isFavorite: Boolean,
    val canComment: Boolean,
    val canEdit: Boolean,
    val canLike: Boolean,
    val canRepost: Boolean,
    val canSubscribe: Boolean,
    val canAddToFaves: Boolean,
    val canAttachLink: Boolean,
    val width: Int,
    val height: Int,
    val userId: Int,
    val converting: Boolean,
    val added: Boolean,
    val isSubscribe: Boolean,
    val repeat: Boolean,
    val typeVideo: String,
    val balance: Int,
    val liveStatus: String,
    val live: Boolean,
    val upcoming: Int,
    val spectators: Int,
    val likes: Likes,
    val reposts: Repost
)

class File(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val typeFile: Int,
    val preview: Preview
)

class Present(
    val id: Int,
    val thumb256: String,
    val thumb96: String,
    val thumb48: String
)

data class Preview(
    val photo: Any,
    val graffiti: Any,
    val audioMessage: Any
)