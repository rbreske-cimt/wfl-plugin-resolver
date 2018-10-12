package de.gvl.camunda.resolver;

import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.impl.scripting.engine.Resolver;
import org.camunda.bpm.engine.impl.scripting.engine.ResolverFactory;
import org.springframework.context.ApplicationContext;

public class SpringResolverFactory implements ResolverFactory {

  private final ApplicationContext applicationContext;

  public SpringResolverFactory(final ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  public Resolver createResolver(final VariableScope variableScope) {
    return new SpringResolver(applicationContext);
  }
}
