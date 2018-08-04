package controllers

import javax.inject._

import play.api.libs.json._
import play.api.mvc._
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.play.json._

import scala.concurrent.ExecutionContext.Implicits.global


@Singleton
  class CouponController @Inject() (val reactiveMongoApi: ReactiveMongoApi)
      extends Controller with MongoController with ReactiveMongoComponents {

        def mongo = new mongohandller.MongoHand(reactiveMongoApi)

        def index = Action.async { implicit request => mongo.loadJSON().map(coupons => Ok(Json.toJson(coupons)))}

        def show(id:String) = Action.async { implicit request => mongo.loadDoc(id).map(coupons => Ok(Json.toJson(coupons)))}
}
