package com.techun.twitterui.utils

import com.techun.twitterui.domain.*
import kotlin.random.Random

object FakeData {
    //Search
    val trendingListData = listOf(
        TrendModel(
            0,
            "Trending in Guatemala",
            "San Lucas",
            null
        ),
        TrendModel(
            0,
            "Trending in Guatemala",
            "#RatchetPS5",
            "1,506 Tweets"
        ),
        TrendModel(
            0,
            "Trending in Guatemala",
            "Portillo",
            "1,451 Tweets"
        ),
        TrendModel(
            0,
            "Gaming Trending",
            "Fable",
            "2,155 Tweets"
        ),
        TrendModel(
            0,
            "Trending in Guatemala",
            "Xela",
            "1,499 Tweets"
        )
    )
    val whoToFollowListData = listOf(
        WhoToFollowModel(
            0,
            "Klax",
            "@Karla",
            "Xboser follows",
            "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cHJvZmlsZSUyMHBob3RvfGVufDB8fDB8fA%3D%3D&w=1000&q=80"
        ),
        WhoToFollowModel(
            0,
            "Xboser",
            "@Drake",
            "Smartemboser follows",
            "https://images.unsplash.com/photo-1618641986557-1ecd230959aa?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aW5zdGFncmFtJTIwcHJvZmlsZXxlbnwwfHwwfHw%3D&w=1000&q=80"
        ),
        WhoToFollowModel(
            0,
            "Julex",
            "@Julia98",
            "Carmen follows",
            "https://www.rd.com/wp-content/uploads/2017/09/01-shutterstock_476340928-Irina-Bg.jpg?fit=640,427"
        ),
        WhoToFollowModel(
            0,
            "Dannes",
            "@DanielaE",
            "Julex follows",
            "https://img.freepik.com/free-photo/half-profile-image-beautiful-young-woman-with-bob-hairdo-posing-gazing-with-eyes-full-reproach-suspicion-human-facial-expressions-emotions-reaction-feelings_343059-4660.jpg?w=2000"

        ),
        WhoToFollowModel(
            0,
            "Carmen",
            "@Carmen98",
            "Dannes follows",
            "https://images.unsplash.com/photo-1614283233556-f35b0c801ef1?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjh8fHByb2ZpbGV8ZW58MHx8MHx8&w=1000&q=80"
        )
    )
    val RockListData = listOf(
        TweetModel(
            0,
            1,
            "Smartemboser",
            "@Armando",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t39.30808-6/275484369_146707454487942_4691892398623405253_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=ZNpDKAsO5nMAX-QwYUE&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT_HkbgxS1Gj40GosmXs8SRXMef7VgwgE3diHYpqVL2Qbw&oe=62A6BE62",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "I have a TextView that I want to limit characters of it. Actually, I can do this but the thing that I'm looking for is how to add three dots (...) at the end of string. This one shows the text has continue. This is my XML but there is no dots although it limit my text.",
            0,
            "https://catalyst-ca.net/wp-content/uploads/2021/12/top-programing-languages.jpeg",
            false
        ),
        TweetModel(
            0,
            1,
            "Daviixo",
            "@David",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t1.18169-9/10175985_10151898488311706_416913463_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=28n1k_d8UIUAX8fP98k&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT-K00Z8T08t5LSUMJITUg8QVCe8sKUBVCDERZNkNjF5tQ&oe=62C7FBED",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "Python es un lenguaje de alto nivel de programación interpretado cuya filosofía hace hincapié en la legibilidad de su código, se utiliza para desarrollar aplicaciones de todo tipo, ejemplos: Instagram, Netflix, Spotify, Panda 3D, entre otros.\u200B",
            0,
            null,
            false
        ),
        TweetModel(
            0,
            1,
            "PtOte",
            "@Tote",
            "https://scontent.fgua1-2.fna.fbcdn.net/v/t1.6435-9/32289759_10210208347519799_8494273129013575680_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=VTV0bR_DG3UAX_4h36w&_nc_ht=scontent.fgua1-2.fna&oh=00_AT-Bf_PGqix_m-TdHqNWApt0t9ATDUna8AoWR4Wrl5tgIA&oe=62C61B8B",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "La ingeniería eléctrica es el campo de la ingeniería que se ocupa del estudio y la aplicación de la electricidad, electromagnetismo, electromecánica y la electrónica a sistemas eléctricos de potencia.",
            0,
            "https://images5.content-hci.com/commimg/myhotcourses/blog-inline/myhc_32056.jpg",
            false
        ),
        TweetModel(
            0,
            1,
            "Probner",
            "@Brodner",
            null,
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "Hello World",
            0,
            null,
            false
        ),
        TweetModel(
            0,
            1,
            "Epic Games",
            "@epic_games",
            "https://pbs.twimg.com/profile_images/1527302450272579585/DzNWMvFI_400x400.jpg",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "Epic Games, Inc. es una empresa de desarrollo de videojuegos estadounidense con sede en Cary, ahora asociada con la compañía china Tencent Holdings.​",
            0,
            "https://i.blogs.es/a4d480/epic-games-store/1366_521.jpg",
            false
        ),
        TweetModel(
            0,
            1,
            "Botman",
            "@botman",
            null,
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "Un robot es una entidad virtual o mecánica artificial. En la práctica, esto es por lo general un sistema electromecánico que, por su apariencia o sus movimientos, ofrece la sensación de tener un propósito propio. ",
            0,
            null,
            false
        ),
        TweetModel(
            0,
            1,
            "Netflix Latinoamérica",
            "@NetflixLAT",
            "https://pbs.twimg.com/profile_images/1322949452047491074/7pBE_7_i_400x400.jpg",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "– Junio, sorpréndeme. 🙄\n– Qué bonito tu tatuaje, ¿qué significa? 🙄\n– Mijo, ¿Para cuándo un nieto? 🙄🙄🙄",
            0,
            "https://pbs.twimg.com/media/FUctQF5WUAAlvIz?format=jpg&name=medium",
            false
        )
    )

