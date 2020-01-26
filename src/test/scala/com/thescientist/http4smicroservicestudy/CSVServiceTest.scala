package com.thescientist.http4smicroservicestudy

import  org.scalatest.flatspec._
import org.scalatest.matchers.should._

class CSVServiceTest extends AnyFlatSpec with Matchers {

  "A CSV Service " should "get real all lines of the CSV" in {
    val service = new CSVService
    val files = service.readFile("src/test/resources/NHSHC_CCG_AgeSex.csv")
    files should be
    new Row("2013-14",
      "NON-ATTENDEE",
      "09L",
      "E38000054",
      "NHS East Surrey CCG",
      "E54000033",
      "E39000042",
      "E40000005",
      "Male",
      "65-69",
      "11"
    )
  }

}
