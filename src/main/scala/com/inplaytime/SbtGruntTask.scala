package com.inplaytime

import sbt._
import Keys._

object SbtGruntTask extends Plugin {
  lazy val gruntTaskSettings = commands ++= Seq(gruntTaskCommand, gruntDefaultCommand)
  
  private def gruntRunner(gruntTask: String) = {
    ("grunt " + gruntTask) !
  }

  def gruntDefaultCommand =
    Command.command("grunt") { (state: State) =>
      gruntRunner("default")
      state
    }

  def gruntTaskCommand = {
    Command.single("grunt-task") {
      case (state, task) => {
        gruntRunner(task)
        state
      }
    }
  }
}