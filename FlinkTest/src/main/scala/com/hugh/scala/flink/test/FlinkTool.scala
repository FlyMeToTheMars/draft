package com.hugh.scala.flink.test

import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.table.api.EnvironmentSettings
import org.apache.flink.table.api.scala.StreamTableEnvironment
import org.apache.log4j.Logger


/**
 * @program: draft
 * @description: ${description}
 * @author: Fly.Hugh
 * @create: 2020-07-20 19:40
 **/
abstract class FlinkTool {
  var streamEnv: StreamExecutionEnvironment = _
  var tableEnv: StreamTableEnvironment = _
  var bsSettings: EnvironmentSettings = _
  var jobname: String =_
  var params :ParameterTool= _
  var LOGGER: Logger = _
  def main(args: Array[String]): Unit = {
    //创建打日志对象
    LOGGER = Logger.getLogger(this.getClass)
    //    params = ParameterTool.fromArgs(args)
    //    streamEnv.getConfig.setGlobalJobParameters(params)
    //    jobname = params.get("jobname")
    streamEnv = StreamExecutionEnvironment.getExecutionEnvironment
    bsSettings = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build()
    tableEnv = StreamTableEnvironment.create(streamEnv, bsSettings)

    //调用初始化方法
    init()

    LOGGER.info("============开始执行flink程序============")

    //调用子类run函数
    run(args)
    //    streamEnv.execute(jobname)

    LOGGER.info("============flink程序执行完成============")
  }

  /**
   * 在run方法里面编写flink业务逻辑
   */
  def run(args: Array[String])

  def init(
          )

}