    //Audio
    val audioListData = listOf(
        SpaceModel(
            0,
            "Tomorrow ata 1:00 PM",
            "How long should a relationship last before marriage? #Lifeissues",
            "American footbal NCAA Football",
            null,
            "ILLZ NFT",
            "NFT lover || Crypto King Tech genius|| Buying BTC ETH NFT SHIB."
        ),
        SpaceModel(
            0,
            "Tomorrow ata 1:00 PM",
            "Live commitment with IPC",
            "American footbal NCAA Football",
            null,
            "Josh",
            "An official Twitter account of 'LonelyPop' by @bushrobins y @OxSutdio | Join our discord."
        ),
        SpaceModel(
            0,
            "Tomorrow ata 1:00 PM",
            "Tell us a petty reason you refused to date someone? #NaijaConversations",
            "American footbal NCAA Football",
            null,
            "Naija",
            "An official Twitter account of 'LonelyPop' by @bushrobins y @OxSutdio | Join our discord."
        )
    )

    //Messages
    val messageListData = listOf(
        MessageModel(
            0,
            "Daviixo",
            "@David",
            "Python es un lenguaje de alto nivel de programación interpretado cuya filosofía hace hincapié en la legibilidad de su código, se utiliza para desarrollar aplicaciones de todo tipo, ejemplos: Instagram, Netflix, Spotify, Panda 3D, entre otros.",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t1.18169-9/10175985_10151898488311706_416913463_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=28n1k_d8UIUAX8fP98k&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT-K00Z8T08t5LSUMJITUg8QVCe8sKUBVCDERZNkNjF5tQ&oe=62C7FBED"
        ),
        MessageModel(
            0,
            "PtOte",
            "@Tote",
            "La ingeniería eléctrica es el campo de la ingeniería que se ocupa del estudio y la aplicación de la electricidad, electromagnetismo, electromecánica y la electrónica a sistemas eléctricos de potencia.",
            "https://scontent.fgua1-2.fna.fbcdn.net/v/t1.6435-9/32289759_10210208347519799_8494273129013575680_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=VTV0bR_DG3UAX_4h36w&_nc_ht=scontent.fgua1-2.fna&oh=00_AT-Bf_PGqix_m-TdHqNWApt0t9ATDUna8AoWR4Wrl5tgIA&oe=62C61B8B",
        ),
        MessageModel(
            0, "Probner",
            "@Brodner",
            "Hello World",
            null
        )
    )

