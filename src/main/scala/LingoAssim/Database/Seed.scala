package lingoassim.database

import sorm._
import lingoassim.database._

object Seed {
  val dummyWords = List(
    ("する", "ja"),
    ("に", "ja"),
    ("いる", "ja"),
    ("は", "ja"),
    ("ろく", "ja"),
    ("こと", "ja"),
    ("なる", "ja"),
    ("にじょう", "ja"),
    ("し", "ja"),
    ("はち", "ja"),
    ("なれる", "ja"),
    ("ひゃく", "ja"),
    ("られる", "ja"),
    ("いう", "ja"),
    ("いえる", "ja"),
    ("the", "en"),
    ("be", "en"),
    ("to", "en"),
    ("of", "en"),
    ("and", "en"),
    ("a", "en"),
    ("in", "en"),
    ("that", "en"),
    ("have", "en"),
    ("I", "en"),
    ("it", "en"),
    ("for", "en"),
    ("not", "en"),
    ("on", "en"),
    ("with", "en")
  )

  val pairPhrases = List(
    ("ちょっと待ってください", "Please wait a moment."),
    ("こんにちは", "Hello."),
    ("お元気ですか", "How are you?"),
    ("元気です", "I'm fine."),
    ("お願いします", "Please."),
    ("ありがとうございます", "Thank you very much."),
    ("どういたしまして", "You're welcome."),
    ("さようなら", "Bye."),
    ("かんぱい", "Cheers!"),
    ("すみません", "Excuse me."),
    ("失礼しました", "Sorry."),
    ("お名前はなんですか", "What is your name?"),
    ("私の名前はトムです", "My name is Tom."),
    ("はじめまして", "Nice to meet you."),
    ("どちらのご出身どこですか", "Where are you from?"),
    ("ご趣味はなんですか", "What are your hobbies?"),
    ("はい", "Yes"),
    ("いいえ", "No"),
    ("英語を話せますか", "Can you speak English?"),
    ("分かりません", "I don't understand."),
    ("すこし話せます", "I can speak a little."),
    ("英語は話せません", "I can't speak English."),
    ("もっとゆっくり話してくれますか", "Could you speak more slowly?"),
    ("それを書けますか", "Can you write that?"),
    ("もう一度お願いします", "One more time, please."),
    ("これはなんといいますか", "What is this called?"),
    ("これはどういう意味ですか", "What does this mean?"),
    ("今何時ですか", "What time is it?"),
    ("五時です", "It's 5:00."),
    ("いくらですか", "How much is it?"),
    ("これが欲しいです", "I want this."),
    ("クレジットカードで払えますか", "Can I pay with my credit card?"),
    ("どうぞ", "Here you go."),
    ("それを見せてください", "Could I see that one?"),
    ("始業時間はなんですか", "What is your opening time?"),
    ("もっと小さいものがありますか", "Do you have something smaller?"),
    ("もっとやすいものがありますか", "Do you have something cheaper?"),
    ("高すぎます", "This is too expensive."),
    ("10ドルを払います", "I will pay 10 dollars."),
    ("両替所はどこですか", "Where can I exchange money?"),
    ("往復切符お願いします", "A round-trip ticket, please."),
    ("旅券はこれです", "Here's my passport."),
    ("バスはいつ着きますか", "When does the bus arrive?"),
    ("バスはいつ出ますか", "When does the bus leave?"),
    ("プラットホームはどちらですか", "Where is the platform?"),
    ("次のバスはいつですか", "When is the next bus?"),
    ("タクシを呼びますか", "Shall I call a taxi?"),
    ("公園へ行きたいです", "I want to go to the park."),
    ("自転車はどこで借りますか", "Where can I borrow a bicycle?"),
    ("おすすめのレストラン知りませんか", "Could you recommend a good restaurant?"),
    ("おすすめはなんですか", "What would you recommend?"),
    ("メニューを見ませんか", "Could I see the menu?"),
    ("お茶お願いします", "Tea please."),
    ("支払いたいです。", "I would like to pay the bill."),
    ("おいしかったです", "That was delicious."),
    ("注文したものと違います", "This isn't what I ordered."),
    ("郵便局への道はなんですか", "How do I get to the post office?"),
    ("右にあります", "It's on the right."),
    ("駅はどれほど遠いですか", "How far is the train station?"),
    ("もっと近い銀行はどこですか", "Where is the closest bank?"),
    ("観光客のための情報はどこで見つけますか", "Where can I find info for tourists?"),
    ("地図がありますか", "Do you have a map?"),
    ("地図に見せてくれますか", "Would you show me on the map?"),
    ("アメリカ大使館はどこですか", "Where is the American embassy?"),
    ("入場料はいくらですか", "How much is the entrance fee?"),
    ("あの建物はなんですか", "What is that building"),
    ("映画館で今上映中はなんですか", "What is showing right now at the movie theater?"),
    ("予約があります", "I have a reservation."),
    ("一人部屋がありますか", "Do you have a one-person room?"),
    ("テレビは故障しています", "The TV is broken."),
    ("助けてください！", "Please help me!"),
    ("お医者さんが要ります", "I need a doctor."),
    ("携帯を使えますか", "Could I use your cellphone?"),
    ("警察をよんでください！", "Call the police!"),
    ("私を一人にしてください！", "Please leave me alone!")
  )

  def createAndAssociatePair(japPhrase: String, engPhrase: String): Unit = {
    val _ = Db.save(English(engPhrase, Db.save(Japanese(japPhrase))))
  }

  def seedDatabase(): Unit = {
    Db.transaction {
      dummyWords.foreach({ case (word, languageCode) => CommonWords.create(word, languageCode).foreach(commonWord => Db.save(commonWord)) })
      pairPhrases.foreach({ case (japPhrase, engPhrase) => createAndAssociatePair(japPhrase, engPhrase) })
    }
  }
}
