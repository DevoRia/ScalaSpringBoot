package com.vadim.site.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty

@Document(collection = "group")
class Group extends Model{

  @Id
  @BeanProperty
  var id: ObjectId = _

  @BeanProperty
  var name: String = _

  def this(id: ObjectId, name: String){
    this()
    this.id = id
    this.name = name
  }



}
