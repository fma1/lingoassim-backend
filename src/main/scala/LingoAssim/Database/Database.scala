package lingoassim.database

import sorm._

case class English(phrase: String, japanese: Japanese)
case class Japanese(phrase: String)
case class CommonWord(word: String, languageCode: String)
case class Score(username: String, score: Int)

object Db extends Instance(
  entities = Set(Entity[English](), Entity[Japanese](), Entity[CommonWord](), Entity[Score]()),
  url = "jdbc:postgresql://localhost/lingolearner-dev?user=postgres&password=postgres",
  user = "",
  password = "",
  initMode = InitMode.DropAllCreate,
  poolSize = 12
) {
  Seed.seedDatabase()
}
