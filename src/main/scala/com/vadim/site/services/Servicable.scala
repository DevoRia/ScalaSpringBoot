package com.vadim.site.services

import java.util

import com.vadim.site.model.Model
import org.bson.types.ObjectId


trait Servicable {

   def removePost(id: ObjectId)

}
