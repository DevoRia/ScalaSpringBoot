package com.vadim.site.model

import java.util

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.{DBRef, Document}

import scala.beans.BeanProperty

@Document(collection = "students")
class Student extends Model{

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

  def this(id: ObjectId, name: String, group: Group, books: util.List[Book]){
    this()
    this.id = id
    this.name = name
    this.group = group
    this.books = books
  }

}
