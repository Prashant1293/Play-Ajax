package controllers

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}
import services.CacheListService


class SignInController@Inject()(service:CacheListService) extends Controller{

  def signInForm(uname:String)=Action{ implicit request =>
    val flag:Boolean=service.check(uname)
    if(flag){
    val usedData=service.userData(uname).get
    Ok(views.html.profilePage(usedData))}
    else Ok(views.html.main())
  }

}
