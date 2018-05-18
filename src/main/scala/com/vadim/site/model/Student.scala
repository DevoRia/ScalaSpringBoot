package com.vadim.site.model

import java.util

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.{DBRef, Document}

import scala.beans.BeanProperty

@Document(collection = "students")
class Student extends Serializable {

  @Id
  @BeanProperty
  var id: ObjectId = _

  @BeanProperty
  var name: String = _

  @DBRef
  @BeanProperty
  var group: Group = _

  @DBRef
  @BeanProperty
  var books: util.List[Book] = _

}
