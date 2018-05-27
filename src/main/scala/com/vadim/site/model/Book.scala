package com.vadim.site.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty


@Document(collection = "book")
class Book extends Model {

  @Id
  @BeanProperty
  var id: ObjectId = _

  @BeanProperty
  var title: String = _

  @BeanProperty
  var prise: Int = _

  def this(id: ObjectId, title: String, prise:Int){
    this()
    this.id = id
    this.title = title
    this.prise = prise
  }

}
