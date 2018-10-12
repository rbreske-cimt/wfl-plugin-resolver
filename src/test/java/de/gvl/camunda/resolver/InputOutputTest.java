package de.gvl.camunda.resolver;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.runtimeService;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testApplicationContext.xml")
public class InputOutputTest {

  @Autowired
  @Rule
  public ProcessEngineRule processEngineRule;

  @Test
  @Deployment(resources = "process.bpmn")
  public void springResolverTest() {
    final ProcessInstance instance = runtimeService().startProcessInstanceByKey("wfl-plugin-resolver");
    assertThat(instance).isEnded();
  }

}
