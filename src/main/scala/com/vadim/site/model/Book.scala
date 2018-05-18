package com.vadim.site.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty

@Document(collection = "book")
class Book extends Serializable {

  @Id
  @BeanProperty
  var id: ObjectId = _

  @BeanProperty
  var title: String = _

  @BeanProperty
  var prise: Int = _


}
