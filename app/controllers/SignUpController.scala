package controllers

import _root_.model.Accounts
import com.google.inject.Inject
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import services.CacheListService


class SignUpController @Inject()(service:CacheListService) extends Controller {

  def addAccount(lname: String, uname: String,
                 password: String, repassword: String, dateOfBitrh: String, gender: String) = {
    Action { implicit request =>

      val userData = Accounts(lname, uname, password, repassword, dateOfBitrh, gender)
      if (!service.check(userData.uname)) {
        service.addUser(userData)
        Ok(views.html.profilePage(userData))
      }
      else {
        Ok(views.html.formSignUp())
      }
    }

  }
}
