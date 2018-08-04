package mongohandller

import play.api.libs.json.{JsObject, Json}
import play.modules.reactivemongo.ReactiveMongoApi
import play.modules.reactivemongo.json._
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.ReadPreference

import scala.concurrent.{ExecutionContext, Future}

trait Mongo {
  def loadJSON()(implicit ec: ExecutionContext): Future[List[JsObject]]
  def loadDoc(id: String)(implicit ec: ExecutionContext): Future[List[JsObject]]
}

class MongoHand(reactiveMongoApi: ReactiveMongoApi) extends Mongo {

  def collection = reactiveMongoApi.db.collection[JSONCollection]("Coupons")

  def loadJSON()(implicit ec: ExecutionContext): Future[List[JsObject]] =collection.find(Json.obj()).cursor[JsObject](ReadPreference.Primary).collect[List]()

  def loadDoc(id: String)(implicit ec: ExecutionContext): Future[List[JsObject]] = collection.find(Json.obj("_id" -> Json.obj("$oid" -> id))).cursor[JsObject](ReadPreference.Primary).collect[List]()
}
