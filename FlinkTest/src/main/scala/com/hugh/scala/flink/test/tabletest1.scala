package com.hugh.scala.flink.test

import org.apache.flink.api.common.typeinfo.{TypeInformation, Types}
import org.apache.flink.api.java.typeutils.RowTypeInfo
import org.apache.flink.streaming.api.scala.{DataStream, _}
import org.apache.flink.table.api.Tumble
import org.apache.flink.table.api.scala._
import org.apache.flink.types.Row

/**
 * @program: draft
 * @description: ${description}
 * @author: Fly.Hugh
 * @create: 2020-07-20 19:41
 **/
object tabletest1 extends FlinkTool{
  /**
   * 在run方法里面编写flink业务逻辑
   */
  override def run(args: Array[String]): Unit = {
    val orderA: DataStream[person] = streamEnv.fromCollection(Seq(
      person("1L", "24",2),
      person("1L", "25",2),
      person("0", "30",1)))

    var ds: DataStream[person] = null
    ds = streamEnv.fromCollection(Seq(
      person("0", "6",1),
      person("0","6",2),
      person("0","6",3)))

    val table1= orderA.union(ds).toTable(tableEnv,'name,'score,'value,'ts.proctime)

    table1.toAppendStream[Row].print()
    table1.window(Tumble.over("1.seconds")
      .on("ts")
      .as("tsrow"))
      .groupBy("tsrow,name")
      .select("name,sum(value) as value")
      .toAppendStream[Row].print()


    streamEnv.execute("fda")

  }

  override def init(): Unit = {}

}

case class person(name:String,score:String,value:Int)
case class score(names:String,scores:String,value:Int)