package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
      "src/test/resources/features/login.feature",
      "src/test/resources/features/api.feature"
    },
    glue    = "com.automation.steps",
    plugin  = {
      "pretty",
      "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests { }
