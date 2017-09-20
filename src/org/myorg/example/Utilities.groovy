#!/usr/bin/env groovy

package org.myorg.example;


class Utilities implements Serializable {
  def steps

  // constructor for class
  Utilities(steps) {
    this.steps = steps
  }

  //
  def mvn(args) {
    steps.sh "${steps.tool 'Maven'}/bin/mvn -o ${args}"
  }

  def echoEnv() {
    steps.env each {
      steps.echo "${it}"
    }
  }

}
