sbt-grunt-task
============

A plugin that allows grunt tasks to be run within SBT.

Currently more of a proof of concept for improving workflow for front-end dev with Lift than a fully fledged plugin. I would expect it to include bower or switch to yeoman in the future if this works out for us.

The goal of this is to abstract as much dependency on sbt as possible as attempts at porting anything to do with front-end asset management over to Scala/Java + SBT have resulted in dependency hell (i.e. incompatible rhino versions) or the work flow being rigid and slow to reload.

###Getting up and running (once cloned and publish-local):

####plugins.sbt
	addSbtPlugin("com.inplaytime" %% "sbt-grunt-task" % "0.1")

####build.sbt
	import com.inplaytime.SbtGruntTask

	…

	SbtGruntTask.gruntTaskSettings

####Working with the plugin
Your package.json and gruntfile.js should be in the root of your project:
	
	grunt

will run the default grunt task

	grunt-task <taskname>

will run the specified task by name

####Useful other SBT commands 

	watchSources <++= baseDirectory map { path => ((path / "src" / "main" / "webapp" / "app" ) ** "*.js").get }
Will allow the task to run on every file change (in this case just js files) in the specified folder when you run grunt with

	~ grunt

or

	~ grunt-task <taskname>
