package com.vadim.site.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import sun.util.calendar.BaseCalendar.Date

import scala.beans.BeanProperty

@Document
class Post extends Serializable {

  @Id
  @BeanProperty
  var id: String = _

  @BeanProperty
  var author: String = _

  @BeanProperty
  var text: String = _

  @BeanProperty
  var date: Date = _

  @BeanProperty
  var visiable: Boolean = _
}
