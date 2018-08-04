package controllers

import javax.inject._

import com.google.gson.Gson
import play.api.mvc._

import scalaj.http._

case class Coupon(_id: CouponId, name: String, desc: String,image: String)

case class CouponId($oid: String)

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  private val URL =  "http://localhost:9000/coupons"
  private val gFormat = new Gson

//Getting the coupon list
  def index() = Action { implicit request: Request[AnyContent] =>
    val JsonPage = Http(URL).asString
    val couponList = gFormat.fromJson(JsonPage.body, classOf[Array[Coupon]])
    Ok(views.html.index(couponList))
  }

//Show Specific one coupon
  def show(id:String) = Action { implicit request: Request[AnyContent] =>
    val JsonPage = Http(URL+"/"+id).asString
    val couponList = gFormat.fromJson(JsonPage.body, classOf[Array[Coupon]])
    Ok(views.html.promo(couponList(0)))
  }
}
