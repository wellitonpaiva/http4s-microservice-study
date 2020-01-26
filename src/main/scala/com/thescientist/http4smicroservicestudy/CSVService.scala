package com.thescientist.http4smicroservicestudy

import scala.io.Source

class CSVService {

  //"NHSHC_CCG_AgeSex.csv"
  def readFile(filePath: String): Seq[Row] = {
    val bufferedSource = Source.fromFile(filePath)
    bufferedSource.getLines()
      .map(line => line.split(","))
      .map(strings => Row(strings(0), strings(1), strings(2), strings(3), strings(4), strings(5), strings(6), strings(7), strings(8), strings(9), strings(10)))
      .toSeq
  }
}

case class Row(Year: String,
               coHort: String,
               ccgCode: String,
               ccgOnsCode: String,
               ccgName: String,
               stpOnsCode: String,
               regionalLocalOfficeOnsCode: String,
               regionOnsCode: String,
               sex: String,
               ageBand: String,
               countOfPatients: String)
