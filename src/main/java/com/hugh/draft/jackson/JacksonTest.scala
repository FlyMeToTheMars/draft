package com.hugh.draft.jackson

import java.util.Date

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * @Author Fly.Hugh
 * @Date 2020/9/25 5:51 下午
 * @Version 1.0
 * */
object JacksonTest {
  def main(args: Array[String]): Unit = {
    val mapper = new ObjectMapper()
    val person = new Person("jackson", 20,new Date())
    println(mapper.writeValueAsString(person))
    println("------------------------------------")
    val mapperscala = new ObjectMapper()
    val scalaScala = PersonScala("scala", 1)

    println(mapperscala.writeValueAsString(scalaScala))
  }
}

// case class 无法顺利被Jackson转化为Json，上面转化结果是空
case class PersonScala(
                      name:String,
                      age:Int
                      )
