package com.vadim.site.services

import java.util

import com.vadim.site.model.Model
import org.bson.types.ObjectId


trait Servicable[T] {

   def getAllPosts(): util.List[T]
   def addPost(model: T)
   def editPost(model: T)
   def removePost(id: ObjectId)

}
