package lingoassim.database

import sorm._

case class English(phrase: String, japanese: Japanese)
case class Japanese(phrase: String)

case class CommonWords private (word: String, languageCode: String)
object CommonWords {
  val languagesSet = java.util.Locale.getISOLanguages().toSet

  def create(word: String, languageCode: String): Option[CommonWords] = {
    if (languagesSet.contains(languageCode)) {
      Some(CommonWords(word, languageCode))
    } else {
      None
    }
  }
}

case class Score(username: String, score: Int)

object Db extends Instance(
  entities = Set(Entity[English](), Entity[Japanese]()),
  url = "jdbc:postgresql://localhost/lingolearner-dev?user=postgres&password=postgres",
  user = "",
  password = "",
  initMode = InitMode.DropAllCreate,
  poolSize = 12
) {
  Seed.seedDatabase()
}
