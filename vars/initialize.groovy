#!/usr/bin/env groovy

def call() {

  env.FOO = env.FOO ?: "Default FOO";
  env.BAR = env.BAR ?: "Default Bar";

  myUtils = new Utilities(this);

  return myUtils;

}
