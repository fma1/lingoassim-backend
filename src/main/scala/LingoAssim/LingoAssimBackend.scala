package lingoassim

import scala.collection.JavaConverters._
import scala.collection.mutable.{Set, ListBuffer}
import scala.util.Random

import io.finch._
import io.finch.circe.jacksonSerializer._
import io.circe.generic.auto._

import com.twitter.finagle.Http
import com.twitter.util.Await

import java.io.FileInputStream

import lingoassim.database._
import sorm._

final case class SingleQuestion(question: String, answer: String, jumbledParts: List[String])

object LingoAssimBackend extends App {
  private val MAX_ID = 76;
  private val rand = Random

  private val helloRoute: Endpoint[String] = get("hello") {
    Ok("Hello World!")
  }

  private val questionListEndpoint: Endpoint[List[SingleQuestion]] = get("questionList") {
    val chosenIds: List[Int] = rand.shuffle(1 to MAX_ID toList).take(10)

    val dummyWords = Db.query[CommonWord].fetch()
    val englishWords = dummyWords.filter(_.languageCode == "en").map(_.word)
    val japaneseWords = dummyWords.filter(_.languageCode == "ja").map(_.word)

    Ok(chosenIds.map(curId => {
      val englishInstance = Db.fetchById[English](curId)
      val engPhrase = englishInstance.phrase
      val japPhrase = englishInstance.japanese.phrase

      // We have the answer be in Japanese
      // and presented text in English
      // if coinFlip is equal to 1
      if (rand.nextBoolean()) {
        // Remove all commas for question and answer
        // For jumbledParts, split all parts of japPhrase
        // with comma as delimiter and add that to 5 random
        // japanese words, and then shuffle that
        // concatenated List
        SingleQuestion(
          engPhrase.replaceAll(",", " "),
          japPhrase.replaceAll(",", ""),
          rand.shuffle(japPhrase.split(",").toList ++
            rand.shuffle(japaneseWords).take(5))
        )
      } else {
        SingleQuestion(
          japPhrase.replaceAll(",", " "),
          engPhrase.replaceAll(",", ""),
          rand.shuffle(engPhrase.split(",").toList ++
            rand.shuffle(englishWords).take(5))
        )
      }
    }))
  }

  val _ = Db
  println("Server up and running on http://localhost:8080")
  Await.ready(Http.server.serve(":8080", questionListEndpoint.toServiceAs[Application.Json]))
}
