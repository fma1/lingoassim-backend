package lingoassim

import scala.collection.JavaConverters._

import io.finch._
import com.twitter.finagle.Http
import com.twitter.util.Await

import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream

case class English(phrase: String, japanese: Japanese)
case class Japanese(phrase: String)

object LingoAssimBackend extends App {
  val api: Endpoint[String] = get("hello") {
    Ok("Hello World!")
  }

  println("Server up and running on http://localhost:8080")
  Await.ready(Http.server.serve(":8080", api.toServiceAs[Text.Plain]))
}
