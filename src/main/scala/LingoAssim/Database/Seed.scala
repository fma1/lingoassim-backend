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
    ("ちょっと,待って,ください", "Please,wait,a,moment."),
    ("こんにちは", "Hello."),
    ("お元気,ですか", "How,are,you?"),
    ("元気,です", "I'm,fine."),
    ("お願いします", "Please."),
    ("ありがとう,ございます", "Thank,you,very,much."),
    ("どういたしまして", "You're,welcome."),
    ("さようなら", "Bye."),
    ("かんぱい", "Cheers!"),
    ("すみません", "Excuse,me."),
    ("失礼しました", "Sorry."),
    ("お名前,は,なん,ですか", "What,is,your,name?"),
    ("私の名前,は,トム,です", "My,name,is,Tom."),
    ("はじめまして", "Nice,to,meet,you."),
    ("どちらのご出身,ですか", "Where,are,you,from?"),
    ("ご趣味,は,なんですか", "What,are,your,hobbies?"),
    ("はい", "Yes"),
    ("いいえ", "No"),
    ("英語,を,話せますか", "Can,you,speak,English?"),
    ("分かりません", "I,don't,understand."),
    ("すこし,話せます", "I,can,speak,a,little."),
    ("英語,は,話せません", "I,can't,speak,English."),
    ("もっと,ゆっくり,話して,くれますか", "Could,you,speak,more,slowly?"),
    ("それ,を,書けますか", "Can,you,write,that?"),
    ("もう,一度,お願いします", "One,more,time, please."),
    ("これ,は,なんと,いいますか", "What,is,this,called?"),
    ("これ,は,どういう意味,ですか", "What,does,this,mean?"),
    ("今,何時,ですか", "What,time,is,it?"),
    ("五時,です", "It's,5:00."),
    ("いくら,ですか", "How,much,is,it?"),
    ("これ,が,欲しいです", "I,want,this,one."),
    ("クレジットカードで,払えますか", "Can,I,pay,with,my,credit,card?"),
    ("どうぞ", "Here,you,go."),
    ("それ,を,見せて,ください", "Could,I,see,that,one?"),
    ("始業時間,は,なん,ですか", "What,is,your,opening,time?"),
    ("もっと,小さいもの,が,ありますか", "Do,you,have,something,smaller?"),
    ("もっと,やすいもの,が,ありますか", "Do,you,have,something,cheaper?"),
    ("高すぎます", "This,is,too,expensive."),
    ("10ドル,を,払います", "I,will,pay,10,dollars."),
    ("両替所,は,どこ,ですか", "Where,can,I,exchange,money?"),
    ("往復切符,お願いします", "A,round-trip,ticket, please."),
    ("旅券,は,これです", "Here's,my,passport."),
    ("バス,は,いつ,着きますか", "When,does,the,bus,arrive?"),
    ("バス,は,いつ,出ますか", "When,does,the,bus,leave?"),
    ("プラットホーム,は,どちら,ですか", "Where,is,the,platform?"),
    ("次のバス,は,いつ,ですか", "When,is,the,next,bus?"),
    ("タクシ,を,呼びますか", "Shall,I,call,a,taxi?"),
    ("公園へ,行きたい,です", "I,want,to,go,to,the,park."),
    ("自転車,は,どこで,借りますか", "Where,can,I,borrow,a,bicycle?"),
    ("おすすめのレストラン,知りませんか", "Could,you,recommend,a,good,restaurant?"),
    ("おすすめは,なん,ですか", "What,would,you,recommend?"),
    ("メニュー,を,見ませんか", "Could,I,see,the,menu?"),
    ("お茶,お願いします", "Tea,please."),
    ("支払いたい,です。", "I,would,like,to,pay,the,bill."),
    ("おいしかった,です", "That,was,delicious."),
    ("注文したもの,と,違います", "This,isn't,what,I,ordered."),
    ("郵便局への道,は,なん,ですか", "How,do,I,get,to,the,post,office?"),
    ("右に,あります", "It's,on,the,right."),
    ("駅,は,どれほど,遠い,ですか", "How,far,is,the,train,station?"),
    ("もっとも近い,銀行,は,どこ,ですか", "Where,is,the,closest,bank?"),
    ("観光客のための情報,は,どこ,で,見つけますか", "Where,can,I,find,info,for,tourists?"),
    ("地図,が,ありますか", "Do,you,have,a,map?"),
    ("地図に,見せてくれますか", "Would,you,show,me,on,the,map?"),
    ("アメリカ大使館,は,どこ,ですか", "Where,is,the,American,embassy?"),
    ("入場料,は,いくら,ですか", "How,much,is,the,entrance,fee?"),
    ("あの建物,は,なん,ですか", "What,is,that,building"),
    ("映画館で,今上映中,は,なんですか", "What,is,showing,right,now,at,the,movie,theater?"),
    ("予約,が,あります", "I,have,a,reservation."),
    ("一人部屋,が,ありますか", "Do,you,have,a,one-person,room?"),
    ("テレビ,は,故障しています", "The,TV,is,broken."),
    ("助けて,ください！", "Please,help,me!"),
    ("お医者さん,が,要ります", "I,need,a,doctor."),
    ("携帯,を,使えますか", "Could,I,use,your,cellphone?"),
    ("警察,を,よんでください！", "Call,the,police!"),
    ("私,を,一人に,してください！", "Please,leave,me,alone!")
  )

  def createAndAssociatePair(japPhrase: String, engPhrase: String): Unit = {
    val _ = Db.save(English(engPhrase, Db.save(Japanese(japPhrase))))
  }

  def seedDatabase(): Unit = {
    println("Seeding database...")
    Db.transaction {
      //dummyWords.foreach({ case (word, languageCode) => CommonWords.create(word, languageCode).foreach(commonWord => Db.save(commonWord)) })
      dummyWords.foreach({ case (word, languageCode) => Db.save(CommonWord(word, languageCode)) })
      pairPhrases.foreach({ case (japPhrase, engPhrase) => createAndAssociatePair(japPhrase, engPhrase) })
    }
    println("Seeding successful!")
  }
}