    //Notifications
    val notificationListData = listOf(
        NotificartionModel(
            0,
            "Daviixo",
            "WTF!",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t1.18169-9/10175985_10151898488311706_416913463_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=28n1k_d8UIUAX8fP98k&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT-K00Z8T08t5LSUMJITUg8QVCe8sKUBVCDERZNkNjF5tQ&oe=62C7FBED",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        ), NotificartionModel(
            0,
            "Daviixo",
            "Kjjjjjj",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t1.18169-9/10175985_10151898488311706_416913463_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=28n1k_d8UIUAX8fP98k&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT-K00Z8T08t5LSUMJITUg8QVCe8sKUBVCDERZNkNjF5tQ&oe=62C7FBED",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        ), NotificartionModel(
            0,
            "Netflix Latinoamérica",
            "Viaja a través de los recuerdos de Once y revive sus escenas más icónicas en Regreso a Hawkins, la ÚLTIMA parada de #StrangerFest. Aparta tu lugar en: http://strangerfest.mx",
            "https://pbs.twimg.com/profile_images/1322949452047491074/7pBE_7_i_400x400.jpg",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        ), NotificartionModel(
            0,
            "Netflix Latinoamérica",
            "😘",
            "https://pbs.twimg.com/profile_images/1322949452047491074/7pBE_7_i_400x400.jpg",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        ), NotificartionModel(
            0,
            "Pt0te",
            "https://pic.twitter.com/ejoR4UbqU3",
            "https://scontent.fgua1-2.fna.fbcdn.net/v/t1.6435-9/32289759_10210208347519799_8494273129013575680_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=VTV0bR_DG3UAX_4h36w&_nc_ht=scontent.fgua1-2.fna&oh=00_AT-Bf_PGqix_m-TdHqNWApt0t9ATDUna8AoWR4Wrl5tgIA&oe=62C61B8B",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        ), NotificartionModel(
            0,
            "Epic Games",
            "https://pic.twitter.com/ejoR4UbqU3",
            "https://pbs.twimg.com/profile_images/1527302450272579585/DzNWMvFI_400x400.jpg",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        )
    )

    //Monetization
    val monetizationOptionsListData = listOf("Ticketed Saces", "Super Follows")
    val monetizationGetHelpListData = listOf("Help Center")

    //Topics
    val topicsListData = listOf(
        TopicModel(0, "BLACKPINK", "K-pop group"),
        TopicModel(0, "Dua Lipa", "Pop musician"),
        TopicModel(0, "Rock", "Music genre"),
        TopicModel(0, "Technology", "All about technology")
    )
    val suggestedTopicsListData = listOf(
        "Animation",
        "Art",
        "Astrology",
        "Books",
        "Comics",
        "Dance",
        "Horoscope",
        "Sci-fi and fantasy",
        "Writing", "Accounting",
        "Advertising",
        "Education",
        "Fields of study",
        "Marketing"
    )

    //Lists
    val discoverListData = listOf(
        DiscoverModel(0, "Test1", "test1", null, "Smartemboser", "@ArmandoS98"),
        DiscoverModel(0, "Test1", "test1", null, "Smartemboser", "@ArmandoS98"),
        DiscoverModel(0, "Test1", "test1", null, "Smartemboser", "@ArmandoS98")
    )
}