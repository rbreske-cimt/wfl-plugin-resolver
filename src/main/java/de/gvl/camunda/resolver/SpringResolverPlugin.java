package de.gvl.camunda.resolver;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class SpringResolverPlugin implements ProcessEnginePlugin {
  @Autowired
  private ApplicationContext applicationContext;


  @Override
  public void preInit(final ProcessEngineConfigurationImpl processEngineConfiguration) {
    // nothing to do
  }

  @Override
  public void postInit(final ProcessEngineConfigurationImpl processEngineConfiguration) {
    processEngineConfiguration.getResolverFactories().add(new SpringResolverFactory(applicationContext));
  }

  @Override
  public void postProcessEngineBuild(final ProcessEngine processEngine) {
    // nothing to do
  }
}
