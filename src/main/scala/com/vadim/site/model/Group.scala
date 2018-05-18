package com.vadim.site.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty

@Document(collection = "group")
class Group {

  @Id
  @BeanProperty
  var id: ObjectId = _

  @BeanProperty
  var name: String = _

}
