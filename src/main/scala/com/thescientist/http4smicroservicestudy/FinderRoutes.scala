package com.thescientist.http4smicroservicestudy

import cats.effect.{Sync, implicits}
import io.circe.{Encoder, Json}
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import io.circe.generic.auto._
import org.http4s.circe.CirceEntityEncoder._

object FinderRoutes {

  def routes[F[_]: Sync](): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F]{}
    import dsl._


    HttpRoutes.of[F] {
      case GET -> Root =>
        Ok("Welcome")
      case GET -> Root / "data" =>
        Ok(new CSVService().readFile("/NHSHC_CCG_AgeSex.csv"))
    }
  }
}